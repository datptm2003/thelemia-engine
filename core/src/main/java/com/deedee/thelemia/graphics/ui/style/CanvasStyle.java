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
