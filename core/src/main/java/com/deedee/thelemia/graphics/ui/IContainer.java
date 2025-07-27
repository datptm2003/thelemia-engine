package com.deedee.thelemia.graphics.ui;

import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.core.IGameObject;

public interface IContainer extends IGameObject {
    void add(String name, Widget widget, int x, int y);
    void remove(String name);
    void render();
}
