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
    public GameObject(NVector location) {
        this.location =  location;
        this.compenents = new ManageCompenents();
        addDefuaultCompenets();
    }
    private void addDefuaultCompenets(){

        compenents.AddCompenet("TransformComponent", new TranformCompenet(location));
    }

    @Override
    public iCompenet GetCompenent(String name) {
        return compenents.GetCompenent(name);
    }

    @Override
    public void AddCompenent(String name, iCompenet compenet) {
        compenents.AddCompenet(name, compenet);
    }

    @Override
    public void GetCompenentList(String name, iCompenet compenet) {

    }
}
