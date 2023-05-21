package org.NayaEngine.ObjectEditor;

import org.NayaEngine.GameObjects.GameObject;

import java.lang.reflect.InvocationTargetException;
import java.util.*;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class ObjectEditorJSON {

    public ObjectEditorJSON(String file){

    }
    public ObjectEditorJSON() throws ClassNotFoundException,
            NoSuchFieldException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {
//        Class<?> clazz = Class.forName("org.NayaEngine.ColliderComponent");
//        Object obj = clazz.getDeclaredConstructor().newInstance();
//
//        Field field = clazz.getDeclaredField("myVariable");


        //how to implement a JSON serializer
//        StringBuilder json = new StringBuilder("{");
//
//        // Iterate over the object's fields
//        Field[] fields = obj.getClass().getDeclaredFields();

    }


    //field.setAccessible(true);
//    Object value = field.get(obj);
    public ArrayList<GameObject> initEditor() {
        ArrayList<GameObject> list = new ArrayList<>();
        return list;
    }
}
