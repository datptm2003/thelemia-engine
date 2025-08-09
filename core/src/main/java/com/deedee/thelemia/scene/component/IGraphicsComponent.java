package com.deedee.thelemia.scene.component;

import com.deedee.thelemia.graphics.utils.IDisposable;
import com.deedee.thelemia.graphics.IContainer;
import com.deedee.thelemia.scene.IComponent;

public interface IGraphicsComponent extends IComponent, IDisposable {
    void render(int x, int y);
    boolean isVisible();
    void setVisible(boolean visible);

    IContainer getContainer();
    void setContainer(IContainer container);
}
