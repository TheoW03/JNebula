import org.NayaEngine.Tooling.Camera;
import org.NayaEngine.Tooling.LoadShader;
import org.NayaEngine.math.Vector3;
import com.jogamp.common.nio.Buffers;
import com.jogamp.opengl.*;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.io.*;

import static com.jogamp.opengl.GL.*;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class renderer implements GLEventListener {
    //    private Texture spriteTexture;
    private Texture texture;
    private int textureID;

    public renderer() {

    }

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {

        int DELAY = 10;
//        Timer timer = new Timer(DELAY, (ActionListener) this); //yes

        GL2 gl = glAutoDrawable.getGL().getGL2();
        setupTex(gl);
//        setupTex(gl);
//        try {
//            TextureData data = TextureIO.newTextureData(GLProfile.getDefault(), new File("src/test.jpg"), true, "jpg");
//            texture = TextureIO.newTexture(data);
//            System.out.println("hi");
//            if (texture == null) {
//                System.err.println("Error loading texture");
//                return;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        gl.glEnable(GL_TEXTURE_2D);
//        texture.bind(gl);
//
//        textureID = texture.getTextureObject();
//        System.out.println(textureID);
//// Set texture parameters
//        gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
//        gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
//        gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
//        gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
//        timer.start();
    }

    public void setupTex(GL gl) {
        try {
            TextureData data = TextureIO.newTextureData(GLProfile.getDefault(), new File("src/sprites/test.jpg"), true, "jpg");
            texture = TextureIO.newTexture(data);
            System.out.println("hi");
            if (texture == null) {
                System.err.println("Error loading texture");
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        gl.glEnable(GL_TEXTURE_2D);
        texture.bind(gl);

        textureID = texture.getTextureObject();
        System.out.println(textureID);
// Set texture parameters
        gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
        gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
        gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {


    }

    int frames = 0;
    int frames2 = 0;
    int frames3 = 0;
    int frames4 = 0;
    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        GL4 gl = (GL4) glAutoDrawable.getGL().getGL2();
        float[] vertices = {
                -1.0f, -1.0f, 0.0f,   // Bottom-left vertex
                1.0f, -1.0f, 0.0f,    // Bottom-right vertex
                -1.0f, 1.0f, 0.0f,    // Top-left vertex
                1.0f, 1.0f, 0.0f      // Top-right vertex
        };


        float[] textureCoords = {
                0.0f, 0.0f,           // Bottom-left texture coordinate
                1.0f, 0.0f,           // Bottom-right texture coordinate
                0.0f, 1.0f,           // Top-left texture coordinate
                1.0f, 1.0f            // Top-right texture coordinate
        };
        gl.glClear(GL.GL_COLOR_BUFFER_BIT); // Clear the color buffer to the clear color

        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = vertices[i] * 100.0f;
        }
        int[] indices = {0, 1, 2, 3};  // Index buffer for a quad

        gl.glEnable(GL_TEXTURE_2D);

        LoadShader sh = new LoadShader();
        String vertexSource = "";
        String fragSource = "";
        int[] buffers = new int[3];
//        int[] matBuffer = new int[2];
        gl.glGenBuffers(3, buffers, 0);
//        gl.glGenBuffers(2, matBuffer, 0);
        try {
            vertexSource = sh.processShader("VertexSprite.glsl");
            fragSource = sh.processShader("SpriteFrag.glsl");
        } catch (IOException e) {
            e.printStackTrace();
        }

        gl.glBindBuffer(GL_ARRAY_BUFFER, buffers[0]);
        gl.glBufferData(GL_ARRAY_BUFFER, vertices.length * 4 + textureCoords.length * 4, null, GL_STATIC_DRAW);

        gl.glBufferSubData(GL_ARRAY_BUFFER, 0, vertices.length * 4, FloatBuffer.wrap(vertices));
        gl.glBindBuffer(GL_ARRAY_BUFFER, buffers[0]);

        gl.glBufferSubData(GL_ARRAY_BUFFER, vertices.length * 4, textureCoords.length * 4, FloatBuffer.wrap(textureCoords));
        gl.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, buffers[2]);

        gl.glBufferData(GL_ELEMENT_ARRAY_BUFFER, indices.length * 4, IntBuffer.wrap(indices), GL_STATIC_DRAW);


        int shaderProgram = sh.loadShaders(vertexSource, fragSource, gl);

        int positionAttrib = gl.glGetAttribLocation(shaderProgram, "vPos");
        System.out.println("pos: " + positionAttrib);
        gl.glBindBuffer(GL_ARRAY_BUFFER, buffers[0]);
        gl.glEnableVertexAttribArray(positionAttrib);
        gl.glVertexAttribPointer(positionAttrib, 3, GL_FLOAT, false, 0, 0);


        gl.glBindBuffer(GL_ARRAY_BUFFER, 0);
        gl.glBindBuffer(GL_ARRAY_BUFFER, buffers[0]);
        int texCoordAttrib = gl.glGetAttribLocation(shaderProgram, "vTex");
        System.out.println("vtex : " + texCoordAttrib);
        gl.glEnableVertexAttribArray(texCoordAttrib);
        gl.glVertexAttribPointer(texCoordAttrib, 2, GL_FLOAT, false, 0, vertices.length * 4);
        gl.glBindBuffer(GL_ARRAY_BUFFER, 0);
// Enable texture mapping


// Bind the texture object to the current texture unit
        gl.glActiveTexture(GL_TEXTURE0);
        gl.glBindTexture(GL_TEXTURE_2D, textureID);
        int textureSamplerLoc = gl.glGetUniformLocation(shaderProgram, "tSample");
        System.out.println("texture: " + textureSamplerLoc);
        gl.glUniform1i(textureSamplerLoc, 0);
//        gl.glUseProgram(shaderProgram);
//
        int matriceLocation = gl.glGetUniformLocation(shaderProgram, "viewMatrix");
        int projectionLocation = gl.glGetUniformLocation(shaderProgram, "projectMatrix");
        int modelMartrix = gl.glGetUniformLocation(shaderProgram, "model");

        //allocate matrix.
        Camera c = new Camera(new Vector3(0, 0, 0));
        FloatBuffer matBufferP = Buffers.newDirectFloatBuffer(1024);
        c.getProjection().get(matBufferP);
        gl.glUniformMatrix4fv(projectionLocation, 1, false, matBufferP);
        matBufferP.clear();

        FloatBuffer matBufferV = Buffers.newDirectFloatBuffer(1024);
        c.viewMatrix().get(matBufferV);
        gl.glUniformMatrix4fv(matriceLocation, 1, false, matBufferV);
        matBufferV.clear();

        FloatBuffer matBufferM = Buffers.newDirectFloatBuffer(1024);
        c.initModel(new Vector3(0,frames,0)).get(matBufferM);
        gl.glUniformMatrix4fv(modelMartrix, 1, false, matBufferM);
        matBufferM.clear();
// Draw the quad
        gl.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, buffers[2]);
        gl.glDrawElements(GL_TRIANGLE_STRIP, 6, GL_UNSIGNED_INT, 0);

        gl.glBindBuffer(GL_ARRAY_BUFFER, 0);
        gl.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
        frames++;
        frames2++;
//        frames3--;
//        frames4--;

    }


    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }
}
