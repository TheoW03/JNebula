package DemoGames.Pong;

import org.JNebula.Tooling.Scene;
import org.JNebula.Tooling.Window;

import java.util.ArrayList;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class DemoMain {

    public static void main(String[] args) {
        ArrayList<Scene> scenes = new ArrayList<>();
        scenes.add(new Scene("src/DemoGames/Pong/Objects.json"));
        scenes.add(new Scene("src/DemoGames/Pong/Scene2.json"));
        Window.InitWindow(640, 480, "JNebula Demo 1: Pong", scenes);
    }
}
