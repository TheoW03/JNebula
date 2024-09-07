package org.JNebula.Components.ComponentUtil;

import org.JNebula.Components.Component;
import org.joml.Vector3f;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class PhysicsComponent extends Component {
    public Vector3f startingV;
    public Vector3f vectorPosition;
    private Vector3f position;
    public boolean veloLock;
    public float ROC;
    public Vector3f transformVector;

    public  Vector3f forceVector;
    public Vector3f dir;
    public PhysicsComponent(Vector3f startingV, float ROC, Vector3f position, Vector3f dir) {
        this.dir = dir;
        this.position = position;
        this.startingV = startingV;
        vectorPosition = position;
        this.ROC = ROC;
        this.veloLock = false;
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
//        System.out.println(startingV);
        vectorPosition.y += a.y;
        vectorPosition.x += a.x;
    }


}
