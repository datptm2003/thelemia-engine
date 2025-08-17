package com.deedee.thelemia.scene;

import com.deedee.thelemia.graphics.IRenderableObject;

import java.util.List;

public interface IScene {
    void addEntity(Entity entity);
    void removeEntity(String id);
    Entity getEntityById(String id);
    List<Entity> getEntitiesByType(Class<? extends Entity> type);
    List<Entity> getAllEntities();

    IRenderableObject getHitObjectByRaycast(int x, int y);

    void show();
    void update(float delta);
    void render();
    void resize(int width, int height);
    void pause();
    void resume();
    void hide();
    void dispose();

}
