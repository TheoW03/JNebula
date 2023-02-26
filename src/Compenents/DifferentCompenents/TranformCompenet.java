package Compenents.DifferentCompenents;

import Compenents.iCompenet;
import math.NVector;
import org.joml.Matrix4f;

import java.util.*;
import java.io.*;


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
