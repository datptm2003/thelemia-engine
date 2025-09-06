package com.deedee.thelemia.input;

import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.event.IEventListener;
import com.deedee.thelemia.event.common.AssignStageEvent;
import com.deedee.thelemia.event.common.ChangeInputControllerEvent;

public class InputListener implements IEventListener {
    private final InputHandler gameSystem;

    public InputListener(InputHandler gameSystem) {
        this.gameSystem = gameSystem;
    }

    @Override
    public void onEvent(Event event) {
        if (event instanceof ChangeInputControllerEvent) {
            ChangeInputControllerEvent changeInputControllerEvent = (ChangeInputControllerEvent) event;
            gameSystem.changeInputController(changeInputControllerEvent.getNextInputController());

        } else if (event instanceof AssignStageEvent) {
            AssignStageEvent assignStageEvent = (AssignStageEvent) event;
            gameSystem.assignStage(assignStageEvent.getStage());

        }
    }

}
