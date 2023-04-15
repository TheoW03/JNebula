package org.NayaEngine.Compenents.DifferentCompenents;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GL4;
import org.NayaEngine.Compenents.iComponent;
import org.NayaEngine.Tooling.Camera;
import org.NayaEngine.Tooling.loadShader;
import org.NayaEngine.math.Vector3;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3fc;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class TransformComponent extends iComponent {

    public Camera camera;
    public Vector3 location;
    public Matrix4f rotation;

    public TransformComponent(Vector3 location, GL4 gl) {
        this.gl = gl;
        camera = new Camera(new Vector3(0, 0, 0));
        this.location = location;

    }

    @Override
    public String toString() {
        return "TransformComponent";
    }

    @Override
    public void update(float dt) {

    }

    public void transform(Vector3 transform) {
        location.x += transform.x;
        location.y += transform.y;
    }
    public void rotateContinosuly(float angle) {
//        this.rotation = new Matrix4f();
        Matrix4f newROtate = new Matrix4f();
        newROtate.identity();
        newROtate.rotate(angle, 0, 0, 1);
        rotation = rotation.mul(newROtate);

    }

    public void rotate(float angle) {
        this.rotation = new Matrix4f();
        rotation.rotate(angle, 0, 0, 1);

    }

    @Override
    public void sendtoGPU(int shaderProgram, loadShader sh) {
        if (rotation == null) {
            rotation = new Matrix4f();
            rotation.identity();
        }
        int modelMartrix = gl.glGetUniformLocation(shaderProgram, "model");
        int rotationMatrix = gl.glGetUniformLocation(shaderProgram, "rot");

        Matrix4f m = camera.initModel(location);
        sh.sendMartices(rotation, gl, rotationMatrix);
        sh.sendMartices(m, gl, modelMartrix);

    }
}
