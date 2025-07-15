package com.deedee.thelemia.scene;

public interface ISceneManager {
    void loadScene(Scene scene);
    void unloadScene();
    IScene getCurrentScene();
}
