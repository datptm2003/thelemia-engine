package com.deedee.thelemia.graphics.ui.style;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.deedee.thelemia.graphics.Style;
import com.deedee.thelemia.graphics.ui.Widget;
import com.deedee.thelemia.graphics.ui.context.ButtonContext;
import com.deedee.thelemia.graphics.GraphicsContext;

public class ButtonStyle extends Style {
    private final BitmapFont font;
    private final Color fontColor;
    private final NinePatch background;

    public ButtonStyle(BitmapFont font, Color fontColor, NinePatch background) {
        this.font = font;
        this.fontColor = fontColor;
        this.background = background;
    }

    public BitmapFont getFont() {
        return font;
    }

    public Color getFontColor() {
        return fontColor;
    }

    public NinePatch getBackground() {
        return background;
    }
}
