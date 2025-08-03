package com.deedee.thelemia.graphics.ui.style;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.deedee.thelemia.graphics.ui.Button;
import com.deedee.thelemia.graphics.ui.Widget;
import com.deedee.thelemia.graphics.ui.context.ButtonContext;
import com.deedee.thelemia.graphics.ui.context.CanvasContext;
import com.deedee.thelemia.graphics.ui.context.LabelContext;
import com.deedee.thelemia.graphics.ui.context.WidgetContext;

import java.awt.*;

public class ButtonStyle extends Style {
    private final BitmapFont font;
    private final Color fontColor;
    private final NinePatch background;

    public ButtonStyle(BitmapFont font, Color fontColor, NinePatch background) {
        this.font = font;
        this.fontColor = fontColor;
        this.background = background;

        substyles.put(LabelStyle.class, new LabelStyle(font, fontColor));
        substyles.put(CanvasStyle.class, new CanvasStyle(background));
    }

    @Override
    public Drawable apply(WidgetContext<? extends Widget> context, SpriteBatch batch, FrameBuffer fbo, boolean transparent) {
        ButtonContext buttonContext = (ButtonContext) context;
        CanvasStyle canvasStyle = getSubstyle(CanvasStyle.class);
        LabelStyle labelStyle = getSubstyle(LabelStyle.class);

        if (canvasStyle == null || labelStyle == null) return null;

        // Begin drawing to FBO
        fbo.begin();

        if (transparent) {
            Gdx.gl.glClearColor(0, 0, 0, 0); // transparent
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        }

        batch.begin();

        Drawable canvasDrawable = canvasStyle.apply(buttonContext.getCanvasContext(), batch, fbo, transparent);
        if (canvasDrawable != null) {
            canvasDrawable.draw(batch, 0, 0, fbo.getWidth(), fbo.getHeight());
        }

        Drawable labelDrawable = labelStyle.apply(buttonContext.getLabelContext(), batch, fbo, false);
        if (labelDrawable != null) {
            labelDrawable.draw(batch, 0, 0, fbo.getWidth(), fbo.getHeight());
        }

        batch.end();
        fbo.end();

        // Flip FBO texture vertically to make it render correctly
        TextureRegion region = new TextureRegion(fbo.getColorBufferTexture());
        region.flip(false, true);

        return new TextureRegionDrawable(region);
    }

    public BitmapFont getFont() {
        return font;
    }

    public Color getFontColor() {
        return fontColor;
    }

    public NinePatch getBgUp() {
        return background;
    }
}
