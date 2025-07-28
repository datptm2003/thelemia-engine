package com.deedee.thelemia.graphics.ui;

import com.deedee.thelemia.graphics.Renderer.ChildEntry;
import com.deedee.thelemia.graphics.ui.context.IWidgetContext;

import java.util.ArrayList;
import java.util.List;

public abstract class CompositeWidget extends Widget {
    protected final List<ChildEntry> children = new ArrayList<>();

    public CompositeWidget(IWidgetContext<? extends Widget> context) {
        super(context);
    }

    @Override
    public void create() {
        for (ChildEntry child : children) {
            child.object.create();
        }
    }
    @Override
    public void start() {
        for (ChildEntry child : children) {
            child.object.start();
        }
    }
    @Override
    public void update(float delta) {
        for (ChildEntry child : children) {
            child.object.update(delta);
        }
    }
    @Override
    public void dispose() {
        for (ChildEntry child : children) {
            child.object.dispose();
        }
        children.clear();
    }

    @Override
    public void render(int x, int y) {
        for (ChildEntry child : children) {
            child.object.render(x + child.x, y + child.y);
        }
    }

    public void addChild(Widget widget, int offsetX, int offsetY) {
        children.add(new ChildEntry(widget, offsetX, offsetY));
    }
    public void removeChild(Widget widget) {
        children.removeIf(entry -> entry.object == widget);
    }
    public List<Widget> getChildren() {
        List<Widget> flat = new ArrayList<>();
        for (ChildEntry entry : children) flat.add((Widget) entry.object);
        return flat;
    }

}
