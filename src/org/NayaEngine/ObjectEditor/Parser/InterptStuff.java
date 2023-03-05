package org.NayaEngine.ObjectEditor.Parser;

import org.NayaEngine.GameObjects.GameObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.io.*;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class InterptStuff {
    public InterptStuff() throws ClassNotFoundException,
            NoSuchFieldException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {
//        Class<?> clazz = Class.forName("org.NayaEngine.ColliderCompenet");
//        Object obj = clazz.getDeclaredConstructor().newInstance();
//
//        Field field = clazz.getDeclaredField("myVariable");
    }


    //field.setAccessible(true);
//    Object value = field.get(obj);
    public ArrayList<GameObject> initEditor() {
        ArrayList<GameObject> list = new ArrayList<>();
        return list;
    }
}
