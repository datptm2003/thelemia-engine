package com.deedee.thelemia.ai.utils;

import com.deedee.thelemia.scene.Entity;

import java.util.List;

public interface IMessageDispatcher {
    boolean dispatch(Entity receiver, Message message);
    boolean dispatchGroup(List<Entity> receivers, Message message);

}
