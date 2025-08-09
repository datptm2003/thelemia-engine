package com.deedee.thelemia.graphics.utils;

import com.badlogic.gdx.math.Vector2;

public interface ICullable {
    boolean isInsideVisibleArea(Vector2 position, int width, int height);
}
