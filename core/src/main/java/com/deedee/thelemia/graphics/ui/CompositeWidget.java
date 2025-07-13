package com.deedee.thelemia.graphics.ui;

import java.util.ArrayList;
import java.util.List;

public abstract class CompositeWidget extends Widget {
    protected static class ChildEntry {
        Widget widget;
        float offsetX, offsetY;

        ChildEntry(Widget widget, float offsetX, float offsetY) {
            this.widget = widget;
            this.offsetX = offsetX;
            this.offsetY = offsetY;
        }
    }

    protected final List<ChildEntry> children = new ArrayList<>();

    @Override
    public void create() {
        for (ChildEntry child : children) {
            child.widget.create();
        }
    }
    @Override
    public void start() {
        for (ChildEntry child : children) {
            child.widget.start();
        }
    }
    @Override
    public void update(float delta) {
        if (!visible || !enabled) return;

        for (ChildEntry child : children) {
            child.widget.update(delta);
        }
    }
    @Override
    public void dispose() {
        for (ChildEntry child : children) {
            child.widget.dispose();
        }
        children.clear();
    }

    @Override
    public void render(int x, int y) {

    }

    public void addChild(Widget widget, float offsetX, float offsetY) {
        children.add(new ChildEntry(widget, offsetX, offsetY));
    }
    public void removeChild(Widget widget) {
        children.removeIf(entry -> entry.widget == widget);
    }
    public List<Widget> getChildren() {
        List<Widget> flat = new ArrayList<>();
        for (ChildEntry entry : children) flat.add(entry.widget);
        return flat;
    }

}
