package com.deedee.thelemia.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.ChangeMapEvent;
import com.deedee.thelemia.event.common.RenderAnimatedSpriteEvent;
import com.deedee.thelemia.event.common.RenderFragmentEvent;
import com.deedee.thelemia.event.common.RenderParticlesEvent;
import com.deedee.thelemia.scene.IGameSystem;
import com.deedee.thelemia.scene.component.*;

import java.util.LinkedList;
import java.util.List;

public class Renderer implements IGameSystem, IRenderer {
    private final RenderListener listener = new RenderListener(this);
    private final Color DEFAULT_BACKGROUND = new Color(1.0f, 1.0f, 1.0f, 1.0f);

    private final Stage stage = new Stage();
    private final Table root = new Table();

    private final Camera camera;
    private final SpriteBatch batch = new SpriteBatch();

    private final AssetManager assetManager = new AssetManager();
    private final ShaderManager shaderManager = new ShaderManager();
    private OrthogonalTiledMapRenderer mapRenderer;

    private final List<AnimatedSpriteComponent> spriteComponents = new LinkedList<>();
    private final List<ParticlesComponent> particlesComponents = new LinkedList<>();

    public Renderer() {
        subscribeListener();
        this.camera = new Camera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.setProjectionMatrix(camera.getProjectionMatrix());

        stage.setViewport(camera.getViewport());
        Gdx.input.setInputProcessor(stage);

        root.setFillParent(true);
        stage.addActor(root);
    }

    @Override
    public void subscribeListener() {
        EventBus.getInstance().subscribe(RenderFragmentEvent.class, listener);
        EventBus.getInstance().subscribe(RenderAnimatedSpriteEvent.class, listener);
        EventBus.getInstance().subscribe(ChangeMapEvent.class, listener);
        EventBus.getInstance().subscribe(RenderParticlesEvent.class, listener);
    }
    @Override
    public void update(float delta) {
        batch.setProjectionMatrix(this.camera.getProjectionMatrix());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update(delta);
        if (mapRenderer != null) {
            mapRenderer.setView(camera.getInternalCamera());
            mapRenderer.render();
        }

        for (AnimatedSpriteComponent spriteComponent : spriteComponents) {
            AnimatedSprite sprite = spriteComponent.getGraphicsObject();
            if (!sprite.isLoaded()) continue;

            sprite.update(delta);
            drawAnimatedSprite(spriteComponent);
        }
        for (ParticlesComponent particlesComponent : particlesComponents) {
            Particles particles = particlesComponent.getGraphicsObject();
            if (!particles.isLoaded()) continue;

            particles.update(delta);
            drawParticles(particlesComponent);
        }

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
    public void addWidget(WidgetComponent widgetComponent) {
        root.add(widgetComponent.getGraphicsObject().getWidget());
    }
    @Override
    public void addAnimatedSprite(AnimatedSpriteComponent spriteComponent) {
        spriteComponents.add(spriteComponent);
    }
    @Override
    public void addParticles(ParticlesComponent particlesComponent) {
        particlesComponents.add(particlesComponent);
    }
    @Override
    public void changeTileMap(TileMapComponent tileMapComponent, float unitScale) {
        if (mapRenderer != null) mapRenderer.dispose();

        TileMap tileMap = tileMapComponent.getGraphicsObject();
        mapRenderer = new OrthogonalTiledMapRenderer(tileMap.getTiledMap(), unitScale, batch);
    }

    @Override
    public void drawAnimatedSprite(AnimatedSpriteComponent spriteComponent) {
        AnimatedSprite sprite = spriteComponent.getGraphicsObject();
        TextureRegion texture = sprite.getCurrentAnimation().getKeyFrame(sprite.getTimeframe());
        TransformComponent transform = spriteComponent.getOwner().getComponentByType(TransformComponent.class);

        float width = transform.getScale().x * texture.getRegionWidth();
        float height = transform.getScale().y * texture.getRegionHeight();

        batch.begin();
        batch.draw(texture, transform.getPosition().x, transform.getPosition().y, width, height);
        batch.end();
    }
    @Override
    public void drawParticles(ParticlesComponent particlesComponent) {
        batch.begin();
        particlesComponent.getGraphicsObject().draw(batch);
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
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.dispose();
        spriteComponents.clear();
    }

    public Stage getStage() {
        return stage;
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
    public OrthogonalTiledMapRenderer getMapRenderer() {
        return mapRenderer;
    }

}
