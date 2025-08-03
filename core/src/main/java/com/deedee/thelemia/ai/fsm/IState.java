package com.deedee.thelemia.ai.fsm;

import com.deedee.thelemia.scene.Entity;

public interface IState {
    void enter();
    void update();
    void exit();
    boolean onMessage(Entity owner, Message message);
}
