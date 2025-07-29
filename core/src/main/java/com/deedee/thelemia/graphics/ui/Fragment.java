package com.deedee.thelemia.graphics.ui;

import com.deedee.thelemia.graphics.behavior.IRenderableObject;
import com.deedee.thelemia.graphics.Renderer.ChildEntry;

import java.util.*;

public class Fragment implements IFragment {
    private final List<ChildEntry> entries = new ArrayList<>();

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
        for (ChildEntry entry : entries) {
            entry.object.update(delta);
        }
    }
    @Override
    public void dispose() {
        for (ChildEntry entry : entries) {
            entry.object.dispose();
        }
        entries.clear();
    }

    @Override
    public void add(String name, IRenderableObject object, int x, int y) {
        entries.add(new ChildEntry(name, object, x, y));
    }
    @Override
    public void remove(String name) {
        entries.removeIf(entry -> Objects.equals(entry.name, name));
    }
    @Override
    public void render(int x, int y) {
        for (ChildEntry entry : entries) {
            entry.object.render(x + entry.x, y + entry.y);
        }
    }
    @Override
    public List<ChildEntry> getAllEntries() {
        return entries;
    }
}
