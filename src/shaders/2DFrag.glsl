
in vec3 FragPos;
in vec3 Normal;

in vec2 tCoord;
in vec2 toLight;
in vec4 lightSourcelocation;
uniform sampler2D tSample;
#define PI 3.1415

uniform vec2 iResolution;
uniform float iTime;
uniform float deltaTime;

uniform float Lightexists = 0;
uniform float LightSource = 0;
uniform float fColor;
uniform vec3 lightPos;
uniform vec3 lightColor;
uniform vec3 objectColor;
//uniform float ambientStrength;
uniform float diffuseStrength;
uniform float specularStrength;
uniform float shininess;
uniform float strength;
uniform vec3 viewPos;
uniform float textureExists = -1;
uniform vec3 camera_pos;
uniform vec3 color_of_sprite;

//uniform float baseIntensity;
//uniform vec3 color;
//uniform vec2 location;
//uniform vec3 lightColor;
uniform float lightIntensity;

out vec4 FragColor;


vec4 mainImage(vec2 fragCoord)
{

    vec2 uv = fragCoord.xy;
    vec2 pos = (uv.xy-0.5);
    vec2 cir = ((pos.xy*pos.xy+sin(uv.x*18.0+iTime)/25.0*sin(uv.y*7.0+iTime*1.5)/1.0)+uv.x*sin(iTime)/16.0+uv.y*sin(iTime*1.2)/16.0);
    float circles = (sqrt(abs(cir.x+cir.y*0.5)*25.0)*5.0);
    vec4 fragColor = vec4(sin(circles*1.25+2.0), abs(sin(circles*1.0-1.0)-cos(circles)), abs(sin(circles)*1.0), 1.0);
    return fragColor;
}
void main(){

    vec3 effect_shderOut = vec3(0, 0, 0);

    //this is for Effect shaders :D i finally adding support :3
    #if defined(EFFECT_SHADER)
    util_effectShader a;
    a.deltaTime = deltaTime;
    a.iResolution = iResolution;
    a.iTime = iTime;
    effect_shderOut =  effectShader(a);
    #endif



    if (Lightexists == 1){
        //        float ambientS = 0.1;

        vec3 lightDir = normalize(lightPos - FragPos);
        vec3 viewDir = normalize(viewPos - FragPos);


        vec3 norm = normalize(Normal);
        vec3 reflectDir = reflect(lightDir, norm);
        float spec = pow(max(dot(viewDir, reflectDir), 0.0), 4);

        float diff = max(dot(norm, lightDir), 0.0);

        vec3 diffuse = diff * lightColor;
        vec3 ambient = strength * lightColor;
        vec3 specular = specularStrength * spec * lightColor;

        if (LightSource == 1){
            vec3 result = (ambient)*objectColor;
            FragColor = vec4(result, 1.0)*texture(tSample, tCoord);

        } else {
            vec3 result = (diffuse+ambient+specular)*objectColor;
            FragColor = vec4(result, 1.0)*texture(tSample, tCoord);

        }
    } else {
        vec4 c = vec4(color_of_sprite, 1.0);
        if (textureExists == 0){
            vec4 color = texture(tSample, tCoord);
            FragColor = c*color;

        } else if (textureExists == 1){
            FragColor = vec4(color_of_sprite, 1.0);

        } else {

        }

    }


}
