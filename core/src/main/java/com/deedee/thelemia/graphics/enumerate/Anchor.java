package com.deedee.thelemia.graphics.enumerate;

import com.badlogic.gdx.math.Vector2;

public enum Anchor {
    TOP_LEFT,
    TOP_CENTER,
    TOP_RIGHT,
    CENTER_LEFT,
    CENTER,
    CENTER_RIGHT,
    BOTTOM_LEFT,
    BOTTOM_CENTER,
    BOTTOM_RIGHT;

    public Vector2 getRelativePosition(int width, int height) {
        switch (this) {
            case BOTTOM_LEFT:
                return new Vector2(0, 0);
            case BOTTOM_CENTER:
                return new Vector2(width / 2f, 0);
            case BOTTOM_RIGHT:
                return new Vector2(width, 0);
            case CENTER_LEFT:
                return new Vector2(0, height / 2f);
            case CENTER:
                return new Vector2(width / 2f, height / 2f);
            case CENTER_RIGHT:
                return new Vector2(width, height / 2f);
            case TOP_LEFT:
                return new Vector2(0, height);
            case TOP_CENTER:
                return new Vector2(width / 2f, height);
            case TOP_RIGHT:
                return new Vector2(width, height);
            default:
                throw new IllegalStateException("Unexpected value: " + this);
        }
    }
}
