package com.deedee.thelemia.graphics;

import com.badlogic.gdx.graphics.Color;
import com.deedee.thelemia.scene.Entity;
import com.deedee.thelemia.scene.component.AnimatedSpriteComponent;
import com.deedee.thelemia.scene.component.TransformComponent;
import com.deedee.thelemia.scene.component.WidgetComponent;

public interface IRenderer {
    void addWidget(WidgetComponent widgetComponent);
    void addSprite(AnimatedSpriteComponent spriteComponent);

    void drawAnimatedSprite(AnimatedSprite sprite, TransformComponent transform);

    void loadShader(String name, String vertexPath, String fragmentPath);
    void applyShader(String name);
    void resetShader();

    void clearScreen(Color color);
}
