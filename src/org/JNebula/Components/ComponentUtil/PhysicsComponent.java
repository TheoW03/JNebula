package org.JNebula.Components.ComponentUtil;

import org.JNebula.Components.Component;
import org.JNebula.math.Vector3;
import org.joml.Vector3f;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class PhysicsComponent extends Component {
    public Vector3 startingV;
    public Vector3 vectorPosition;
    private Vector3 position;
    public boolean veloLock;
    public float ROC;
    public Vector3 transformVector;

    public  Vector3 forceVector;
    public Vector3 dir;
    public PhysicsComponent(Vector3 startingV, float ROC, Vector3 position, Vector3 dir) {
        this.dir = dir;
        this.position = position;
        this.startingV = startingV;
        vectorPosition = position;
        this.ROC = ROC;
        this.veloLock = false;
        System.out.println("constructor value: " + vectorPosition.y);
    }

    @Override
    public String toString() {
        return "PhysicsComponent";
    }

    @Override
    public void update(float dt) {
        if (veloLock) {
            return;
        }


        if(startingV.y > 0){
            startingV.y += ROC;

        }else {
            startingV.y = 0;
        }
        if(startingV.x > 0){
            startingV.x += ROC;

        }else {
            startingV.x = 0;
        }
        Vector3f a = new Vector3f(startingV.x, startingV.y,0);
        a.mul(new Vector3f(dir.x,dir.y,0));
        System.out.println(startingV);
        vectorPosition.y += a.y;
        vectorPosition.x += a.x;
    }


}
