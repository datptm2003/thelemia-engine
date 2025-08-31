package com.deedee.thelemia.scene;

import com.deedee.thelemia.ai.utils.MessageDispatcher;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.DispatchMessageEvent;

import java.util.HashMap;
import java.util.Map;

public class SceneManager implements IGameSystem, ISceneManager {
    private final SceneEventListener listener = new SceneEventListener(this);

    private final MessageDispatcher messageDispatcher = new MessageDispatcher();
    private final Map<String, Scene> scenes = new HashMap<>();
    private String currentScene;

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
            getCurrentScene().update(delta);
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
    public void loadScene(String name) {
        if (currentScene != null) {
            unloadScene();
        }
        currentScene = name;
        getCurrentScene().show();
    }
    @Override
    public void unloadScene() {
        if (currentScene != null) {
            getCurrentScene().dispose();
            currentScene = null;
        }
    }

    @Override
    public void addScene(String name, Scene scene) {
        scenes.put(name, scene);
    }
    @Override
    public Scene getSceneByName(String name) {
        return scenes.get(name);
    }
    @Override
    public Scene getCurrentScene() {
        if (currentScene == null) return null;
        return scenes.get(currentScene);
    }

    @Override
    public MessageDispatcher getMessageDispatcher() {
        return messageDispatcher;
    }
}
