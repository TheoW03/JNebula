package org.JNebula.Tooling;

import org.JNebula.math.Ray;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class Debug {
    public Debug() {

    }

    public void DrawRay(Ray ray, Colors color) {
        float[] vertices = new float[]{
                0.0f, 0.0f, 0.0f,
                ray.length, 0.0f,0.0f
        };
    }
}
