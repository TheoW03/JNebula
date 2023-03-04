import org.NayaEngine.Tooling.Window;
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
 * <p>
 * <p>
 * this is how it would work
 * <p>
 * you would spawn an object you would like, SPrite which would be a sprite Object or GameObject
 * they will be default compenets, like transform, sprite renderer
 * you will have to code your own shaders.
 * @Javadoc
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Window w = new Window(640, 480, "2D graphics inDev edition", new RendererTest());
    }
}
