package com.deedee.thelemia.scene;

import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.event.IEventListener;
import com.deedee.thelemia.event.common.MessageDispatchEvent;

public class SceneEventListener implements IEventListener {
    private final SceneManager gameSystem;

    public SceneEventListener(SceneManager system) {
        this.gameSystem = system;
    }

    @Override
    public void onEvent(Event event) {
        if (event instanceof MessageDispatchEvent) {
            MessageDispatchEvent dispatchEvent = (MessageDispatchEvent) event;
            switch (dispatchEvent.getScope()) {
                case SINGLE:
                    gameSystem.getMessageDispatcher().dispatch(dispatchEvent.getSingleReceiver(), dispatchEvent.getMessage());
                    break;
                case GROUP:
                    gameSystem.getMessageDispatcher().dispatchGroup(dispatchEvent.getReceiverGroup(), dispatchEvent.getMessage());
                    break;
                case BROADCAST:
                    gameSystem.getMessageDispatcher().dispatchGroup(gameSystem.getCurrentScene().getAllEntities(), dispatchEvent.getMessage());
            }
        }
    }
}
