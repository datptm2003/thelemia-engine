package com.deedee.thelemia.graphics.ui.style;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.deedee.thelemia.graphics.Style;
import com.deedee.thelemia.graphics.enumerate.Anchor;
import com.deedee.thelemia.graphics.ui.Widget;
import com.deedee.thelemia.graphics.ui.context.LabelContext;
import com.deedee.thelemia.graphics.GraphicsContext;

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
