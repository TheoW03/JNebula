package DemoGames.Pong;

import org.JNebula.Components.Component;
import org.JNebula.Tooling.Input;
import org.JNebula.Tooling.Renderer;
import org.JNebula.math.VectorMath;

import java.awt.event.KeyEvent;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class PaddleComponent1 extends Component {
    @Override
    public void update(float dt) {
        if (Input.getKey(KeyEvent.VK_UP)) {
            gameObject.transform.transform(VectorMath.UP);
            Renderer.SwitchScene(0);
        }
        if (Input.getKey(KeyEvent.VK_DOWN)) {
            gameObject.transform.transform(VectorMath.DOWN);

        }
        if (Input.getKey(KeyEvent.VK_1)) {
            Renderer.SwitchScene(1);
        } else if (Input.getKey(KeyEvent.VK_2)) {
            Renderer.SwitchScene(0);
        }


    }
}
