package org.NayaEngine.Compenents.DifferentCompenents;

import org.NayaEngine.Compenents.iComponent;
import org.NayaEngine.math.Vector3;
import org.joml.Matrix4f;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class TranformComponent implements iComponent {
    public Vector3 location;
    public Matrix4f modelViewMatrix;
    public TranformComponent(Vector3 location) {
        this.location =location;
    }
    public void translate(Vector3 vector){
        modelViewMatrix = new Matrix4f();
        modelViewMatrix.identity();
        modelViewMatrix.translate(location.x, location.y,0);
    }
    public Matrix4f getModelViewMatrix(){
        modelViewMatrix = new Matrix4f();
        modelViewMatrix.identity();
        return modelViewMatrix.translate(location.x, location.y,0);
    }
}
