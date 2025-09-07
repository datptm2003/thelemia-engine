package com.deedee.thelemia.graphics;

import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.event.IEventListener;
import com.deedee.thelemia.event.common.*;

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
            gameSystem.addAnimatedSprite(renderAnimatedSpriteEvent.getAnimatedSpriteComponent());

        } else if (event instanceof ChangeMapEvent) {
            ChangeMapEvent changeMapEvent = (ChangeMapEvent) event;
            gameSystem.changeTileMap(changeMapEvent.getNextTileMapComponent(), 1.0f);

        } else if (event instanceof RenderParticlesEvent) {
            RenderParticlesEvent renderParticlesEvent = (RenderParticlesEvent) event;
            gameSystem.addParticles(renderParticlesEvent.getParticlesComponent());

        } else if (event instanceof ChangeTransitionEvent) {
            ChangeTransitionEvent changeTransitionEvent = (ChangeTransitionEvent) event;
            Transition nextTransition = changeTransitionEvent.getNextTransition();
            gameSystem.changeNextTransition(nextTransition);
            if (nextTransition != null) {
                nextTransition.start();
            }

        } else if (event instanceof FinishTransitionEvent) {
            gameSystem.finishCurrentTransition();

        } else if (event instanceof ApplyShaderEvent) {
            ApplyShaderEvent applyShaderEvent = (ApplyShaderEvent) event;
            gameSystem.applyShader(applyShaderEvent.getShaderName());

        } else if (event instanceof ResetShaderEvent) {
            gameSystem.resetShader();
        }
    }
}
