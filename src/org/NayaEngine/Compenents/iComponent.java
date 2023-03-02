package org.NayaEngine.Compenents;


import org.NayaEngine.GameObjects.GameObject;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public abstract class iComponent {
    public GameObject gameObject;
    public void init(float dt){

    }
    public abstract void update(float dt);


}
