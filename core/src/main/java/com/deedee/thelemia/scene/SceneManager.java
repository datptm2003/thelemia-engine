package com.deedee.thelemia.scene;

import com.deedee.thelemia.ai.utils.MessageDispatcher;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.ChangeTransitionEvent;
import com.deedee.thelemia.event.common.DispatchMessageEvent;
import com.deedee.thelemia.graphics.Transition;

import java.util.*;

public class SceneManager extends GameSystem implements ISceneManager {
    private final SceneEventListener listener = new SceneEventListener(this);

    private final MessageDispatcher messageDispatcher = new MessageDispatcher();
    private final AssetStorage assetStorage = new AssetStorage();
    private final List<Scene> scenes = new ArrayList<>();

    private Scene currentScene;
    private Transition currentInTransition;
    private Transition currentOutTransition;
    private Scene pendingNextScene;

    public SceneManager() {
        subscribeListener();
    }

    @Override
    public void subscribeListener() {
        EventBus.getInstance().subscribe(DispatchMessageEvent.class, listener);
    }

    @Override
    public void update(float delta) {
        if (currentOutTransition != null) {
            updateOutTransition(delta);
        } else if (currentInTransition != null) {
            updateInTransition(delta);
        }
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

    private void updateOutTransition(float delta) {
        currentOutTransition.update(delta);
        if (currentOutTransition.isFinished()) {
            if (currentScene != null) {
                unloadScene();
            }

            currentScene = pendingNextScene;
            if (currentScene != null) {
                currentScene.show();
            }
            currentOutTransition = null;
            pendingNextScene = null;

            EventBus.getInstance().post(new ChangeTransitionEvent(currentInTransition));
        }
    }
    private void updateInTransition(float delta) {
        currentInTransition.update(delta);

        if (currentInTransition.isFinished()) {
            currentInTransition = null;
            EventBus.getInstance().post(new ChangeTransitionEvent(null));
        }
    }

    @Override
    public void loadScene(String name) {
        if (currentScene != null) {
            unloadScene();
        }
        currentScene = getSceneByName(name);
        if (currentScene != null) {
            currentScene.show();
        }

    }
    @Override
    public void loadScene(String name, Transition outTransition, Transition inTransition) {
        currentOutTransition = outTransition;
        currentInTransition = inTransition;
        pendingNextScene = getSceneByName(name);
        EventBus.getInstance().post(new ChangeTransitionEvent(outTransition));

        if (currentOutTransition == null) {
            if (currentScene != null) {
                unloadScene();
            }
            currentScene = pendingNextScene;
            if (currentScene != null) {
                currentScene.show();
            }
            pendingNextScene = null;
        }

    }
    @Override
    public void unloadScene() {
        currentScene.hide();
        currentScene = null;
    }

    @Override
    public boolean addScene(Scene newScene) {
        if (getSceneByName(newScene.getName()) != null) {
            return false;
        }
        scenes.add(newScene);
        return true;
    }
    @Override
    public Scene getSceneByName(String name) {
        for (Scene scene : scenes) {
            if (scene.getName().equals(name)) {
                return scene;
            }
        }
        return null;
    }
    @Override
    public Scene getCurrentScene() {
        if (currentScene == null) return null;
        return currentScene;
    }
    @Override
    public void removeScene(String name) {
        if (currentScene != null && currentScene.getName().equals(name)) {
            unloadScene();
        }
        scenes.removeIf(scene -> scene.getName().equals(name));
    }

    @Override
    public MessageDispatcher getMessageDispatcher() {
        return messageDispatcher;
    }
    @Override
    public AssetStorage getAssetStorage() {
        return assetStorage;
    }
}
