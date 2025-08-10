package com.deedee.thelemia.graphics.ui.context;

import com.deedee.thelemia.graphics.GraphicsContext;
import com.deedee.thelemia.graphics.enumerate.Anchor;
import com.deedee.thelemia.graphics.ui.Button;

public class ButtonContext extends GraphicsContext {
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
    public void reset() {
        text = "Default Text";
        anchor = Anchor.CENTER;
        fontSize = 24;
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

    public Anchor getAnchor() {
        return anchor;
    }
    public void setAnchor(Anchor anchor) {
        this.anchor = anchor;
    }

    public int getFontSize() {
        return fontSize;
    }
    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public Runnable getCallback() {
        return callback;
    }
    public void setCallback(Runnable callback) {
        this.callback = callback;
    }

}
