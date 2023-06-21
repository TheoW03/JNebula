#version 330

uniform vec3 color_of_sprite;

out vec4 FragColor;

void main()
{
    FragColor = vec4(color_of_sprite, 1.0);

}