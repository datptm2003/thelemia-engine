package com.deedee.thelemia.event.common;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Null;
import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.graphics.AnimatedSprite;
import com.deedee.thelemia.graphics.enumerate.RenderRequestType;
import com.deedee.thelemia.scene.component.TransformComponent;

public class RenderAnimatedSpriteEvent extends Event {
    private final AnimatedSprite sprite;
    private final TransformComponent transform;

    public RenderAnimatedSpriteEvent(AnimatedSprite sprite, TransformComponent transform) {
        super();
        this.sprite = sprite;
        this.transform = transform;
    }

    public AnimatedSprite getSprite() {
        return sprite;
    }
    public TransformComponent getTransform() {
        return transform;
    }

    @Override
    public String getLog() {
        return "";
    }

}
