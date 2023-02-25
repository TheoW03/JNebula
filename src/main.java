import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.util.FPSAnimator;

import javax.swing.*;
import java.util.*;
import java.io.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class main {
    public main() {

    }

    public static void main(String[] args) throws IOException {

        final GLProfile glProfile = GLProfile.getDefault();
        final GLCapabilities glCapabilities = new GLCapabilities(glProfile);
        loadShader a = new loadShader();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                JFrame jFrame = new JFrame("naya 2D graphics inDev edition");
                jFrame.setSize(640, 480);

                GLJPanel glJPanel = new GLJPanel(glCapabilities);
                glJPanel.addGLEventListener(new renderer());
                glJPanel.setSize(jFrame.getSize());

                jFrame.getContentPane().add(glJPanel);

                jFrame.setVisible(true);
                FPSAnimator animator = new FPSAnimator(glJPanel, 60);
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                animator.start();

            }
        });

    }
}
