package com.deedee.thelemia.event.common;

import com.badlogic.gdx.InputAdapter;
import com.deedee.thelemia.event.Event;
import com.deedee.thelemia.scene.Scene;

public class ChangeInputAdapterEvent extends Event {
    private final InputAdapter nextInputAdapter;

    public ChangeInputAdapterEvent(InputAdapter nextInputAdapter) {
        this.nextInputAdapter = nextInputAdapter;
    }

    @Override
    public String getLog() {
        return "";
    }

    public InputAdapter getNextInputAdapter() {
        return nextInputAdapter;
    }
}
