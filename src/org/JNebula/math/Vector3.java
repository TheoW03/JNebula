package org.JNebula.math;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class Vector3 {

    public float x, y, z;

    public final static Vector3 up = new Vector3(0,1,0);
    public final static Vector3 down = new Vector3(0,-1,0);
    public final static Vector3 right = new Vector3(1,0,0);
    public final static Vector3 left = new Vector3(-1,0,0);
    public final static Vector3 zero = new Vector3(0,0,0); //zero vector >:3 sends shivers
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
        if(mag == 0){
            return  this;
        }
        return new Vector3(x*(1/mag),y*(1/mag),z*(1/mag));
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
