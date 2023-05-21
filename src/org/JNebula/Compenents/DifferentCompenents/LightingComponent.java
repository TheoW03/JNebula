package org.JNebula.Compenents.DifferentCompenents;


import org.JNebula.Compenents.iComponent;
import org.JNebula.Tooling.LoadShader;
import org.JNebula.math.Vector3;
import org.JNebula.math.VectorMath;

import java.nio.FloatBuffer;
import java.util.Arrays;

import static com.jogamp.opengl.GL.*;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */


public class LightingComponent extends iComponent {

    public float intensity;
    public float[] lightColor;
    public float strength;
    public Vector3 lightLocation, cameraPos;
    public LightingComponent source;

    public LightingComponent(float intensity,
                             float[] lightColor,
                             float strength) {
        this.gl = gl;
        this.lightColor = lightColor;
        this.strength = strength;
        this.intensity = intensity;

    }

    public LightingComponent(LightingComponent source) {
        this.lightColor = source.lightColor;
        this.strength = source.strength;
        this.intensity = source.intensity;
        this.lightLocation = source.lightLocation;
        this.cameraPos = source.cameraPos;
        this.source = source;
    }

    public LightingComponent() {


    }

    @Override
    public void init(float dt) {

    }

    @Override
    public String toString() {
        return "LightingComponent";
    }

    public void bake() {

    }

    float i = 0;

    @Override
    public void update(float dt) {


    }

    float i2 = 1.0f;

    @Override
    public void sendtoGPU(int shaderProgram, LoadShader sh) {
        int[] buffers = new int[2];
        if (source != null) {
            if (source.gameObject.GetCompenent(TransformComponent.class) == null || source.gameObject.GetCompenent(CameraComponent.class) == null) {
                this.lightLocation = new Vector3(0, 0, 0);
                this.cameraPos = new Vector3(0, 0, 0);
            } else {
                this.lightLocation = source.gameObject.GetCompenent(TransformComponent.class).location;
                this.cameraPos = source.gameObject.GetCompenent(CameraComponent.class).cameralocation;
            }
        } else {
            this.lightLocation = this.gameObject.GetCompenent(TransformComponent.class).location;
            this.cameraPos = this.gameObject.GetCompenent(CameraComponent.class).cameralocation;
        }

        gl.glGenBuffers(2, buffers, 0);
        int lightColorLoc = gl.glGetUniformLocation(shaderProgram, "lightColor");
        int objColor = gl.glGetUniformLocation(shaderProgram, "objectColor");
        int lightExists = gl.glGetUniformLocation(shaderProgram, "Lightexists");
        int lightExists2 = gl.glGetUniformLocation(shaderProgram, "lightExits2");
        int strengthL = gl.glGetUniformLocation(shaderProgram, "strength");
        int lightPosition = gl.glGetUniformLocation(shaderProgram, "lightPos");
        int lightSource = gl.glGetUniformLocation(shaderProgram, "LightSource");
        int viewPosLoc = gl.glGetUniformLocation(shaderProgram, "viewPos");
        int specularStrengthLoc = gl.glGetUniformLocation(shaderProgram, "specularStrength");
        System.out.println("light: " + lightColorLoc);
        System.out.println("obj: " + objColor);
        gl.glUniform3f(lightColorLoc, lightColor[0], lightColor[1], lightColor[2]);
        gl.glUniform3f(objColor, lightColor[0], lightColor[1], lightColor[2]);
        gl.glUniform3f(viewPosLoc, cameraPos.x, cameraPos.y, 0);
        gl.glUniform1f(specularStrengthLoc, 0.1f);
//        gl.glUniform3f(objColor, 1.0f, 0.5f, 0.31f);
        gl.glUniform1f(lightExists, 1.0f);
        gl.glUniform1f(lightExists2, 1.0f);
        if (source == null) {
            gl.glUniform1f(lightSource, 1.0f);
        }
        Vector3 a = gameObject.GetCompenent(TransformComponent.class).location;
        gl.glUniform3f(lightPosition, lightLocation.x, lightLocation.y, 0);

        i2++;
//        if(a.x <0){
//            i2 = 1.0f;
//        }else if(a.x > 200){
//            i2 = -1.0f;
//        }
        gameObject.GetCompenent(TransformComponent.class).location = a;
        gl.glUniform1f(strengthL, this.strength);
        VectorMath v = new VectorMath();
        float[] normals;
        normals = v.vectorNormals(this.gameObject.GetCompenent(SpriteComponent.class).getVecticesAsVector());
        int normalLoc = gl.glGetAttribLocation(shaderProgram, "anormal");
        gl.glBindBuffer(GL_ARRAY_BUFFER, buffers[0]);
        gl.glBufferData(GL_ARRAY_BUFFER, normals.length * 4L, FloatBuffer.wrap(normals), GL_STATIC_DRAW);
        gl.glEnableVertexAttribArray(normalLoc);
        gl.glVertexAttribPointer(normalLoc, 2, GL_FLOAT, false, 0, 0);
        System.out.println("normals: " + Arrays.toString(normals));
//        if(i2 == 20){
//          i2 = 0;
//        }
//        i2 = i2 - 1.0f;
        System.out.println("u2: " + i2);

    }
    public void raymarchingcalc(){

    }
}
