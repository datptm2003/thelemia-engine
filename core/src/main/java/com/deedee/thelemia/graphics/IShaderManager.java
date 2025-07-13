package com.deedee.thelemia.graphics;

import com.badlogic.gdx.graphics.glutils.ShaderProgram;

public interface IShaderManager {
    void loadShader(String name, String vertexPath, String fragmentPath);
    ShaderProgram applyShader(String name);
    void setUniform(String name, Object value);
    void dispose();
}
