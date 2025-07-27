package com.deedee.thelemia.scene;

import com.deedee.thelemia.event.IEvent;
import com.deedee.thelemia.event.IEventListener;
import com.deedee.thelemia.event.common.ClickEvent;

import java.util.ArrayList;

public class SceneEventListener implements IEventListener {
    private final SceneManager gameSystem;

    public SceneEventListener(SceneManager system) {
        this.gameSystem = system;
    }

    @Override
    public void onEvent(IEvent event) {
        if (event instanceof ClickEvent) {
            System.out.println("Hello from SceneEventListener! (" + ((ClickEvent) event).getX() + ", " + ((ClickEvent) event).getY() + ")");
        }
    }
}
