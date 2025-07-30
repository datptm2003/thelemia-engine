package com.deedee.thelemia.graphics;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.deedee.thelemia.graphics.behavior.IRenderableObject;

public interface IRenderer {
    void draw(IRenderableObject object, Vector2 position, Vector2 size);
    void draw(IRenderableObject object, Vector2 position, float scale);
    void applyShader(String name);
    void resetShader();
    void clearScreen(Color color);
}
