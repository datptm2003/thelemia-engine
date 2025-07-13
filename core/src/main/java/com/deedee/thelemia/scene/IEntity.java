package com.deedee.thelemia.scene;

public interface IEntity {
    void addComponent(IComponent component); // Add component to entity
    <T extends IComponent> T getComponent(Class<T> componentType); // Get component
    void removeComponent(Class<? extends IComponent> componentType); // Remove component
}
