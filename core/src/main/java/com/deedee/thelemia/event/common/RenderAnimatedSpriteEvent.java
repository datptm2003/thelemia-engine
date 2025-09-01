package com.deedee.thelemia.event.common;

import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.graphics.AnimatedSprite;
import com.deedee.thelemia.graphics.enumerate.RenderRequestType;
import com.deedee.thelemia.scene.Entity;
import com.deedee.thelemia.scene.component.TransformComponent;

public class RenderAnimatedSpriteEvent extends Event {
    private final Entity animatedSpriteEntity;

    public RenderAnimatedSpriteEvent(Entity animatedSpriteEntity) {
        super();
        this.animatedSpriteEntity = animatedSpriteEntity;
    }

    public Entity getAnimatedSpriteEntity() {
        return animatedSpriteEntity;
    }

    @Override
    public String getLog() {
        return "";
    }

}
