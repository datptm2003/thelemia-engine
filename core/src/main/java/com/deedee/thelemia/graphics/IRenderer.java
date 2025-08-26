package com.deedee.thelemia.graphics;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public interface IRenderer {
    void draw(IRenderableObject object, Vector2 position, int width, int height);
    void draw(IRenderableObject object, Vector2 position, float scale);

    void addFrequentObjects(String name, IRenderableObject object, Vector2 position);
    void removeFrequentObjects(String name);

    void addSkin(String name, Skin skin);
    void addSkin(String name, String skinPath);
    Skin getSkin(String name);

    void loadShader(String name, String vertexPath, String fragmentPath);
    void applyShader(String name);
    void resetShader();

    void clearScreen(Color color);
}
