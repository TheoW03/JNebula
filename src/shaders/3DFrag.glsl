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
    vec2 uv = (fragCoord*2.0-1.0);

    // Time varying pixel color

    float d = length(uv);
    d = sin(d*8.0+iTime)/8.0;

    d = abs(d);

    // Output to screen
    FragColor = vec4(uv,d,1.0);
}
void main()
{
    vec2 fragCoord = vec2(FragCoord.x, FragCoord.y);
//    mainImage(fragCoord);
    FragColor = vec4(SH_color,1.0);

//    FragColor = vec4(SH_color,1.0);


}

