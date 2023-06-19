package org.JNebula.Components;

import java.util.*;

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
public class ManageComponent {
    private HashMap<String, iComponent> a;
    public ManageComponent() {
        a = new HashMap<>();
    }

    public iComponent GetCompenent(String className){
        if(a.get(className) == null){
            System.err.println(className+" doesn't exist");
        }
        return a.get(className);
    }
    public iComponent AddCompenet(String className, iComponent compenet){
        return a.put(className,compenet);
    }
}