package org.NayaEngine.Tooling;

import org.NayaEngine.math.Ray;

import java.util.*;
import java.io.*;


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
