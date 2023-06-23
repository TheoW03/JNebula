#version 430 core

in vec3 FragPos;
in vec3 Normal;

in vec2 tCoord;
in vec2 toLight;
in vec4 lightSourcelocation;
uniform sampler2D tSample;

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

struct Light {
    vec3 position;
    vec3 color;
    float intensity;
};
struct Ray {
    vec3 origin;
    vec3 direction;
};
struct renderedObject{
    vec3 textureCoords;
    vec4 color;
};

vec4 calcLight(Light light){
    return vec4(0,0,0,0);
}
Ray[4] rays(){

    // Define the corners of the square in camera space
    vec3 bl = vec3(-1.0, -1.0, 0.0);
    vec3 br = vec3(1.0, -1.0, 0.0);
    vec3 tl = vec3(-1.0, 1.0, 0.0);
    vec3 tr = vec3(1.0, 1.0, 0.0);

    // Generate rays for each corner of the square
    Ray rays[4];
    rays[0] = Ray(camera_pos, normalize(bl - camera_pos));
    rays[1] = Ray(camera_pos, normalize(br - camera_pos));
    rays[2] = Ray(camera_pos, normalize(tl - camera_pos));
    rays[3] = Ray(camera_pos, normalize(tr - camera_pos));
    return rays;
}
vec4 mainImage(  vec2 fragCoord)
{

    vec2 uv = fragCoord.xy;
    vec2 pos = (uv.xy-0.5);
    vec2 cir = ((pos.xy*pos.xy+sin(uv.x*18.0+iTime)/25.0*sin(uv.y*7.0+iTime*1.5)/1.0)+uv.x*sin(iTime)/16.0+uv.y*sin(iTime*1.2)/16.0);
    float circles = (sqrt(abs(cir.x+cir.y*0.5)*25.0)*5.0);
    vec4 fragColor = vec4(sin(circles*1.25+2.0),abs(sin(circles*1.0-1.0)-cos(circles)),abs(sin(circles)*1.0),1.0);
    return fragColor;
}
void main(){


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

        //        vec3 result = ambient * objectColor;
        //        vec4 color = texture(tSample, tCoord)+vec4(result,1.0);
        //        if (color.a < 0.1){
        //            discard;
        //        }

        if (LightSource == 1){
            vec3 result = (ambient)*objectColor;
            FragColor = vec4(result, 1.0)*texture(tSample, tCoord);
//            FragColor *= screenRes.x/screenRes.y; //needed so stuff stays consistent


        } else {
            vec3 result = (diffuse+ambient+specular)*objectColor;
            FragColor = vec4(result, 1.0)*texture(tSample, tCoord);

        }
    } else {
        vec4 c = vec4(color_of_sprite,1.0);
        if(textureExists == 0){
            vec4 color = texture(tSample, tCoord);
            FragColor = c*color;

        }else if(textureExists == 1){
            FragColor = vec4(color_of_sprite,1.0);
//            FragColor *= screenRes.x/screenRes.y; //needed so stuff stays consistent

        }else{

        }

    }

    //    color *= vec4(lightColor,1.0);

    //


    //    vec2 distance = location - tCoord;

    //    float raidalFallof = pow(1.0 - distance,2.0);
    //    float angularFalloff = smoothstep()

    //    vec3 color = vec3(texture(tSample, tCoord).r, texture(tSample, tCoord).g, texture(tSample, tCoord).b);

}
