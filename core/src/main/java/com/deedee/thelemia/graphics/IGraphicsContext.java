package com.deedee.thelemia.graphics;

import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.graphics.ui.Widget;

public interface IGraphicsContext<T extends Widget> {
    void reset();
    Vector2 getHitboxSize();

    Vector2 getRelativePosition();
    void setRelativePosition(int x, int y);
}
