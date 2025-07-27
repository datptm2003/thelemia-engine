package com.deedee.thelemia.scene;

import com.deedee.thelemia.scene.enumerate.ComponentGroup;

import java.util.*;

public class Entity implements IEntity {
    private final String id;
    private final Map<Class<? extends IComponent>, IComponent> components = new HashMap<>();
    private final Map<ComponentGroup, Boolean> componentGroups = new HashMap<>();

    public Entity() {
        this.id = UUID.randomUUID().toString();
        initComponentGroups();
    }

    private void initComponentGroups() {
        for (ComponentGroup group : ComponentGroup.values()) componentGroups.put(group, false);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void addComponent(IComponent component) {
        components.put(component.getClass(), component);
        componentGroups.put(component.getGroup(), true);
    }
    @Override
    public boolean hasComponentGroup(ComponentGroup group) {
        return componentGroups.get(group);
    }
    @Override
    @SuppressWarnings("unchecked")
    public <T extends IComponent> T getComponent(Class<T> type) {
        return (T) components.get(type);
    }
    @Override
    @SuppressWarnings("unchecked")
    public <T extends IComponent> List<T> getComponentsByGroup(ComponentGroup group) {
        List<T> result = new ArrayList<>();
        for (IComponent component : components.values()) {
            if (component.getGroup() == group) {
                result.add((T) component);
            }
        }
        return result;
    }
    @Override
    public List<IComponent> getAllComponents() {
        return new ArrayList<>(components.values());
    }
    @Override
    public void removeComponent(Class<? extends IComponent> componentType) {
        components.remove(componentType);
    }

}
