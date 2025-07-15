package com.deedee.thelemia.graphics.ui;

import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.core.IGameObject;

public interface IContainer extends IGameObject {
    void add(Widget widget, Vector2 position);
    void remove(Widget widget);
    void render();
}
