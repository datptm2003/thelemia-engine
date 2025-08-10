package com.deedee.thelemia.graphics.ui;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.deedee.thelemia.graphics.Renderer.ChildEntry;
import com.deedee.thelemia.graphics.Style;
import com.deedee.thelemia.graphics.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public abstract class CompositeWidget<C extends GraphicsContext, S extends Style> extends Widget<C, S> {
    protected final List<ChildEntry<Widget<?, ?>>> children = new ArrayList<>();

    public CompositeWidget(C context, S style) {
        super(context, style);
    }

    @Override
    public void create() {
        for (ChildEntry<Widget<?, ?>> child : children) {
            child.object.create();
        }
    }
    @Override
    public void start() {
        for (ChildEntry<Widget<?, ?>> child : children) {
            child.object.start();
        }
    }
    @Override
    public void update(float delta) {
        for (ChildEntry<Widget<?, ?>> child : children) {
            child.object.update(delta);
        }
    }
    @Override
    public void dispose() {
        for (ChildEntry<Widget<?, ?>> child : children) {
            child.object.dispose();
        }
        children.clear();
    }

    @Override
    public void render(Vector2 position) {
        for (ChildEntry<Widget<?, ?>> child : children) {
            child.object.render(new Vector2(position.x + child.position.x, position.y + child.position.y));
        }
    }
    @Override
    public void render() {
        for (ChildEntry<Widget<?, ?>> child : children) {
            child.object.render(new Vector2(context.getPosition().x + child.position.x, context.getPosition().y + child.position.y));
        }
    }

    public void addChild(String name, Widget<?, ?> widget, Vector2 position) {
        children.add(new ChildEntry<>(name, widget, position));
    }
    public void removeChild(Widget<?, ?> widget) {
        children.removeIf(entry -> entry.object == widget);
    }
    public <T extends Widget<?, ?>> T getChildByName(String name, Class<T> widgetType) {
        for (ChildEntry<Widget<?, ?>> entry : children) {
            if (entry.name.equals(name)) {
                return widgetType.cast(entry.object);
            }
        }
        return null;
    }
    public <T extends Widget<?, ?>> List<T> getChildrenByType(Class<T> widgetType) {
        List<T> widgets = new ArrayList<>();
        for (ChildEntry<Widget<?, ?>> entry : children) {
            if (widgetType.isInstance(entry.object)) {
                widgets.add(widgetType.cast(entry.object));
            }
        }
        return widgets;
    }
    public List<Widget<?, ?>> getAllChildren() {
        List<Widget<?, ?>> flat = new ArrayList<>();
        for (ChildEntry<Widget<?, ?>> entry : children) flat.add(entry.object);
        return flat;
    }

}
