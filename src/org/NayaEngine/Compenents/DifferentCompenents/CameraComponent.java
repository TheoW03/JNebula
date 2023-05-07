package org.NayaEngine.Compenents.DifferentCompenents;

import org.NayaEngine.Compenents.iComponent;
import org.NayaEngine.Tooling.Camera;
import org.NayaEngine.Tooling.LoadShader;
import org.NayaEngine.math.Vector3;


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
    public void sendtoGPU(int shaderProgram, LoadShader sh) {
        int matriceLocation = gl.glGetUniformLocation(shaderProgram, "viewMatrix");
        int projectionLocation = gl.glGetUniformLocation(shaderProgram, "projectMatrix");
        sh.sendMartices(camera.viewMatrix(),gl,matriceLocation);
        sh.sendMartices(camera.getProjection(),gl,projectionLocation);
    }
    public void zoom(float zoomfactor){
        this.camera.zoom(zoomfactor);
    }
    @Override
    public void update(float dt) {

    }
}
