#version 330


uniform vec2 iResolution;
uniform float iTime;
uniform float deltaTime;

uniform sampler3D tSample;
uniform vec3 color_of_sprite;
in vec3 SH_color;
in vec4 FragCoord;
in vec3 tCoord;

out vec4 FragColor;


void mainImage(  vec2 fragCoord)
{
    vec2 uv = (fragCoord);
    float d= length(uv) * (iTime);
    d = cos(d) * sin(d) * SH_color.x;
    float d2 = cos(d) * sin(d) * SH_color.y;
    float d3 = cos(d) * SH_color.z;
    FragColor = vec4(d,d2,d3,1.0);
}
void main()
{
//    vec2 fragCoord = vec2(FragCoord.x, FragCoord.y);
//    mainImage(fragCoord);
    FragColor = vec4(SH_color,1.0);

//    FragColor = vec4(SH_color,1.0);


}