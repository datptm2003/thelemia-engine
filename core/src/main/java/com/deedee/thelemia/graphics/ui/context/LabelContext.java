package com.deedee.thelemia.graphics.ui.context;

import com.deedee.thelemia.graphics.Style;
import com.deedee.thelemia.graphics.ui.Label;

public class LabelContext implements IWidgetContext<Label> {
    private final Style style;

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
}
