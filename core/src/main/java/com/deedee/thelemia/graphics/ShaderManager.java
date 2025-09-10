package com.deedee.thelemia.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.Disposable;

import java.util.HashMap;
import java.util.Map;

public class ShaderManager implements Disposable {
    private final Map<String, ShaderProgram> shaders = new HashMap<>();
    private ShaderProgram currentShader;

    public ShaderManager() {}

    public void loadShader(String name, String vertexPath, String fragmentPath) {
        String vertexCode = Gdx.files.internal(vertexPath).readString();
        String fragmentCode = Gdx.files.internal(fragmentPath).readString();

        ShaderProgram shader = new ShaderProgram(vertexCode, fragmentCode);

        if (!shader.isCompiled()) {
            throw new RuntimeException("Shader compile error: " + shader.getLog());
        }

        shaders.put(name, shader);
    }
    public ShaderProgram applyShader(String name) {
        ShaderProgram shader = shaders.get(name);
        if (shader != null) {
            currentShader = shader;
            shader.bind(); // Must be called before setting uniforms
        }
        return currentShader;
    }
    public void setUniform(String name, Object value) {
        if (currentShader == null) return;

        if (value instanceof Float)
            currentShader.setUniformf(name, (Float) value);
        else if (value instanceof Integer)
            currentShader.setUniformi(name, (Integer) value);
        else if (value instanceof com.badlogic.gdx.math.Vector2)
            currentShader.setUniformf(name, (com.badlogic.gdx.math.Vector2) value);
        else if (value instanceof com.badlogic.gdx.math.Vector3)
            currentShader.setUniformf(name, (com.badlogic.gdx.math.Vector3) value);
        else if (value instanceof com.badlogic.gdx.math.Matrix4)
            currentShader.setUniformMatrix(name, (com.badlogic.gdx.math.Matrix4) value);
        else
            throw new IllegalArgumentException("Unsupported uniform type: " + value.getClass());
    }
    @Override
    public void dispose() {
        for (ShaderProgram shader : shaders.values()) {
            shader.dispose();
        }
        shaders.clear();
    }

    public ShaderProgram getCurrentShader() {
        return currentShader;
    }
}

