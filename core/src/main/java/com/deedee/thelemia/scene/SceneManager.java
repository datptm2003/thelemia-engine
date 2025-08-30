package com.deedee.thelemia.scene;

import com.deedee.thelemia.ai.utils.MessageDispatcher;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.DispatchMessageEvent;

public class SceneManager implements IGameSystem, ISceneManager {
    private final SceneEventListener listener = new SceneEventListener(this);
    private final MessageDispatcher messageDispatcher = new MessageDispatcher();
    private Scene currentScene;

    public SceneManager() {
        subscribeListener();
    }

    @Override
    public void subscribeListener() {
        EventBus.getInstance().subscribe(DispatchMessageEvent.class, listener);
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
    @Override
    public MessageDispatcher getMessageDispatcher() {
        return messageDispatcher;
    }
}
