package com.deedee.thelemia.graphics.ui;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.deedee.thelemia.graphics.Container;
import com.deedee.thelemia.graphics.utils.IRenderableObject;
import com.deedee.thelemia.graphics.Renderer.ChildEntry;

import java.util.*;

public class Fragment extends Container implements IFragment {
    public Fragment(Skin skin) {
        super(skin);
    }

    @Override
    public void add(String name, IRenderableObject object, Vector2 position) {
        if (!(object instanceof Widget)) {
            throw new IllegalArgumentException("Only Widget objects can be added to a Fragment.");
        }
        super.add(name, object, position);
    }

    @Override
    public <T extends Widget> T getWidgetByName(String name, Class<T> type) {
        for (ChildEntry<IRenderableObject> entry : entries) {
            if (Objects.equals(entry.name, name) && type.isInstance(entry.object)) {
                return type.cast(entry.object);
            }
        }
        return null;
    }

}
