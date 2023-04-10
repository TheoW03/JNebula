package org.NayaEngine.Tooling;

import org.NayaEngine.math.Vector3;

import java.util.*;
import java.io.*;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class Rays {
    public Vector3 dir, origin, length;
    public Rays(Vector3 dir, Vector3 origin, Vector3 length) {
        this.length = length;
        this.dir = dir;
        this.origin = origin;
    }
    public Rays(Vector3 dir, Vector3 length) {
        this.length = length;
        this.dir = dir;
    }

    public Vector3 getEndPoint(){
        System.out.println("endpoint: "+new Vector3(origin.x + length.x+dir.x, origin.y +length.y+ dir.y));
        return new Vector3(origin.x + length.x+dir.x, origin.y +length.y+ dir.y);
    }
}
