package org.JNebula.GameObjects;

import com.jogamp.opengl.GL4;
import org.JNebula.Components.DifferentComponents.*;
import org.JNebula.Components.iComponent;
import org.JNebula.Tooling.Shader;
import org.JNebula.Tooling.Window;

import java.nio.IntBuffer;
import java.util.ArrayList;

import static com.jogamp.opengl.GL.*;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class GameObject {
    public int[] indices;

    public ArrayList<iComponent> compenets;
    public String name;
    public TransformComponent transform;

    public boolean isActive = true;
    public float time;

    public static GL4 gl;

    public GameObject(String name) {
        compenets = new ArrayList<>();

        this.name = name;
    }

    public <T extends iComponent> T GetCompenent(Class<T> compenet) {
        if (compenets == null) {
            compenets = new ArrayList<>();
        }
        for (iComponent c : compenets) {
            if (compenet.isAssignableFrom(c.getClass())) {
                return compenet.cast(c);
            }
        }
        return null;
    }


    public <T extends iComponent> T RemoveCompenent(Class<T> compenet) {
        if (compenets == null) {
            compenets = new ArrayList<>();
        }
        for (int i = 0; i < compenets.size(); i++) {
            if (compenet.isAssignableFrom(compenets.get(i).getClass())) {
                return compenet.cast(compenets.remove(i));
            }

        }
        return null;
    }


    public void AddComponent(iComponent component) {
        if (compenets == null) {
            compenets = new ArrayList<>();
        }
        if (component instanceof TransformComponent) {
            transform = (TransformComponent) component;
        }
        component.gameObject = this;
        compenets.add(component);


    }

    private void sendUtilVars(GL4 gl, int shader) {
        int iRes = gl.glGetUniformLocation(shader, "iResolution");
        gl.glUniform2f(iRes, Window.screenRes.x, Window.screenRes.y);
        int iTime = gl.glGetUniformLocation(shader, "iTime");
        gl.glUniform2f(iTime, time,0);
        int deltaTime = gl.glGetUniformLocation(shader, "deltaTime");
        gl.glUniform2f(deltaTime, 1.5f,0);
        time++;
    }

    public void update(float dt, GL4 gl) {
        if (isActive) {

            Shader sh = new Shader();
//        gl.glClear(GL.GL_COLOR_BUFFER_BIT); // Clear the color buffer to the clear color
            indices = new int[3];
            int shP = sh.shaderCompile(gl);
            sendUtilVars(gl,shP);
            for (int i = 0; i < compenets.size(); i++) {
                compenets.get(i).update(dt);
                compenets.get(i).sendtoGPU(shP, sh);
                if (GetCompenent(SpriteComponent.class) != null) {
                    System.out.println("update: " + this.name);
                    indices = GetCompenent(SpriteComponent.class).indices;
                    int[] buffers = new int[1];
                    gl.glGenBuffers(1, buffers, 0);
//                    gl.glPolygonMode(GL.GL_FRONT_AND_BACK, GL_LINES);
                    gl.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, buffers[0]);
                    gl.glBufferData(GL_ELEMENT_ARRAY_BUFFER, indices.length * 6L, IntBuffer.wrap(indices), GL_STATIC_DRAW);

                    gl.glDrawElements(GL_TRIANGLE_STRIP, 7, GL_UNSIGNED_INT, 0); //learn to make dynamic


//                    if(i == 2){
//                        gl.glDrawElements(GL_TRIANGLE_STRIP, 7, GL_UNSIGNED_INT, 0); //learn to make dynamic
//
//                    }else {
//                        gl.glDrawElements(GL_LINE_LOOP, 7, GL_UNSIGNED_INT, 0); //learn to make dynamic
//
//                    }
//                    gl.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
//                    gl.glGenBuffers(1, buffers, 0);

//                    gl.glPolygonMode(GL.GL_FRONT_AND_BACK, GL_LINES);
                    if (GetCompenent(ColliderComponent.class) != null) {
                        if (GetCompenent(ColliderComponent.class).showHitBox) {
                            int colorLocation = gl.glGetUniformLocation(shP, "color_of_sprite");
                            int location = gl.glGetUniformLocation(shP, "textureExists");
                            gl.glUniform1f(location, 1);
                            gl.glUniform3f(colorLocation, 0, 1, 0);
//                    gl.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, buffers[0]);
//                    gl.glBufferData(GL_ELEMENT_ARRAY_BUFFER, indices.length * 6L, IntBuffer.wrap(indices), GL_STATIC_DRAW);
                            gl.glDrawElements(GL_LINE_LOOP, 7, GL_UNSIGNED_INT, 0); //learn to make dynamic
                            if (GetCompenent(SpriteComponent.class).color == null) {
                                gl.glUniform3f(colorLocation, 1, 1, 1);
                            } else {
                                gl.glUniform3f(colorLocation, GetCompenent(SpriteComponent.class).color.r2,
                                        GetCompenent(SpriteComponent.class).color.g2, GetCompenent(SpriteComponent.class).color.b2);
                            }
                            if (GetCompenent(SpriteComponent.class).texture != null) {
                                gl.glUniform1f(location, 0);
                            }
                        }
                    }


//                    gl.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
                    System.out.println("sprite render 1st");

//                    gl.glDrawElements(GL_TRIANGLE_STRIP, 12, GL_UNSIGNED_INT, 0); //learn to make dynamic
//                    gl.glDrawElements(GL_LINE_LOOP, 3, GL_UNSIGNED_INT, 0);
//                    gl.glPolygonMode(GL_BACK, GL_LINES);
                }

                if (compenets.get(i) instanceof PhysicsComponent) {
                    GetCompenent(TransformComponent.class).location = ((PhysicsComponent) compenets.get(i)).vectorPosition;
                }


            }
            if (GetCompenent(SpriteComponent.class) != null) {
                System.out.println("render");


            }
//            gl.glDrawElements(GL_TRIANGLE_STRIP, 6, GL_UNSIGNED_INT, 0);
//
//            gl.glBindBuffer(GL_ARRAY_BUFFER, 0);
//            gl.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
        }

    }


    public void start(float dt, GL4 gl) {


        if (this.isActive) {

            Shader sh = new Shader();
            int shP = sh.shaderCompile(gl);
            indices = new int[3];
            System.out.println("a: " + compenets.size());

            for (int i = 0; i < compenets.size(); i++) {
                compenets.get(i).init(dt);
                compenets.get(i).sendtoGPU(shP, sh);
                if (compenets.get(i) instanceof SpriteComponent) {
                    indices = GetCompenent(SpriteComponent.class).indices;
                    int[] buffers = new int[1];
                    gl.glGenBuffers(1, buffers, 0);
                    gl.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, buffers[0]);
                    gl.glBufferData(GL_ELEMENT_ARRAY_BUFFER, indices.length * 4L, IntBuffer.wrap(indices), GL_STATIC_DRAW);

                }

//                if (compenets.get(i) instanceof SpriteComponent) {
//                    indices = ((SpriteComponent) compenets.get(i)).indices;
//                    int[] buffers = new int[1];
//                    gl.glGenBuffers(1, buffers, 0);
//                    gl.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, buffers[0]);
//                    gl.glBufferData(GL_ELEMENT_ARRAY_BUFFER, indices.length * 4L, IntBuffer.wrap(indices), GL_STATIC_DRAW);
//                }
                if (compenets.get(i) instanceof PhysicsComponent) {
                    GetCompenent(TransformComponent.class).location = ((PhysicsComponent) compenets.get(i)).vectorPosition;
                }


            }

//            if(GetCompenent(SpriteComponent.class) != null){
//                gl.glDrawElements(GL_TRIANGLE_STRIP, 6, GL_UNSIGNED_INT, 0);
//                gl.glBindBuffer(GL_ARRAY_BUFFER, 0);
//                gl.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
//            }


        }

    }


    public void GetCompenentList(String name, iComponent compenet) {

    }

    public String toString() {
//        if(compenets != null){
//            return name+" "+ Arrays.toString(compenets.toArray());
//        }
//        return name;
        return name;
    }

    public ArrayList<String> getList() {
        return null;
    }
}
