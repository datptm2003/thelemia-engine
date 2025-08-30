package com.deedee.thelemia.graphics;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public interface IRenderer {
    void draw(Actor object, int width, int height, float parentAlpha);
    void draw(Actor object, float scale, float parentAlpha);

    void addFrequentActor(String name, Actor object);
    void removeFrequentActor(String name);

    void loadShader(String name, String vertexPath, String fragmentPath);
    void applyShader(String name);
    void resetShader();

    void clearScreen(Color color);
}
