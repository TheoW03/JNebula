#version 330


uniform vec2 iResolution;
uniform float iTime;
uniform float deltaTime;


uniform vec3 color_of_sprite;
in vec3 SH_color;
in vec4 FragCoord;
out vec4 FragColor;
//void mainImage(vec2 fragCoord)
//{
//    vec2 uv = fragCoord / iResolution.xy;  // Normalize coordinates
//
//    // Determine which face is being rendered based on UV coordinates
//    vec3 faceColor = vec3(0.0);
//    if (uv.x < 0.2) { // Left face
//        faceColor = vec3(1.0, 0.0, 0.0);
//    } else if (uv.x < 0.4) { // Right face
//        faceColor = vec3(0.0, 1.0, 0.0);
//    } else if (uv.x < 0.6) { // Front face
//        faceColor = vec3(0.0, 0.0, 1.0);
//    } else if (uv.x < 0.8) { // Back face
//        faceColor = vec3(1.0, 1.0, 0.0);
//    } else { // Top and bottom faces
//        faceColor = vec3(1.0, 0.0, 1.0);
//    }
//
//    float d = length(uv) * iTime;
//    d = cos(d) * sin(d) * faceColor.x;
//    float d2 = cos(d) * sin(d) * faceColor.y;
//    float d3 = cos(d) * faceColor.z;
//
//    FragColor = vec4(d, d2, d3, 1.0);
//}
void mainImage(  vec2 fragCoord)
{
    vec2 uv = (fragCoord);
    float d= length(uv) * (iTime-(iTime -1));
    d = cos(d) * sin(d) * SH_color.x;
    float d2 = cos(d) * sin(d) * SH_color.y;
    float d3 = cos(d) * SH_color.z;



    FragColor = vec4(-d,-d2,d3,1.0);
}
void main()
{
    vec2 fragCoord = vec2(FragCoord.x, FragCoord.y);
    mainImage(fragCoord);

//    FragColor = vec4(SH_color,1.0);


}