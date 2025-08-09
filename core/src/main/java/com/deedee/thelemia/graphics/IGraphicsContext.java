package com.deedee.thelemia.graphics;

import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.graphics.ui.Widget;

public interface IGraphicsContext<T extends Widget> {
    void reset();

    int getWidth();
    int getHeight();

    Vector2 getPosition();
    void setPosition(int x, int y);
}
