package org.JNebula.GameObjects;

import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import org.JNebula.Components.iComponent;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public abstract class GameRenderer implements GLEventListener, KeyListener {
    public static GL4 gl;
    public ArrayList<GameObject> gameObjectArrayList; //might use map
    public InitObjects Init;
    @Override
    public void init(GLAutoDrawable glAutoDrawable) {

        gl = (GL4) glAutoDrawable.getGL();
        iComponent.gl = gl;
        GameObject.gl = gl;
        gameObjectArrayList = new ArrayList<>();
        Init = new InitObjects();
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}
