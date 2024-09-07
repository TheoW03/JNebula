package org.JNebula.Components.ComponentUtil;

import org.JNebula.Components.Component;
import org.JNebula.math.Ray;
import org.joml.Vector2f;
import org.joml.Vector3f;

import java.util.Arrays;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class ColliderComponent extends Component {
    public float width, height;


    public boolean showHitBox;
    public Ray[] list;
    public Ray ray;
    public float[][] hitBox;

    public ColliderComponent() {
//        this.height = this.gameObject.GetCompenent(SpriteComponent.class).height;
//        this.width = this.gameObject.GetCompenent(SpriteComponent.class).width;
    }

    public ColliderComponent(float colliderWidth, float collliderHeight) {
        this.height = collliderHeight;
        this.width = colliderWidth;

    }

    public ColliderComponent(Ray[] list) {
        this.list = list;
    }

    public ColliderComponent(Ray ray) {
        this.ray = ray;
    }

    @Override
    public void init(float dt) {
        hitBox = gameObject.GetComponent(SpriteComponent.class).vertices;
    }

    @Override
    public void update(float dt) {
        hitBox = gameObject.GetComponent(SpriteComponent.class).vertices;
    }

    private Vector2f calcOffset(Vector2f p, Vector2f center, Vector2f size) {
        Vector2f o1 = center.sub(p);
        Vector2f o3 = new Vector2f(Math.abs(o1.x), Math.abs(o1.y));
        return o3.sub(size);
    }

    private float getDist(Vector3f p, Vector3f center, Vector3f size) {
        Vector2f p1 = new Vector2f(p.x, p.y);
        Vector2f c = new Vector2f(center.x, center.y);
        Vector2f size2 = new Vector2f(size.x, size.y);
        Vector2f offset = calcOffset(p1, c, size2);
        return offset.max(new Vector2f(0, 0)).length();
    }


    private Vector3f getUSdist(Vector3f p, Vector3f center, Vector3f size) {
        Vector2f p1 = new Vector2f(p.x, p.y);
        Vector2f c = new Vector2f(center.x, center.y);
        Vector2f size2 = new Vector2f(size.x, size.y);
        Vector2f offset = calcOffset(p1, c, size2);
        float usignedDIst = offset.max(new Vector2f(0, 0)).length();

        Vector2f signedDIst = offset.max(offset.min(new Vector2f(0, 0)));
        Vector2f output = signedDIst.add(new Vector2f(usignedDIst, usignedDIst));
        return new Vector3f(output.x, output.y, 0);
    }

    /**
     * @param collider
     * @return this does the raymarch distance algorithm.
     */
    public boolean isCollided(ColliderComponent collider) {
//        Vector3 location1 = this.gameObject.transform.location;
        Vector3f location2 = collider.gameObject.transform.location;
        Vector3f[] location1 = this.gameObject.GetComponent(SpriteComponent.class).getCenterPoints();
//        Vector3[] location2 = collider.gameObject.GetCompenent(SpriteComponent.class).getCenterPoints();
        Vector3f size1 = collider.gameObject.GetComponent(SpriteComponent.class).get_size();
        return !Arrays.stream(location1)
                .filter(vector3 -> getDist(vector3, location2, size1) < 1)
                .toList()
                .isEmpty();
//        for (Vector3f vector3 : location1) {
//            if (getDist(vector3, location2, size1) < 1) {
//                return true;
//            }
//        }
//        return  false;


    }

    public boolean rayCollides(ColliderComponent collider) {
        if (ray == null) {
            return false;
        }
        Vector3f location2 = collider.gameObject.GetComponent(TransformComponent.class).location;
        Vector3f size = collider.gameObject.GetComponent(SpriteComponent.class).get_size();
        ray.origin = this.gameObject.GetComponent(TransformComponent.class).location;
        Vector3f origin = ray.origin;
        Vector3f direction = ray.dir.normalize();
        Vector2f s = new Vector2f(origin.x, origin.y);
        Vector2f d = new Vector2f(direction.x, direction.y);
        int x = (int) Math.floor(s.x);
        int y = (int) Math.floor(s.y);
        float tX, tY;
        float dTx, dTy, stepX, stepY;
        if (direction.x < 0) {
            tX = (s.x - x) / (-d.x);
            stepX = -1;
            dTx = -1 / d.x;
        } else {
            tX = (x + 1 - s.x) / d.x;
            stepX = 1;
            dTx = 1 / d.x;
        }

        if (d.y < 0) {
            tY = (s.y - y) / (-d.y);
            stepY = -1;
            dTy = -1 / d.y;
        } else {
            tY = (y + 1 - s.y) / d.y;
            stepY = 1;
            dTy = 1 / d.y;
        }
        double dist = 0;
        while (dist < ray.length) {
            double tMin = Math.min(tX, tY);
            // Check for intersection with each plane
            if (tX == tMin) {
                x += stepX;
                tX += dTx;
            }
            if (tY == tMin) {
                y += stepY;
                tY += dTy;
            }
//            if(getDist(new Vector3(x,y),location2,size) == 0){
//                return true;
//            }
            dist = Math.sqrt((x - s.x) * (x - s.x) + (y - s.y) * (y - s.y));

        }
        return false;
    }

    private void checkUnsignedDist(ColliderComponent collider) {
        Vector3f location1 = this.gameObject.GetComponent(TransformComponent.class).location;
        Vector3f location2 = collider.gameObject.GetComponent(TransformComponent.class).location;

    }

    public boolean isCollided2(ColliderComponent collider) {
        Vector3f location1 = this.gameObject.GetComponent(TransformComponent.class).location;
        Vector3f location2 = collider.gameObject.GetComponent(TransformComponent.class).location;
        Vector3f size = collider.gameObject.GetComponent(SpriteComponent.class).get_size();
        float x1 = Math.max(location1.x, location2.x);
        float y1 = Math.max(location1.y, location2.y);
        float x2 = Math.min(location1.x + size.x * 2 / 100, location2.x +
                collider.width * 2 / 100);
        float y2 = Math.min(location1.y + size.y * 2 / 100, location2.y +
                collider.height * 2 / 100);
        if ((x2 * width - x1 > 0 && y2 * height - y1 > 0)) {
            return true;
        } else {
            return false;
        }
    }
}



