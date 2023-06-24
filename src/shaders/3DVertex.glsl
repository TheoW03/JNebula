#version 330 core

layout (location = 0) in vec3 position;
layout (location = 1) in vec3 color; // the color variable has attribute position 1

uniform mat4 model;
uniform mat4 projectMatrix;
uniform mat4 viewMatrix;
uniform mat4 rot; //T~T i ned to get off :') but im addicted. AAAA

out vec4 FragCoord;
out vec3 SH_color;


void main(){
    vec4 l = rot*vec4(position, 1.0);
    gl_Position = l;
    FragCoord = gl_Position;
    SH_color = color;
}