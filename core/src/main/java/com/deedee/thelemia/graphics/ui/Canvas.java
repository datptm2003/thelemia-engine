package com.deedee.thelemia.graphics.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.deedee.thelemia.graphics.GraphicsContext;
import com.deedee.thelemia.graphics.utils.ICullable;
import com.deedee.thelemia.graphics.ui.context.CanvasContext;
import com.deedee.thelemia.graphics.ui.style.CanvasStyle;

public class Canvas extends Widget implements ICullable {
    public Canvas(CanvasContext context, CanvasStyle style) {
        super(context, style);
    }

    @Override
    public boolean isInsideVisibleArea(Vector2 position, int width, int height) {
        return position.x >= 0 && position.y >= 0 && position.x + width <= getWidth() && position.y + height <= getHeight();
    }

    @Override
    public CanvasContext getContext() {
        return (CanvasContext) context;
    }
    @Override
    public CanvasStyle getStyle() {
        return (CanvasStyle) style;
    }

    @Override
    public Drawable getDrawable(SpriteBatch batch, FrameBuffer fbo, boolean clear) {
        NinePatch background = getStyle().getBackground();

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
                context.getPosition().x, context.getPosition().y,
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
}
