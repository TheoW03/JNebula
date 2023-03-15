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
    public float magnitude(){
        return (float) Math.sqrt((this.x*this.x)+(this.y*this.y));

    }
    public Vector3 unitVector(){
        float mag = magnitude();
        if(mag != 0){
            return  this;
        }
        return new Vector3(x*1/mag,y*1/mag,0 );
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
