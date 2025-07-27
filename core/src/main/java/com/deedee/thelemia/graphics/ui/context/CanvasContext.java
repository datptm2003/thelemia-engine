package com.deedee.thelemia.graphics.ui.context;

import com.deedee.thelemia.graphics.Style;
import com.deedee.thelemia.graphics.ui.Canvas;

public class CanvasContext implements IWidgetContext<Canvas> {
    private final Style style;

    public CanvasContext(Style style) {
        this.style = style;
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

}
