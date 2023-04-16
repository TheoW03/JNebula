package org.NayaEngine.Compenents.DifferentCompenents;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GL4;
import org.NayaEngine.Compenents.iComponent;
import org.NayaEngine.Tooling.loadShader;
import org.NayaEngine.math.Vector3;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class PhysicsComponent extends iComponent {
    public Vector3 startingV;
    public Vector3 vectorPosition;
    private Vector3 position;
    public boolean veloLock;
    public float ROC;
    public Vector3 transformVector;
    public PhysicsComponent(Vector3 startingV, float ROC, Vector3 position) {
        this.gl = gl;
        this.position = position;
        this.startingV = startingV;
        vectorPosition = position;
        this.ROC = ROC;
        this.veloLock = false;
        System.out.println("constructor value: " + vectorPosition.y);
    }

    @Override
    public String toString() {
        return "PhysicsComponent";
    }

    @Override
    public void update(float dt) {
        if (veloLock) {
            return;
        }

        startingV.y += ROC;
        vectorPosition.y += startingV.y;
    }

    @Override
    public void sendtoGPU(int shaderProgram, loadShader sh) {


    }

}
