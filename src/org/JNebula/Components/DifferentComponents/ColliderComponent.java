package org.JNebula.Components.DifferentComponents;

import org.JNebula.Components.Component;
import org.JNebula.math.Ray;
import org.JNebula.math.Vector3;
import org.joml.Vector2f;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class ColliderComponent extends Component {
    public float width, height;

    public boolean showHitBox ;
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
    public ColliderComponent(Ray[] list){
        this.list = list;
    }
    public ColliderComponent(Ray ray){
        this.ray = ray;
    }

    @Override
    public void init(float dt) {
        hitBox = gameObject.GetCompenent(SpriteComponent.class).vertices;
    }

    @Override
    public void update(float dt) {
        hitBox = gameObject.GetCompenent(SpriteComponent.class).vertices;
    }

    private Vector2f calcOffset(Vector2f p, Vector2f center, Vector2f size) {
        Vector2f o1 = center.sub(p);
        Vector2f o3 = new Vector2f(Math.abs(o1.x), Math.abs(o1.y));
        return o3.sub(size);
    }

    private float getDist(Vector3 p, Vector3 center, Vector3 size) {
        Vector2f p1 = new Vector2f(p.x, p.y);
        Vector2f c = new Vector2f(center.x, center.y);
        Vector2f size2 = new Vector2f(size.x, size.y);
        Vector2f offset = calcOffset(p1, c, size2);
        System.out.println(offset);
        return offset.max(new Vector2f(0, 0)).length();
    }


    private Vector3 getUSdist(Vector3 p, Vector3 center, Vector3 size) {
        Vector2f p1 = new Vector2f(p.x, p.y);
        Vector2f c = new Vector2f(center.x, center.y);
        Vector2f size2 = new Vector2f(size.x, size.y);
        Vector2f offset = calcOffset(p1, c, size2);
        float usignedDIst = offset.max(new Vector2f(0, 0)).length();
        System.out.println("usigned dist" + usignedDIst);
        Vector2f signedDIst = offset.max(offset.min(new Vector2f(0, 0)));
        Vector2f output = signedDIst.add(new Vector2f(usignedDIst, usignedDIst));
        return new Vector3(output.x, output.y);
    }

    /**
     * @param collider
     * @return this does the raymarch distance algorithm.
     */
    public boolean isCollided(ColliderComponent collider) {
        System.out.println("is collided");
//        Vector3 location1 = this.gameObject.transform.location;
        Vector3 location2 = collider.gameObject.transform.location;
        Vector3[] location1 = this.gameObject.GetCompenent(SpriteComponent.class).getCenterPoints();
//        Vector3[] location2 = collider.gameObject.GetCompenent(SpriteComponent.class).getCenterPoints();
        Vector3 size1 = collider.gameObject.GetCompenent(SpriteComponent.class).get_size();
        for (Vector3 vector3 : location1) {
            if (getDist(vector3, location2, size1) < 1) {
                return true;
            }
        }
        return  false;


    }
    public boolean rayCollides(ColliderComponent collider){
        if(ray == null){
            return false;
        }
        Vector3 location2 = collider.gameObject.GetCompenent(TransformComponent.class).location;
        Vector3 size = collider.gameObject.GetCompenent(SpriteComponent.class).get_size();
        ray.origin = this.gameObject.GetCompenent(TransformComponent.class).location;
        System.out.println(ray.getEndPoint());
        Vector3 origin = ray.origin;
        Vector3 direction = ray.dir.unitVector();
        Vector2f s = new Vector2f(origin.x,origin.y);
        Vector2f d = new Vector2f(direction.x,direction.y);
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
        while (dist < ray.length){
            double tMin = Math.min(tX,tY);
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
            System.out.println(new Vector3(x,y));
            dist = Math.sqrt((x - s.x)*(x - s.x) + (y - s.y)*(y - s.y));

        }
        return false;
    }
    private void checkUnsignedDist(ColliderComponent collider){
        Vector3 location1 = this.gameObject.GetCompenent(TransformComponent.class).location;
        Vector3 location2 = collider.gameObject.GetCompenent(TransformComponent.class).location;
        System.out.println("checks: "+getUSdist(location2,location2,collider.gameObject.GetCompenent(SpriteComponent.class).get_size()));

    }
//    public boolean rayCollide(ColliderComponent collider){
//        if(ray == null){
//            return false;
//        }
//        ray.origin = this.gameObject.GetCompenent(TransformComponent.class).location;
//        Vector3 location1 = this.ray.getEndPoint();
//        Vector3 location2 = collider.gameObject.GetCompenent(TransformComponent.class).location;
//        Vector3 size = new Vector3(0, ray.length);
//        System.out.println(location1);
//        System.out.println("dist: "+getDist(location1, location2, size));
//        return getDist(location1, location2, size) == 0;
//    }
    public boolean isCollided2(ColliderComponent collider) {
        Vector3 location1 = this.gameObject.GetCompenent(TransformComponent.class).location;
        Vector3 location2 = collider.gameObject.GetCompenent(TransformComponent.class).location;
        Vector3 size = collider.gameObject.GetCompenent(SpriteComponent.class).get_size();
        float x1 = Math.max(location1.x, location2.x);
        float y1 = Math.max(location1.y, location2.y);
        float x2 = Math.min(location1.x + size.x * 2 / 100, location2.x +
                collider.width * 2 / 100);
        float y2 = Math.min(location1.y + size.y * 2 / 100, location2.y +
                collider.height * 2 / 100);
        System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
        if ((x2 * width - x1 > 0 && y2 * height - y1 > 0)) {
            return true;
        } else {
            return false;
        }
    }
}



