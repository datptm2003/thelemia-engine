package com.deedee.thelemia.event.common;

import com.badlogic.gdx.utils.Null;
import com.deedee.thelemia.ai.utils.Message;
import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.scene.Entity;
import com.deedee.thelemia.ai.enumerate.DispatchScope;

import java.util.List;

public class DispatchMessageEvent extends Event {
    @Null
    private Entity receiver;
    @Null
    private List<Entity> receivers;
    private final Message message;
    private final DispatchScope scope;

    public DispatchMessageEvent(Entity receiver, Message message) {
        super();
        this.receiver = receiver;
        this.message = message;
        this.scope = DispatchScope.SINGLE;
    }
    public DispatchMessageEvent(List<Entity> receivers, Message message) {
        super();
        this.receivers = receivers;
        this.message = message;
        this.scope = DispatchScope.GROUP;
    }
    public DispatchMessageEvent(Message message) {
        super();
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
