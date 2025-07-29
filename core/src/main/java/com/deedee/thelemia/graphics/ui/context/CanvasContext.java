package com.deedee.thelemia.graphics.ui.context;

import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.graphics.Style;
import com.deedee.thelemia.graphics.ui.Canvas;
import com.deedee.thelemia.graphics.ui.style.CanvasStyle;

public class CanvasContext extends WidgetContext<Canvas> {
    public CanvasContext(int width, int height) {
        super(width, height);
    }

    @Override
    public Canvas build(Style style) {
        CanvasStyle canvasStyle = (CanvasStyle) style;
        // TODO
        return new Canvas(this, canvasStyle);
    }

    @Override
    public void reset() {

    }

}
