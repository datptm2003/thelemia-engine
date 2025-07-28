package com.deedee.thelemia.graphics.ui.context;

import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.graphics.Style;
import com.deedee.thelemia.graphics.ui.Widget;

public interface IWidgetContext<T extends Widget> {
    T build();
    void reset();
    Style getStyle();
    Vector2 getHitboxSize();
}
