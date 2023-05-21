package org.JNebula.GameObjects;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL4;
import com.jogamp.opengl.util.FPSAnimator;
import org.JNebula.Compenents.DifferentCompenents.CameraComponent;
import org.JNebula.Compenents.DifferentCompenents.ColliderComponent;
import org.JNebula.Compenents.DifferentCompenents.TransformComponent;
import org.JNebula.Compenents.iComponent;
import org.JNebula.math.Vector3;

import java.util.*;

import static com.jogamp.opengl.fixedfunc.GLLightingFunc.GL_LIGHTING;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class InitObjects {
    public boolean first = false;
    private FPSAnimator fpsAnimator;
    public static CameraComponent mainCamera;
    private GL4 gl;
    public InitObjects() {
        mainCamera = new CameraComponent(new Vector3(0,0,0));
        this.gl = iComponent.gl;
        GameObject.gl = gl;
//        this.fpsAnimator = fpsAnimator;
    }




    public void InstantiateObjects(List<GameObject> object) {
        ArrayList<GameObject> hasCollison = new ArrayList<>();
        gl.glEnable(GL_LIGHTING);
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);// Clear the color buffer to the clear color

        for (int i = 0; i < object.size(); i++) {
            if(object.get(i).GetCompenent(CameraComponent.class) == null){
                object.get(i).AddComponent(mainCamera);
            }
            if(object.get(i).GetCompenent(ColliderComponent.class) != null){
                hasCollison.add(object.get(i));
            }
            if(object.get(i).GetCompenent(TransformComponent.class) == null){
                object.get(i).AddComponent(new TransformComponent(new Vector3(0,0,0)));
            }

            if (!first) {
                object.get(i).start(0.1f, gl);
                System.out.println(object.get(i).name);

            } else {
                object.get(i).update(0.1f, gl);
                System.out.println(object.get(i).name);
            }

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
