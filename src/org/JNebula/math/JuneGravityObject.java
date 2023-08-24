package org.JNebula.math;

import org.joml.Vector3f;

public class JuneGravityObject { // :3, gravity comes from june's brain because it is very dense
    public static final float G = 6.67f; // 6.67f is realistic, but can be changed for game purposes if needed
    float mass;
    float density;
    float size;
    Vector3f position;

    public JuneGravityObject(float mass, float density, Vector3f position, float size) {
        this.mass = mass;
        this.position = position;
        this.size = size; // Area, assumes sphere
        this.density = density;
    }

    public Vector3f getGravity(JuneGravityObject[] objects) { // Calculates the force of all the relevant gravity objects in the scene
        Vector3f totalForce = new Vector3f(0, 0, 0);
        for (JuneGravityObject object : objects) {
            float force = (G * object.mass * this.mass * (this.position.length() - object.position.length())) * (size / density);
            Vector3f heading = object.position.sub(this.position);
            Vector3f forceHeading = new Vector3f(
                    heading.x * force,
                    heading.y * force,
                    heading.z * force
            );
            totalForce.add(forceHeading);
        }
        return totalForce; // Returns the force, this should be added to the velocity of the target object
    }
}
