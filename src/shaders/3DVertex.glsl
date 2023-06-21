#version 330 core

layout (location = 0) in vec3 position;
layout (location = 1) in vec3 color; // the color variable has attribute position 1

uniform mat4 model;
uniform mat4 rot;
out vec3 SH_color;
void main(){
    gl_Position = model*vec4(position, 1.0);
    SH_color = color;

}