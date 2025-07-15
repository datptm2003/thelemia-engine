package com.deedee.thelemia.scene;

import java.util.List;

public interface IEntity {
    String getId();
    void addComponent(IComponent component);
    <T extends IComponent> T getComponent(Class<T> componentType);
    List<IComponent> getComponents();
    void removeComponent(Class<? extends IComponent> componentType);
}
