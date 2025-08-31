package com.deedee.thelemia.scene;

import com.deedee.thelemia.ai.utils.MessageDispatcher;

public interface ISceneManager {
    void loadScene(String name);
    void unloadScene();

    void addScene(String name, Scene scene);
    Scene getSceneByName(String name);
    IScene getCurrentScene();

    MessageDispatcher getMessageDispatcher();
}
