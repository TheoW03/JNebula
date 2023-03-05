package org.NayaEngine.Tooling;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.io.*;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class KeyboardInput implements KeyListener {
    public static int inputTyped;
    public static int inputPressed;
    public static int inputRealeased;
    public KeyboardInput() {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        inputTyped = e.getKeyCode();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        inputPressed = e.getKeyCode();
        System.out.println("hi");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        inputRealeased = e.getKeyCode();
    }
}
