package com.deedee.thelemia.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.ResetBufferEvent;
import com.deedee.thelemia.event.common.UpdateBufferEvent;
import com.deedee.thelemia.scene.IGameSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Renderer implements IGameSystem, IRenderer {
    private final RenderListener listener = new RenderListener(this);

    private final Color DEFAULT_BACKGROUND = new Color(1.0f, 1.0f, 1.0f, 1.0f);
    private final Map<String, Actor> frequentActors = new HashMap<>();

    private final Camera camera;
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
        for (Actor actor : frequentActors.values()) {
            draw(actor, 1.0f, 1.0f);
        }
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
    public void draw(Actor actor, int width, int height, float parentAlpha) {
        actor.setWidth(width);
        actor.setHeight(height);
        actor.draw(batch, parentAlpha);
    }
    @Override
    public void draw(Actor actor, float scale, float parentAlpha) {
        actor.setScale(scale);
        actor.draw(batch, parentAlpha);
    }

    @Override
    public void addFrequentActor(String name, Actor actor) {
        frequentActors.put(name, actor);
    }
    @Override
    public void removeFrequentActor(String name) {
        frequentActors.remove(name);
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
    public AssetManager getAssetManager() {
        return assetManager;
    }

}
