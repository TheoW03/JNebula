package DemoGame;

import org.JNebula.Tooling.Window;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class DemoMain {
    public DemoMain() {

    }

    public static void main(String[] args) {
        Window.InitWindow(640, 480, "Pong", new DemoRenderer());
    }
}
