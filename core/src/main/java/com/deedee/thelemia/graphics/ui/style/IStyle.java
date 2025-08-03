package com.deedee.thelemia.graphics.ui.style;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.deedee.thelemia.graphics.ui.Widget;
import com.deedee.thelemia.graphics.ui.context.WidgetContext;

import java.awt.*;

public interface IStyle {
    <T extends Style> T getSubstyle(Class<T> styleType);

    Drawable apply(WidgetContext<? extends Widget> context, SpriteBatch batch, FrameBuffer fbo, boolean clear);
}
