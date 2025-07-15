package com.deedee.thelemia.input;

import com.deedee.thelemia.event.IEvent;
import com.deedee.thelemia.event.IEventListener;
import com.deedee.thelemia.event.common.ClickEvent;
import com.deedee.thelemia.scene.IGameSystem;

public class InputListener implements IEventListener {
    private final InputHandler gameSystem;

    public InputListener(InputHandler gameSystem) {
        this.gameSystem = gameSystem;
    }

    @Override
    public void onEvent(IEvent event) {

    }

}
