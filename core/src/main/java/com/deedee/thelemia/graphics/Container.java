package com.deedee.thelemia.graphics;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.deedee.thelemia.graphics.utils.IRenderableObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Container implements IContainer {
    protected final Skin skin;
    protected final List<Renderer.ChildEntry<IRenderableObject>> entries = new ArrayList<>();

    public Container(Skin skin) {
        this.skin = skin;
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
    public void add(String name, IRenderableObject object, Vector2 position) {
        entries.add(new Renderer.ChildEntry<>(name, object, position));
    }
    @Override
    public void remove(String name) {
        entries.removeIf(entry -> Objects.equals(entry.name, name));
    }
    @Override
    public void render(Vector2 position) {
        for (Renderer.ChildEntry<IRenderableObject> entry : entries) {
            entry.object.render(new Vector2(position.x + entry.position.x, position.y + entry.position.y));
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
}
