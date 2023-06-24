
import TestStuff.RendererTest3D;
import TestStuff.RendererTest2D;
import org.JNebula.ObjectEditor.ObjectEditorJSON;
import org.JNebula.Tooling.Window;

import java.io.*;


/**
 * @author Theo willis
 * @version 1.0.0s
 * ~ project outline here ~
 * <p>
 * <p>
 * this is how it would work
 * <p>
 * you would spawn an object you would like, SPrite which would be a sprite Object or GameObject
 * they will be default components, like transform, sprite renderer
 * you will have to code your own shaders.
 * @Javadoc
 */
public class Main {
    public static void main(String[] args) throws IOException {
        render3D();

    }

    public  static void render3D(){
        Window.InitWindow(640, 480, "3D JNebula Dev edition", new RendererTest3D());
    }
    public static void render2D(){
        Window.InitWindow(640, 480, "2D JNebula Dev edition", new RendererTest2D());
    }
    public static void testObjectEditor() throws IOException {
        ObjectEditorJSON js = new ObjectEditorJSON("src/ObjectEditorJSON/TestObject.json");

    }
}


































