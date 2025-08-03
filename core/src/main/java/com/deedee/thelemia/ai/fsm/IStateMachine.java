package com.deedee.thelemia.ai.fsm;

import com.deedee.thelemia.ai.enumerate.MessageTarget;
import com.deedee.thelemia.scene.Entity;

public interface IStateMachine {
    void update();
    State getCurrentState();
    State getGlobalState();
    boolean handleMessage(Message message);
}
