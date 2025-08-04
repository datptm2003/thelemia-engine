package com.deedee.thelemia.scene.component;

import com.deedee.thelemia.ai.fsm.StateMachine;
import com.deedee.thelemia.scene.Component;
import com.deedee.thelemia.scene.enumerate.ComponentGroup;

public class StateMachineComponent extends Component implements IControlComponent {
    private final StateMachine stateMachine;

    public StateMachineComponent(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
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
    public ComponentGroup getGroup() {
        return ComponentGroup.CONTROL;
    }

    public StateMachine getStateMachine() {
        return stateMachine;
    }
}
