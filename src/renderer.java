import com.jogamp.common.nio.Buffers;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.awt.ImageUtil;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureCoords;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;
import org.w3c.dom.Text;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.*;
import java.io.*;

import static com.jogamp.opengl.GL.*;
import static com.jogamp.opengl.GL2ES3.GL_QUADS;

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
        GL2 gl = glAutoDrawable.getGL().getGL2();
        try {
            TextureData data = TextureIO.newTextureData(GLProfile.getDefault(),new File("src/maxwell.png"), true, "png");
            texture = TextureIO.newTexture(data);
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


    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        GL2 gl = glAutoDrawable.getGL().getGL2();
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
        for (int i = 0; i < vertices.length;i++){
            vertices[i] = vertices[i] *0.25f;
        }
        int[] indices = {0, 1, 2, 3};  // Index buffer for a quad
        gl.glEnable(GL_TEXTURE_2D);
        loadShader sh = new loadShader();
        String vertexSource = "";
        String fragSource = "";
        int[] buffers = new int[3];
        gl.glGenBuffers(3, buffers, 0);
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
        System.out.println("pos: "+positionAttrib);
        gl.glBindBuffer(GL2.GL_ARRAY_BUFFER, buffers[0]);
        gl.glEnableVertexAttribArray(positionAttrib);
        gl.glVertexAttribPointer(positionAttrib, 3, GL_FLOAT, false, 0, 0);
        gl.glBindBuffer(GL2.GL_ARRAY_BUFFER, 0);
        gl.glBindBuffer(GL2.GL_ARRAY_BUFFER, buffers[0]);
        int texCoordAttrib = gl.glGetAttribLocation(shaderProgram, "vTex");
        System.out.println("vtex : "+texCoordAttrib);
        gl.glEnableVertexAttribArray(texCoordAttrib);
        gl.glVertexAttribPointer(texCoordAttrib, 2, GL_FLOAT, false, 0, vertices.length * 4);
        gl.glBindBuffer(GL2.GL_ARRAY_BUFFER, 0);
// Enable texture mapping


// Bind the texture object to the current texture unit
        gl.glActiveTexture(GL_TEXTURE0);
        gl.glBindTexture(GL_TEXTURE_2D, textureID);
        int textureSamplerLoc = gl.glGetUniformLocation(shaderProgram, "tSample");
        System.out.println("texture: "+textureSamplerLoc);
        gl.glUniform1i(textureSamplerLoc, 0);
        gl.glUseProgram(shaderProgram);

// Draw the quad
        gl.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, buffers[2]);
        gl.glDrawElements(GL_TRIANGLE_STRIP, 6, GL_UNSIGNED_INT, 0);

        gl.glBindBuffer(GL_ARRAY_BUFFER, 0);
        gl.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
    }


    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }
}
