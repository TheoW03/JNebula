import com.jogamp.opengl.util.FPSAnimator;
import org.NayaEngine.Compenents.DifferentCompenents.PhysicsComponent;
import org.NayaEngine.Compenents.DifferentCompenents.SpriteComponents;
import org.NayaEngine.Compenents.DifferentCompenents.TransformComponent;
import org.NayaEngine.Compenents.ManageCmponent;
import org.NayaEngine.GameObjects.FrameRate;
import org.NayaEngine.GameObjects.GameObject;
import org.NayaEngine.GameObjects.InitObjects;
import org.NayaEngine.GameObjects.SpriteObject;
import org.NayaEngine.math.Vector3;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

import java.util.ArrayList;


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

    public RendererTest(FPSAnimator fps){
        c = new InitObjects(fps);
    }
    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        list = new ArrayList<>();
        test = new GameObject("TEST");
        test.AddCompenent(new SpriteComponents());
        test.AddCompenent(new PhysicsComponent());
        test.AddCompenent(new TransformComponent());
        list.add(test);
        GameObject test2 = new GameObject("TEST2");
        test2.AddCompenent(new SpriteComponents());
        test2.AddCompenent(new PhysicsComponent());
        list.add(test2);


    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        c.printFrameRate();
        c.InstiateObjects(list);
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }
}
