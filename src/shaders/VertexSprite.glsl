#version 330 core

layout (location = 0) in vec3 vPos;
layout (location = 1) in vec2 vTex;
layout (location = 2) in vec3 color;

uniform mat4 projectMatrix;
uniform mat4 viewMatrix;
uniform mat4 model;

uniform float dt;
uniform float vx;
uniform float vy;


out vec2 tCoord;

//mat4 getRotationMatrix(float angle) {
//    float c = cos(radians(angle));
//    float s = sin(radians(angle));
//    return mat4(c, -s, 0.0, 0.0,
//    s, c, 0.0, 0.0,
//    0.0, 0.0, 1.0, 0.0,
//    0.0, 0.0, 0.0, 1.0);
//}

void main() {
    gl_Position =  model*projectMatrix* viewMatrix * vec4(vPos, 1.0);
    tCoord = vTex;
}