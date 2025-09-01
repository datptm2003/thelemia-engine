package com.deedee.thelemia.ai.fsm;

import com.deedee.thelemia.ai.utils.Message;

public interface IStateMachine {
    void update();
    void reset();
    void release();

    State getInitialState();
    State getCurrentState();
    State getGlobalState();
    boolean handleMessage(Message message);
}
