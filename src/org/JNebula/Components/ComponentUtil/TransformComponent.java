package org.JNebula.Components.ComponentUtil;

import org.JNebula.Components.Component;
import org.JNebula.Tooling.Camera;
import org.JNebula.Tooling.Shader;
import org.joml.Matrix4f;
import org.joml.Vector3f;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class TransformComponent extends Component {

    public Camera camera;
    public Vector3f location;
    public Matrix4f rotation;

    public TransformComponent(Vector3f location) {
        camera = new Camera(new Vector3f(0, 0, 0));
        this.location = location;

    }

    @Override
    public String toString() {
        return "TransformComponent";
    }

    @Override
    public void update(float dt) {

    }

    public void transform(Vector3f transform) {
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
    private Matrix4f initModel(Vector3f location){
        Matrix4f modelViewMatrix = new Matrix4f();
        modelViewMatrix.identity();

        return modelViewMatrix.translate(location.x/100.0f, location.y/100.0f,0);

    }
    @Override
    public void sendToGPU(int shaderProgram, Shader sh) {
        if (rotation == null) {
            rotation = new Matrix4f();
            rotation.identity();
        }
        int modelMartrix = gl.glGetUniformLocation(shaderProgram, "model");
        int rotationMatrix = gl.glGetUniformLocation(shaderProgram, "rot");

        Matrix4f m = initModel(location);
        sh.sendMatrices(rotation, gl, rotationMatrix);
        sh.sendMatrices(m, gl, modelMartrix);

    }
}
