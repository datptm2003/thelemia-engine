package com.deedee.thelemia.graphics;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.deedee.thelemia.core.IGameObject;
import com.deedee.thelemia.scene.component.TransformComponent;

public interface IGraphicsObject extends IGameObject {
//    void render(TransformComponent transform);
    Skin getSkin();
}
