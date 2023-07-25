package org.JNebula.GameObjects;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL4;
import com.jogamp.opengl.util.FPSAnimator;
import org.JNebula.Components.DifferentComponents.CameraComponent;
import org.JNebula.Components.DifferentComponents.ColliderComponent;
import org.JNebula.Components.DifferentComponents.TransformComponent;
import org.JNebula.Components.Component;
import org.JNebula.Tooling.Window;
import org.JNebula.math.Vector3;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import static com.jogamp.opengl.fixedfunc.GLLightingFunc.GL_LIGHTING;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class InitObjects {
    private static boolean first = false;
    private FPSAnimator fpsAnimator;
    public static CameraComponent mainCamera;
    private GL4 gl;

    private static ArrayList<GameObject> objectList = new ArrayList<>();

    public InitObjects() {

//        this.fpsAnimator = fpsAnimator;
    }


    /**
     * @param name finds game object with similar name. will return null if non existant.
     * @return
     */
    public static GameObject Find(String name) {
        for (int i = 0; i < objectList.size(); i++) {
            if (objectList.get(i).name.equals(name)) {
                return objectList.get(i);

            }
        }
        return null;
    }
    public ArrayList<GameObject> FindByTag(String tag){
        ArrayList<GameObject> list = new ArrayList<>();
        for (int i = 0; i < objectList.size(); i++) {
            if (objectList.get(i).tag.equals(tag)) {
                list.add(objectList.get(i));

            }
        }
        return list;
    }

    private static void combinationUtil(ArrayList<GameObject> arr, GameObject[] colliderComponents, int start,
                                int index) {
        // Current combination is ready to be printed, print it
        if (index == 2) {

            if (colliderComponents[0].GetComponent(ColliderComponent.class)
                    .isCollided(colliderComponents[1].GetComponent(ColliderComponent.class))
            ) {
                colliderComponents[0].Collides(colliderComponents[1]);
                colliderComponents[1].Collides(colliderComponents[0]);

            }
            return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i = start; i <= (arr.size() - 1) && (arr.size() - 1) - i + 1 >= 2 - index; i++) {
            colliderComponents[index] = arr.get(i);
            combinationUtil(arr, colliderComponents, i + 1, index + 1);
        }
    }

    public static void InstantiateObjects(ArrayList<GameObject> object, float dt) {
        if (mainCamera == null) {
            mainCamera = new CameraComponent(new Vector3(0, 0, 0));
        }
        GL4 gl = Component.gl;
        objectList = object;
        ArrayList<GameObject> hasCollison = new ArrayList<>();
        gl.glEnable(GL_LIGHTING);
        for (int i = 0; i < object.size(); i++) {
//            dtAtStart = System.currentTimeMillis();
            if (object.get(i).GetComponent(CameraComponent.class) == null) {
                object.get(i).AddComponent(mainCamera);
            }
            if (object.get(i).GetComponent(ColliderComponent.class) != null) {
                System.out.println("added collison");

                hasCollison.add(object.get(i));
            }
            if (object.get(i).GetComponent(TransformComponent.class) == null) {
                object.get(i).AddComponent(new TransformComponent(new Vector3(0, 0, 0)));
            }

            System.out.println(object.get(i).toString());
            System.out.println(object.get(i).isActive);
            if (!first) {
                object.get(i).start(dt, gl);

            } else {
                object.get(i).update(dt, gl);
                System.out.println(object.get(i).name);
            }

            System.out.println("dt: " + dt);

        }
        GameObject[] data =new GameObject[3];
        combinationUtil(hasCollison,data,0,0);


//        for (int i = 0; i < object.size(); i++) {
//            if(object.get(i).GetCompenent(SpriteComponent.class) != null){
//                System.out.println("init: "+object.get(i).name);
//                int[] indices = object.get(i).indices;
//                int[] buffers = new int[1];
//                gl.glPolygonMode(GL.GL_FRONT_AND_BACK, GL_LINES);
//
//                gl.glGenBuffers(1, buffers, 0);
//                gl.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, buffers[0]);
//
//                gl.glBufferData(GL_ELEMENT_ARRAY_BUFFER, indices.length * 4L, IntBuffer.wrap(indices), GL_STATIC_DRAW);
////                gl.glDrawElements(GL_LINE_LOOP, 9, GL_UNSIGNED_INT, 0);
////                gl.glBindBuffer(GL_ARRAY_BUFFER, 0);
////                gl.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
//
////                gl.glPolygonMode(GL_BACK, GL_LINES);
//
//            }

//        }
        first = true;
    }


}
