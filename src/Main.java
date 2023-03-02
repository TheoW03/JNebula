import org.NayaEngine.Tooling.loadShader;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.util.FPSAnimator;

import javax.swing.*;
import java.io.*;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 *
 *
 * this is how it would work
 *
 * you would spawn an object you would like, SPrite which would be a sprite Object or GameObject
 * they will be default compenets, like transform, sprite renderer
 * you will have to code your own shaders.
 *
 * @Javadoc
 */
public class Main {
    public static void main(String[] args) throws IOException {

        final GLProfile glProfile = GLProfile.getDefault();
        final GLCapabilities glCapabilities = new GLCapabilities(glProfile);
        loadShader a = new loadShader();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                JFrame jFrame = new JFrame("naya 2D graphics inDev edition");
                jFrame.setSize(640, 480);

                GLJPanel glJPanel = new GLJPanel(glCapabilities);
                FPSAnimator animator = new FPSAnimator(glJPanel, 60);
                glJPanel.addGLEventListener(new RendererTest(animator));
                glJPanel.setSize(jFrame.getSize());

                jFrame.getContentPane().add(glJPanel);

                jFrame.setVisible(true);

                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                animator.start();

            }
        });

    }
}
