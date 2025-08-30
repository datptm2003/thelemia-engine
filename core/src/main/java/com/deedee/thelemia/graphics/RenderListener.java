package com.deedee.thelemia.graphics;

import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.event.IEventListener;
import com.deedee.thelemia.event.common.ResetBufferEvent;
import com.deedee.thelemia.event.common.UpdateBufferEvent;
import com.deedee.thelemia.scene.Entity;
import com.deedee.thelemia.scene.component.IGraphicsComponent;
import com.deedee.thelemia.scene.enumerate.ComponentGroup;

import java.util.List;

public class RenderListener implements IEventListener {
    private final Renderer gameSystem;

    public RenderListener(Renderer system) {
        this.gameSystem = system;
    }

    @Override
    public void onEvent(Event event) {
        if (event instanceof UpdateBufferEvent) {
            UpdateBufferEvent updateBufferEvent = (UpdateBufferEvent) event;
            switch (updateBufferEvent.getRequestType()) {
                case BY_SIZE:
                    gameSystem.draw(updateBufferEvent.getActor(), updateBufferEvent.getWidth(), updateBufferEvent.getHeight(), 1.0f);
                    break;
                case BY_SCALE:
                    gameSystem.draw(updateBufferEvent.getActor(), updateBufferEvent.getScale(), 1.0f);
                    break;
            }

        } else if (event instanceof ResetBufferEvent) {
            ResetBufferEvent resetBufferEvent = (ResetBufferEvent) event;
            gameSystem.clearScreen(resetBufferEvent.getBackgroundColor());

            for (Entity entity : resetBufferEvent.getRenderableEntities()) {
                if (!entity.hasComponentGroup(ComponentGroup.GRAPHICS)) continue;

                List<? extends IGraphicsComponent> graphicsComponents = entity.getComponentsByGroup(ComponentGroup.GRAPHICS);
                for (IGraphicsComponent component : graphicsComponents) {
                    component.render();
                }
            }

        }
    }
}
