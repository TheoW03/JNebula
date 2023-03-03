package org.NayaEngine.Tooling;

import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.util.FPSAnimator;

import javax.swing.*;
import java.util.*;
import java.io.*;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class Window {
    public static FPSAnimator animator;
    public Window(int width, int height, String title,GLEventListener renderer) {
        final GLProfile glProfile = GLProfile.getDefault();
        final GLCapabilities glCapabilities = new GLCapabilities(glProfile);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                JFrame jFrame = new JFrame(title);
                jFrame.setSize(width, height);

                GLJPanel glJPanel = new GLJPanel(glCapabilities);
                animator = new FPSAnimator(glJPanel, 60);
                glJPanel.addGLEventListener(renderer);
                glJPanel.setSize(jFrame.getSize());

                jFrame.getContentPane().add(glJPanel);

                jFrame.setVisible(true);

                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                animator.start();

            }
        });

    }
}
