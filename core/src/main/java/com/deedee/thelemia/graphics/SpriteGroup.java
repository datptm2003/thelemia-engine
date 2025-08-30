package com.deedee.thelemia.graphics;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class SpriteGroup extends GraphicsContainer implements ISpriteGroup {
    //TODO: Need implementation

    public SpriteGroup(Skin skin) {
        super(skin);
    }

    @Override
    public void add(String name, Actor actor) {
//        if (!(object instanceof Sprite)) {
//            throw new IllegalArgumentException("Only Sprite objects can be added to a SpriteGroup.");
//        }
        super.add(name, actor);
    }

}
