package com.deedee.thelemia.graphics.ui.style;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.deedee.thelemia.graphics.Style;
import com.deedee.thelemia.graphics.ui.Widget;
import com.deedee.thelemia.graphics.GraphicsContext;

public class CanvasStyle extends Style {
    private final NinePatch background;

    @Override
    public Drawable apply(GraphicsContext<? extends Widget> context, SpriteBatch batch, FrameBuffer fbo, boolean clear) {
        // Begin rendering to the FrameBuffer
        fbo.begin();

        if (clear) {
            Gdx.gl.glClearColor(0, 0, 0, 0); // transparent
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        }

        batch.begin();

        if (background != null) {
            // Draw the ninepatch background using widget coordinates and size
            background.draw(
                batch,
                context.getRelativePosition().x, context.getRelativePosition().y,
                fbo.getWidth(), fbo.getHeight()
            );
        }

        batch.end();
        fbo.end();

        // Wrap the FBO texture as a Drawable and return it
        TextureRegion region = new TextureRegion(fbo.getColorBufferTexture());
        region.flip(false, true); // Flip because FBO rendering is upside down

        return new TextureRegionDrawable(region);
    }

    public CanvasStyle(NinePatch background) {
        this.background = background;
    }
    public CanvasStyle() {
        this.background = null;
    }

    public NinePatch getBackground() {
        return background;
    }
}
