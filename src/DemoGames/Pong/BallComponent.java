package DemoGames.Pong;

import org.JNebula.Components.Component;
import org.JNebula.GameObjects.GameObject;
import org.JNebula.GameObjects.InitObjects;
import org.JNebula.Tooling.Input;
import org.JNebula.math.VectorMath;
import org.joml.Vector3f;

import java.awt.event.KeyEvent;
import java.util.*;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class BallComponent extends Component {
    Vector3f bt = VectorMath.LEFT;
    @Override
    public void update(float dt) {
        Objects.requireNonNull(InitObjects.Find("ball")).transform.transform(bt);
        if(Input.getKey(KeyEvent.VK_SPACE)){
            gameObject.transform.location = new Vector3f(100,100, 0);
        }
    }

    @Override
    public void Collides(GameObject other) {
        if(other.name.equals("paddle2")){
            float min = -0.5f;
            float max = 0.5f;
            float randomNum = (float) (Math.random() * (max - min) + min);
            bt = new Vector3f(1, randomNum, 0);
        }
        if (other.name.equals("paddle1")) {
            float min = -0.5f;
            float max = 0.5f;
            float randomNum = (float) (Math.random() * (max - min) + min);
            bt = new Vector3f(-1, randomNum, 0);
        }
    }
}
