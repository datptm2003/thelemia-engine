package com.deedee.thelemia.scene;

import java.util.ArrayList;
import java.util.List;

public class SceneManager {
    private Scene currentScene;
    private final List<Entity> entities = new ArrayList<>();

    public SceneManager() {

    }

    public void loadScene(Scene scene) {
        if (currentScene != null) {
            unloadScene();
        }
        currentScene = scene;
        currentScene.show();
    }

    public void unloadScene() {
        if (currentScene != null) {
            currentScene.dispose();
            currentScene = null;
            entities.clear();
        }
    }

    public void update(float delta) {
        if (currentScene != null) {
            currentScene.update(delta);
        }
        for (Entity entity : entities) {
            for (IComponent component : entity.getComponents()) {
                component.update(delta);
            }
        }
    }

    public void render() {
        if (currentScene != null) {
            currentScene.render();
        }
    }

    public Entity createEntity() {
        Entity entity = new Entity();
        entities.add(entity);
        return entity;
    }
}
