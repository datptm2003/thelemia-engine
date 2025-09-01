package com.deedee.thelemia.scene;

import com.deedee.thelemia.ai.utils.MessageDispatcher;

public interface ISceneManager {
    void loadScene(String name);
    void unloadScene();

    boolean addScene(Scene newScene);
    Scene getSceneByName(String name);
    Scene getCurrentScene();
    void removeScene(String name);

    MessageDispatcher getMessageDispatcher();
}
