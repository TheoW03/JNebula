package org.NayaEngine.GameObjects;

import org.NayaEngine.Compenents.ManageCmponent;
import org.NayaEngine.Compenents.DifferentCompenents.TranformComponent;
import org.NayaEngine.Compenents.iComponent;
import org.NayaEngine.math.Vector3;

import java.util.ArrayList;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class GameObject implements GameBehavior {
    ManageCmponent compenents;
    Vector3 location;
    public ArrayList<String> compenetsString;
    public float[] vertices;
    public GameObject(Vector3 location) {
        this.location =  location;
        this.compenents = new ManageCmponent();
        this.vertices = new float[]{
                -1.0f, -1.0f, 0.0f,   // Bottom-left vertex
                1.0f, -1.0f, 0.0f,    // Bottom-right vertex
                -1.0f, 1.0f, 0.0f,    // Top-left vertex
                1.0f, 1.0f, 0.0f      // Top-right vertex
        };
        addDefuaultCompenets();
    }
    private void addDefuaultCompenets(){

        compenents.AddCompenet("TransformComponent", new TranformComponent(location));
    }

    public void scaleVertices(float scale){
        for (int i = 0; i < vertices.length;i++){
            vertices[i] *= scale;
        }
    }

    @Override
    public iComponent GetCompenent(String name) {
        return compenents.GetCompenent(name);
    }

    @Override
    public void AddCompenent(String name, iComponent compenet) {
        compenents.AddCompenet(compenet.toString(), compenet);
    }

    @Override
    public void GetCompenentList(String name, iComponent compenet) {

    }
}
