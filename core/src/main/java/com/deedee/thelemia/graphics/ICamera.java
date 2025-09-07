package com.deedee.thelemia.graphics;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;

public interface ICamera {
    void resize(int width, int height);
    void setPosition(Vector2 position);
    void setViewport(float width, float height);
    Matrix4 getProjectionMatrix();
}
