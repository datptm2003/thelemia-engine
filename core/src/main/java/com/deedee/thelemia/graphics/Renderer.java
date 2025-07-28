package com.deedee.thelemia.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.ResetBufferEvent;
import com.deedee.thelemia.event.common.UpdateBufferEvent;
import com.deedee.thelemia.graphics.behavior.IRenderableObject;
import com.deedee.thelemia.scene.IGameSystem;

public class Renderer implements IGameSystem, IRenderer {
    public static class ChildEntry {
        public String name;
        public IRenderableObject object;
        public int x, y;

        public ChildEntry(String name, IRenderableObject object, int x, int y) {
            this.name = name;
            this.object = object;
            this.x = x;
            this.y = y;
        }
        public ChildEntry(IRenderableObject object, int x, int y) {
            this.name = "";
            this.object = object;
            this.x = x;
            this.y = y;
        }
    }

    private final RenderListener listener = new RenderListener(this);

    private final Color DEFAULT_BACKGROUND = new Color(1.0f, 1.0f, 1.0f, 1.0f);
    private final Camera camera;
    private final FrameBuffer fbo;

    private final SpriteBatch batch = new SpriteBatch();
    private final ShaderManager shaderManager = new ShaderManager();
    private final ShapeRenderer shapeRenderer = new ShapeRenderer();

    public Renderer(int width, int height) {
        this.camera = new Camera(width, height);
        this.fbo = new FrameBuffer(Pixmap.Format.RGBA8888, width, height, false);
        subscribeListener();
        batch.setProjectionMatrix(camera.getProjectionMatrix());
        shapeRenderer.setProjectionMatrix(camera.getProjectionMatrix());
    }

    @Override
    public void subscribeListener() {
        EventBus.getInstance().subscribe(UpdateBufferEvent.class, listener);
        EventBus.getInstance().subscribe(ResetBufferEvent.class, listener);
    }
    @Override
    public void update(float delta) {
        batch.setProjectionMatrix(this.camera.getProjectionMatrix());
        shapeRenderer.setProjectionMatrix(this.camera.getProjectionMatrix());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
    @Override
    public void dispose() {
        batch.dispose();
        camera.dispose();
        shaderManager.dispose();
        shapeRenderer.dispose();
    }
    @Override
    public RenderListener getListener() {
        return listener;
    }

    @Override
    public void begin() {
        fbo.begin();
        batch.begin();
    }
    @Override
    public void draw(Texture texture, Vector2 position, Vector2 size) {
        batch.draw(texture, position.x, position.y, size.x, size.y);
    }
    @Override
    public void draw(Texture texture, Vector2 position, float scale) {
        float width = texture.getWidth() * scale;
        float height = texture.getHeight() * scale;
        batch.draw(texture, position.x, position.y, width, height);
    }

//    @Override
//    public void draw(TextureRegion textureRegion, Vector2 position, Vector2 size) {
//
//    }
//    @Override
//    public void draw(TextureRegion textureRegion, Vector2 position, float scale) {
//
//    }

    @Override
    public void end() {
        fbo.end();
        batch.end();
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
    public FrameBuffer getFrameBuffer() {
        return fbo;
    }
    public SpriteBatch getBatch() {
        return batch;
    }
    public ShaderProgram getCurrentShader() {
        return shaderManager.getCurrentShader();
    }
}
