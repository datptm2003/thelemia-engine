package com.deedee.thelemia.input;

import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.event.IEventListener;

public class InputListener implements IEventListener {
    private final InputHandler gameSystem;

    public InputListener(InputHandler gameSystem) {
        this.gameSystem = gameSystem;
    }

    @Override
    public void onEvent(Event event) {

    }

}
