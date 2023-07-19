package DemoGame;

import com.jogamp.opengl.GLAutoDrawable;
import org.JNebula.Components.DifferentComponents.ColliderComponent;
import org.JNebula.Components.DifferentComponents.SpriteComponent;
import org.JNebula.Components.DifferentComponents.TransformComponent;
import org.JNebula.GameObjects.GameObject;
import org.JNebula.GameObjects.GameRenderer;
import org.JNebula.GameObjects.InitObjects;
import org.JNebula.ObjectEditor.ObjectEditorJSON;
import org.JNebula.Tooling.Colors;
import org.JNebula.Tooling.Input;
import org.JNebula.math.Vector3;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.Objects;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class DemoRenderer extends GameRenderer implements KeyListener {

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        super.init(glAutoDrawable);
        ObjectEditorJSON a = new ObjectEditorJSON("src/DemoGame/Objects.json");
        gameObjectArrayList = a.objects;

    }

    Vector3 bt = Vector3.left;

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        InitObjects.InstantiateObjects(gameObjectArrayList);

//        if(Input.getKey(KeyEvent.VK_S)){
//            Objects.requireNonNull(InitObjects.Find("paddle2")).transform.transform(Vector3.down);
//        }
//        if(Input.getKey(KeyEvent.VK_W)){
//            Objects.requireNonNull(InitObjects.Find("paddle2")).transform.transform(Vector3.up);
//        }
//        if(Input.getKey(KeyEvent.VK_DOWN)){
//            Objects.requireNonNull(InitObjects.Find("paddle1")).transform.transform(Vector3.down);
//        }
//        if(Input.getKey(KeyEvent.VK_UP)){
//            Objects.requireNonNull(InitObjects.Find("paddle1")).transform.transform(Vector3.up);
//        }
        if(Input.getKey(KeyEvent.VK_SPACE)){
            Objects.requireNonNull(InitObjects.Find("ball")).transform.location = new Vector3(100,100);
        }

//        if (Objects.requireNonNull(InitObjects.Find("paddle2")).
//                GetCompenent(ColliderComponent.class).isCollided(Objects.requireNonNull(InitObjects.Find("paddle1")).
//                        GetCompenent(ColliderComponent.class))) {
//            float min = -0.5f;
//            float max = 0.5f;
//            float randomNum = (float) (Math.random() * (max - min) + min);
//            bt = new Vector3(1, randomNum);
//        }
//        if (Objects.requireNonNull(InitObjects.Find("paddle1")).GetCompenent(ColliderComponent.class).isCollided(InitObjects.Find("ball").GetCompenent(ColliderComponent.class))) {
//            float min = -0.5f;
//            float max = 0.5f;
//            float randomNum = (float) (Math.random() * (max - min) + min);
//            bt = new Vector3(-1, randomNum);
//        }
//        if (Objects.requireNonNull(InitObjects.Find("ball")).transform.location.y > 200) {
//            bt = new Vector3(bt.x, -bt.y);
//        }
//        if (Objects.requireNonNull(InitObjects.Find("ball")).transform.location.y < 0) {
//            bt = new Vector3(bt.x, bt.y);
//        }

    }



}
