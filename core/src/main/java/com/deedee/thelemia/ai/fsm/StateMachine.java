package com.deedee.thelemia.ai.fsm;

import com.deedee.thelemia.ai.utils.Message;
import com.deedee.thelemia.scene.Entity;

public class StateMachine {
    private final Entity owner;

    private State initialState;
    private State currentState;
    private State globalState;

    public StateMachine(Entity owner) {
        this.owner = owner;
        this.initialState = null;
        this.globalState = null;
        this.currentState = null;
    }
    public StateMachine(Entity owner, State initialState) {
        this.owner = owner;
        this.initialState = initialState;
        this.currentState = initialState;
        this.globalState = null;
    }
    public StateMachine(Entity owner, State initialState, State globalState) {
        this.owner = owner;
        this.initialState = initialState;
        this.currentState = initialState;
        this.globalState = globalState;
        currentState.updateGlobalState(globalState);
    }

    public void update() {
        currentState.update();
        globalState.update();
    }
    public void reset() {
        if (currentState != null) {
            currentState.exit();
        }
        if (initialState != null) {
            currentState = initialState;
            currentState.enter();
        } else {
            currentState = null;
        }
    }
    public void release() {

    }

    protected void changeState(State newState) {
        if (currentState != null) {
            currentState.exit();
        }
        if (initialState == null) {
            initialState = newState;
        }
        currentState = newState;
        currentState.enter();
    }
    protected void changeGlobalState(State newState) {
        if (globalState != null) {
            globalState.exit();
        }
        globalState = newState;
        currentState.updateGlobalState(globalState);
        globalState.enter();
    }

    public State getInitialState() {
        return initialState;
    }
    public State getCurrentState() {
        return currentState;
    }
    public State getGlobalState() {
        return globalState;
    }

    public boolean handleMessage(Message message) {
        switch (message.getTarget()) {
            case CURRENT:
                return currentState != null && currentState.onMessage(owner, message);
            case GLOBAL:
                return globalState != null && globalState.onMessage(owner, message);
            case BOTH:
                return currentState != null && currentState.onMessage(owner, message) && globalState != null && globalState.onMessage(owner, message);
            default:
                return false;
        }
    }
}
