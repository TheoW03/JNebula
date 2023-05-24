package org.JNebula.Tooling;


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
    private static boolean[] mouse_buttons = new boolean[4];


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

    public static int getMouseCode() {

        if (me == null) {
            return 0;
        } else {
            int code = me.getButton();
            me = null;
            return code;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouse");
        me = e;

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        me = null;

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        me = e;
    }
}
