package org.NayaEngine.Compenents.DifferentCompenents;

import org.NayaEngine.Compenents.iComponent;
import org.NayaEngine.Tooling.Camera;
import org.joml.Matrix4f;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class CameraComponent implements iComponent {
    public Camera camera;
    public Matrix4f projectMatrix, viewMatrix;
    public CameraComponent(Camera camera) {
        this.camera = camera;
        this.projectMatrix = camera.getProjection();
        this.viewMatrix = camera.viewMatrix();
    }
}
