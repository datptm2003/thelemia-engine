package com.deedee.thelemia.graphics;

import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.event.IEventListener;
import com.deedee.thelemia.event.common.ChangeMapEvent;
import com.deedee.thelemia.event.common.RenderAnimatedSpriteEvent;
import com.deedee.thelemia.event.common.RenderFragmentEvent;
import com.deedee.thelemia.event.common.RenderParticlesEvent;

public class RenderListener implements IEventListener {
    private final Renderer gameSystem;

    public RenderListener(Renderer system) {
        this.gameSystem = system;
    }

    @Override
    public void onEvent(Event event) {
        if (event instanceof RenderFragmentEvent) {
            RenderFragmentEvent renderFragmentEvent = (RenderFragmentEvent) event;
            gameSystem.addWidget(renderFragmentEvent.getWidgetComponent());

        } else if (event instanceof RenderAnimatedSpriteEvent) {
            RenderAnimatedSpriteEvent renderAnimatedSpriteEvent = (RenderAnimatedSpriteEvent) event;
            gameSystem.addSprite(renderAnimatedSpriteEvent.getAnimatedSpriteComponent());

        } else if (event instanceof ChangeMapEvent) {
            ChangeMapEvent changeMapEvent = (ChangeMapEvent) event;
            gameSystem.changeTileMap(changeMapEvent.getNextTileMap());

        } else if (event instanceof RenderParticlesEvent) {
            RenderParticlesEvent renderParticlesEvent = (RenderParticlesEvent) event;
            gameSystem.addParticles(renderParticlesEvent.getParticlesComponent());

        }
    }
}
