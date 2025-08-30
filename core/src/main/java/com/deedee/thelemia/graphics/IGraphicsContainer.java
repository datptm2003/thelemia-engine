package com.deedee.thelemia.graphics;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.deedee.thelemia.core.IGameObject;

public interface IGraphicsContainer extends IGameObject {
    void add(String name, Actor actor);
    void remove(String name);
    void render();

    Skin getSkin();
}
