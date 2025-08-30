package com.deedee.thelemia.graphics;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.UpdateBufferEvent;

import java.util.*;

public abstract class GraphicsContainer implements IGraphicsContainer {
    protected final Skin skin;
    protected final Map<String, Actor> entries = new HashMap<>();

    public GraphicsContainer(Skin skin) {
        this.skin = skin;
    }

    @Override
    public void create() {

    }
    @Override
    public void start() {

    }
    @Override
    public void update(float delta) {

    }
    @Override
    public void dispose() {
        entries.clear();
    }

    @Override
    public void add(String name, Actor actor) {
        entries.put(name, actor);
    }
    @Override
    public void remove(String name) {
        entries.remove(name);
    }
    @Override
    public void render() {
        for (Actor actor : entries.values()) {
            EventBus.getInstance().post(new UpdateBufferEvent(actor, 1.0f));
        }
    }

    @Override
    public Skin getSkin() {
        return skin;
    }
}
