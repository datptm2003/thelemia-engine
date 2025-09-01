package com.deedee.thelemia.core;

public interface IGameObject {
    void create();
    void start();
    void update(float delta);
    void stop();
    void dispose();
}
