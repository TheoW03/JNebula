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

    public ColliderCompenet(float colliderWidth, float collliderHeight) {
        this.height = collliderHeight;
        this.width = colliderWidth;

    }

    @Override
    public void update(float dt) {

    }

    /**
     * @param collider
     * @param location1
     * @param location2
     * @return Get the position (x,y) and size (width, height) of each square.
     * Calculate the center point of each square by adding half of the
     * width to the x-coordinate and half of the height to the y-coordinate.
     * Calculate the distance between the center points of the two squares
     * using the Pythagorean theorem: distance = sqrt((x2-x1)^2 + (y2-y1)^2), where (x1,y1)
     * and (x2,y2) are the center points of the two squares.
     * Check if the distance is less than or equal to the sum of
     * half of the width of each square: distance <= (width1/2 + width2/2)
     */
    public boolean isCollided(ColliderCompenet collider, Vector3 location1, Vector3 location2) {

        float left = location1.x - (location2.x + (collider.width/100)+.5f);
        float top = (location2.y + (collider.height/100)+.5f)  - location1.y;

        float right = (location2.x + (collider.width/100)+.5f)  - location1.y;
        float bottom = location1.y - (location2.y + (collider.height/100)+.5f);
        return !(left > 0 || right < 0 || top < 0 || bottom > 0);
//        // Get the center points of the squares
//        float centerX1 = location1.x + this.width/2;
//        float centerY1 = location1.y + this.height/2;
//        float centerX2 = location2.x + collider.width/2;
//        float centerY2 = location2.y + collider.height/2;
//
//        // Calculate the distance between the center points
//        float distance = (float)Math.sqrt(Math.pow(centerX2-centerX1, 2) + Math.pow(centerY2-centerY1, 2));
//
//        // Check if the distance is less than or equal to the sum of half the widths
//        return distance <= (this.width/2 + collider.width/2);
    }
}
