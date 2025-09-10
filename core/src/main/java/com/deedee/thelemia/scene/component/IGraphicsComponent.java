package com.deedee.thelemia.scene.component;

import com.badlogic.gdx.utils.Disposable;
import com.deedee.thelemia.graphics.RenderableObject;
import com.deedee.thelemia.scene.IComponent;

public interface IGraphicsComponent extends IComponent, Disposable {
    boolean isVisible();
    void setVisible(boolean visible);

    RenderableObject getRenderableObject();
}
