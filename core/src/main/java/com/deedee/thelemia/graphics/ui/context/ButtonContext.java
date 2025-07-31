package com.deedee.thelemia.graphics.ui.context;

import com.deedee.thelemia.graphics.ui.Canvas;
import com.deedee.thelemia.graphics.ui.Widget;
import com.deedee.thelemia.graphics.ui.style.Style;
import com.deedee.thelemia.graphics.enumerate.Anchor;
import com.deedee.thelemia.graphics.ui.Button;
import com.deedee.thelemia.graphics.ui.style.ButtonStyle;
import com.deedee.thelemia.graphics.ui.style.CanvasStyle;
import com.deedee.thelemia.graphics.ui.style.LabelStyle;

import java.util.List;

public class ButtonContext extends WidgetContext<Button> {
    protected Runnable callback;

    protected final CanvasContext canvasContext;
    protected final LabelContext labelContext;

    public ButtonContext(int width, int height, String text, Anchor anchor, int fontSize, Runnable callback) {
        super(width, height);
        this.callback = callback;

        canvasContext = new CanvasContext(width, height);
        labelContext = new LabelContext(width, height, text, anchor, fontSize);
    }

    @Override
    public void reset() {
        callback = () -> {
            // Do nothing
        };
    }

    public String getText() {
        return labelContext.getText();
    }
    public void setText(String text) {
        labelContext.setText(text);
    }

    public Anchor getAnchor() {
        return labelContext.getAnchor();
    }
    public void setAnchor(Anchor anchor) {
        labelContext.setAnchor(anchor);
    }

    public int getFontSize() {
        return labelContext.getSize();
    }
    public void setFontSize(int fontSize) {
        labelContext.setSize(fontSize);
    }

    public Runnable getCallback() {
        return callback;
    }
    public void setCallback(Runnable callback) {
        this.callback = callback;
    }

    public CanvasContext getCanvasContext() {
        return canvasContext;
    }
    public LabelContext getLabelContext() {
        return labelContext;
    }
}
