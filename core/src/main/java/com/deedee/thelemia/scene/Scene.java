package com.deedee.thelemia.scene;

import com.badlogic.gdx.Screen;

public abstract class Scene implements IScene {
    protected SceneManager sceneManager;

    public Scene(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @Override
    public void show() {
        // Called when the scene is set
    }
    @Override
    public void render() {

    }
    @Override
    public void resize(int width, int height) {
        // Override as needed
    }
    @Override
    public void pause() {

    }
    @Override
    public void resume() {

    }
    @Override
    public void hide() {

    }
    @Override
    public void dispose() {
        // Cleanup resources
    }
}
