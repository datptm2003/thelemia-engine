package com.deedee.thelemia.scene;

import com.badlogic.gdx.audio.Sound;

import java.util.List;

public interface IScene {
    void addEntity(Entity entity);
    void removeEntity(String id);
    Entity getEntityById(String id);
    List<Entity> getEntitiesByType(Class<? extends Entity> type);
    List<Entity> getAllEntities();

    void addSound(String alias);
    Sound getSound(String alias);
    void removeSound(String alias);

    void show();
    void hide();
    void update(float delta);
    void dispose();

}
