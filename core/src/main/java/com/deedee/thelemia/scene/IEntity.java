package com.deedee.thelemia.scene;

import com.deedee.thelemia.scene.enumerate.ComponentGroup;

import java.util.List;

public interface IEntity {
    String getId();
    void addComponent(IComponent component);
    boolean hasComponentGroup(ComponentGroup group);
    <T extends IComponent> T getComponent(Class<T> type);
    <T extends IComponent> List<T> getComponentsByGroup(ComponentGroup group);
    List<IComponent> getAllComponents();
    void removeComponent(Class<? extends IComponent> componentType);
}
