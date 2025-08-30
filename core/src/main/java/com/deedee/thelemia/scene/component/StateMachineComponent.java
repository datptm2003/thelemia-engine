package com.deedee.thelemia.scene.component;

import com.deedee.thelemia.ai.fsm.StateMachine;
import com.deedee.thelemia.scene.Component;
import com.deedee.thelemia.scene.Entity;
import com.deedee.thelemia.scene.enumerate.ComponentGroup;

public class StateMachineComponent extends Component implements IControlComponent {
    private final StateMachine stateMachine;

    public StateMachineComponent(Entity owner, StateMachine stateMachine) {
        super(owner);
        this.stateMachine = stateMachine;
    }
    public StateMachineComponent(Entity owner) {
        super(owner);
        this.stateMachine = new StateMachine(owner);
    }

    @Override
    public void update(float delta) {
        stateMachine.update();
    }
    @Override
    public void reset() {
        stateMachine.reset();
    }
    @Override
    public void release() {
        stateMachine.release();
    }

    @Override
    public ComponentGroup getGroup() {
        return ComponentGroup.CONTROL;
    }

    public StateMachine getStateMachine() {
        return stateMachine;
    }
}
