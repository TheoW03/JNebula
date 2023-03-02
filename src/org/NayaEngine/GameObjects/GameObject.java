package org.NayaEngine.GameObjects;

import com.jogamp.opencl.llb.CL;
import org.NayaEngine.Compenents.ManageCmponent;
import org.NayaEngine.Compenents.DifferentCompenents.TransformComponent;
import org.NayaEngine.Compenents.iComponent;
import org.NayaEngine.math.Vector3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class GameObject {

    public ArrayList<iComponent> compenets;

    public GameObject(String name) {
        compenets = new ArrayList<>();

    }

    public <T extends iComponent> T GetCompenent(Class<T> compenet) {
        for (iComponent c : compenets) {
            if (compenet.isAssignableFrom(c.getClass())) {
                return compenet.cast(c);
            }
        }
        return null;
    }

    public <T extends iComponent> T RemoveCompenent(Class<T> compenet) {
        for (int i = 0; i < compenets.size(); i++) {
            if (compenet.isAssignableFrom(compenets.get(i).getClass())) {
                return compenet.cast(compenets.remove(i));
            }

        }
        return null;
    }


    public void AddCompenent(iComponent compenet) {
        compenets.add(compenet);
        compenet.gameObject = this;
    }

    public void update(float dt) {
        for (int i = 0; i < compenets.size(); i++) {
            compenets.get(i).update(1);
        }
    }

    public void start(float dt) {
        for (int i = 0; i < compenets.size(); i++) {
            compenets.get(i).init(1);
        }
    }

    public void GetCompenentList(String name, iComponent compenet) {

    }


    public ArrayList<String> getList() {
        return null;
    }
}
