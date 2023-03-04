import com.jogamp.opengl.GL;
import com.jogamp.opengl.GLAutoDrawable;
import org.NayaEngine.GameObjects.GameRenderer;

import java.util.*;
import java.io.*;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class Renderer4 extends GameRenderer {
    @Override
    public void display(GLAutoDrawable glAutoDrawable) {

        System.out.println(this.gl.glGetString(GL.GL_VERSION));
    }
}
