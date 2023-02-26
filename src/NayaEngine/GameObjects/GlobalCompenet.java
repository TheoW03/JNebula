package NayaEngine.GameObjects;

import NayaEngine.Compenents.DifferentCompenents.CameraCompenent;
import NayaEngine.Compenents.ManageCompenents;
import NayaEngine.Compenents.iCompenet;
import NayaEngine.Tooling.Camera;
import NayaEngine.math.NVector;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class GlobalCompenet implements GameBehavior{
    private ManageCompenents compenents;
    private NVector position;
    public GlobalCompenet(NVector position) {
        this.position = position;
        addDefualtCompenets();
    }
    private void addDefualtCompenets(){
        compenents.AddCompenet("mainCamera", new CameraCompenent(new Camera(position)));
    }

    @Override
    public iCompenet GetCompenent(String name) {
        return null;
    }

    @Override
    public void AddCompenent(String name, iCompenet compenet) {

    }

    @Override
    public void GetCompenentList(String name, iCompenet compenet) {

    }
}
