package com.deedee.thelemia.graphics.ui;

import com.deedee.thelemia.core.IGameObject;
import com.deedee.thelemia.graphics.Renderer;
import com.deedee.thelemia.graphics.behavior.IRenderableObject;

import java.util.List;

public interface IContainer extends IGameObject {
    void add(String name, IRenderableObject object, int x, int y);
    void remove(String name);
    void render(int x, int y);
    List<Renderer.ChildEntry> getAllEntries();
}
