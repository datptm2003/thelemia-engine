package com.deedee.thelemia.graphics;

import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.event.IEventListener;
import com.deedee.thelemia.event.common.RenderAnimatedSpriteEvent;
import com.deedee.thelemia.event.common.ResetBufferEvent;
import com.deedee.thelemia.event.common.RenderFragmentEvent;
import com.deedee.thelemia.scene.Entity;
import com.deedee.thelemia.scene.component.TransformComponent;
import com.deedee.thelemia.scene.enumerate.ComponentGroup;

public class RenderListener implements IEventListener {
    private final Renderer gameSystem;

    public RenderListener(Renderer system) {
        this.gameSystem = system;
    }

    @Override
    public void onEvent(Event event) {
        if (event instanceof RenderFragmentEvent) {
            RenderFragmentEvent renderFragmentEvent = (RenderFragmentEvent) event;
            Fragment fragment = renderFragmentEvent.getFragment();
            TransformComponent transform = renderFragmentEvent.getTransform();

//            fragment.getWidgetGroup().setPosition(transform.getPosition().x, transform.getPosition().y);
//            fragment.getWidgetGroup().setScale(transform.getScale().x, transform.getScale().y);
//            fragment.getWidgetGroup().setOrigin(transform.getOrigin().x, transform.getOrigin().y);
//            fragment.getWidgetGroup().setRotation(transform.getRotation());

//            gameSystem.drawFragment(renderFragmentEvent.getFragment(), renderFragmentEvent.getParentAlpha());

        } else if (event instanceof RenderAnimatedSpriteEvent) {
            RenderAnimatedSpriteEvent renderAnimatedSpriteEvent = (RenderAnimatedSpriteEvent) event;
            gameSystem.drawAnimatedSprite(renderAnimatedSpriteEvent.getSprite(), renderAnimatedSpriteEvent.getTransform());

        } else if (event instanceof ResetBufferEvent) {
            ResetBufferEvent resetBufferEvent = (ResetBufferEvent) event;
            gameSystem.clearScreen(resetBufferEvent.getBackgroundColor());

            for (Entity entity : resetBufferEvent.getRenderableEntities()) {
                if (!entity.hasComponentGroup(ComponentGroup.GRAPHICS)) continue;

                gameSystem.getRoot().clear();

//                List<? extends IGraphicsComponent> graphicsComponents = entity.getComponentsByGroup(ComponentGroup.GRAPHICS);
//                for (IGraphicsComponent component : graphicsComponents) {
//                    component.render();
//                }
            }

        }
    }
}
