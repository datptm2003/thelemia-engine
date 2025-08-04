package com.deedee.thelemia.event.common;

import com.deedee.thelemia.ai.utils.Message;
import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.scene.Entity;
import com.deedee.thelemia.ai.enumerate.DispatchScope;

import java.util.List;

public class MessageDispatchEvent extends Event {
    private Entity receiver;
    private List<Entity> receivers;
    private final Message message;
    private final DispatchScope scope;

    public MessageDispatchEvent(Entity receiver, Message message) {
        this.receiver = receiver;
        this.message = message;
        this.scope = DispatchScope.SINGLE;
    }
    public MessageDispatchEvent(List<Entity> receivers, Message message) {
        this.receivers = receivers;
        this.message = message;
        this.scope = DispatchScope.GROUP;
    }
    public MessageDispatchEvent(Message message) {
        this.message = message;
        this.scope = DispatchScope.BROADCAST;
    }

    @Override
    public String getLog() {
        return "";
    }

    public Entity getSingleReceiver() {
        return receiver;
    }
    public List<Entity> getReceiverGroup() {
        return receivers;
    }
    public Message getMessage() {
        return message;
    }
    public DispatchScope getScope() {
        return scope;
    }
}
