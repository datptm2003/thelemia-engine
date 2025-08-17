package com.deedee.thelemia.graphics;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.deedee.thelemia.core.IGameObject;
import com.deedee.thelemia.graphics.Renderer.ChildEntry;

import java.util.List;

public interface IContainer extends IGameObject {
    void add(String name, IRenderableObject object, Vector2 position);
    void remove(String name);
    void render(Vector2 position);

    Skin getSkin();
    List<ChildEntry<?>> getAllEntries();
}
