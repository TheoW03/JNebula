package GameObjects;

import Compenents.iCompenet;

import java.util.*;
import java.io.*;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public interface GameBehavior {
    public iCompenet GetCompenent(String name);
    public void AddCompenent(String name, iCompenet compenet);
    public void GetCompenentList(String name, iCompenet compenet);



}
