package org.JNebula.Components.ComponentUtil;

import org.JNebula.Components.Component;
import org.JNebula.Tooling.Camera;
import org.JNebula.Tooling.Shader;
import org.joml.Vector3f;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class CameraComponent extends Component {

    public Camera camera;
    public Vector3f cameralocation;

    public CameraComponent(Vector3f cameraLocation) {
        this.camera = new Camera(cameraLocation);
        this.cameralocation = cameraLocation;
    }


    @Override
    public void sendToGPU(int shaderProgram, Shader sh) {
        int matricesLocation = gl.glGetUniformLocation(shaderProgram, "viewMatrix");
        int projectionLocation = gl.glGetUniformLocation(shaderProgram, "projectMatrix");
        sh.sendMatrices(camera.viewMatrix(), gl, matricesLocation);
        sh.sendMatrices(camera.getProjection(), gl, projectionLocation);
    }

}
