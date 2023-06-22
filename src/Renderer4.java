import com.jogamp.opengl.*;
import org.JNebula.GameObjects.GameRenderer;
import org.JNebula.Tooling.LoadShader;
import org.joml.Matrix4f;
import org.joml.Quaterniond;
import org.joml.Quaternionf;
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
    Matrix4f m;
    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        gl = glAutoDrawable.getGL().getGL2();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f); // Set background color to black and opaque
        gl.glClearDepth(1.0f);                   // Set background depth to farthest
        gl.glEnable(GL_DEPTH_TEST);   // Enable depth testing for z-culling
        gl.glDepthFunc(GL_LEQUAL);    // Set the type of depth-test
        gl.glShadeModel(GL_SMOOTH);   // Enable smooth shading
        gl.glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);  // Nice perspective corrections
        m = new Matrix4f();
        m.identity();

    }

    public void renderCube() {
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
        gl.glFlush(); // Flush the rendering pipeline
    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        gl.glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // Clear color and depth buffers

        float[] colors = {
                0.0f, 1.0f, 0.0f,
                1.0f, 0.0f, 0.0f,
                0.0f, 0.0f, 1.0f,
                1.0f, 1.0f, 0.0f,
                1.0f, 0.0f, 1.0f,
                1.0f, 0.0f, 1.0f
        };
//        renderCube();

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
        int[] indices = {
                // Front face
                0, 1, 2,
                2, 3, 0,
                // Back face
                4, 5, 6,
                6, 7, 4,
                // Top face
                8, 9, 10,
                10, 11, 8,
                // Bottom face
                12, 13, 14,
                14, 15, 12,
                // Left face
                16, 17, 18,
                18, 19, 16,
                // Right face
                20, 21, 22,
                22, 23, 20
        };
        int[] nonOverlappingIndices = new int[indices.length];
        int[] vertexOffsets = { 0, 4, 8, 12, 16, 20 };


        LoadShader l = new LoadShader();
        int shaderP;
        try {
            shaderP = l.loadShaders(l.processShader("3DVertex.glsl"), l.processShader("3DFrag.glsl"), (GL4) gl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int location = gl.glGetAttribLocation(shaderP, "position");
        int color = gl.glGetAttribLocation(shaderP, "color");

        int rot = gl.glGetUniformLocation(shaderP,"rot");
        int[] buffers = new int[3];
//        Matrix4f m = new Matrix4f();
//        m.identity();
        m.rotate(0.05f,1,0,0);
        m.rotate(0.05f,0,0,1);
        m.rotate(0.005f,0,1,0);
        l.sendMartices(m,(GL4) gl,rot);
        gl.glGenBuffers(buffers.length, buffers, 0);


        gl.glBindBuffer(GL_ARRAY_BUFFER, buffers[0]);

        // Copy vertex data to GPU

        gl.glBufferData(GL_ARRAY_BUFFER,  vertices.length * 24, FloatBuffer.wrap(vertices), GL_STATIC_DRAW);

        // Set up vertex attribute pointer
        gl.glVertexAttribPointer(location, 3, GL_FLOAT, false, 0, 0);
        gl.glEnableVertexAttribArray(location);


        gl.glBindBuffer(GL_ARRAY_BUFFER, buffers[1]);
        gl.glBufferData(GL_ARRAY_BUFFER,  colors.length * 24, FloatBuffer.wrap(colors), GL_STATIC_DRAW);

        gl.glVertexAttribPointer(color, 3, GL_FLOAT, false, 0, 0);
        gl.glEnableVertexAttribArray(color);

        gl.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, buffers[2]);

        gl.glBufferData(GL_ELEMENT_ARRAY_BUFFER, indices.length * 6, IntBuffer.wrap(indices), GL_STATIC_DRAW);


        gl.glDrawElements(GL_TRIANGLE_STRIP, indices.length, GL_UNSIGNED_INT, 0); //learn to make dynamic


    }
}
