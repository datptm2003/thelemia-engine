package com.deedee.thelemia.event.common;

import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.scene.component.AnimatedSpriteComponent;

public class RenderAnimatedSpriteEvent extends Event {
    private final AnimatedSpriteComponent spriteComponent;

    public RenderAnimatedSpriteEvent(AnimatedSpriteComponent spriteComponent) {
        super();
        this.spriteComponent = spriteComponent;
    }

    public AnimatedSpriteComponent getAnimatedSpriteComponent() {
        return spriteComponent;
    }

    @Override
    public String getLog() {
        return "";
    }

}
