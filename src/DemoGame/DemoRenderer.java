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
    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        InitObjects.InstantiateObjects(gameObjectArrayList);

    }


}
