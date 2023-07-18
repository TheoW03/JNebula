package org.JNebula.Components;


import com.jogamp.opengl.GL4;
import org.JNebula.Components.DifferentComponents.ColliderComponent;
import org.JNebula.GameObjects.GameObject;
import org.JNebula.Tooling.Shader;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public abstract class Component {
    public GameObject gameObject;
    public static GL4 gl;
    public void init(float dt){

    }
    public void update(float dt){

    }
    public void sendtoGPU(int shaderProgram, Shader sh){

    }
    public void Collides(GameObject other){

    }


}
