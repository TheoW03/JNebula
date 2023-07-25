package org.JNebula.Tooling;

import com.jogamp.opengl.*;
import org.JNebula.Components.Component;
import org.JNebula.Components.DifferentComponents.TransformComponent;
import org.JNebula.GameObjects.GameObject;
import org.JNebula.GameObjects.GameRenderer;
import org.JNebula.GameObjects.InitObjects;
import org.JNebula.ObjectEditor.ObjectEditorJSON;
import org.JNebula.math.Vector3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.JNebula.Components.Component.gl;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class Scene implements GLEventListener {

    private static ArrayList<GameObject> objectList;

    private GameRenderer g;
    public String JSONPath;
    public static float deltaTime;

    public Scene(GameRenderer g, String JSONPath) {
        this.g = g;
        objectList = new ArrayList<>();
        this.JSONPath = JSONPath;
    }

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {

        long dtAtStart = System.currentTimeMillis();
        if (!JSONPath.equals("")) {
            ObjectEditorJSON a = new ObjectEditorJSON(JSONPath);
            objectList = a.objects;
        }
        gl = (GL4) glAutoDrawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT); // clears the screen with the background color
        InitObjects.InstantiateObjects(objectList, deltaTime);
        g.start(deltaTime, (GL2)glAutoDrawable.getGL());
        long dtAtEnd = System.currentTimeMillis();
        deltaTime = (float) (dtAtEnd - dtAtStart) / 1000;
    }


    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        long dtAtStart = System.currentTimeMillis();
        GL2 gl = (GL2) glAutoDrawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT); // clears the screen with the background color
        InitObjects.InstantiateObjects(objectList, deltaTime);
        g.update(deltaTime, gl);
        long dtAtEnd = System.currentTimeMillis();
        deltaTime = (float) (dtAtEnd - dtAtStart) / 1000;
    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }


    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    public static GameObject Find(String name) {
        for (int i = 0; i < objectList.size(); i++) {
            if (objectList.get(i).name.equals(name)) {
                return objectList.get(i);

            }
        }
        return null;
    }

    public static ArrayList<GameObject> FindByTag(String tag) {
        ArrayList<GameObject> list = new ArrayList<>();
        for (int i = 0; i < objectList.size(); i++) {
            if (objectList.get(i).tag.equals(tag)) {
                list.add(objectList.get(i));

            }
        }
        return list;
    }

    public static void InstantiateObject(GameObject gameObject) {
        while (Find(gameObject.name) != null) {
            gameObject.name += "(Clone)";
        }
        objectList.add(gameObject);
    }

    public static void InstantiateObject(GameObject gameObject, Vector3 location) {
        while (Find(gameObject.name) != null) {
            gameObject.name += "(Clone)";
        }
        if (gameObject.GetComponent(TransformComponent.class) != null) {
            gameObject.transform.location = location;
        } else {
            gameObject.AddComponent(new TransformComponent(location));
        }
        objectList.add(gameObject);

    }

    public static void DestroyObject(GameObject gameObject) {
        for (int i = 0; i < objectList.size(); i++) {
            if (gameObject.name.equals(objectList.get(i).name)) {
                objectList.remove(i);
                return;
            }
        }

    }
    public static void printFPS(){
        float FPS = 1000/deltaTime;
        System.out.println("FPS: "+FPS);
        System.out.println("DT: "+deltaTime);
    }
    public static float getFPS(){
        return 1000/deltaTime;
    }
}