package NayaEngine.Compenents.DifferentCompenents;

import NayaEngine.Compenents.iCompenet;
import NayaEngine.math.NVector;
import org.joml.Matrix4f;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class TranformCompenet implements iCompenet {
    public NVector location;
    public Matrix4f modelViewMatrix;
    public TranformCompenet(NVector location) {
        this.location =location;
    }
    public void translate(NVector vector){
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
