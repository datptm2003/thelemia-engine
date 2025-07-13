#ifdef GL_ES
precision mediump float;
#endif

varying vec4 v_color;
varying vec2 v_texCoords;
uniform sampler2D u_texture;
uniform mat4 u_projTrans;

//uniform sampler2D u_noiseTexture;

uniform float u_time;
uniform float u_duration;

void main() {
    vec4 color = texture2D(u_texture, v_texCoords).rgba;
//    vec3 dissolve = texture2D(u_noiseTexture, v_texCoords).rgb;
//    float dissolveValue = (dissolve.r + dissolve.g + dissolve.b) / 3.0;
    float alpha = clamp(u_time / u_duration, 0.0, 1.0);

    gl_FragColor = vec4(color.r, color.g, color.b, clamp(color.a - alpha, 0.0, 1.0));
}
