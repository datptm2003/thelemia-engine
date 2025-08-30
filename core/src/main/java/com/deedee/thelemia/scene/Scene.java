package com.deedee.thelemia.scene;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Scene implements IScene {
    protected SceneManager sceneManager;
    protected final List<Entity> entities = new ArrayList<>();

    public Scene(SceneManager sceneManager) {
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
        // Called when the scene is set
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
    public void render() {

    }
    @Override
    public void resize(int width, int height) {
        // Override as needed
    }
    @Override
    public void pause() {

    }
    @Override
    public void resume() {

    }
    @Override
    public void hide() {

    }
    @Override
    public void dispose() {
        entities.clear();
    }
}
