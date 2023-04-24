package org.NayaEngine.GameObjects;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import org.NayaEngine.Compenents.iComponent;

import java.util.*;
import java.io.*;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public abstract class GameRenderer implements GLEventListener {
    public static GL4 gl;
    public ArrayList<GameObject> gameObjectArrayList; //might use map
    public InitObjects instantiate;
    @Override
    public void init(GLAutoDrawable glAutoDrawable) {

        gl = (GL4) glAutoDrawable.getGL();
        iComponent.gl = gl;
        GameObject.gl = gl;
        gameObjectArrayList = new ArrayList<>();
        instantiate = new InitObjects();
    }

    public  void dispose(GLAutoDrawable glAutoDrawable){

    }

    public void display(GLAutoDrawable glAutoDrawable){
        gl = (GL4) glAutoDrawable.getGL();
        iComponent.gl = gl;
        GameObject.gl = gl;
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

}
