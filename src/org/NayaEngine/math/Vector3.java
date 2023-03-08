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
    public float dotProduct(Vector3 product){
        //SUNATION(n, n < compenets) axnbxn
        return product.x*this.x + product.y*this.y;
    }

    /**
     *
     * @return
     */
    public float mangitude(){
        return (float) Math.sqrt(this.x*this.x + this.y*this.y);
    }
    @Override
    public String toString() {
        return "Vector3{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
