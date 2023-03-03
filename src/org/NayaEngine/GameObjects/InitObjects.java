package org.NayaEngine.GameObjects;

import com.jogamp.common.nio.Buffers;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.FPSAnimator;
import org.NayaEngine.Compenents.DifferentCompenents.CameraComponent;
import org.NayaEngine.Compenents.DifferentCompenents.SpriteComponents;
import org.NayaEngine.Compenents.DifferentCompenents.TransformComponent;
import org.NayaEngine.Compenents.iComponent;
import org.NayaEngine.Tooling.Camera;
import org.NayaEngine.Tooling.loadShader;
import org.NayaEngine.math.Vector3;
import org.joml.Matrix4f;

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
public class InitObjects {
    public boolean first = false;
    private FPSAnimator fpsAnimator;
    private GL2 gl;

    public InitObjects(FPSAnimator fpsAnimator, GL2 gl) {
        this.gl = gl;
        this.fpsAnimator = fpsAnimator;
    }

    public void printFrameRate() {
        long currentTime = System.currentTimeMillis();
        long deltaTime = currentTime - fpsAnimator.getLastFPSUpdateTime();
        int frames = fpsAnimator.getFPS();
        double fps = (double) frames / ((double) deltaTime / 1000000000.0);
        System.out.println("FPS: " + frames);

    }


    public void InstiateObjects(List<GameObject> object) {

        for (int i = 0; i < object.size(); i++) {
            if (!first) {
                object.get(i).start(1, gl);
                System.out.println(object.get(i).name);

            } else {
                object.get(i).update(1, gl);
                System.out.println(object.get(i).name);
            }

        }
        for (int i = 0; i < object.size(); i++) {
            int[] indices = object.get(i).indices;
            int[] buffers = new int[1];
            gl.glGenBuffers(1, buffers, 0);
            gl.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, buffers[0]);
            gl.glBufferData(GL_ELEMENT_ARRAY_BUFFER, indices.length * 4L, IntBuffer.wrap(indices), GL_STATIC_DRAW);
            gl.glDrawElements(GL_TRIANGLE_STRIP, 6, GL_UNSIGNED_INT, 0);
            gl.glBindBuffer(GL_ARRAY_BUFFER, 0);
            gl.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
        }
        first = true;
    }



}
