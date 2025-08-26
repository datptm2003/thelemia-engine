package com.deedee.thelemia.graphics;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.deedee.thelemia.core.IGameObject;
import com.deedee.thelemia.graphics.utils.IRenderable;

public interface IRenderableObject extends IGameObject, IRenderable {
    int getWidth();
    int getHeight();

    Drawable getDrawable(SpriteBatch batch, FrameBuffer fbo, boolean isTransparent);
}
