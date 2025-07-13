#ifdef GL_ES
precision mediump float;
#endif

varying vec4 v_color;
varying vec2 v_texCoords;   // Texture coordinates from vertex shader
uniform sampler2D u_texture;  // Card texture
uniform mat4 u_projTrans;

uniform sampler2D u_backTexture;
uniform float u_time;
uniform float u_duration;

void main() {
    vec2 uv = v_texCoords;

    float progress = clamp(u_time / u_duration, 0.0, 1.0);
    float angle = progress * 3.14159265; // Map progress to π (180° flip)

    float scale = cos(angle);
    uv.x = (uv.x - 0.5) / scale + 0.5;

    bool isBack = (progress >= 0.5);  // If sin(angle) < 0, show back side

    if (uv.x < 0.0 || uv.x > 1.0) {
        discard;
    }

    vec4 texColor = isBack ? texture2D(u_backTexture, uv) : texture2D(u_texture, uv);
    gl_FragColor = texColor * v_color;
}
