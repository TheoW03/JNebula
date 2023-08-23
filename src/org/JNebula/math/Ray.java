package org.JNebula.math;


import org.joml.Vector3f;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class Ray {
    public Vector3f dir, origin;
    public float length;

    public Ray(Vector3f dir, Vector3f origin, float length) {
        this.dir = dir;
        this.origin = origin;
        this.length = length;
    }
    public Ray(Vector3f dir, Vector3f origin) {
        this.dir = dir;
        this.origin = origin;
    }

    public Ray(Vector3f dir, float length) {
        this.dir = dir;
        this.length = length;
    }

    public Vector3f getEndPoint() {
        Vector3f add = new Vector3f((length) * dir.x, (length) * dir.y, 0);

        return new Vector3f(add.x + origin.x, add.y + origin.y, 0);
    }
}
