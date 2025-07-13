package com.deedee.thelemia.graphics.ui;

import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.core.IGameObject;

public interface IFragment extends IGameObject {
    void render();
    void add(Widget widget, Vector2 position);
    void remove(Widget widget);
}
