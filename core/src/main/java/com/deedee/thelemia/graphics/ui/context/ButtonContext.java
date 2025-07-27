package com.deedee.thelemia.graphics.ui.context;

import com.deedee.thelemia.graphics.Style;
import com.deedee.thelemia.graphics.ui.Button;
import com.deedee.thelemia.graphics.ui.Widget;

public class ButtonContext implements IWidgetContext<Button> {
    private final Style style;
    private final CanvasContext canvasContext;
    private final LabelContext labelContext;

    private Runnable callback;

    public ButtonContext(Style style, CanvasContext canvasContext, LabelContext labelContext) {
        this.style = style;
        this.canvasContext = canvasContext;
        this.labelContext = labelContext;
        this.callback = () -> {
            // Do nothing
        };
    }

    @Override
    public Button build() {
        return new Button(this);
    }
    @Override
    public void reset() {
        canvasContext.reset();
        labelContext.reset();
        callback = () -> {
            // Do nothing
        };
    }

    @Override
    public Style getStyle() {
        return style;
    }

    public CanvasContext getCanvasContext() {
        return canvasContext;
    }
    public LabelContext getLabelContext() {
        return labelContext;
    }

    public Runnable getCallback() {
        return callback;
    }
    public ButtonContext setCallback(Runnable callback) {
        this.callback = callback;
        return this;
    }
}
