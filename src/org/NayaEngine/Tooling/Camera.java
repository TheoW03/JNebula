package org.NayaEngine.Tooling;

import org.NayaEngine.math.Vector3;
import org.joml.Matrix4f;
import org.joml.Vector3f;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class Camera {
    //    private Matrix4 projection, view;
    private Matrix4f projection, view;

    private Matrix4f ortho;
    private Vector3 location;

    public Camera(Vector3 location) {
        this.location = location;
        this.projection = new Matrix4f();
        this.view = new Matrix4f();
        initMatrix();

    }

    public void initMatrix() {
        projection.identity(); //this is like n*1
        projection.ortho(0.0f, 32.0f * 40.0f, 0.0f, 32.0f * 21.0f, 0.0f, 100.0f);
    }

    public Matrix4f viewMatrix() {
        Vector3f cameraFront = new Vector3f(0.0f,0.0f,-1.0f);
        Vector3f cameraUp = new Vector3f(0.0f,1.0f,0.0f);
        this.view.identity();
        this.view = view.lookAt(new Vector3f(location.x, location.y, 20.0f),
                cameraFront.add(location.x,location.y,0),cameraUp);
        return view;
    }
    public Matrix4f getProjection() {
        return projection;
    }
}
