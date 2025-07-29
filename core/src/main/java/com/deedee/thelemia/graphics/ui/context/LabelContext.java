package com.deedee.thelemia.graphics.ui.context;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.deedee.thelemia.graphics.Style;
import com.deedee.thelemia.graphics.enumerate.Anchor;
import com.deedee.thelemia.graphics.ui.Label;
import com.deedee.thelemia.graphics.ui.style.LabelStyle;

public class LabelContext extends WidgetContext<Label> {
    private String text;
    private Anchor anchor;
    private int size;

    public LabelContext(int width, int height, String text, Anchor anchor, int size) {
        super(width, height);
        this.text = text;
        this.anchor = anchor;
        this.size = size;

        Vector2 relativePosition = anchor.getRelativePosition(width, height);
        x = (int) relativePosition.x - width / 2;
        y = (int) relativePosition.y - height / 2;
    }

    @Override
    public Label build(Style style) {
        LabelStyle labelStyle = (LabelStyle) style;
        // TODO

        return new Label(this, labelStyle);
    }
    @Override
    public void reset() {

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
