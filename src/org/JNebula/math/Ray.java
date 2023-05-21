package org.JNebula.math;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class Ray {
    public Vector3 dir, origin;
    public float length;

    public Ray(Vector3 dir, Vector3 origin, float length) {
        this.dir = dir;
        this.origin = origin;
        this.length = length;
    }
    public Ray(Vector3 dir, Vector3 origin) {
        this.dir = dir;
        this.origin = origin;
    }

    public Ray(Vector3 dir, float length) {
        this.dir = dir;
        this.length = length;
    }

    public Vector3 getEndPoint() {
        Vector3 add = new Vector3((length) * dir.x, (length) * dir.y);

        return new Vector3(add.x + origin.x, add.y + origin.y);
    }
}
