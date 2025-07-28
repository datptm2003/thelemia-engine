package com.deedee.thelemia.scene;

import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.IEventListener;
import com.deedee.thelemia.event.common.ClickEvent;

public class SceneManager implements IGameSystem, ISceneManager {
    private final SceneEventListener listener = new SceneEventListener(this);
    private Scene currentScene;

    public SceneManager() {
        subscribeListener();
    }

    @Override
    public void subscribeListener() {
        EventBus.getInstance().subscribe(ClickEvent.class, listener);
    }
    @Override
    public void update(float delta) {
        if (currentScene != null) {
            currentScene.update(delta);
        }
    }
    @Override
    public void dispose() {
        unloadScene();
    }
    @Override
    public SceneEventListener getListener() {
        return listener;
    }

    @Override
    public void loadScene(Scene scene) {
        if (currentScene != null) {
            unloadScene();
        }
        currentScene = scene;
        currentScene.show();
    }
    @Override
    public void unloadScene() {
        if (currentScene != null) {
            currentScene.dispose();
            currentScene = null;
        }
    }
    @Override
    public Scene getCurrentScene() {
        return currentScene;
    }

}
