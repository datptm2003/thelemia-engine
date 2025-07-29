package com.deedee.thelemia.graphics.ui.context;

import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.graphics.Style;
import com.deedee.thelemia.graphics.enumerate.Anchor;
import com.deedee.thelemia.graphics.ui.Button;
import com.deedee.thelemia.graphics.ui.Canvas;
import com.deedee.thelemia.graphics.ui.Label;
import com.deedee.thelemia.graphics.ui.Widget;
import com.deedee.thelemia.graphics.ui.style.ButtonStyle;
import com.deedee.thelemia.graphics.ui.style.CanvasStyle;
import com.deedee.thelemia.graphics.ui.style.LabelStyle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ButtonContext extends WidgetContext<Button> {
    protected String text;
    protected Anchor anchor;
    protected int fontSize;
    protected Runnable callback;

    public ButtonContext(int width, int height, String text, Anchor anchor, int fontSize, Runnable callback) {
        super(width, height);
        this.text = text;
        this.anchor = anchor;
        this.fontSize = fontSize;
        this.callback = callback;
    }

    @Override
    public Button build(Style style) {
        ButtonStyle buttonStyle = (ButtonStyle) style;
        CanvasStyle canvasStyle = (CanvasStyle) buttonStyle.getSubstyle(CanvasStyle.class);
        LabelStyle labelStyle = (LabelStyle) buttonStyle.getSubstyle(LabelStyle.class);

        CanvasContext canvasContext = new CanvasContext(width, height);
        LabelContext labelContext = new LabelContext(width, height, text, anchor, fontSize);

        Button button = new Button(this, buttonStyle);

        button.addChild(canvasContext.build(canvasStyle), canvasContext.x, canvasContext.y);
        button.addChild(labelContext.build(labelStyle), labelContext.x, labelContext.y);

        return button;
    }
    @Override
    public void reset() {
        callback = () -> {
            // Do nothing
        };
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public Runnable getCallback() {
        return callback;
    }
    public void setCallback(Runnable callback) {
        this.callback = callback;
    }
}
