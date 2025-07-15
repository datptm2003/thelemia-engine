package com.deedee.thelemia.scene;

import java.util.List;

public interface IScene {
    void addEntity(IEntity entity);
    void removeEntity(String id);
    IEntity getEntityById(String id);
    List<IEntity> getEntitiesByType(Class<? extends IEntity> type);
    List<IEntity> getAllEntities();

    void show();
    void update(float delta);
    void render();
    void resize(int width, int height);
    void pause();
    void resume();
    void hide();
    void dispose();

}
