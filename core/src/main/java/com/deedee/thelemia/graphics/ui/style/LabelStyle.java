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

    @Override
    public Drawable apply(GraphicsContext<? extends Widget> context, SpriteBatch batch, FrameBuffer fbo, boolean transparent) {
        LabelContext labelContext = (LabelContext) context;

        // Store original font scale to restore it later, preventing side effects
        float originalScaleX = font.getScaleX();
        float originalScaleY = font.getScaleY();

        try {
            // Calculate and apply new scale based on the desired size from the context.
            // This assumes the font's "default" size is its cap height.
            if (labelContext.getSize() > 0 && font.getCapHeight() > 0) {
                float newScale = (float) labelContext.getSize() / font.getCapHeight();
                font.getData().setScale(newScale);
            }

            int alignment = convertAnchorToAlign(labelContext.getAnchor());

            fbo.begin();

            if (transparent) {
                Gdx.gl.glClearColor(0, 0, 0, 0); // transparent
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            }

            batch.begin();
            font.setColor(color);

            // Draw the text within the FBO's bounds, using the specified alignment and enabling wrapping.
            // The `y` coordinate for this draw call specifies the top of the text block.
            font.draw(batch, labelContext.getText(), 0, fbo.getHeight(), fbo.getWidth(), alignment, true);

            batch.end();
            fbo.end();

        } finally {
            // Restore the original font scale to avoid affecting other UI elements
            font.getData().setScale(originalScaleX, originalScaleY);
        }

        // Create texture region from FrameBuffer
        TextureRegion region = new TextureRegion(fbo.getColorBufferTexture());
        region.flip(false, true); // Flip because FBO rendering is upside down

        return new TextureRegionDrawable(region);
    }

    /**
     * Converts the custom Anchor enum to libGDX's Align integer constants.
     *
     * @param anchor The Anchor from the LabelContext.
     * @return An integer representing a gdx.utils.Align value.
     */
    private int convertAnchorToAlign(Anchor anchor) {
        // This implementation assumes the naming convention in your Anchor enum.
        // Adjust the cases if your enum has different names.
        if (anchor == null) {
            return Align.center;
        }
        switch (anchor) {
            case TOP_LEFT:
                return Align.topLeft;
            case TOP_CENTER:
                return Align.top;
            case TOP_RIGHT:
                return Align.topRight;
            case CENTER_LEFT:
                return Align.left;
            case CENTER:
                return Align.center;
            case CENTER_RIGHT:
                return Align.right;
            case BOTTOM_LEFT:
                return Align.bottomLeft;
            case BOTTOM_CENTER:
                return Align.bottom;
            case BOTTOM_RIGHT:
                return Align.bottomRight;
            default:
                return Align.center; // A sensible default
        }
    }

    public BitmapFont getFont() {
        return font;
    }

    public Color getColor() {
        return color;
    }
}
