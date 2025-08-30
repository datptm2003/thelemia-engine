package com.deedee.thelemia.scene;

import com.deedee.thelemia.scene.component.TransformComponent;
import com.deedee.thelemia.scene.enumerate.ComponentGroup;

import java.util.*;

public class Entity implements IEntity {
    protected final String id;
    protected final Map<Class<? extends Component>, Component> components = new HashMap<>();
    protected final Map<ComponentGroup, Boolean> componentGroups = new HashMap<>();

    public Entity() {
        this.id = UUID.randomUUID().toString();
        init();
    }

    private void init() {
        for (ComponentGroup group : ComponentGroup.values()) componentGroups.put(group, false);
        addComponent(new TransformComponent(this));
    }

    @Override
    public void addComponent(Component component) {
        components.put(component.getClass(), component);
        componentGroups.put(component.getGroup(), true);
    }
    @Override
    public boolean hasComponentGroup(ComponentGroup group) {
        return componentGroups.get(group);
    }
    @Override
    @SuppressWarnings("unchecked")
    public <T extends Component> T getComponentByType(Class<T> type) {
        return (T) components.get(type);
    }
    @Override
    @SuppressWarnings("unchecked")
    public <T extends Component> List<T> getComponentsByGroup(ComponentGroup group) {
        List<T> result = new ArrayList<>();
        for (Component component : components.values()) {
            if (component.getGroup() == group) {
                result.add((T) component);
            }
        }
        return result;
    }
    @Override
    public List<Component> getAllComponents() {
        return new ArrayList<>(components.values());
    }
    @Override
    public void removeComponent(Class<? extends Component> componentType) {
        components.remove(componentType);
    }

    public String getId() {
        return id;
    }
}
