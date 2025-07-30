package com.deedee.thelemia.graphics.behavior;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.deedee.thelemia.core.IGameObject;
import com.deedee.thelemia.graphics.ui.style.Style;

public interface IRenderableObject extends IGameObject, IRenderable {
    Vector2 getHitboxSize();
    Drawable getDrawable(SpriteBatch batch, FrameBuffer fbo, boolean transparent);
    Style getStyle();
}
