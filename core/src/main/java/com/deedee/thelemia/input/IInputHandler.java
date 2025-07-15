package com.deedee.thelemia.input;

import com.badlogic.gdx.math.Vector2;

public interface IInputHandler {
    boolean isTouchDown(int pointer);
    Vector2 getTouchPosition(int pointer);
}
