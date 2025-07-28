package com.deedee.thelemia.graphics.ui.context;

import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.graphics.Style;
import com.deedee.thelemia.graphics.ui.Canvas;

public class CanvasContext implements IWidgetContext<Canvas> {
    protected final Style style;
    protected final int width, height;

    public CanvasContext(Style style, int width, int height) {
        this.style = style;
        this.width = width;
        this.height = height;
    }

    @Override
    public Canvas build() {
        return new Canvas(this);
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
        return new Vector2(width, height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
