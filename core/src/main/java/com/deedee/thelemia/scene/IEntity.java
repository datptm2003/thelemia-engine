package com.deedee.thelemia.scene;

import com.deedee.thelemia.graphics.utils.IRenderableObject;
import com.deedee.thelemia.scene.enumerate.ComponentGroup;

import java.util.List;

public interface IEntity {
    void addComponent(IComponent component);
    boolean hasComponentGroup(ComponentGroup group);
    <T extends IComponent> T getComponentByType(Class<T> type);
    <T extends IComponent> List<T> getComponentsByGroup(ComponentGroup group);
    List<IComponent> getAllComponents();
    void removeComponent(Class<? extends IComponent> componentType);

    IRenderableObject getHitObject(int x, int y);
}
