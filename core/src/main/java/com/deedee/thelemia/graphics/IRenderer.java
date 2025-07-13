package com.deedee.thelemia.graphics;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public interface IRenderer {
    void begin();
    void draw(Texture texture, Vector2 position, Vector2 size);
    void draw(Texture texture, Vector2 position, float scale);
    void end();
    void applyShader(String name);
    void resetShader();
    void clearScreen(float r, float g, float b, float a);
}
