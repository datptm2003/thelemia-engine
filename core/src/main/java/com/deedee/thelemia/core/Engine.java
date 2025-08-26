package com.deedee.thelemia.core;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.graphics.Camera;
import com.deedee.thelemia.graphics.Renderer;
import com.deedee.thelemia.input.InputHandler;
import com.deedee.thelemia.physics.PhysicsConfig;
import com.deedee.thelemia.physics.PhysicsEngine;
import com.deedee.thelemia.scene.SceneManager;
import com.deedee.thelemia.time.Timer;
import com.deedee.thelemia.time.TimerManager;

public class Engine extends ApplicationAdapter {
    private final EngineConfig config;
    private final PhysicsConfig physicsConfig;
    private final LifecycleListener lifecycleListener;

    private Renderer renderer;
    private InputHandler inputHandler;
    private PhysicsEngine physicsEngine;
    private SceneManager sceneManager;
    private TimerManager timerManager;

    public Engine(EngineConfig config, PhysicsConfig physicsConfig) {
        this.config = config;
        this.physicsConfig = physicsConfig;
        lifecycleListener = new LifecycleListener();
    }

    @Override
    public void create() {
        // Initialization logic for the engine
        renderer = new Renderer(config.getWidth(), config.getHeight());
        inputHandler = new InputHandler();
        physicsEngine = new PhysicsEngine(physicsConfig);
        sceneManager = new SceneManager();
        timerManager = new TimerManager();
    }
    @Override
    public void render() {
        // Rendering logic for the engine
        float delta = Gdx.graphics.getDeltaTime();
        renderer.update(delta);
        inputHandler.update(delta);
        physicsEngine.update(delta);
        sceneManager.update(delta);
        timerManager.update(delta);

        EventBus.getInstance().process();
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
        inputHandler.dispose();
        physicsEngine.dispose();
        sceneManager.dispose();
        timerManager.dispose();
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
    public TimerManager getTimerManager() {
        return timerManager;
    }
}
