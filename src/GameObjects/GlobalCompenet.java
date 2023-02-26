package GameObjects;

import Compenents.DifferentCompenents.CameraCompenent;
import Compenents.DifferentCompenents.TranformCompenet;
import Compenents.ManageCompenents;
import Compenents.iCompenet;
import Tooling.Camera;
import math.NVector;

import java.util.*;
import java.io.*;


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
