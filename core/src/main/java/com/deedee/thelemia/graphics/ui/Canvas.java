package com.deedee.thelemia.graphics.ui;

import com.deedee.thelemia.graphics.behavior.ICullable;
import com.deedee.thelemia.graphics.ui.context.CanvasContext;

public class Canvas extends Widget implements ICullable {
    public Canvas(CanvasContext context) {
        super(context);
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
    public boolean isInsideVisibleArea(int x, int y) {
        return false;
    }
    @Override
    public void setVisibleArea(int x, int y, int width, int height) {

    }

    @Override
    public CanvasContext getContext() {
        return (CanvasContext) super.getContext();
    }

}
