import com.jogamp.opengl.*;
import org.JNebula.GameObjects.GameRenderer;
import org.JNebula.Tooling.LoadShader;
import org.joml.Matrix4f;
import org.joml.Vector3f;

import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static com.jogamp.opengl.GL.*;
import static com.jogamp.opengl.GL2ES1.GL_PERSPECTIVE_CORRECTION_HINT;
import static com.jogamp.opengl.GL2ES3.GL_QUADS;
import static com.jogamp.opengl.fixedfunc.GLLightingFunc.GL_SMOOTH;
import static com.jogamp.opengl.fixedfunc.GLMatrixFunc.GL_MODELVIEW;
import static com.jogamp.opengl.util.GLBuffers.sizeof;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class Renderer4 extends GameRenderer {

    float i = 0;
    GL2 gl;

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        gl = glAutoDrawable.getGL().getGL2();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f); // Set background color to black and opaque
        gl.glClearDepth(1.0f);                   // Set background depth to farthest
        gl.glEnable(GL_DEPTH_TEST);   // Enable depth testing for z-culling
        gl.glDepthFunc(GL_LEQUAL);    // Set the type of depth-test
        gl.glShadeModel(GL_SMOOTH);   // Enable smooth shading
        gl.glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);  // Nice perspective corrections
//        gl.glTranslatef(0.0f, 0.0f, 0.0f);
        gl.glPushMatrix();
    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        gl.glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // Clear color and depth buffers
        gl.glMatrixMode(GL_MODELVIEW);     // To operate on model-view matrix

        // Render a color-cube consisting of 6 quads with different colors


        gl.glRotatef(0.5f, 1.0f, 0.0f, 1.0f); // Rotate the model by the current angle around the axis (1.0, 1.0, 1.0)


        gl.glBegin(GL_QUADS);                // Begin drawing the color cube with 6 quads


        // Top face (y = 1.0f)
        // Define vertices in counter-clockwise (CCW) order with normal pointing out
        gl.glColor3f(0.0f, 1.0f, 0.0f); // Green
        gl.glVertex3f(-0.5f, -0.5f, 0.5f);
        gl.glVertex3f(0.5f, -0.5f, 0.5f);
        gl.glVertex3f(0.5f, 0.5f, 0.5f);
        gl.glVertex3f(-0.5f, 0.5f, 0.5f);

// Back face
        gl.glColor3f(1.0f, 0.0f, 0.0f); // Red
        gl.glVertex3f(0.5f, -0.5f, -0.5f);
        gl.glVertex3f(-0.5f, -0.5f, -0.5f);
        gl.glVertex3f(-0.5f, 0.5f, -0.5f);
        gl.glVertex3f(0.5f, 0.5f, -0.5f);

// Top face
        gl.glColor3f(0.0f, 0.0f, 1.0f); // Blue
        gl.glVertex3f(-0.5f, 0.5f, 0.5f);
        gl.glVertex3f(0.5f, 0.5f, 0.5f);
        gl.glVertex3f(0.5f, 0.5f, -0.5f);
        gl.glVertex3f(-0.5f, 0.5f, -0.5f);

// Bottom face
        gl.glColor3f(1.0f, 1.0f, 0.0f); // Yellow
        gl.glVertex3f(0.5f, -0.5f, 0.5f);
        gl.glVertex3f(-0.5f, -0.5f, 0.5f);
        gl.glVertex3f(-0.5f, -0.5f, -0.5f);
        gl.glVertex3f(0.5f, -0.5f, -0.5f);

// Left face
        gl.glColor3f(1.0f, 0.0f, 1.0f); // Magenta
        gl.glVertex3f(-0.5f, -0.5f, 0.5f);
        gl.glVertex3f(-0.5f, -0.5f, -0.5f);
        gl.glVertex3f(-0.5f, 0.5f, -0.5f);
        gl.glVertex3f(-0.5f, 0.5f, 0.5f);

// Right face
        gl.glColor3f(1.0f, 0.0f, 1.0f); // Cyan
        gl.glVertex3f(0.5f, -0.5f, -0.5f);
        gl.glVertex3f(0.5f, -0.5f, 0.5f);
        gl.glVertex3f(0.5f, 0.5f, 0.5f);
        gl.glVertex3f(0.5f, 0.5f, -0.5f);

        gl.glEnd(); // End drawing the cube

        float[] colors = {
                0.0f, 1.0f, 0.0f,
                1.0f, 0.0f, 0.0f,
                0.0f, 0.0f, 1.0f,
                1.0f, 1.0f, 0.0f,
                1.0f, 0.0f, 1.0f,
                1.0f, 0.0f, 1.0f
        };
        gl.glFlush(); // Flush the rendering pipeline

        float[] vertices = {
                // Front face
                -0.5f, -0.5f, 0.5f,
                0.5f, -0.5f, 0.5f,
                0.5f, 0.5f, 0.5f,
                -0.5f, 0.5f, 0.5f,

                // Back face
                0.5f, -0.5f, -0.5f,
                -0.5f, -0.5f, -0.5f,
                -0.5f, 0.5f, -0.5f,
                0.5f, 0.5f, -0.5f,

                // Top face
                -0.5f, 0.5f, 0.5f,
                0.5f, 0.5f, 0.5f,
                0.5f, 0.5f, -0.5f,
                -0.5f, 0.5f, -0.5f,

                // Bottom face
                0.5f, -0.5f, 0.5f,
                -0.5f, -0.5f, 0.5f,
                -0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,

                // Left face
                -0.5f, -0.5f, 0.5f,
                -0.5f, -0.5f, -0.5f,
                -0.5f, 0.5f, -0.5f,
                -0.5f, 0.5f, 0.5f,

                // Right face
                0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, 0.5f,
                0.5f, 0.5f, 0.5f,
                0.5f, 0.5f, -0.5f
        };
        LoadShader l = new LoadShader();
        int shaderP;
        try {
            shaderP = l.loadShaders(l.processShader("3DVertex.glsl"),l.processShader("3DFrag.glsl"),(GL4)gl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int location = gl.glGetAttribLocation(shaderP, "position");
        int color = gl.glGetAttribLocation(shaderP, "color");
        int[] buffers = new int[3];
        gl.glGenBuffers(buffers.length, buffers, 0);

        gl.glBindBuffer(GL_ARRAY_BUFFER, buffers[0]);

// position attribute
        gl.glBufferData(GL_ARRAY_BUFFER, vertices.length * 4, FloatBuffer.wrap(vertices), GL_STATIC_DRAW);

        gl.glVertexAttribPointer(location, 3, GL_FLOAT, false, 0, vertices.length * 4L);
        gl.glEnableVertexAttribArray(location);
        gl.glBindBuffer(GL_ARRAY_BUFFER, buffers[1]);
// color attribute
//        gl.glBufferData(GL_ARRAY_BUFFER, colors.length * 6, FloatBuffer.wrap(colors), GL_STATIC_DRAW);
//        gl.glVertexAttribPointer(color, 2, GL_FLOAT, false, 0, colors.length * 4L);
//        gl.glEnableVertexAttribArray(color);
        Matrix4f rotation = new Matrix4f();
//        rotation.rotate(0.5f,0,1,1);
        int modelMartrix = gl.glGetUniformLocation(shaderP, "model");

//        location = new Vector3f(1,1,1);
        Matrix4f modelViewMatrix = new Matrix4f();
        Matrix4f m = modelViewMatrix.translate(0.0f, 0.0f,0.0f);
        l.sendMartices(m, (GL4) gl, modelMartrix);
        int[] indices = new int[]{0, 2, 1,
                1, 3, 2,
                1, 2, 3};
        int colorLocation = gl.glGetUniformLocation(shaderP, "color_of_sprite");
        gl.glUniform3f(colorLocation, 0.5f, 0.5f, 0.5f);

        gl.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, buffers[2]);
        gl.glBufferData(GL_ELEMENT_ARRAY_BUFFER, indices.length, IntBuffer.wrap(indices), GL_STATIC_DRAW);
        gl.glDrawElements(GL_TRIANGLE_STRIP, 7, GL_UNSIGNED_INT, 0); //learn to make dynamic

//        gl.glDrawArrays(GL_QUADS, 0, 3);

//        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);// Clear the color buffer to the clear color
////        gl.glClearColor(0.1f, 0.5f, 0.2f, 0.0f);
//        gl = glAutoDrawable.getGL().getGL4();
//        gl.glEnable(GL_LIGHTING);
//
//
//// Set up a directional light source
//        float[] light_position = { 1.0f, 0.0f, 0.5f, 0.0f };
//        float[] light_ambient = { 0.2f, 1.0f, 1.0f, 1.0f };
//        float[] light_diffuse = { 1.0f, 0.8f, 0.8f, 1.0f };
//        float[] light_specular = { 0.5f, 1.0f, 1.0f, 1.0f };
//
//        float[] materialAmbient = {1.0f, 0.2f, 0.2f, 1.0f}; // r, g, b, a
//        float[] materialDiffuse = {1.0f, 0.8f, 0.8f, 1.0f}; // r, g, b, a
//        float[] materialSpecular = {1.0f, 0.5f, 0.5f, 1.0f};// r, g, b, a
//        float materialShininess = 0.6f; // specular exponent
//        gl.glLightfv(GL_LIGHT0, GL_POSITION, light_position, 0);
//        gl.glLightfv(GL_LIGHT0, GL_AMBIENT, light_ambient, 0);
//        gl.glLightfv(GL_LIGHT0, GL_DIFFUSE, light_diffuse, 0);
//        gl.glLightfv(GL_LIGHT0, GL_SPECULAR, light_specular, 0);
//        gl.glEnable(GL_LIGHT0);
//
////         Set up the material properties
//        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT, materialAmbient, 0);
//        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_DIFFUSE, materialDiffuse, 0);
//        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, materialSpecular, 0);
//        gl.glMaterialf(GL2.GL_FRONT_AND_BACK, GL2.GL_SHININESS, materialShininess);
//        gl.glEnable(GL_NORMALIZE);
//        // Draw a rectangle
//        if(Input.getKey() == KeyEvent.VK_W){
//            System.out.println("W pressed");
//        }
//        if(Input.getMouseCode() == MouseEvent.BUTTON1){
//            System.out.println("clicked pressed");
//        }
//        gl.glBegin(GL2.GL_QUADS);
//        gl.glNormal3f(0.0f, 0.0f, i); // surface normal
//        gl.glVertex2f(0.0f, 0.0f);
//        gl.glVertex2f(1.0f, 0.0f);
//        gl.glVertex2f(1.0f, 1.0f);
//        gl.glVertex2f(0.0f, 1.0f);
//        gl.glEnd();
//        gl.glBegin(GL2.GL_QUADS);
//        gl.glVertex2f(0.0f, 0.0f);
////        gl.glNormal3f(0.0f, 0.0f, 1.0f); // surface normal
//        gl.glVertex2f(-1.0f, 0.0f);
//        gl.glVertex2f(-1.0f, -1.0f);
//        gl.glVertex2f(0.0f, 1.0f);
//        gl.glEnd();
//        i = i+0.01f;
    }
}
