package com.deedee.thelemia.scene;

public interface IScene {
    void show();
    void update(float delta);
    void render();
    void resize(int width, int height);
    void pause();
    void resume();
    void hide();
    void dispose();
}
