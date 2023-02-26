package org.NayaEngine.math;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class Vector3 {

    public float x, y, z;

    public Vector3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3(float x, float y) {
        this.x = x;
        this.y = y;
        this.z = 0;
    }
}
