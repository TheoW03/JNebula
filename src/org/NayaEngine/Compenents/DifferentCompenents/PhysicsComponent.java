package org.NayaEngine.Compenents.DifferentCompenents;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import org.NayaEngine.Compenents.iComponent;
import org.NayaEngine.Tooling.loadShader;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class PhysicsComponent extends iComponent {
    public PhysicsComponent(GL2 gl) {
        this.gl = gl;

    }
    @Override
    public String toString() {
        return "PhysicsComponent";
    }

    @Override
    public void update(float dt) {

        System.out.println("physics uwu >:3");

    }

    @Override
    public void sendtoGPU(int shaderProgram, loadShader sh) {


    }
}
