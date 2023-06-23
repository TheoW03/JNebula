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

//mat4 getRotationMatrix(float angle) {
//    float c = cos(radians(angle));
//    float s = sin(radians(angle));
//    return mat4(c, -s, 0.0, 0.0,
//                s, c, 0.0, 0.0,
//                0.0, 0.0, 1.0, 0.0,
//                0.0, 0.0, 0.0, 1.0);
//}
//temp commenr

//float signedDst(vec3 point, vec3 center, vec3 size){
//    vec3 offset = abs(point-center) - size;
//    float unsignedDst = magnitude(max(offset,0));
//    float signedDst = max(min(offset,0),0);
//    return unsignedDst+signedDst;
//}
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