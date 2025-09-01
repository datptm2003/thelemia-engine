package com.deedee.thelemia.input;

import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.event.IEventListener;
import com.deedee.thelemia.event.common.ChangeInputAdapterEvent;

public class InputListener implements IEventListener {
    private final InputHandler gameSystem;

    public InputListener(InputHandler gameSystem) {
        this.gameSystem = gameSystem;
    }

    @Override
    public void onEvent(Event event) {
        if (event instanceof ChangeInputAdapterEvent) {
            ChangeInputAdapterEvent changeInputAdapterEvent = (ChangeInputAdapterEvent) event;
            gameSystem.changeInputAdapter(changeInputAdapterEvent.getNextInputAdapter());
        }
    }

}
