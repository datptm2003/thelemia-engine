package com.deedee.thelemia.graphics;

import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.event.IEventListener;
import com.deedee.thelemia.event.common.RenderAnimatedSpriteEvent;
import com.deedee.thelemia.event.common.RenderFragmentEvent;

public class RenderListener implements IEventListener {
    private final Renderer gameSystem;

    public RenderListener(Renderer system) {
        this.gameSystem = system;
    }

    @Override
    public void onEvent(Event event) {
        if (event instanceof RenderFragmentEvent) {
            RenderFragmentEvent renderFragmentEvent = (RenderFragmentEvent) event;
            gameSystem.addWidget(renderFragmentEvent.getFragmentEntity());

        } else if (event instanceof RenderAnimatedSpriteEvent) {
            RenderAnimatedSpriteEvent renderAnimatedSpriteEvent = (RenderAnimatedSpriteEvent) event;
            gameSystem.addAnimatableEntity(renderAnimatedSpriteEvent.getAnimatedSpriteEntity());

        }
    }
}
