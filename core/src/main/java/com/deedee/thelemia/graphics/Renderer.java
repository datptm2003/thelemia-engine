package com.deedee.thelemia.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.ResetBufferEvent;
import com.deedee.thelemia.event.common.RenderFragmentEvent;
import com.deedee.thelemia.scene.IGameSystem;
import com.deedee.thelemia.scene.component.TransformComponent;

public class Renderer implements IGameSystem, IRenderer {
    private final RenderListener listener = new RenderListener(this);
    private final Color DEFAULT_BACKGROUND = new Color(1.0f, 1.0f, 1.0f, 1.0f);

    private final Stage stage = new Stage();
    private final Table root = new Table();

    private final Camera camera;
    private final SpriteBatch batch = new SpriteBatch();

    private final AssetManager assetManager = new AssetManager();
    private final ShaderManager shaderManager = new ShaderManager();

    public Renderer(int width, int height) {
        this.camera = new Camera(width, height);
        subscribeListener();
        batch.setProjectionMatrix(camera.getProjectionMatrix());

        stage.setViewport(camera.getViewport());
        Gdx.input.setInputProcessor(stage);

        root.setFillParent(true);
        stage.addActor(root);
    }

    @Override
    public void subscribeListener() {
        EventBus.getInstance().subscribe(RenderFragmentEvent.class, listener);
        EventBus.getInstance().subscribe(ResetBufferEvent.class, listener);
    }
    @Override
    public void update(float delta) {
        batch.setProjectionMatrix(this.camera.getProjectionMatrix());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }
    @Override
    public void dispose() {
        batch.dispose();
        camera.dispose();
        shaderManager.dispose();
    }
    @Override
    public RenderListener getListener() {
        return listener;
    }

    @Override
    public void drawFragment(Fragment fragment, float parentAlpha) {
        WidgetGroup widget = fragment.getWidgetGroup();

        // TODO: Need re-implementation
        batch.begin();
        widget.draw(batch, parentAlpha);
        batch.end();
    }
    @Override
    public void drawAnimatedSprite(AnimatedSprite sprite, TransformComponent transform) {
        TextureRegion texture = sprite.getCurrentAnimation().getKeyFrame(sprite.getTimeframe());
        float width = transform.getScale().x * texture.getRegionWidth();
        float height = transform.getScale().y * texture.getRegionHeight();

        // TODO: Need re-implementation
        batch.begin();
        batch.draw(texture, transform.getPosition().x, transform.getPosition().y, width, height);
        batch.end();
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

    public Table getRoot() {
        return root;
    }
    public Camera getCamera() {
        return camera;
    }
    public SpriteBatch getBatch() {
        return batch;
    }
    public AssetManager getAssetManager() {
        return assetManager;
    }

}
