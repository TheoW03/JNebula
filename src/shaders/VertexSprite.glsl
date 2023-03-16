#version 330 core

layout (location = 0) in vec3 vPos;
layout (location = 1) in vec2 vTex;
layout (location = 2) in vec3 anormal;


uniform mat4 projectMatrix;
uniform mat4 viewMatrix;
uniform mat4 model;
//uniform vec3 pointLightPosition;


uniform float dt;
uniform float vx;
uniform float vy;
uniform float lightExits2 = 0;

out vec4 pointLightPosition;
out vec2 tCoord;
out vec3 FragPos;
out vec3 Normal;   // Normal of the vertex in world space
out vec4 lightSourcelocation;

//mat4 getRotationMatrix(float angle) {
//    float c = cos(radians(angle));
//    float s = sin(radians(angle));
//    return mat4(c, -s, 0.0, 0.0,
//    s, c, 0.0, 0.0,
//    0.0, 0.0, 1.0, 0.0,
//    0.0, 0.0, 0.0, 1.0);
//}
//temp commenr
void main() {
    gl_Position =  model*projectMatrix* viewMatrix * vec4(vPos, 1.0);

    if(lightExits2 == 1){
        vec3 pointLightPosition = vPos;
        FragPos = vec3(model * vec4(vPos, 1.0));
        Normal = mat3(transpose(inverse(model))) * anormal;
    }
    lightSourcelocation = gl_Position;
    tCoord = vTex;
}