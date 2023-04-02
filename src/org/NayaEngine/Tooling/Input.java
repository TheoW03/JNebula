package org.NayaEngine.Tooling;


import javax.swing.event.MouseInputAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.Key;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class Input extends MouseInputAdapter implements KeyListener {
    private static KeyEvent ke;
    private static MouseEvent me;

    public Input() {

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        ke = e;
    }


    @Override
    public void keyReleased(KeyEvent e) {
        ke = null;
    }

    public static int getKey() {
        return (ke == null) ? 0 : ke.getKeyCode();
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
        System.out.println("realeased");
        me = null;
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
