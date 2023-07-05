package org.JNebula.Tooling;


import org.JNebula.math.Vector3;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class Input extends MouseInputAdapter implements KeyListener {
    private static KeyEvent ke;
    private static MouseEvent me;

    private static boolean[] keys = new boolean[256];

    private static boolean[] mouseButtons = new boolean[4];

    public static Vector3 mouseLocation = new Vector3(0,0);

    public Input() {

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode >= 0 && keyCode < keys.length) {
            keys[keyCode] = true;
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode >= 0 && keyCode < keys.length) {
            keys[keyCode] = false;
        }
    }


    public static boolean getKey(int keyCode) {
        if (keyCode >= 0 && keyCode < keys.length) {
            return keys[keyCode];
        }
        return false;
    }

    public static boolean getMouseCode(int mouseCode) {
        if (mouseCode >= 0 && mouseCode < mouseButtons.length) {
            return mouseButtons[mouseCode];
        }

        return false;

    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mouseButton = e.getButton();
        mouseLocation = new Vector3(e.getX(), e.getY());
        if (mouseButton >= 0 && mouseButton < mouseButtons.length) {
            mouseButtons[mouseButton] = true;

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int mouseButton = e.getButton();

        if (mouseButton >= 0 && mouseButton < mouseButtons.length) {
            mouseButtons[mouseButton] = false;

        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {


    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}
