package com.deedee.thelemia.scene;

import java.util.*;

public class Entity implements IEntity {
    private final String id;
    private final Map<Class<? extends IComponent>, IComponent> components = new HashMap<>();

    public Entity() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String getId() {
        return id;
    }

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
    public List<IComponent> getComponents() {
        return new ArrayList<>(components.values());
    }
    @Override
    public void removeComponent(Class<? extends IComponent> componentType) {
        components.remove(componentType);
    }

}
