package com.deedee.thelemia.graphics.ui.style;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.deedee.thelemia.graphics.Style;

public class LabelStyle extends Style {
    private final BitmapFont font;
    private final Color color;

    public LabelStyle(BitmapFont font, Color color) {
        this.font = font;
        this.color = color;
    }

    public BitmapFont getFont() {
        return font;
    }

    public Color getColor() {
        return color;
    }
}
