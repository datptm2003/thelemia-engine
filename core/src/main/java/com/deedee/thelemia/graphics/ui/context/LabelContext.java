package com.deedee.thelemia.graphics.ui.context;

import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.graphics.GraphicsContext;
import com.deedee.thelemia.graphics.enumerate.Anchor;
import com.deedee.thelemia.graphics.ui.Label;

public class LabelContext extends GraphicsContext<Label> {
    private String text;
    private Anchor anchor;
    private int size;

    public LabelContext(int width, int height, String text, Anchor anchor, int size) {
        super(width, height);
        this.text = text;
        this.anchor = anchor;
        this.size = size;

        // TODO: Not true
        Vector2 relativePosition = anchor.getRelativePosition(width, height);
        position.x = relativePosition.x - (float) width / 2;
        position.y = relativePosition.y - (float) height / 2;
    }

    @Override
    public void reset() {
        text = "Default Text";
        anchor = Anchor.CENTER;
        size = 24;
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

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

}
