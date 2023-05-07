package org.NayaEngine.Compenents.DifferentCompenents;

import org.NayaEngine.Compenents.iComponent;
import org.NayaEngine.Tooling.Camera;
import org.NayaEngine.Tooling.LoadShader;
import org.NayaEngine.math.Vector3;
import org.joml.Matrix4f;


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

    public TransformComponent(Vector3 location) {
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
    public void rotateContinuously(float angle) {
//        this.rotation = new Matrix4f();
        Matrix4f newRotate = new Matrix4f();
        newRotate.identity();
        newRotate.rotate(angle, 0, 0, 1);
        rotation = rotation.mul(newRotate);

    }

    public void rotate(float angle) {
        this.rotation = new Matrix4f();
        rotation.rotate(angle, 0, 0, 1);

    }
    private Matrix4f initModel(Vector3 location){
        Matrix4f modelViewMatrix = new Matrix4f();
        modelViewMatrix.identity();

        return modelViewMatrix.translate(location.x/100.0f, location.y/100.0f,0);

    }
    @Override
    public void sendtoGPU(int shaderProgram, LoadShader sh) {
        if (rotation == null) {
            rotation = new Matrix4f();
            rotation.identity();
        }
        int modelMartrix = gl.glGetUniformLocation(shaderProgram, "model");
        int rotationMatrix = gl.glGetUniformLocation(shaderProgram, "rot");

        Matrix4f m = initModel(location);
        sh.sendMartices(rotation, gl, rotationMatrix);
        sh.sendMartices(m, gl, modelMartrix);

    }
}
