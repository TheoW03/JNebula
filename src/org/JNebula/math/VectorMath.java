package org.JNebula.math;


import java.util.Arrays;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class VectorMath {

    public void dotProduct() {

    }

    public void crossProduct() {

    }

    public void add() {

    }

    public void mangtude() {

    }


    public float[] vectorNormals(Vector3[] list) {
        float[] vertices = new float[]{
                -1.0f, -1.0f, 0.0f,   // Bottom-left vertex
                1.0f, -1.0f, 0.0f,    // Bottom-right vertex
                -1.0f, 1.0f, 0.0f,    // Top-left vertex
                1.0f, 1.0f, 0.0f      // Top-right vertex
        };
        System.out.println(Arrays.toString(list));

        float[] tempList = new float[vertices.length];
        Vector3 a = new Vector3(list[0].x - list[2].x, list[0].y - list[2].y, 0);
        Vector3 b = new Vector3(list[1].x - list[3].x, list[1].y - list[3].y, 0);
        System.out.println(a.toString());
        System.out.println(b.toString());
        /* visualizing cross product AxB
        |i    j   k|
        |a.x a.y a.z| =
        |b.x b.y b.z| = |a.y a.z |      |a.x a.z|     |a.x a.z|
                        | b.y b.z| i + |b.x b.z| j + |b.x b.z|k
                        ((a.z)(b.y)-(a.y)(b.z))i + ((a.x)(b.z)-(b.x)(a.z))j + ((a.x)(b.z)-(a.z)(b.x))k
         */
        Vector3 cross = new Vector3(a.y*b.x,a.x*b.y);
        System.out.println(cross.toString());
        float mag = cross.magnitude();
        if (mag == 1.0f || mag == 0.0f) {

            cross = new Vector3((cross.x != 0) ? 1.0f : 0, (cross.y != 0) ? 1.0f : 0, (cross.z != 0) ? 1.0f : 0);
        } else {
            cross = new Vector3(cross.x / mag, cross.y / mag, cross.z / mag);
        }
        int i2 = 0;
        for (int i = 0; i < tempList.length; i++) {
            if (i % 3 == 0) {
                i2 = 0;
            }
            if (i2 == 0) {
                tempList[i] = 0;
            } else if (i2 == 1) {
                tempList[i] = 0;
            } else if (i2 == 2) {
                tempList[i] = 1;
            }
            i2++;
        }
        return tempList;
    }

    public void angleOfVector() {

    }

    public void calcNormals() {

    }


}
