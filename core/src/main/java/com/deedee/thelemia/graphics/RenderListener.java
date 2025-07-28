package com.deedee.thelemia.graphics;

import com.deedee.thelemia.event.IEvent;
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
    public void onEvent(IEvent event) {
        if (event instanceof UpdateBufferEvent) {
            UpdateBufferEvent updateBufferEvent = (UpdateBufferEvent) event;
            gameSystem.begin();
            switch (updateBufferEvent.getRequestType()) {
                case BY_SIZE:
                    gameSystem.draw(updateBufferEvent.getTexture(), updateBufferEvent.getPosition(), updateBufferEvent.getSize());
                    break;
                case BY_SCALE:
                    gameSystem.draw(updateBufferEvent.getTexture(), updateBufferEvent.getPosition(), updateBufferEvent.getScale());
                    break;
            }
            gameSystem.end();

        } else if (event instanceof ResetBufferEvent) {
            ResetBufferEvent resetBufferEvent = (ResetBufferEvent) event;
            gameSystem.clearScreen(resetBufferEvent.getBackgroundColor());

            for (Entity entity : resetBufferEvent.getRenderableEntities()) {
                if (!entity.hasComponentGroup(ComponentGroup.GRAPHICS)) continue;

                List<IGraphicsComponent> graphicsComponents = entity.getComponentsByGroup(ComponentGroup.GRAPHICS);
                for (IGraphicsComponent component : graphicsComponents) {
                    component.render();
                }
            }

        }
    }
}
