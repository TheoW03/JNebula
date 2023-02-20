#version 330
out vec4 frag_color;
uniform vec4 myColor;


void main() {
    frag_color = myColor;
}