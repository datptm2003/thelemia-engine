package com.deedee.thelemia.graphics.behavior;

import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.core.IGameObject;

public interface IRenderableObject extends IGameObject, IRenderable {
    Vector2 getHitboxSize();
}
