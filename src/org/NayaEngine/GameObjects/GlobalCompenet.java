package org.NayaEngine.GameObjects;

import org.NayaEngine.Compenents.DifferentCompenents.CameraComponent;
import org.NayaEngine.Compenents.ManageCmponent;
import org.NayaEngine.Compenents.iComponent;
import org.NayaEngine.Tooling.Camera;
import org.NayaEngine.math.Vector3;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class GlobalCompenet implements GameBehavior{
    private ManageCmponent compenents;
    private Vector3 position;
    public GlobalCompenet(Vector3 position) {
        this.position = position;
        addDefualtCompenets();
    }
    private void addDefualtCompenets(){
        compenents.AddCompenet("mainCamera", new CameraComponent(new Camera(position)));
    }

    @Override
    public iComponent GetCompenent(String name) {
        return null;
    }

    @Override
    public void AddCompenent(String name, iComponent compenet) {

    }

    @Override
    public void GetCompenentList(String name, iComponent compenet) {

    }
}
