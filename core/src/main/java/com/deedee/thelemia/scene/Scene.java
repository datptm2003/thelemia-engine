package com.deedee.thelemia.scene;

import com.badlogic.gdx.InputAdapter;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.ChangeInputAdapterEvent;
import com.deedee.thelemia.input.InputListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Scene implements IScene {

    protected final String name;
    protected final SceneManager sceneManager;
    protected final List<Entity> entities = new ArrayList<>();
    protected final InputAdapter inputAdapter;

    public Scene(String name, InputAdapter inputAdapter, SceneManager sceneManager) {
        this.name = name;
        this.inputAdapter = inputAdapter;
        this.sceneManager = sceneManager;
    }
    public Scene(String name, SceneManager sceneManager) {
        this.name = name;
        this.sceneManager = sceneManager;
        this.inputAdapter = null;
    }

    @Override
    public void addEntity(Entity entity) {
        entities.add(entity);
    }
    @Override
    public void removeEntity(String id) {
        entities.removeIf(entity -> entity.getId().equals(id));
    }
    @Override
    public Entity getEntityById(String id) {
        return entities.stream().filter(entity -> Objects.equals(entity.getId(), id)).findFirst().orElse(null);
    }
    @Override
    public List<Entity> getEntitiesByType(Class<? extends Entity> type) {
        List<Entity> result = new ArrayList<>();
        for (Entity entity : entities) {
            if (type.isInstance(entity)) {
                result.add(entity);
            }
        }
        return result;
    }
    @Override
    public List<Entity> getAllEntities() {
        return entities;
    }

    @Override
    public void show() {
        EventBus.getInstance().post(new ChangeInputAdapterEvent(inputAdapter));
    }
    @Override
    public void update(float delta) {

    }
    @Override
    public void hide() {
        EventBus.getInstance().post(new ChangeInputAdapterEvent(null));
    }

    @Override
    public void dispose() {
        entities.clear();
    }

    public String getName() {
        return name;
    }
    public SceneManager getSceneManager() {
        return sceneManager;
    }
    public InputAdapter getInputAdapter() {
        return inputAdapter;
    }
}
