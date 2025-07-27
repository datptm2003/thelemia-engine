package com.deedee.thelemia.input;

import com.badlogic.gdx.graphics.Color;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.IEvent;
import com.deedee.thelemia.event.IEventListener;
import com.deedee.thelemia.event.common.ClickEvent;
import com.deedee.thelemia.event.common.RedrawScreenEvent;
import com.deedee.thelemia.scene.IGameSystem;

import java.util.ArrayList;

public class InputListener implements IEventListener {
    private final InputHandler gameSystem;

    public InputListener(InputHandler gameSystem) {
        this.gameSystem = gameSystem;
    }

    @Override
    public void onEvent(IEvent event) {

    }

}
