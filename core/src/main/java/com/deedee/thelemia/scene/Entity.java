package com.deedee.thelemia.scene;

import java.util.*;

public class Entity implements IEntity {
    private final Map<Class<? extends IComponent>, IComponent> components = new HashMap<>();

    @Override
    public void addComponent(IComponent component) {
        components.put(component.getClass(), component);
    }
    @Override
    @SuppressWarnings("unchecked")
    public <T extends IComponent> T getComponent(Class<T> componentType) {
        return (T) components.get(componentType);
    }
    @Override
    public void removeComponent(Class<? extends IComponent> componentType) {
        components.remove(componentType);
    }

    public List<IComponent> getComponents() {
        return new ArrayList<>(components.values());
    }
}
