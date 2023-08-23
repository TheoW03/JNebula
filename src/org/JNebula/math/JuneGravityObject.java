package org.JNebula.math;

import org.joml.Vector3f;

public class JuneGravityObject {
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

    public Vector3f getGravity(JuneGravityObject[] objects) {
        Vector3f totalForce = new Vector3f(0, 0, 0);
        for (JuneGravityObject object : objects) {
            float force = (6.67f * object.mass * this.mass * (this.position.length() - object.position.length())) * (size / density);
            Vector3f heading = object.position.sub(this.position);
            Vector3f forceHeading = new Vector3f(
                    heading.x * force,
                    heading.y * force,
                    heading.z * force
            );
            totalForce.add(forceHeading);
        }
        return totalForce;
    }
}
