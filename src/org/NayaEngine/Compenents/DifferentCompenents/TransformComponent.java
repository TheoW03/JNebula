package org.NayaEngine.Compenents.DifferentCompenents;

import com.jogamp.opengl.GL2;
import org.NayaEngine.Compenents.iComponent;
import org.NayaEngine.Tooling.Camera;
import org.NayaEngine.Tooling.loadShader;
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
    public TransformComponent(Vector3 location, GL2 gl){
        this.gl = gl;
        camera = new Camera(new Vector3(0,0,0));
        this.location = location;

    }
    @Override
    public String toString() {
        return "TransformComponent";
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void sendtoGPU(int shaderProgram, loadShader sh) {
        int modelMartrix = gl.glGetUniformLocation(shaderProgram, "model");
        Matrix4f m = camera.initModel(location);
        sh.sendMartices(m,gl,modelMartrix);

    }
}
