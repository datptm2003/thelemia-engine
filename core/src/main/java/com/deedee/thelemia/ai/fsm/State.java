package com.deedee.thelemia.ai.fsm;

import com.deedee.thelemia.ai.utils.Message;
import com.deedee.thelemia.scene.Entity;

public abstract class State implements IState {
    protected State globalState;

    public State() {
    }

    public abstract void enter();
    public abstract void update();
    public abstract void exit();
    public abstract boolean onMessage(Entity receiver, Message message);

    public void updateGlobalState(State globalState) {
        this.globalState = globalState;
    }
}
