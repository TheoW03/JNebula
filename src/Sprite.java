import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;
import org.joml.Matrix4f;
import org.w3c.dom.Text;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.*;
import java.io.*;

import static com.jogamp.opengl.GL.*;
import static com.jogamp.opengl.GL.GL_CLAMP_TO_EDGE;

import math.Vector;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class Sprite {
    public Texture spriteTexture;
    private Vector location;
    private Camera camera;
    private GL gl;
    public float[] vertices, textureCoords;
    public int[] indicies;
    public int textureID;
    /**
     * @param file     picture ex: blank.png
     * @param location xyz
     * @param type     png or JPG
     * @param gl       GL ref
     */
    public Sprite(String file, String type, Vector location, GL gl) {
        this.location = location;
        this.camera = new Camera(location);
        this.vertices = new float[]{
                -1.0f, -1.0f, 0.0f,   // Bottom-left vertex
                1.0f, -1.0f, 0.0f,    // Bottom-right vertex
                -1.0f, 1.0f, 0.0f,    // Top-left vertex
                1.0f, 1.0f, 0.0f      // Top-right vertex
        };
        this.indicies = new int[]{0, 1, 2, 3};  // Index buffer for a quad

        this.textureCoords = new float[]{
                0.0f, 0.0f,           // Bottom-left texture coordinate
                1.0f, 0.0f,           // Bottom-right texture coordinate
                0.0f, 1.0f,           // Top-left texture coordinate
                1.0f, 1.0f
        };// Top-right texture coordinate
        loadTexture(file,type);
    }

    private boolean loadTexture(String file, String type) {
        try {
            TextureData data = TextureIO.newTextureData(GLProfile.getDefault(), new File(file), true, type);
            this.spriteTexture = TextureIO.newTexture(data);
            System.out.println("hi");
            if (spriteTexture == null) {
                System.err.println("Error loading texture");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        gl.glEnable(GL_TEXTURE_2D);
        spriteTexture.bind(gl);

        textureID = spriteTexture.getTextureObject();
        System.out.println(textureID);
// Set texture parameters
        gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
        gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
        gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
        return true;
    }

    public Matrix4f getProjectionMatrix() {
        return camera.getProjection();
    }

    public Matrix4f getViewMatrix() {
        return camera.viewMatrix();
    }

    public void updateLocation(Vector location) {
        this.camera = new Camera(location);
    }


}
