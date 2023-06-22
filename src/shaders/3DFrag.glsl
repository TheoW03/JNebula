#version 330


uniform vec2 iResolution;
uniform float iTime;
uniform float deltaTime;


uniform vec3 color_of_sprite;
in vec3 SH_color;
out vec4 FragColor;

void main()
{

    FragColor = vec4(SH_color,1.0);


}