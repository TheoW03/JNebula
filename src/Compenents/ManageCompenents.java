package Compenents;

import Compenents.iCompenet;

import java.util.*;
import java.io.*;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 *
 * how this can work,
 * we could have a reference here in the spirte method and a reference for it here
 * we then add the compenets in the constructor of the method.
 *
 */
public class ManageCompenents {
    private HashMap<String, iCompenet> a;
    public ManageCompenents() {
        a = new HashMap<>();
    }

    public iCompenet GetCompenent(String className){
        return a.get(className);
    }
    public iCompenet AddCompenet(String className, iCompenet compenet){
        return a.put(className,compenet);
    }
}
