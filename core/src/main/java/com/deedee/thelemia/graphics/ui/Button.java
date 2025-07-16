package com.deedee.thelemia.graphics.ui;

import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.ClickEvent;
import com.deedee.thelemia.graphics.behavior.IClickable;

public class Button extends Widget implements IClickable {
    private final Runnable callback;

    public Button(int width, int height, Runnable callback) {
        this.callback = callback;
    }

    @Override
    public void create() {
        super.create();
    }
    @Override
    public void start() {
        super.start();
    }
    @Override
    public void update(float delta) {
        super.update(delta);
    }
    @Override
    public void render(int x, int y) {
        super.render(x, y);
    }
    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void onClick(int x, int y) {
        callback.run();
    }

    public Runnable getCallback() {
        return callback;
    }
}
