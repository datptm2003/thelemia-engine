package com.deedee.thelemia.graphics.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.deedee.thelemia.graphics.utils.IRenderableObject;
import com.deedee.thelemia.graphics.Renderer.ChildEntry;

import java.util.*;

public class Fragment implements IFragment {
    protected final Skin skin;
    protected final List<ChildEntry<IRenderableObject>> entries = new ArrayList<>();

    public Fragment(Skin skin) {
        this.skin = skin;
    }

    @Override
    public void create() {
        for (ChildEntry<IRenderableObject> entry : entries) {
            entry.object.create();
        }

//        ButtonContext leftButtonContext = new ButtonContext(200, 150, "Left", Anchor.CENTER, 30, () -> {
//            System.out.println("Testing LEFT!");
//        });
//        ButtonContext rightButtonContext = new ButtonContext(200, 150, "Right", Anchor.CENTER, 30, () -> {
//            System.out.println("Testing RIGHT!");
//        });
//
//        ButtonStyle style = skin.get("button", ButtonStyle.class);
//
//        Button leftButton = new Button(leftButtonContext, style);
//        Button rightButton = new Button(rightButtonContext, style);
//
//        add("left-button", leftButton, 0, 0);
//        add("right-button", rightButton, 0, 0);

    }
    @Override
    public void start() {
        for (ChildEntry<IRenderableObject> entry : entries) {
            entry.object.start();
        }
    }
    @Override
    public void update(float delta) {
        for (ChildEntry<IRenderableObject> entry : entries) {
            entry.object.update(delta);
        }
    }
    @Override
    public void dispose() {
        for (ChildEntry<IRenderableObject> entry : entries) {
            entry.object.dispose();
        }
        entries.clear();
    }

    @Override
    public void add(String name, IRenderableObject object, int x, int y) {
        entries.add(new ChildEntry<>(name, object, x, y));
    }
    @Override
    public void remove(String name) {
        entries.removeIf(entry -> Objects.equals(entry.name, name));
    }
    @Override
    public void render(int x, int y) {
        for (ChildEntry<IRenderableObject> entry : entries) {
            entry.object.render(x + entry.x, y + entry.y);
        }
    }

    @Override
    public Skin getSkin() {
        return skin;
    }
    @Override
    public List<ChildEntry<IRenderableObject>> getAllEntries() {
        return entries;
    }
}
