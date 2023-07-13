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


    public static GameObject Find(String nameP) {
        for (int i = 0; i < objectList.size(); i++) {
            if (objectList.get(i).name.equals(nameP)) {
                return objectList.get(i);

            }
        }
        return null;
    }

    public static void InstantiateObjects(ArrayList<GameObject> object) {
        if (mainCamera == null) {
            mainCamera = new CameraComponent(new Vector3(0, 0, 0));
        }
        GL4 gl = Component.gl;
        objectList = object;
        ArrayList<GameObject> hasCollison = new ArrayList<>();
        gl.glEnable(GL_LIGHTING);
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);// Clear the color buffer to the clear color
        long dtAtStart;
        long dtAtEnd;
        float dt = 0;
        for (int i = 0; i < object.size(); i++) {
            dtAtStart = System.currentTimeMillis();
            if (object.get(i).GetCompenent(CameraComponent.class) == null) {
                object.get(i).AddComponent(mainCamera);
            }
            if (object.get(i).GetCompenent(ColliderComponent.class) != null) {
                hasCollison.add(object.get(i));
            }
            if (object.get(i).GetCompenent(TransformComponent.class) == null) {
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

            dtAtEnd = System.currentTimeMillis();
            dt = (float) (dtAtEnd - dtAtStart) / 1000;
            System.out.println("dt: " + dt);
            Window.deltaTime = dt;

        }


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
