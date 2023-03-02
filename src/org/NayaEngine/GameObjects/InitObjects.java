package org.NayaEngine.GameObjects;

import com.jogamp.common.nio.Buffers;
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

    public InitObjects(FPSAnimator fpsAnimator) {
        this.fpsAnimator = fpsAnimator;
    }
    public void printFrameRate(){
        long currentTime = System.currentTimeMillis();
        long deltaTime = currentTime - fpsAnimator.getLastFPSUpdateTime();
        int frames = fpsAnimator.getFPS();
        double fps = (double) frames / ((double) deltaTime / 1000000000.0);
        System.out.println("FPS: "+frames);

    }


    public void InstiateObjects(List<GameObject> object) {

        for (int i = 0; i < object.size(); i++) {
            if (!first) {
                object.get(i).start(1);
                first = true;
            } else {
                object.get(i).update(1);
            }

        }
    }


}
