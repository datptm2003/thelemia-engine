package com.deedee.thelemia.graphics.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.deedee.thelemia.core.IGameObject;
import com.deedee.thelemia.graphics.Renderer.ChildEntry;
import com.deedee.thelemia.graphics.utils.IRenderableObject;

import java.util.List;

public interface IContainer extends IGameObject {
    void add(String name, IRenderableObject object, int x, int y);
    void remove(String name);
    void render(int x, int y);

    Skin getSkin();
    List<ChildEntry<IRenderableObject>> getAllEntries();
}
