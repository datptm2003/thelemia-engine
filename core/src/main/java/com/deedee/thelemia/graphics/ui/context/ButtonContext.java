package com.deedee.thelemia.graphics.ui.context;

import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.graphics.Style;
import com.deedee.thelemia.graphics.ui.Button;
import com.deedee.thelemia.graphics.ui.Canvas;
import com.deedee.thelemia.graphics.ui.Label;
import com.deedee.thelemia.graphics.ui.Widget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ButtonContext implements IWidgetContext<Button> {
    protected final Style style;
    protected final CanvasContext canvasContext;
    protected final LabelContext labelContext;
    protected Runnable callback;

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
        // TODO: Need more updates
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

    @Override
    public Vector2 getHitboxSize() {
        return new Vector2(canvasContext.getWidth(), canvasContext.getHeight());
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
