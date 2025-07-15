package com.deedee.thelemia.core;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.graphics.Camera;
import com.deedee.thelemia.graphics.Renderer;
import com.deedee.thelemia.graphics.ShaderManager;
import com.deedee.thelemia.input.InputHandler;
import com.deedee.thelemia.scene.SceneManager;

public class Engine extends ApplicationAdapter implements IEngine {
    private final EngineConfig config;
    private final LifecycleListener lifecycleListener;

    private Renderer renderer;
    private InputHandler inputHandler;
    private SceneManager sceneManager;

    public Engine(EngineConfig config) {
        this.config = config;
        lifecycleListener = new LifecycleListener();
    }

    @Override
    public void create() {
        // Initialization logic for the engine
        renderer = new Renderer(new Camera(config.getWidth(), config.getHeight()));
        inputHandler = new InputHandler();
        sceneManager = new SceneManager();
    }
    @Override
    public void update(float delta) {
        // Update logic for the engine
    }
    @Override
    public void render() {
        // Rendering logic for the engine
    }
    @Override
    public void resize(int width, int height) {
        // Resize logic for the engine
    }
    @Override
    public void pause() {
        // Pause logic for the engine
    }
    @Override
    public void resume() {
        // Resume logic for the engine
    }
    @Override
    public void dispose() {
        // Dispose logic for the engine
        renderer.dispose();
    }

    public EngineConfig getConfig() {
        return config;
    }
    public LifecycleListener getLifecycleListener() {
        return lifecycleListener;
    }
    public Renderer getRenderer() {
        return renderer;
    }
    public InputHandler getInputHandler() {
        return inputHandler;
    }
    public SceneManager getSceneManager() {
        return sceneManager;
    }
}
