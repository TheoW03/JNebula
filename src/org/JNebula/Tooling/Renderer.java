package org.JNebula.Tooling;

import com.jogamp.opengl.*;
import org.JNebula.GameObjects.GameObject;
import org.JNebula.GameObjects.InitObjects;
import org.joml.Vector3f;

import java.util.ArrayList;

import static org.JNebula.Components.Component.gl;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class Renderer implements GLEventListener {
    private static Scene currentScene;
    public ArrayList<GameObject> objectList;
    public float deltaTime;

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        long dtAtStart = System.currentTimeMillis();

        gl = (GL4) glAutoDrawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT); // clears the screen with the background color
        InitObjects.InstantiateObjects(objectList, deltaTime);
        long dtAtEnd = System.currentTimeMillis();
        deltaTime = (float) (dtAtEnd - dtAtStart) / 1000;
    }


    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        long dtAtStart = System.currentTimeMillis();
        GL2 gl = (GL2) glAutoDrawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT); // clears the screen with the background color
        InitObjects.InstantiateObjects(objectList, deltaTime);
        long dtAtEnd = System.currentTimeMillis();
        deltaTime = (float) (dtAtEnd - dtAtStart) / 1000;
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    public static GameObject Find(String tag) {
        return currentScene.Find(tag);
    }

    public ArrayList<GameObject> FindByTag(String tag) {
        return currentScene.FindByTag(tag);
    }

    public static void InstantiateObject(GameObject gameObject) {
        currentScene.InstantiateObject(gameObject);
    }

    public static void InstantiateObject(GameObject gameObject, Vector3f location) {
        currentScene.InstantiateObject(gameObject, location);
    }

    public static void DestroyObject(GameObject gameObject) {
        currentScene.DestroyObject(gameObject);

    }

    public void printFPS() {
        currentScene.printFPS();

    }

    public float getFPS() {
        return currentScene.getFPS();
    }

}
