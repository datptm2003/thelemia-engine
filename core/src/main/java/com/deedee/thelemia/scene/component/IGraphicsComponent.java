package com.deedee.thelemia.scene.component;

import com.badlogic.gdx.utils.Disposable;
import com.deedee.thelemia.graphics.GraphicsContainer;
import com.deedee.thelemia.scene.IComponent;

public interface IGraphicsComponent extends IComponent, Disposable {
    void render();
    boolean isVisible();
    void setVisible(boolean visible);

    GraphicsContainer getContainer();
}
