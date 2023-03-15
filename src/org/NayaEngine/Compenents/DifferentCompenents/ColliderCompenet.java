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
        Vector3 location1 = this.gameObject.GetCompenent(TransformComponent.class).location;
        Vector3 location2 = collider.gameObject.GetCompenent(TransformComponent.class).location;
        float x1 = Math.max(location1.x, location2.x);
        float y1 = Math.max(location1.y, location2.y);
        float x2 = Math.min(location1.x + this.width / 100, location2.x + collider.width * 2 / 100);
        float y2 = Math.min(location1.y + this.height / 100, location2.y + collider.height * 2 / 100);
        System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
        if ((x2 * 1.5f - x1 > 0 && y2 * 1.5f - y1 > 0)) {
            return true;
        } else {
            return false;
        }
    }

//        Vector3[] collidSpriteVertices = collider.gameObject.GetCompenent(SpriteComponents.class).getVecticesAsVector();
//        Vector3[] spriteVertices = this.gameObject.GetCompenent(SpriteComponents.class).getVecticesAsVector();
//        Vector3 dot11 = location1;
////        dot11 = new Vector3(dot11.x + location1.x, dot11.y + location1.y);
//        Vector3 dot10 = collidSpriteVertices[1];
////        dot10 = new Vector3(dot10.x+location1.x, dot11.y + location1.y);
//        Vector3 dot20 = location2;
////        dot20 = new Vector3(dot20.x+location2.x, dot20.y + location2.y);
//        Vector3 dot22 = spriteVertices[3];
////        dot22 = new Vector3(dot22.x+location2.x, dot22.y + location2.y);
//
//        Vector3 axis = new Vector3(location1.x, -location1.y).unitVector();
//        Vector3 A = new Vector3((dot20.x - dot10.x), dot20.y - dot10.y);
//        Vector3 B = new Vector3(dot11.x - dot10.x, dot11.y - dot10.y);
//        Vector3 C = new Vector3(dot22.x - dot20.x, dot22.y - dot20.y);
//        System.out.println(A);
//        System.out.println(B);
//        System.out.println(C);
//        float projC = C.dotProduct(axis);
//        float projA = A.dotProduct(axis);
//        float projB = B.dotProduct(axis);
//        System.out.println(projA);
//        System.out.println(projB);
//        System.out.println(projC);
//        float gap = projC - (projA + projB);
//        System.out.println(gap);

//        float max_proj_box1 = spriteVertices[1].dotProduct(axis);
//        int min_dot_box1 = 1;
//        float min_proj_box1 = collidSpriteVertices[1].dotProduct(axis);
//        int max_dot_box1 = 1;
//        for (int j = 2; j < spriteVertices.length; j++) {
//            float curr_proj1 = spriteVertices[j].dotProduct(axis);
//            //select the maximum projection on axis to corresponding box corners
//            if (min_proj_box1 > curr_proj1) {
//                min_proj_box1 = curr_proj1;
//                max_dot_box1 = j;
//            }
//            //select the minimum projection on axis to corresponding box corners
//            if (curr_proj1 < max_proj_box1) {
//                max_proj_box1 = curr_proj1;
//                min_dot_box1 = j;
//            }
//        }
//
//        boolean gap = max_proj_box2 < min_proj_box1 || max_proj_box1 < min_proj_box2
//        if (isSeparated) t.text = "There's a gap between both boxes"
//        else t.text = "No gap calculated."
//        return false;
    }
//
//        Vector3 location2 = collider.gameObject.GetCompenent(TransformComponent.class).location;
//        Vector3 location1 = this.gameObject.GetCompenent(TransformComponent.class).location;


//

            // Get the center points of the squares


