package com.deedee.thelemia.graphics;

import com.badlogic.gdx.graphics.Color;
import com.deedee.thelemia.event.IEvent;
import com.deedee.thelemia.event.IEventListener;
import com.deedee.thelemia.event.common.RedrawScreenEvent;
import com.deedee.thelemia.event.common.RenderRequestEvent;
import com.deedee.thelemia.scene.Entity;
import com.deedee.thelemia.scene.component.IGraphicsComponent;

public class RenderListener implements IEventListener {
    private final Renderer gameSystem;

    public RenderListener(Renderer system) {
        this.gameSystem = system;
    }

    @Override
    public void onEvent(IEvent event) {
        if (event instanceof RenderRequestEvent) {
            RenderRequestEvent renderRequestEvent = (RenderRequestEvent) event;
            gameSystem.begin();
            switch (renderRequestEvent.getRequestType()) {
                case BY_SIZE:
                    gameSystem.draw(renderRequestEvent.getTexture(), renderRequestEvent.getPosition(), renderRequestEvent.getSize());
                    break;
                case BY_SCALE:
                    gameSystem.draw(renderRequestEvent.getTexture(), renderRequestEvent.getPosition(), renderRequestEvent.getScale());
                    break;
            }
            gameSystem.end();
        } else if (event instanceof RedrawScreenEvent) {
            RedrawScreenEvent redrawScreenEvent = (RedrawScreenEvent) event;
            gameSystem.clearScreen(redrawScreenEvent.getBackgroundColor());
            for (Entity entity : redrawScreenEvent.getRenderableEntities()) {
                entity.getComponent(IGraphicsComponent.class).render();
            }
        }
    }
}
