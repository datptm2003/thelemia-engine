package com.deedee.thelemia.graphics.ui.context;

import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.graphics.ui.style.Style;
import com.deedee.thelemia.graphics.ui.Widget;

public interface IWidgetContext<T extends Widget> {
    T build(Style style);
    void reset();
    Vector2 getHitboxSize();

    Vector2 getRelativePosition();
    void setRelativePosition(int x, int y);
}
