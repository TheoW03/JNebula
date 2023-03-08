import com.jogamp.newt.event.KeyEvent;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.FPSAnimator;
import org.NayaEngine.Compenents.DifferentCompenents.*;
import org.NayaEngine.Compenents.ManageCmponent;
//import org.NayaEngine.GameObjects.FrameRate;
import org.NayaEngine.GameObjects.GameObject;
import org.NayaEngine.GameObjects.InitObjects;
import org.NayaEngine.GameObjects.SpriteObject;
import org.NayaEngine.Tooling.KeyboardInput;
import org.NayaEngine.Tooling.Window;
import org.NayaEngine.math.Vector3;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

import java.util.ArrayList;

import static com.jogamp.opengl.GL.*;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class RendererTest implements GLEventListener {

    public SpriteObject s, s2;
    ArrayList<GameObject> list;
    InitObjects c;
    public GameObject test, test2;
    FPSAnimator fps;
    GL2 gl;

    public RendererTest() {
//        this.fps = w.animator;
    }

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        gl = glAutoDrawable.getGL().getGL2();
        gl.glEnable(GL.GL_BLEND);
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);

        c = new InitObjects(gl);
        list = new ArrayList<>();
        test = new GameObject("TEST");
        test.AddCompenent(new SpriteComponents("src/sprites/test.jpg", "jpg", gl));
        test.AddCompenent(new CameraComponent(new Vector3(0, 0, 0), gl));
        test.AddCompenent(new TransformComponent(new Vector3(100, 150, 0), gl));
        test.AddCompenent(new PhysicsComponent(gl, 4.0f, test.GetCompenent(TransformComponent.class).location));
        test.AddCompenent(new ColliderCompenet(test.GetCompenent(SpriteComponents.class).width, test.GetCompenent(SpriteComponents.class).height));

        list.add(test);
        test2 = new GameObject("TEST2");
        test2.AddCompenent(new SpriteComponents("src/sprites/maxwell.png", "png", gl));
        test2.AddCompenent(new CameraComponent(new Vector3(0, 0, 0), gl));
        test2.AddCompenent(new TransformComponent(new Vector3(96, 40, 0), gl));
        test2.AddCompenent(new PhysicsComponent(gl, 1.0f, test2.GetCompenent(TransformComponent.class).location));
        test2.AddCompenent(new ColliderCompenet(test2.GetCompenent(SpriteComponents.class).width, test2.GetCompenent(SpriteComponents.class).height));
        test2.GetCompenent(PhysicsComponent.class).veloLock = true;
        list.add(test2);
        gl.glClearColor(0.1f, 0.5f, 0.2f, 0.0f);


    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    public int i = 0;

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        Window.printFrameRate();
        c.InstiateObjects(list);
        if (KeyboardInput.inputPressed == KeyEvent.VK_W) {
            System.out.println("typed");
        }
        if (test2.GetCompenent(ColliderCompenet.class).isCollided(test.GetCompenent(ColliderCompenet.class))) {
            test.GetCompenent(PhysicsComponent.class).veloLock = true;
            System.out.println("collided");
        }
        i++;
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }
}
