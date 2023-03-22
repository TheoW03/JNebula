package org.NayaEngine.Tooling;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class Input implements KeyListener {
    private static KeyEvent ke;
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
    public static int getKey(){
        if(ke != null){
            return ke.getKeyCode();
        }else {
            return 0;
        }
    }
}
