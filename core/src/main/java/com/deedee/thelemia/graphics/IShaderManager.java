package com.deedee.thelemia.graphics;

import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.Disposable;

public interface IShaderManager extends Disposable {
    void loadShader(String name, String vertexPath, String fragmentPath);
    ShaderProgram applyShader(String name);
    void setUniform(String name, Object value);
}
