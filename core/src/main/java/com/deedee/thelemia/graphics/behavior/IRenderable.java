package com.deedee.thelemia.graphics.behavior;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public interface IRenderable {
    void render(int x, int y);
    void render();
}
