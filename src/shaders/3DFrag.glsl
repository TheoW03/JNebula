#version 330

uniform vec3 color_of_sprite;
in vec3 SH_color;
in vec4 FragPosition;
out vec4 FragColor;

void main()
{
    FragColor = vec4(SH_color, 1.0);

}