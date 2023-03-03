#version 330 core

in vec2 tCoord;
uniform sampler2D tSample;

out vec4 FragColor;

void main(){
//    vec3 color = vec3(texture(tSample, tCoord).r, texture(tSample, tCoord).g, texture(tSample, tCoord).b);
    vec4 color = texture(tSample,tCoord);
    if(color.a < 0.1){
        discard;
    }
    FragColor = color;
}
