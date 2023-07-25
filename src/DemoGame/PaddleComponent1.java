package DemoGame;

import org.JNebula.Components.Component;
import org.JNebula.GameObjects.InitObjects;
import org.JNebula.Tooling.Input;
import org.JNebula.Tooling.Scene;
import org.JNebula.Tooling.Window;
import org.JNebula.math.Vector3;

import java.awt.event.KeyEvent;
import java.util.Objects;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class PaddleComponent1 extends Component {
    @Override
    public void update(float dt) {
        if(Input.getKey(KeyEvent.VK_UP)){
            gameObject.transform.transform(Vector3.up);
        }
        if(Input.getKey(KeyEvent.VK_DOWN)){
            gameObject.transform.transform(Vector3.down);

        }
        Scene.printFPS();

    }
}
