package com.deedee.thelemia.event.common;

import com.badlogic.gdx.InputAdapter;
import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.input.InputController;

public class ChangeInputControllerEvent extends Event {
    private final InputController<? extends InputAdapter> nextInputController;

    public ChangeInputControllerEvent(InputController<?> nextInputController) {
        super();
        this.nextInputController = nextInputController;
    }

    @Override
    public String getLog() {
        return "";
    }

    public InputController<?> getNextInputController() {
        return nextInputController;
    }
}
