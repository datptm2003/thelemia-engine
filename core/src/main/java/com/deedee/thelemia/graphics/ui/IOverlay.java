package com.deedee.thelemia.graphics.ui;

import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.core.IGameObject;

public interface IOverlay extends IGameObject {
    void render();
    void add(Widget widget, Vector2 position);
    void remove(Widget widget);

    void setLayer(int layer);
    int getLayer();
}
