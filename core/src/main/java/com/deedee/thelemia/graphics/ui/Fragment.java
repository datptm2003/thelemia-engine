package com.deedee.thelemia.graphics.ui;

import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.graphics.Style;
import com.deedee.thelemia.graphics.ui.context.ButtonContext;
import com.deedee.thelemia.graphics.ui.context.CanvasContext;
import com.deedee.thelemia.graphics.ui.context.LabelContext;

import java.util.*;

public class Fragment implements IFragment {
    protected static class ChildEntry {
        String name;
        Widget widget;
        int x, y;

        ChildEntry(String name, Widget widget, int x, int y) {
            this.name = name;
            this.widget = widget;
            this.x = x;
            this.y = y;
        }
    }

    private final List<ChildEntry> widgets = new ArrayList<>();

    @Override
    public void create() {
//        Style style = new Style();
//        ButtonContext buttonContext = new ButtonContext(style, new CanvasContext(style), new LabelContext(style));
//
//        Button leftButton = buttonContext.setCallback(() -> {
//            System.out.println("Testing LEFT!");
//        }).build();
//        buttonContext.reset();
//        Button rightButton = buttonContext.setCallback(() -> {
//            System.out.println("Testing RIGHT!");
//        }).build();
//
//        add("left-button", leftButton, 100, 200);
//        add("right-button", rightButton, 200, 200);

    }
    @Override
    public void start() {

    }
    @Override
    public void update(float delta) {
        for (ChildEntry entry : widgets) {
            entry.widget.update(delta);
        }
    }
    @Override
    public void dispose() {
        for (ChildEntry entry : widgets) {
            entry.widget.dispose();
        }
        widgets.clear();
    }

    @Override
    public void add(String name, Widget widget, int x, int y) {
        widgets.add(new ChildEntry(name, widget, x, y));
    }
    @Override
    public void remove(String name) {
        widgets.removeIf(entry -> Objects.equals(entry.name, name));
    }
    @Override
    public void render() {
        for (ChildEntry entry : widgets) {
            entry.widget.render(entry.x, entry.y);
        }
    }

    public List<Widget> getWidgets() {
        List<Widget> flat = new ArrayList<>();
        for (ChildEntry entry : widgets) flat.add(entry.widget);
        return flat;
    }
}
