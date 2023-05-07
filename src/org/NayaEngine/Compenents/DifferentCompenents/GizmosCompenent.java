package org.NayaEngine.Compenents.DifferentCompenents;

import com.jogamp.opengl.GL;
import org.NayaEngine.Compenents.iComponent;
import org.NayaEngine.Tooling.loadShader;
import org.NayaEngine.math.Ray;

import java.awt.*;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.*;
import java.io.*;

import static com.jogamp.opengl.GL.*;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class GizmosCompenent  extends iComponent {

    public SpriteComponents components;
    public Color c;
    public float[] vertices;
    public int[] indicies;
    public GizmosCompenent(SpriteComponents components) {
        this.components = components;
        gl.glEnable(GL.GL_BLEND);
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);

    }
    public GizmosCompenent(Ray ray){

    }
    public void draw_collider(SpriteComponents co, Color c){

    }

    @Override
    public void sendtoGPU(int shaderProgram, loadShader sh) {

        int location = gl.glGetUniformLocation(shaderProgram, "textureExists");
//        gl.glUniform1f(location, 1);
        System.out.println("Gizmos send 1st");
        this.vertices =components.oneDto2D(components.vertices);
        this.indicies = components.indices;
        for(int i = 0;i  < vertices.length;i++){
            vertices[i] /= 2;
        }

        int[] buffers = new int[3];
        gl.glGenBuffers(2, buffers, 0);


        gl.glBindBuffer(GL_ARRAY_BUFFER, buffers[0]);

        gl.glBufferData(GL_ARRAY_BUFFER, vertices.length * 4L, FloatBuffer.wrap(vertices), GL_STATIC_DRAW);

        gl.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, buffers[1]);
        gl.glBufferData(GL_ELEMENT_ARRAY_BUFFER, indicies.length * 4L, IntBuffer.wrap(indicies), GL_STATIC_DRAW);
        int positionAttrib = gl.glGetAttribLocation(shaderProgram, "vPos");
        int colorLocation = gl.glGetUniformLocation(shaderProgram, "color_of_sprite");
        gl.glVertexAttribPointer(positionAttrib, 3, GL_FLOAT, false, 0, 0);
        gl.glEnableVertexAttribArray(positionAttrib);
        gl.glBindBuffer(GL_ARRAY_BUFFER, 0);
        gl.glUniform3f(colorLocation, 0, 1,0);
        int textureSamplerLoc = gl.glGetUniformLocation(shaderProgram, "tSample");
        gl.glUniform1i(textureSamplerLoc, 0);
    }
}
