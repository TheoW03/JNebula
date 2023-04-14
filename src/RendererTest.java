import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.FPSAnimator;
import org.NayaEngine.Compenents.DifferentCompenents.*;
//import org.NayaEngine.GameObjects.FrameRate;
import org.NayaEngine.GameObjects.GameObject;
import org.NayaEngine.GameObjects.InitObjects;
import org.NayaEngine.GameObjects.SpriteObject;

import org.NayaEngine.Tooling.Colors;
import org.NayaEngine.Tooling.Rays;
import org.NayaEngine.Tooling.SpriteSheetList;
import org.NayaEngine.Tooling.Window;
import org.NayaEngine.math.Vector3;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

import java.io.IOException;
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
//        SpriteSheetList s1 = new SpriteSheetList("src/sprites/sprite_sheet.jpg", "jpg", 1, 5, 64, 64, 7);
//        try {
//            SpriteSheetList s2 = new SpriteSheetList("src/sprites/sprite_sheet.jpg", "jpg",1,5);
//        } catch (IOException e) {
////
//        }
//        System.exit(0);
        list = new ArrayList<>();
        test = new GameObject("TEST");
//        test.AddCompenent(new LightingComponent(0.2f,new float[]{0.5f,0.5f,0.5f},0.3f,gl));
//        test.AddCompenent(new SpriteComponents("src/sprites/sprite_sheet.jpg", "jpg",1,5,20,108,64,7,gl));
//        test.AddCompenent(new SpriteComponents("src/sprites/sprite_sheet.jpg", "jpg", 1, 5, 20, 64, 64, 7, gl));
//        test.AddCompenent(new SpriteComponents(s1.getSection(1,3), s1,15, gl));
//        test.AddCompenent(new RenderCompenent(Colors.RED));
        test.AddCompenent(new SpriteComponents("src/sprites/maxwell.png", "png",gl));
//        test.GetCompenent(SpriteComponents.class).scale(200);

//        test.AddCompenent(new CameraComponent(new Vector3(0, 0, 0), gl));
        test.AddCompenent(new TransformComponent(new Vector3(0, 200, 0), gl));


        test.AddCompenent(new PhysicsComponent(gl, new Vector3(-1,0.5f),-0.05f, test.GetCompenent(TransformComponent.class).location));
        Rays ray = new Rays(Vector3.down, 94);
        test.AddCompenent(new ColliderCompenet(ray));
//        test.AddCompenent(new LightingComponent(10, Colors.colorHex(Colors.RED),1.0f,gl));
        list.add(test);
        test2 = new GameObject("TEST2");

        test2.AddCompenent(new SpriteComponents("src/sprites/test.jpg", "jpg", gl));

//        test2.AddCompenent(new LightingComponent(1.0f, Colors.colorHex(Colors.WHITE),0.4f,gl));
//        test.AddCompenent(new LightingComponent(test2.GetCompenent(LightingComponent.class),gl));

        System.out.println("test: " + test2);
        test2.AddCompenent(new TransformComponent(new Vector3(100, 50, 0), gl));


        test2.AddCompenent(new PhysicsComponent(gl, new Vector3(0.5f,0.5f),-0.05f, test2.GetCompenent(TransformComponent.class).location));
        test2.AddCompenent(new ColliderCompenet(test2.GetCompenent(SpriteComponents.class).width, test2.GetCompenent(SpriteComponents.class).height));

        test2.GetCompenent(PhysicsComponent.class).veloLock = true;
        test.GetCompenent(PhysicsComponent.class).veloLock = true;
//        test.GetCompenent(PhysicsComponent.class).veloLock = true;
        list.add(test2);

//        test2.GetCompenent(SpriteComponents.class).scale(2);
        gl.glClearColor(0, 1, 1, 0.0f);


    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    public float i2 = 1;

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT); // clears the screen with the background color
//        test2.GetCompenent(SpriteComponents.class).scale(i);
        Window.printFrameRate();


        c.InstiateObjects(list);

//        test2.GetCompenent(ColliderCompenet.class).rayCastCollider(test.GetCompenent(ColliderCompenet.class));
        test.GetCompenent(TransformComponent.class).transform(new Vector3(0.5f,0));
        if (test.GetCompenent(ColliderCompenet.class).raycasting(test2.GetCompenent(ColliderCompenet.class))) {
            gl.glClearColor(1, 1, 1, 0.0f);
            System.out.println("collided");
        }else {

            gl.glClearColor(0, 1, 1, 0.0f);
        }
//        test2.GetCompenent(TransformComponent.class).rotateContinosuly(-0.05f);
//        test2.isActive = false;
//        i = i +100;
        int error = gl.glGetError();
        if (error != GL_NO_ERROR) {

            System.out.println("OpenGL error occurred: " + error);
        }
//        test2.GetCompenent(TransformComponent.class).location.y +=i2;
//        if ( test2.GetCompenent(TransformComponent.class).location.x < -200) {
//            i2 = 1.0f;
//        } else if ( test2.GetCompenent(TransformComponent.class).location.x > 200) {
//            i2 = -1.0f;
//        }

    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }
}
