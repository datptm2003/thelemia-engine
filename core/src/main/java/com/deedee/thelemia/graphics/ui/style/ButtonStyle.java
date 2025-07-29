package com.deedee.thelemia.graphics.ui.style;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.deedee.thelemia.graphics.Style;

import java.util.HashMap;
import java.util.Map;

public class ButtonStyle extends Style {
    private final BitmapFont font;
    private final Color fontColor;
    private final Texture bgUp;
    private final Texture bgDown;

    public ButtonStyle(BitmapFont font, Color fontColor, Texture bgUp, Texture bgDown) {
        this.font = font;
        this.fontColor = fontColor;
        this.bgUp = bgUp;
        this.bgDown = bgDown;

        substyles.put(LabelStyle.class, new LabelStyle(font, fontColor));
        substyles.put(CanvasStyle.class, new CanvasStyle());
    }

    public BitmapFont getFont() {
        return font;
    }

    public Color getFontColor() {
        return fontColor;
    }

    public Texture getBgUp() {
        return bgUp;
    }

    public Texture getBgDown() {
        return bgDown;
    }
}
