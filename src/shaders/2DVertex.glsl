#version 430 core

layout (location = 0) in vec3 vPos;
layout (location = 1) in vec2 vTex;
layout (location = 2) in vec3 anormal;


uniform mat4 projectMatrix;
uniform mat4 viewMatrix;
uniform mat4 model;
uniform mat4 rot;

//uniform vec3 pointLightPosition;


uniform float dt;
uniform float vx;
uniform float vy;
uniform float lightExits2 = 0;
uniform vec2 screenRes;

out vec4 pointLightPosition;
out vec2 tCoord;
out vec3 FragPos;
out vec3 Normal;// Normal of the vertex in world space
out vec4 lightSourcelocation;


void main() {
    vec4 pos = vec4(vPos, 1.0);
    pos = rot*pos;
    //    gl_Position = getRotationMatrix(45)*model*projectMatrix* viewMatrix*vec4(vPos,1.0);


    gl_Position = (model)*projectMatrix* viewMatrix * pos;


    //    gl_Position *= screenRes.x/screenRes.y; //T~T
    if (lightExits2 == 1){
        vec3 pointLightPosition = vPos;
        FragPos = vec3(model * vec4(vPos, 1.0));
        Normal = mat3(transpose(inverse(model))) * anormal;
    }
    lightSourcelocation = gl_Position;
    tCoord = vTex;
}