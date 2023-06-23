package org.JNebula.Tooling;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.util.FPSAnimator;
import org.JNebula.Components.Component;
import org.JNebula.math.Vector3;

import javax.swing.*;
import java.awt.*;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class Window {
    public static FPSAnimator animator;
    public static Vector3 screenRes;
    public static float deltaTime;
    public static float time;

    public static void InitWindow(int width, int height, String title, GLEventListener renderer) {
        final GLProfile glProfile = GLProfile.getDefault();
        final GLCapabilities glCapabilities = new GLCapabilities(glProfile);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
//                screenRes = new Vector3(width,height);
                JFrame jFrame = new JFrame(title);
                jFrame.setSize(width, height);
                jFrame.addKeyListener(new Input());

                GLJPanel glJPanel = new GLJPanel(glCapabilities);
                glJPanel.addKeyListener(new Input());
                glJPanel.addMouseListener(new Input());

                animator = new FPSAnimator(glJPanel, 60);
                glJPanel.addGLEventListener(renderer);
                glJPanel.setSize(jFrame.getSize());
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                screenRes = new Vector3(screenSize.width, screenSize.height);
                jFrame.getContentPane().add(glJPanel);

                jFrame.setVisible(true);


                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                animator.start();


            }
        });
    }

    public static void printFrameRate() {

        deltaTime = 0.1f;
        int frames = Window.animator.getFPS();
        System.out.println("DT: " + deltaTime);
        double fps = (double) frames / ((double) deltaTime / 1000000000.0);
        System.out.println("FPS: " + frames);

    }

    public static void setBGColor(Colors c) {
        Component.gl.glClearColor(c.r2, c.b2, c.g2, 0.0f);

    }
}
