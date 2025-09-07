package com.deedee.thelemia.scene;

import com.deedee.thelemia.ai.utils.MessageDispatcher;
import com.deedee.thelemia.graphics.Transition;

public interface ISceneManager {
    void loadScene(String name);
    void loadScene(String name, Transition outTransition, Transition inTransition);
    void unloadScene();

    boolean addScene(Scene newScene);
    Scene getSceneByName(String name);
    Scene getCurrentScene();
    void removeScene(String name);

    MessageDispatcher getMessageDispatcher();
    AssetStorage getAssetStorage();
}
