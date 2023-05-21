
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.NayaEngine.Tooling.Camera;
import org.NayaEngine.Tooling.Window;
import org.NayaEngine.math.Vector3;
import org.json.JSONArray;
import org.json.JSONML;
import org.json.JSONObject;

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
//        Window.InitWindow(640, 480, "2D graphics inDev edition", new RendererTest());
        Vector3 a ;
//        Camera a;




        // TODO: Object eidtor
//        String json = "{\n" +
//                "  \"name\": \"org.NayaEngine.Tooling.Camera\",\n" +
//                "  \"location\": {\n" +
//                "    \"x\": 10.0,\n" +
//                "    \"y\": 5.0,\n" +
//                "    \"z\": 2.0\n" +
//                "  }\n" +
//                "}";
////
////        // Create Gson instance
//        Gson gson = new Gson();
////
////        // Convert JSON to JsonObject
//        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
////
////        // Get the class name from JSON
//        String className = jsonObject.get("name").getAsString();
//
//        try {
//            // Dynamically create an instance of the class
//            Class<?> clazz = Class.forName(className);
//
//            Object object = gson.fromJson(json, clazz);
//
//            // Access object properties
//            System.out.println(object.toString());
//        } catch (ClassNotFoundException e) {
//            System.out.println("class not found");
//        }
        //        testLexxer();
//        Window.InitWindow(640, 480, "2D graphics inDev edition", new Renderer4());
    }

    public static void testLexxer() throws IOException {
//        String PATH = "src/ui.naya";
//        ArrayList<String> a = (ArrayList<String>) Files.readAllLines(Path.of(PATH), StandardCharsets.UTF_8);
//        Lexxer obk = new Lexxer(a);
//        System.out.println("lexxing..");
//        ArrayList<Token> tokenData = obk.lexString();
//        for (Token tokenDatum : tokenData) {
//            System.out.println(tokenDatum.toString());
//        }
//        System.out.println("lexxing complete");
    }
}


































