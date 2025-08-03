package com.deedee.thelemia.graphics;

import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.deedee.thelemia.graphics.utils.IDisposable;

public interface IShaderManager extends IDisposable {
    void loadShader(String name, String vertexPath, String fragmentPath);
    ShaderProgram applyShader(String name);
    void setUniform(String name, Object value);
}
