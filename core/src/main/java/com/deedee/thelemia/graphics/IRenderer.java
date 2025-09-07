package com.deedee.thelemia.graphics;

import com.badlogic.gdx.graphics.Color;
import com.deedee.thelemia.scene.component.AnimatedSpriteComponent;
import com.deedee.thelemia.scene.component.ParticlesComponent;
import com.deedee.thelemia.scene.component.TileMapComponent;
import com.deedee.thelemia.scene.component.WidgetComponent;

public interface IRenderer {
    void addWidget(WidgetComponent widgetComponent);
    void addAnimatedSprite(AnimatedSpriteComponent spriteComponent);
    void addParticles(ParticlesComponent particlesComponent);
    void changeTileMap(TileMapComponent tileMapComponent, float unitScale);

    void drawAnimatedSprite(AnimatedSpriteComponent spriteComponent);
    void drawParticles(ParticlesComponent particlesComponent);

    void loadShader(String name, String vertexPath, String fragmentPath);
    void applyShader(String name);
    void resetShader();

    void clearScreen(Color color);
}
