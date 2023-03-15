package org.NayaEngine.Compenents.DifferentCompenents;


import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import org.NayaEngine.Compenents.iComponent;
import org.NayaEngine.GameObjects.GameObject;
import org.NayaEngine.Tooling.loadShader;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static com.jogamp.opengl.GL.*;
import static com.jogamp.opengl.fixedfunc.GLLightingFunc.*;
import static com.jogamp.opengl.fixedfunc.GLLightingFunc.GL_LIGHT0;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class LightingComponent extends iComponent {

    public LightingComponent(float intensity,
                             float[] lightColor,
                             float strength,
                             GL2 gl) {
        this.gl = gl;


    }

    public LightingComponent(GL2 gl){
        this.gl = gl;

    }

    @Override
    public void init(float dt) {

    }

    @Override
    public String toString() {
        return "LightingComponent";
    }

    float i = 0;

    @Override
    public void update(float dt) {


    }

    float i2 = 0;
    @Override
    public void sendtoGPU(int shaderProgram, loadShader sh) {
        int lightColorLoc = gl.glGetUniformLocation(shaderProgram, "lightColor");
        int objColor = gl.glGetUniformLocation(shaderProgram, "objectColor");
        int lightExists = gl.glGetUniformLocation(shaderProgram, "Lightexists");
        int strength = gl.glGetUniformLocation(shaderProgram, "strength");
        System.out.println("light: "+lightColorLoc);
        System.out.println("obj: "+objColor);
        gl.glUniform3f(lightColorLoc, 1.0f,1.0f,1.0f);
        gl.glUniform3f(objColor, 1.0f, 0.5f, 0.31f);
        gl.glUniform1f(lightExists, 1.0f);
        gl.glUniform1f(strength, i2);
        i2 = i2 + 0.01f;

    }
}
