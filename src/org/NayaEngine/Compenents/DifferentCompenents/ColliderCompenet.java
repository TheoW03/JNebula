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
//
        float left = location1.x - (location2.x + (collider.width / 100) + .5f);
        float top = (location2.y + (collider.height / 100) + .5f) - location1.y;

        float right = (location2.x + (collider.width / 100) + .5f) - location1.y;
        float bottom = location1.y - (location2.y + (collider.height / 100) + .5f);
        return !(left > 0 || right < 0 || top < 0 || bottom > 0);
        // Get the center points of the squares
    }
}
