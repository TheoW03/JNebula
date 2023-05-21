package org.JNebula.uselessgameObjStuff;

import org.JNebula.Compenents.iComponent;

import java.util.ArrayList;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public interface GameBehavior {
    public iComponent GetCompenent(String name);

    public void AddCompenent(String name, iComponent compenet);

    public void GetCompenentList(String name, iComponent compenet);

    public ArrayList<String> getList();

}
