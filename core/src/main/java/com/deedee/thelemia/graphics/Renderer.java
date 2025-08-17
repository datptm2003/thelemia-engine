package com.deedee.thelemia.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.ResetBufferEvent;
import com.deedee.thelemia.event.common.UpdateBufferEvent;
import com.deedee.thelemia.scene.IGameSystem;

public class Renderer implements IGameSystem, IRenderer {
    public static class ChildEntry<T extends IRenderableObject> {
        public String name;
        public T object;
        public Vector2 position;

        public ChildEntry(String name, T object, Vector2 position) {
            this.name = name;
            this.object = object;
            this.position = position;
        }
        public ChildEntry(T object, Vector2 position) {
            this.name = "";
            this.object = object;
            this.position = position;
        }
    }

    private final RenderListener listener = new RenderListener(this);

    private final Color DEFAULT_BACKGROUND = new Color(1.0f, 1.0f, 1.0f, 1.0f);
    private final Camera camera;
    private FrameBuffer fbo;

    private final SpriteBatch batch = new SpriteBatch();
    private final AssetManager assetManager = new AssetManager();
    private final ShaderManager shaderManager = new ShaderManager();

    public Renderer(int width, int height) {
        this.camera = new Camera(width, height);
        subscribeListener();
        batch.setProjectionMatrix(camera.getProjectionMatrix());
    }

    @Override
    public void subscribeListener() {
        EventBus.getInstance().subscribe(UpdateBufferEvent.class, listener);
        EventBus.getInstance().subscribe(ResetBufferEvent.class, listener);
    }
    @Override
    public void update(float delta) {
        batch.setProjectionMatrix(this.camera.getProjectionMatrix());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
    @Override
    public void dispose() {
        batch.dispose();
        fbo.dispose();
        camera.dispose();
        shaderManager.dispose();
    }
    @Override
    public RenderListener getListener() {
        return listener;
    }

    @Override
    public void draw(IRenderableObject object, Vector2 position, Vector2 size) {
        fbo = new FrameBuffer(Pixmap.Format.RGBA8888, object.getWidth(), object.getHeight(), false);
        object.getDrawable(batch, fbo, false).draw(batch, position.x, position.y, size.x, size.y);
    }
    @Override
    public void draw(IRenderableObject object, Vector2 position, float scale) {
        fbo = new FrameBuffer(Pixmap.Format.RGBA8888, object.getWidth(), object.getHeight(), false);
        Drawable drawable = object.getDrawable(batch, fbo, false);
        float width = object.getWidth() * scale;
        float height = object.getHeight() * scale;
        drawable.draw(batch, position.x, position.y, width, height);
    }

    @Override
    public void addSkin(String name, Skin skin) {
        assetManager.addUiSkin(name, skin);
    }
    @Override
    public void addSkin(String name, String skinPath) {
        FileHandle file = Gdx.files.internal(skinPath);
        assetManager.addUiSkin(name, file);
    }
    @Override
    public Skin getSkin(String name) {
        return assetManager.getUiSkin(name);
    }

    @Override
    public void loadShader(String name, String vertexPath, String fragmentPath) {
        shaderManager.loadShader(name, vertexPath, fragmentPath);
    }
    @Override
    public void applyShader(String name) {
        ShaderProgram currentShader = shaderManager.applyShader(name);
        batch.setShader(currentShader);
    }
    @Override
    public void resetShader() {
        batch.setShader(null);
    }

    @Override
    public void clearScreen(Color color) {
        if (color == null) Gdx.gl.glClearColor(DEFAULT_BACKGROUND.r, DEFAULT_BACKGROUND.g, DEFAULT_BACKGROUND.b, DEFAULT_BACKGROUND.a);
        else Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
    }

    public Camera getCamera() {
        return camera;
    }
    public SpriteBatch getBatch() {
        return batch;
    }
}
