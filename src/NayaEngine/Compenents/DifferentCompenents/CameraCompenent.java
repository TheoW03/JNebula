package NayaEngine.Compenents.DifferentCompenents;

import NayaEngine.Compenents.iCompenet;
import NayaEngine.Tooling.Camera;
import org.joml.Matrix4f;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class CameraCompenent implements iCompenet {
    public Camera camera;
    public Matrix4f projectMatrix, viewMatrix;
    public CameraCompenent(Camera camera) {
        this.camera = camera;
        this.projectMatrix = camera.getProjection();
        this.viewMatrix = camera.viewMatrix();
    }
}
