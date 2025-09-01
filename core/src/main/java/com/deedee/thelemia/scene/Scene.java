package com.deedee.thelemia.scene;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Scene implements IScene {

    protected final String name;
    protected final SceneManager sceneManager;
    protected final List<Entity> entities = new ArrayList<>();

    protected Runnable onShowCallback;
    protected Runnable onHideCallback;

    public Scene(String name, SceneManager sceneManager) {
        this.name = name;
        this.sceneManager = sceneManager;
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
        if (onShowCallback == null) return;
        onShowCallback.run();
    }
    @Override
    public void hide() {
        if (onHideCallback == null) return;
        onHideCallback.run();
    }

    @Override
    public void update(float delta) {
        for (Entity entity : entities) {
            for (Component component : entity.getAllComponents()) {
                component.update(delta);
            }
        }
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

    public void onShow(Runnable callback) {
        onShowCallback = callback;
    }
    public void onHide(Runnable callback) {
        onHideCallback = callback;
    }
}
