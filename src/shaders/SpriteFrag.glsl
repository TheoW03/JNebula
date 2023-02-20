#version 330 core

in vec2 tCoord;
uniform sampler2D tSample;

out vec3 FragColor;

void main(){
    vec3 color = vec3(texture(tSample, tCoord).r, texture(tSample, tCoord).g, texture(tSample, tCoord).b);
    FragColor = color;
}
