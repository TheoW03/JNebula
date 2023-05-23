import com.jogamp.opengl.*;
import com.jogamp.opengl.util.FPSAnimator;
import org.JNebula.Components.DifferentComponents.*;
//import org.NayaEngine.GameObjects.FrameRate;
import org.JNebula.Components.iComponent;
import org.JNebula.GameObjects.GameObject;
import org.JNebula.GameObjects.InitObjects;
import org.JNebula.ObjectEditor.ObjectEditorJSON;
import org.JNebula.Tooling.SceneObject;
import org.JNebula.Tooling.SpriteSheetList;
import org.JNebula.uselessgameObjStuff.SpriteObject;

import org.JNebula.Tooling.Colors;
import org.JNebula.math.Ray;
import org.JNebula.Tooling.Window;
import org.JNebula.math.Vector3;

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
    SceneObject list;
    InitObjects c;
    public GameObject test, test2, test3;
    FPSAnimator fps;
    GL4 gl;

    public RendererTest() {
//        this.fps = w.animator;
    }

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {


        iComponent.gl = glAutoDrawable.getGL().getGL4();
        gl = iComponent.gl;
        gl.glEnable(GL.GL_BLEND);
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
        ObjectEditorJSON js = new ObjectEditorJSON("src/ObjectEditorJSON/TestObject.json");
        list = js.objects;
//        System.exit(0);
//        list =  new ArrayList<>();
        c = new InitObjects();
//        SpriteSheetList s1 = new SpriteSheetList("src/sprites/sprite_sheet.jpg", "jpg", 1, 5, 64, 64, 7);
//        try {
//            SpriteSheetList s2 = new SpriteSheetList("src/sprites/sprite_sheet.jpg", "jpg",1,5);
//        } catch (IOException e) {
////
//        }
//        System.exit(0);
        test = new GameObject("TEST");
        test3 = new GameObject("TEST3");
        test3.AddComponent(new SpriteComponent(new Colors(1, 1, 1)));
        test3.AddComponent(new TransformComponent(new Vector3(90, 0, 0)));
//        list.add(test3);
//        test.AddComponent(new LightingComponent(0.2f,new float[]{0.5f,0.5f,0.5f},0.3f,gl));
//        test.AddComponent(new SpriteComponent(s1,20,null));
//        test.AddComponent(new SpriteComponent(s1.getSection(1,3), s1,15, gl));
//        test.AddComponent(new RenderCompenent(Colors.RED));
        test.AddComponent(new SpriteComponent("src/sprites/test.jpg","jpg",null));
//        test.AddComponent(new SpriteComponent(s1,20, null));
//        test.AddComponent(new GizmosCompenent(test.GetCompenent(SpriteComponent.class)));
//        test.GetCompenent(SpriteComponent.class).scale(200);
//

//        test.AddComponent(new CameraComponent(new Vector3(0, 0, 0), gl));
        test.AddComponent(new TransformComponent(new Vector3(20, 0, 0)));


//        test.AddComponent(new PhysicsComponent(new Vector3(-1,0.5f),-0.05f, test.GetCompenent(TransformComponent.class).location));
        Ray ray = new Ray(Vector3.down, 500);
        test.AddComponent(new ColliderComponent());

//        test.AddComponent(new LightingComponent(10, Colors.colorHex(Colors.RED),1.0f,gl));
        list.initObject(test);
        test2 = new GameObject("TEST2");
        test2.AddComponent(new SpriteComponent(new Colors(1, 0, 0)));
        System.out.println("sprite init");
        test2.AddComponent(new ColliderComponent());

//        test.GetCompenent(SpriteComponent.class).scaleX(0.25f);
//        test2.GetCompenent(SpriteComponent.class).scaleX(0.25f);
//        test2.GetCompenent(SpriteComponent.class).scaleVertex(2,2);


//test2.AddComponent(new SpriteComponent(new Colors(0.1f,0.5f,0.5f)));
//        test2.AddComponent(new LightingComponent(1.0f, Colors.colorHex(Colors.WHITE),0.4f));
//        test.AddComponent(new LightingComponent(test2.GetCompenent(LightingComponent.class)));

        System.out.println("test: " + test2);
        test2.AddComponent(new TransformComponent(new Vector3(100, 200, 0)));


        test2.AddComponent(new PhysicsComponent(new Vector3(0, 3), -0.05f, test2.GetCompenent(TransformComponent.class).location, Vector3.down));


//        test2.GetCompenent(PhysicsComponent.class).veloLock = true;
//        test.GetCompenent(PhysicsComponent.class).veloLock = true;
//        test.GetCompenent(PhysicsComponent.class).veloLock = true;
//        list.add(test2);

//        test.GetCompenent(SpriteComponent.class).scaleXY(0.05f,0.05f);
//        test2.GetCompenent(SpriteComponent.class).scaleX(0.5f);
//        test2.GetCompenent(SpriteComponent.class).scaleXY(0.2f,0.2f);
        gl.glClearColor(0, 1, 1, 0.0f);
        System.out.println("end of init");

    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    public int i2 = 0;
    public int f = 0;

    public boolean a = true;

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
//        Vector3 cent[] = test.GetCompenent(SpriteComponent.class).getCenterPoints();
//        if(i2 == cent.length){
//            i2 = 0;
//        }
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT); // clears the screen with the background color
        c.InstantiateObjects(list.getList());
//        test2.GetCompenent(SpriteComponent.class).scale(i);
        Window.printFrameRate();


//        test2.AddComponent(new ColliderComponent());


//
//        System.out.println(cent[i2]);
//        test2.GetCompenent(TransformComponent.class).location = cent[i2];
//        System.out.println("loc: " + test.transform.location);


//        if(f % 100 == 0){
//            i2++;
//        }
//        f++;
//        test2.GetCompenent(ColliderComponent.class).rayCastCollider(test.GetCompenent(ColliderComponent.class));

//        if (test.GetCompenent(ColliderComponent.class).isCollided(test2.GetCompenent(ColliderComponent.class))) {
//            gl.glClearColor(0, 0, 0, 0.0f);
//            a = false;
//            test.GetCompenent(TransformComponent.class).transform(new Vector3(0,0.5f));
//            System.out.println("collided");
//        }else {
//            gl.glClearColor(0, 0, 0, 0.0f);
////            test.GetCompenent(TransformComponent.class).transform(new Vector3(0.5f,0));
//        }
        gl.glClearColor(0, 0, 0, 0.0f);
//        test2.GetCompenent(TransformComponent.class).rotateContinosuly(-0.05f);
//        test.GetCompenent(TransformComponent.class).rotateContinosuly(-0.05f);
//        test3.GetCompenent(TransformComponent.class).rotateContinosuly(-0.05f);
//        test2.isActive = false;
//        i = i +100;
        int error = gl.glGetError();
        if (error != GL_NO_ERROR) {

            String errorString = gl.glGetString(error);
            System.out.println("OpenGL Error: " + errorString);
//            System.exit(0);
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
