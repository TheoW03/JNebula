package org.NayaEngine.Compenents.DifferentCompenents;

import com.jogamp.opengl.GL;
import org.NayaEngine.Compenents.iComponent;
import org.NayaEngine.Tooling.Colors;
import org.NayaEngine.Tooling.loadShader;

import java.nio.FloatBuffer;
import java.util.*;
import java.io.*;

import static com.jogamp.opengl.GL.*;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class RenderCompenent extends iComponent {
    public float[] vertices;
    public int[] indices;
    public float[] color;
    public RenderCompenent(String colorHex) {
        vertices = new float[]{
                -1.0f, -1.0f, 0.0f,   // Bottom-left vertex
                1.0f, -1.0f, 0.0f,    // Bottom-right vertex
                -1.0f, 1.0f, 0.0f,    // Top-left vertex
                1.0f, 1.0f, 0.0f      // Top-right vertex
        };
        color = Colors.colorHex(colorHex);

    }


    @Override
    public void update(float dt) {

    }

    @Override
    public void sendtoGPU(int shaderProgram, loadShader sh) {
        indices = new int[]{0, 1, 2, 3};  // Index buffer for a quad

        int[] buffers = new int[1];
        gl.glGenBuffers(1, buffers, 0);
//        gl.glBufferData(GL_ARRAY_BUFFER, vertices.length * 4, null, GL_STATIC_DRAW);
        gl.glBufferData(GL.GL_ARRAY_BUFFER, vertices.length * 4, FloatBuffer.wrap(vertices), GL.GL_STATIC_DRAW);
        int positionAttrib = gl.glGetAttribLocation(shaderProgram, "vPos");
        System.out.println("pos: " + positionAttrib);
        gl.glBindBuffer(GL_ARRAY_BUFFER, buffers[0]);
        gl.glEnableVertexAttribArray(positionAttrib);
        gl.glVertexAttribPointer(positionAttrib, 3, GL_FLOAT, false, 0, 0);
        int colors = gl.glGetAttribLocation(shaderProgram, "fColor");
        gl.glUniform3f(colors, color[0],color[1],color[2]);

    }
}
