#version 330
//layout(location = 0) in vec3 a_position;
//varying vec2 vTexCoord;
//
//void Main()
//{
//    gl_Position = vec4(a_position, 1.0);
//    vTextCoord = a_position;
//
//}

layout (location = 0) in vec3 vPos;
layout (location = 1) in vec2 vTexCoord;

out vec2 fTexCoord;

//uniform mat4 uModelViewProj

void main()
{
    gl_Position = vec4(vPos, 1.0);
    fTexCoord = vTexCoord;
}