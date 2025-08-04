package com.deedee.thelemia.scene;

import com.deedee.thelemia.ai.utils.MessageDispatcher;

public interface ISceneManager {
    void loadScene(Scene scene);
    void unloadScene();
    IScene getCurrentScene();
    MessageDispatcher getMessageDispatcher();
}
