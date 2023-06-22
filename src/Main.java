
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import de.javagl.obj.Obj;
import org.JNebula.ObjectEditor.ObjectEditorJSON;
import org.JNebula.Tooling.Window;
import org.JNebula.math.Vector3;
import org.json.JSONObject;

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
 * they will be default compenets, like transform, sprite renderer
 * you will have to code your own shaders.
 * @Javadoc
 */
public class Main {
    public static void main(String[] args) throws IOException {
        render3D();

    }

    public  static void render3D(){
        Window.InitWindow(640, 480, "3D JNebula Dev edition", new Renderer4());
    }
    public static void render2D(){
        Window.InitWindow(640, 480, "2D JNebula Dev edition", new RendererTest());
    }
    public static void testObjectEditor() throws IOException {
        ObjectEditorJSON js = new ObjectEditorJSON("src/ObjectEditorJSON/TestObject.json");

    }
}


































