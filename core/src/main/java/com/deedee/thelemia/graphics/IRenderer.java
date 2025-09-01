package com.deedee.thelemia.graphics;

import com.badlogic.gdx.graphics.Color;
import com.deedee.thelemia.scene.Entity;
import com.deedee.thelemia.scene.component.TransformComponent;

public interface IRenderer {
    void addWidget(Entity widgetEntity);
    void addAnimatableEntity(Entity animatableEntity);

    void drawAnimatedSprite(AnimatedSprite sprite, TransformComponent transform);

    void loadShader(String name, String vertexPath, String fragmentPath);
    void applyShader(String name);
    void resetShader();

    void clearScreen(Color color);
}
