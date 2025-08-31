package com.deedee.thelemia.graphics;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.deedee.thelemia.scene.component.TransformComponent;

public interface IRenderer {
    void drawFragment(Fragment fragment, float parentAlpha);
    void drawAnimatedSprite(AnimatedSprite sprite, TransformComponent transform);

//    void addRenderable(String name, GraphicsObject renderable);
//    void removeRenderable(String name);

    void loadShader(String name, String vertexPath, String fragmentPath);
    void applyShader(String name);
    void resetShader();

    void clearScreen(Color color);
}
