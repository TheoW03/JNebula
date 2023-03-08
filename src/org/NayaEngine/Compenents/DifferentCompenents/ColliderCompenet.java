package org.NayaEngine.Compenents.DifferentCompenents;

import org.NayaEngine.Compenents.iComponent;
import org.NayaEngine.math.Vector3;

import java.util.*;
import java.io.*;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class ColliderCompenet extends iComponent {
    public float width, height;

    public ColliderCompenet() {
        this.height = this.gameObject.GetCompenent(SpriteComponents.class).height;
        this.width = this.gameObject.GetCompenent(SpriteComponents.class).width;
    }

    public ColliderCompenet(float colliderWidth, float collliderHeight) {
        this.height = collliderHeight;
        this.width = colliderWidth;

    }

    @Override
    public void update(float dt) {

    }

    /**
     * @param collider
     */
    public boolean isCollided(ColliderCompenet collider) {

        Vector3 location2 = collider.gameObject.GetCompenent(TransformComponent.class).location;
        Vector3 location1 = this.gameObject.GetCompenent(TransformComponent.class).location;
        float x1 = Math.max(location1.x, location2.x);
        float y1 = Math.max(location1.y, location2.y);
        float x2 = Math.min(location1.x + this.width / 100, location2.x + collider.width / 100);
        float y2 = Math.min(location1.y + this.height / 100, location2.y + collider.height / 100);
        System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
        if((x2 - x1 > 0 && y2 - y1 > 0)){
            collider.gameObject.GetCompenent(TransformComponent.class).location = new Vector3(location2.x, location1.x + this.width/100);
            return true;
        }else {
            return false;
        }

////
//        float left = location2.x - (location1.x + (this.width / 100) + .5f);
//        float top = (location1.y + (this.height / 100) + .5f) - location2.y;
//        float right = (location1.x + (this.width / 100) + .5f) - location2.y;
//        float bottom = location2.y - (location1.y + (this.height / 100) + .5f);
//        System.out.println(left);
//        System.out.println(right);
//        System.out.println();
//        return !(left > 0 || right < 0 || top < 0 || bottom > 0);
        // Get the center points of the squares
    }
}
