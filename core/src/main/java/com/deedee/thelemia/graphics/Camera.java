package com.deedee.thelemia.graphics;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.core.IGameObject;

public class Camera implements IGameObject, ICamera {
    private final OrthographicCamera camera;

    public Camera(float width, float height) {
        this.camera = new OrthographicCamera(width, height);
        this.camera.setToOrtho(false, width, height);
    }

    @Override
    public void create() {

    }
    @Override
    public void start() {

    }
    @Override
    public void update(float delta) {
        camera.update();
    }
    @Override
    public void dispose() {

    }

    @Override
    public void setPosition(Vector2 position) {
        camera.position.set(position.x, position.y, 0);
    }
    @Override
    public void setViewport(float width, float height) {
        camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.update();
    }
    @Override
    public Matrix4 getProjectionMatrix() {
        return camera.combined;
    }


    public OrthographicCamera getInternalCamera() {
        return camera;
    }
}
