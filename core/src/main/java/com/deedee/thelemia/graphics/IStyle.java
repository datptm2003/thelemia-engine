package com.deedee.thelemia.graphics;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.deedee.thelemia.graphics.ui.Widget;

public interface IStyle {
    <T extends Style> T getSubstyle(Class<T> styleType);

    Drawable apply(GraphicsContext<? extends Widget> context, SpriteBatch batch, FrameBuffer fbo, boolean clear);
}
