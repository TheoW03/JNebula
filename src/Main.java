import org.NayaEngine.ObjectEditor.Lexer.Lexxer;
import org.NayaEngine.ObjectEditor.Lexer.Token;
import org.NayaEngine.Tooling.Input;
import org.NayaEngine.Tooling.Window;
import org.NayaEngine.Tooling.loadShader;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.util.FPSAnimator;

import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


/**
 * @author Theo willis
 * @version 1.0.0s
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
//        Window w = new Window(640, 480, "2D graphics inDev edition", new RendererTest());
        Window.InitWindow(640, 480, "2D graphics inDev edition", new RendererTest());
        //        testLexxer();
//        Window.InitWindow(640, 480, "2D graphics inDev edition", new Renderer4());\
    }

    public static void testLexxer() throws IOException {
        String PATH = "src/ui.naya";
        ArrayList<String> a = (ArrayList<String>) Files.readAllLines(Path.of(PATH), StandardCharsets.UTF_8);
        Lexxer obk = new Lexxer(a);
        System.out.println("lexxing..");
        ArrayList<Token> tokenData = obk.lexString();
        for (Token tokenDatum : tokenData) {
            System.out.println(tokenDatum.toString());
        }
        System.out.println("lexxing complete");
    }
}


































