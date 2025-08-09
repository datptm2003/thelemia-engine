package com.deedee.thelemia.graphics.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.deedee.thelemia.graphics.Renderer;
import com.deedee.thelemia.graphics.utils.IRenderableObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Overlay implements IOverlay {
    protected final Skin skin;
    protected final List<Renderer.ChildEntry<IRenderableObject>> entries = new ArrayList<>();

    protected int layer;

    public Overlay(Skin skin) {
        this.skin = skin;
        this.layer = 0;
    }
    public Overlay(Skin skin, int layer) {
        this.skin = skin;
        this.layer = layer;
    }

    @Override
    public void create() {
        for (Renderer.ChildEntry<IRenderableObject> entry : entries) {
            entry.object.create();
        }

    }
    @Override
    public void start() {
        for (Renderer.ChildEntry<IRenderableObject> entry : entries) {
            entry.object.start();
        }
    }
    @Override
    public void update(float delta) {
        for (Renderer.ChildEntry<IRenderableObject> entry : entries) {
            entry.object.update(delta);
        }
    }
    @Override
    public void dispose() {
        for (Renderer.ChildEntry<IRenderableObject> entry : entries) {
            entry.object.dispose();
        }
        entries.clear();
    }

    @Override
    public void add(String name, IRenderableObject object, int x, int y) {
        entries.add(new Renderer.ChildEntry<>(name, object, x, y));
    }
    @Override
    public void remove(String name) {
        entries.removeIf(entry -> Objects.equals(entry.name, name));
    }
    @Override
    public void render(int x, int y) {
        // TODO
        for (Renderer.ChildEntry<IRenderableObject> entry : entries) {
            entry.object.render(x + entry.x, y + entry.y);
        }
    }

    @Override
    public Skin getSkin() {
        return skin;
    }
    @Override
    public List<Renderer.ChildEntry<IRenderableObject>> getAllEntries() {
        return entries;
    }

    @Override
    public int getLayer() {
        return layer;
    }
    @Override
    public void setLayer(int layer) {
        this.layer = layer;
    }

}
