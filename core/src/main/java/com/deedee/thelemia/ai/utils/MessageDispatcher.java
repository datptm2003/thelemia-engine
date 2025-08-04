package com.deedee.thelemia.ai.utils;

import com.deedee.thelemia.scene.Entity;
import com.deedee.thelemia.scene.component.StateMachineComponent;

import java.util.List;

public class MessageDispatcher implements IMessageDispatcher {
    public boolean dispatch(Entity receiver, Message message) {
        StateMachineComponent stateMachineComponent = receiver.getComponentByType(StateMachineComponent.class);
        if (stateMachineComponent != null) {
            return stateMachineComponent.getStateMachine().handleMessage(message);
        }
        return true;
    }

    public boolean dispatchGroup(List<Entity> receivers, Message message) {
        for (Entity receiver : receivers) {
            if (!dispatch(receiver, message)) return false;
        }
        return true;
    }
}
