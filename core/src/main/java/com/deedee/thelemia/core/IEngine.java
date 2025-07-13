package com.deedee.thelemia.core;

public interface IEngine {
    void create();
    void update(float delta);
    void render();
    void resize(int width, int height);
    void pause();
    void resume();
    void dispose();
}
