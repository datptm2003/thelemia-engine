package com.deedee.thelemia.graphics;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;

public class Fragment extends GraphicsContainer implements IFragment {
    public Fragment(Skin skin) {
        super(skin);
    }

    @Override
    public void add(String name, Actor widget) {
        super.add(name, widget);
    }

    @Override
    public <T extends Widget> T getWidgetByName(String name, Class<T> type) {
        if (entries.containsKey(name)) {
            Actor actor = entries.get(name);
            if (type.isInstance(actor)) {
                return type.cast(actor);
            }
        }
        return null;
    }

}
