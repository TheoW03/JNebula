package InfinityTrain;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GLAutoDrawable;
import org.JNebula.GameObjects.GameRenderer;

import java.util.*;
import java.io.*;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class InfinityTRainRender extends GameRenderer {
    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT); // clears the screen with the background color

        gl.glClearColor(1.0f,1.0f,1.0f,1.0f);
    }
}
