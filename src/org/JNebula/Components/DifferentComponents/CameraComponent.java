package org.JNebula.Components.DifferentComponents;

import org.JNebula.Components.iComponent;
import org.JNebula.Tooling.Camera;
import org.JNebula.Tooling.Shader;
import org.JNebula.math.Vector3;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class CameraComponent extends iComponent {

    public Camera camera;
    public Vector3 cameralocation;
    public CameraComponent(Vector3 cameraLocation){
        this.camera = new Camera(cameraLocation);
        this.cameralocation = cameraLocation;
    }

    @Override
    public void sendtoGPU(int shaderProgram, Shader sh) {
        int matriceLocation = gl.glGetUniformLocation(shaderProgram, "viewMatrix");
        int projectionLocation = gl.glGetUniformLocation(shaderProgram, "projectMatrix");
        sh.sendMatrices(camera.viewMatrix(),gl,matriceLocation);
        sh.sendMatrices(camera.getProjection(),gl,projectionLocation);
    }
    public void zoom(float zoomfactor){
        this.camera.zoom(zoomfactor);
    }
    @Override
    public void update(float dt) {

    }
}
