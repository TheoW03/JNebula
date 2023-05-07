package org.NayaEngine.Compenents;


import com.jogamp.opengl.GL4;
import org.NayaEngine.Compenents.DifferentCompenents.ColliderComponent;
import org.NayaEngine.GameObjects.GameObject;
import org.NayaEngine.Tooling.LoadShader;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public abstract class iComponent {
    public GameObject gameObject;
//    public GL4 gl;
    public static GL4 gl;
    public void init(float dt){

    }
    public void update(float dt){

    }
    public void sendtoGPU(int shaderProgram, LoadShader sh){

    }
    public void Collides(ColliderComponent c){

    }

}
