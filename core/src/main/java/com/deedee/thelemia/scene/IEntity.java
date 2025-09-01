package com.deedee.thelemia.scene;

import com.deedee.thelemia.scene.enumerate.ComponentGroup;

import java.util.List;

public interface IEntity {
    void addComponent(Component component);
    boolean hasComponentGroup(ComponentGroup group);
    <T extends Component> T getComponentByType(Class<T> type);
    <T extends Component> List<T> getComponentsByGroup(ComponentGroup group);
    List<Component> getAllComponents();
    void removeComponent(Class<? extends Component> componentType);
}
