package org.NayaEngine.GameObjects;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

import java.util.*;
import java.io.*;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public abstract class GameRenderer implements GLEventListener {
    public GL4 gl;
    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        gl = (GL4) glAutoDrawable.getGL();
    }

    public  void dispose(GLAutoDrawable glAutoDrawable){

    }

    public void display(GLAutoDrawable glAutoDrawable){
        gl = (GL4) glAutoDrawable.getGL();
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

}
