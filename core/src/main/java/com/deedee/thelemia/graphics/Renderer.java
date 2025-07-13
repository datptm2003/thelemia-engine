package com.deedee.thelemia.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.core.IGameObject;

public class Renderer implements IGameObject, IRenderer {
    private final SpriteBatch batch;
    private final Camera camera;
    private final ShaderManager shaderManager;

    public Renderer(SpriteBatch batch, Camera camera, ShaderManager shaderManager) {
        System.out.println("ABC");
        this.batch = batch;
        this.camera = camera;
        this.shaderManager = shaderManager;
        this.batch.setProjectionMatrix(camera.getProjectionMatrix());
    }

    @Override
    public void create() {

    }
    @Override
    public void start() {

    }
    @Override
    public void update(float delta) {
        batch.setProjectionMatrix(this.camera.getProjectionMatrix());
    }
    @Override
    public void dispose() {
        batch.dispose();
        camera.dispose();
        shaderManager.dispose();
    }

    @Override
    public void begin() {
        batch.begin();
    }
    @Override
    public void draw(Texture texture, Vector2 position, Vector2 size) {
        batch.draw(texture, position.x, position.y, size.x, size.y);
    }
    @Override
    public void draw(Texture texture, Vector2 position, float scale) {
        float width = texture.getWidth() * scale;
        float height = texture.getHeight() * scale;
        batch.draw(texture, position.x, position.y, width, height);
    }
    @Override
    public void end() {
        batch.end();
    }
    @Override
    public void applyShader(String name) {
        ShaderProgram currentShader = shaderManager.applyShader(name);
        batch.setShader(currentShader);
    }
    @Override
    public void resetShader() {
        batch.setShader(null);
    }
    @Override
    public void clearScreen(float r, float g, float b, float a) {
        Gdx.gl.glClearColor(r, g, b, a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    public SpriteBatch getBatch() {
        return batch;
    }
    public Camera getCamera() {
        return camera;
    }
    public ShaderProgram getCurrentShader() {
        return shaderManager.getCurrentShader();
    }
}
