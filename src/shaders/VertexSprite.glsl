#version 330 core

layout (location = 0) in vec3 vPos;
layout (location = 1) in vec2 vTex;
layout (location = 2) in vec3 color;

uniform mat4 projectMatrix;
uniform mat4 viewMatrix;

out vec2 tCoord;

void main() {
    gl_Position =  projectMatrix* viewMatrix * vec4(vPos, 1.0);
    tCoord = vTex;
}