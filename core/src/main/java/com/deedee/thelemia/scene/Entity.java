package com.deedee.thelemia.scene;

import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.ai.fsm.StateMachine;
import com.deedee.thelemia.graphics.Renderer.ChildEntry;
import com.deedee.thelemia.graphics.utils.IRenderableObject;
import com.deedee.thelemia.scene.component.IGraphicsComponent;
import com.deedee.thelemia.scene.component.TransformComponent;
import com.deedee.thelemia.scene.enumerate.ComponentGroup;

import java.util.*;

public class Entity implements IEntity {
    protected final String id;
    protected final Map<Class<? extends IComponent>, IComponent> components = new HashMap<>();
    protected final Map<ComponentGroup, Boolean> componentGroups = new HashMap<>();

    public Entity() {
        this.id = UUID.randomUUID().toString();
        init();
    }

    private void init() {
        for (ComponentGroup group : ComponentGroup.values()) componentGroups.put(group, false);
        addComponent(new TransformComponent());
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
    public <T extends IComponent> T getComponentByType(Class<T> type) {
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

    @Override
    public IRenderableObject getHitObject(int x, int y) {
        TransformComponent transform = getComponentByType(TransformComponent.class);
        if (transform == null) return null;

        Vector2 entityPos = transform.getPosition();

        List<IGraphicsComponent> graphicsComponents = getComponentsByGroup(ComponentGroup.GRAPHICS);
        for (IGraphicsComponent graphicsComponent : graphicsComponents) {
            List<ChildEntry<IRenderableObject>> entries = graphicsComponent.getContainer().getAllEntries();

            for (int i = entries.size() - 1; i >= 0; i--) {
                ChildEntry<IRenderableObject> entry = entries.get(i);
                IRenderableObject renderable = entry.object;

                Vector2 hitboxSize = renderable.getHitboxSize();
                float hitboxWidth = hitboxSize.x;
                float hitboxHeight = hitboxSize.y;

                float worldX = entityPos.x + entry.x;
                float worldY = entityPos.y + entry.y;

                if (x >= worldX && x <= worldX + hitboxWidth &&
                    y >= worldY && y <= worldY + hitboxHeight) {
                    return renderable;
                }
            }
        }

        return null;
    }

    public String getId() {
        return id;
    }
}
