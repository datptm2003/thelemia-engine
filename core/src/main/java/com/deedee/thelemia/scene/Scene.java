package com.deedee.thelemia.scene;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Scene implements IScene {
    protected SceneManager sceneManager;
    private final List<IEntity> entities = new ArrayList<>();

    public Scene(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @Override
    public void addEntity(IEntity entity) {
        entities.add(entity);
    }
    @Override
    public void removeEntity(String id) {
        entities.removeIf(entity -> entity.getId().equals(id));
    }
    @Override
    public IEntity getEntityById(String id) {
        return entities.stream().filter(entity -> Objects.equals(entity.getId(), id)).findFirst().orElse(null);
    }
    @Override
    public List<IEntity> getEntitiesByType(Class<? extends IEntity> type) {
        List<IEntity> result = new ArrayList<>();
        for (IEntity entity : entities) {
            if (type.isInstance(entity)) {
                result.add(entity);
            }
        }
        return result;
    }
    @Override
    public List<IEntity> getAllEntities() {
        return entities;
    }

    @Override
    public void show() {
        // Called when the scene is set
    }
    @Override
    public void update(float delta) {
        for (IEntity entity : entities) {
            for (IComponent component : entity.getComponents()) {
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
