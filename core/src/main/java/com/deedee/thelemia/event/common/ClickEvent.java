package com.deedee.thelemia.event.common;

import com.deedee.thelemia.core.IGameObject;
import com.deedee.thelemia.event.Event;

public class ClickEvent extends Event {
    private final int x, y;

    public ClickEvent(IGameObject gameObject, int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    @Override
    public String getLog() {
        return "";
    }
}
