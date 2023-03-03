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
    public GameObject test;
    FPSAnimator fps;
    GL2 gl;

    public RendererTest(FPSAnimator fps){
        this.fps = fps;
    }
    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        gl = glAutoDrawable.getGL().getGL2();
        c = new InitObjects(fps,gl);
        list = new ArrayList<>();
        test = new GameObject("TEST");
        test.AddCompenent(new SpriteComponents("src/sprites/test.jpg","jpg",gl));
        test.AddCompenent(new CameraComponent(new Vector3(0,0,0),gl));
        test.AddCompenent(new TransformComponent(new Vector3(100,100,0),gl));
        list.add(test);
        GameObject test2 = new GameObject("TEST2");
        test2.AddCompenent(new SpriteComponents("src/sprites/test.jpg","jpg",gl));
        test2.AddCompenent(new CameraComponent(new Vector3(0,0,0),gl));
        test2.AddCompenent(new TransformComponent(new Vector3(10,40,0),gl));
        list.add(test2);

    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        c.printFrameRate();
        c.InstiateObjects(list);
//        gl.glDrawElements(GL_TRIANGLE_STRIP, 6, GL_UNSIGNED_INT, 0);
//        gl.glBindBuffer(GL_ARRAY_BUFFER, 0);
//        gl.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }
}
