package com.deedee.thelemia.graphics.ui.context;

import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.graphics.Style;
import com.deedee.thelemia.graphics.ui.Label;

public class LabelContext implements IWidgetContext<Label> {
    protected final Style style;

    public LabelContext(Style style) {
        this.style = style;
    }

    @Override
    public Label build() {
        return new Label(this);
    }
    @Override
    public void reset() {

    }

    @Override
    public Style getStyle() {
        return style;
    }

    @Override
    public Vector2 getHitboxSize() {
        return new Vector2();
    }
}
