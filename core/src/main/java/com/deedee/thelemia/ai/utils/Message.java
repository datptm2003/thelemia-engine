package com.deedee.thelemia.ai.utils;

import com.deedee.thelemia.ai.enumerate.MessageTarget;

public class Message {
    private final String name;
    private final MessageTarget target;

    public Message(String name, MessageTarget target) {
        // TODO: Need more information
        this.name = name;
        this.target = target;
    }

    public String getName() {
        return name;
    }

    public MessageTarget getTarget() {
        return target;
    }
}
