package org.NayaEngine.Compenents;


import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GL4;
import org.NayaEngine.GameObjects.GameObject;
import org.NayaEngine.Tooling.loadShader;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public abstract class iComponent {
    public GameObject gameObject;
    public GL4 gl;
    public void init(float dt){

    }
    public abstract void update(float dt);
    public void sendtoGPU(int shaderProgram, loadShader sh){

    }

}
