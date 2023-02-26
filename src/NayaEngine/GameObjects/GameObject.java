package NayaEngine.GameObjects;

import NayaEngine.Compenents.ManageCompenents;
import NayaEngine.Compenents.DifferentCompenents.TranformCompenet;
import NayaEngine.Compenents.iCompenet;
import NayaEngine.math.NVector;

import java.util.ArrayList;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class GameObject implements GameBehavior {
    ManageCompenents compenents;
    NVector location;
    public ArrayList<String> compenetsString;
    public float[] vertices;
    public GameObject(NVector location) {
        this.location =  location;
        this.compenents = new ManageCompenents();
        this.vertices = new float[]{
                -1.0f, -1.0f, 0.0f,   // Bottom-left vertex
                1.0f, -1.0f, 0.0f,    // Bottom-right vertex
                -1.0f, 1.0f, 0.0f,    // Top-left vertex
                1.0f, 1.0f, 0.0f      // Top-right vertex
        };
        addDefuaultCompenets();
    }
    private void addDefuaultCompenets(){

        compenents.AddCompenet("TransformComponent", new TranformCompenet(location));
    }

    public void scaleVertices(float scale){
        for (int i = 0; i < vertices.length;i++){
            vertices[i] *= scale;
        }
    }

    @Override
    public iCompenet GetCompenent(String name) {
        return compenents.GetCompenent(name);
    }

    @Override
    public void AddCompenent(String name, iCompenet compenet) {
        compenents.AddCompenet(compenet.toString(), compenet);
    }

    @Override
    public void GetCompenentList(String name, iCompenet compenet) {

    }
}
