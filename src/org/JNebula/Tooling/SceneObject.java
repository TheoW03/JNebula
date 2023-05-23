package org.JNebula.Tooling;

import org.JNebula.GameObjects.GameObject;

import java.util.*;
import java.io.*;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class SceneObject {
    private ArrayList<GameObject> gameObjectList;
    private HashMap<String, GameObject> gameObjectMap;

    public SceneObject() {
        gameObjectList = new ArrayList<>();
        gameObjectMap = new HashMap<>();
    }

    public GameObject findObject(String name) {
        return gameObjectMap.get(name);
    }

    public void initObject(GameObject object) {
        gameObjectList.add(object);
        gameObjectMap.put(object.name, object);
    }

    public ArrayList<GameObject> getList() {
        return gameObjectList;
    }
    /**
     *
     * @param object
     * only if Java had default values T~T like C#, C++
     */
    public void destroyObject(GameObject object) {
        for (int i = 0; i < gameObjectList.size(); i++) {
            if (object.name.equals(gameObjectList.get(i).name)) {
                gameObjectList.remove(i);
                gameObjectMap.remove(object.name);
                return;
            }
        }


    }


    public void destroyObject(String objectName) {
        for (int i = 0; i < gameObjectList.size(); i++) {
            if (objectName.equals(gameObjectList.get(i).name)) {
                gameObjectList.remove(i);
                gameObjectMap.remove(objectName);
                return;
            }
        }


    }
}
