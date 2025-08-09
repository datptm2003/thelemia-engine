package com.deedee.thelemia.graphics.sprite;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.deedee.thelemia.graphics.Container;
import com.deedee.thelemia.graphics.utils.IRenderableObject;

public class SpriteGroup extends Container implements ISpriteGroup {
    //TODO: Need implementation

    public SpriteGroup(Skin skin) {
        super(skin);
    }

    @Override
    public void add(String name, IRenderableObject object, Vector2 position) {
//        if (!(object instanceof Sprite)) {
//            throw new IllegalArgumentException("Only Sprite objects can be added to a SpriteGroup.");
//        }
        super.add(name, object, position);
    }

}
