package com.deedee.thelemia.graphics.behavior;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface IRenderable {
    void render(int x, int y);
    Texture getTexture();
}
