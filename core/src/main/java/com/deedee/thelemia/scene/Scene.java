package com.deedee.thelemia.scene;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.audio.Sound;
import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.ChangeInputControllerEvent;
import com.deedee.thelemia.input.InputController;

import java.util.*;

public class Scene implements IScene {
    protected final String name;
    protected final SceneManager sceneManager;
    protected final List<Entity> entities = new ArrayList<>();
    protected final List<String> sounds = new ArrayList<>();
    protected final InputController<? extends InputAdapter> inputController;

    public Scene(String name, InputController<?> inputController, SceneManager sceneManager) {
        this.name = name;
        this.inputController = inputController;
        this.sceneManager = sceneManager;
    }
    public Scene(String name, SceneManager sceneManager) {
        this.name = name;
        this.sceneManager = sceneManager;
        this.inputController = null;
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
    public void addSound(String alias) {
        sounds.add(alias);
    }
    @Override
    public Sound getSound(String alias) {
        return sceneManager.getAssetStorage().get(alias, Sound.class);
    }
    @Override
    public void removeSound(String alias) {
        sounds.remove(alias);
    }

    @Override
    public void show() {
        EventBus.getInstance().post(new ChangeInputControllerEvent(inputController));
        for (String alias : sounds) {
            sceneManager.getAssetStorage().load(alias, Sound.class);
        }
    }
    @Override
    public void update(float delta) {

    }
    @Override
    public void hide() {
        EventBus.getInstance().post(new ChangeInputControllerEvent(null));
        for (String alias : sounds) {
            sceneManager.getAssetStorage().unload(alias);
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
    public InputController<?> getInputController() {
        return inputController;
    }
    public List<String> getAllSounds() {
        return sounds;
    }
}
