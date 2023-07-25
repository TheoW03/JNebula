package org.JNebula.GameObjects;

import com.jogamp.opengl.*;
import org.JNebula.Components.Component;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public abstract class GameRenderer implements KeyListener, GLEventListener {



    public  void start(float dt, GL2 gl){

    }


    public void update(float dt, GL2 gl){

    }


    public static GL4 gl;
    public ArrayList<GameObject> gameObjectArrayList; //might use map
    public InitObjects Init;
    @Override
    public void init(GLAutoDrawable glAutoDrawable) {

//        gl = (GL4) glAutoDrawable.getGL();
//        Component.gl = gl;
//        GameObject.gl = gl;
//        gameObjectArrayList = new ArrayList<>();
//        Init = new InitObjects();
    }

    public  void dispose(GLAutoDrawable glAutoDrawable){

    }

    public void display(GLAutoDrawable glAutoDrawable){
        gl = (GL4) glAutoDrawable.getGL();
        Component.gl = gl;
        GameObject.gl = gl;
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }
//
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
