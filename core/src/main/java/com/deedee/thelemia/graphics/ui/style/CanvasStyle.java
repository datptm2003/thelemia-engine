package com.deedee.thelemia.graphics.ui.style;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.deedee.thelemia.graphics.ui.Widget;
import com.deedee.thelemia.graphics.ui.context.CanvasContext;
import com.deedee.thelemia.graphics.ui.context.WidgetContext;

public class CanvasStyle extends Style {
    private final Texture background;

    @Override
    public Drawable apply(WidgetContext<? extends Widget> context, SpriteBatch batch, FrameBuffer fbo, boolean clear) {
        // Begin rendering to the FrameBuffer
        fbo.begin();

        if (clear) {
            Gdx.gl.glClearColor(0, 0, 0, 0); // transparent
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        }

        batch.begin();

        if (background != null) {
            // Draw the background to fill the entire FBO
            batch.draw(
                background,
                0, 0,
                fbo.getWidth(), fbo.getHeight(),
                0, 0,
                background.getWidth(), background.getHeight(),
                false, true // Flip vertically to match FBO orientation
            );
        }

        batch.end();
        fbo.end();

        // Wrap the FBO texture as a Drawable and return it
        return new TextureRegionDrawable(new TextureRegion(fbo.getColorBufferTexture()));
    }

    public CanvasStyle(Texture background) {
        this.background = background;
    }
    public CanvasStyle() {
        this.background = null;
    }

    public Texture getBackground() {
        return background;
    }
}
