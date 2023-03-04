import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.FPSAnimator;
import org.NayaEngine.Compenents.DifferentCompenents.CameraComponent;
import org.NayaEngine.Compenents.DifferentCompenents.PhysicsComponent;
import org.NayaEngine.Compenents.DifferentCompenents.SpriteComponents;
import org.NayaEngine.Compenents.DifferentCompenents.TransformComponent;
import org.NayaEngine.Compenents.ManageCmponent;
//import org.NayaEngine.GameObjects.FrameRate;
import org.NayaEngine.GameObjects.GameObject;
import org.NayaEngine.GameObjects.InitObjects;
import org.NayaEngine.GameObjects.SpriteObject;
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

    public SpriteObject s,s2;
    ArrayList<GameObject> list;
    InitObjects c;
    public GameObject test, test2;
    FPSAnimator fps;
    GL2 gl;

    public RendererTest(){
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
        test.AddCompenent(new SpriteComponents("src/sprites/test.jpg","jpg",gl));
        test.AddCompenent(new CameraComponent(new Vector3(0,0,0),gl));
        test.AddCompenent(new TransformComponent(new Vector3(100,150,0),gl));
        list.add(test);
        test2 = new GameObject("TEST2");
        test2.AddCompenent(new SpriteComponents("src/sprites/maxwell.png","png",gl));
        test2.AddCompenent(new CameraComponent(new Vector3(0,0,0),gl));
        test2.AddCompenent(new TransformComponent(new Vector3(100,40,0),gl));
        list.add(test2);
        gl.glClearColor(0.1f, 0.5f, 0.2f, 0.0f);


    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    public  int i = 0;
    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        test.GetCompenent(TransformComponent.class).location = new Vector3(100,i,0);
        Window.printFrameRate();
        c.InstiateObjects(list);
        i++;
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }
}
