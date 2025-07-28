package com.deedee.thelemia.scene;

import com.deedee.thelemia.event.IEvent;
import com.deedee.thelemia.event.IEventListener;
import com.deedee.thelemia.event.common.ClickEvent;
import com.deedee.thelemia.graphics.behavior.IClickable;
import com.deedee.thelemia.graphics.behavior.IRenderableObject;

public class SceneEventListener implements IEventListener {
    private final SceneManager gameSystem;

    public SceneEventListener(SceneManager system) {
        this.gameSystem = system;
    }

    @Override
    public void onEvent(IEvent event) {
        if (event instanceof ClickEvent) {
            ClickEvent clickEvent = (ClickEvent) event;
            IRenderableObject hitObject = gameSystem.getCurrentScene().getHitObjectByRaycast(clickEvent.getX(), clickEvent.getY());
            if (hitObject instanceof IClickable) {
                ((IClickable) hitObject).onClick(clickEvent.getX(), clickEvent.getY());
            }

        }
    }
}
