package org.NayaEngine.uselessgameObjStuff;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;
import org.NayaEngine.Tooling.Camera;
import org.NayaEngine.math.Vector3;
import org.joml.Matrix4f;
import org.w3c.dom.Text;

import java.util.*;
import java.io.*;

import static com.jogamp.opengl.GL.*;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class Sprite2D {
    private int textureID;

    public Sprite2D(Camera camera, Vector3 location, String file, String type, GL gl) {
        float[] vertices = new float[]{
                -1.0f, -1.0f, 0.0f,   // Bottom-left vertex
                1.0f, -1.0f, 0.0f,    // Bottom-right vertex
                -1.0f, 1.0f, 0.0f,    // Top-left vertex
                1.0f, 1.0f, 0.0f      // Top-right vertex
        };
        int[] indicies = new int[]{0, 1, 2, 3};  // Index buffer for a quad
        float[] textureCoords = new float[]{
                0.0f, 0.0f,           // Bottom-left texture coordinate
                1.0f, 0.0f,           // Bottom-right texture coordinate
                0.0f, 1.0f,           // Top-left texture coordinate
                1.0f, 1.0f
        };// Top-right texture coordinate
        Texture texture = loadTexture(file,type,gl);
        render(camera,location,gl,texture);

    }

    public Texture loadTexture(String file,String type,GL gl) {
        Texture texture = null;
        try {
            TextureData data = TextureIO.newTextureData(GLProfile.getDefault(), new File("src/sprites/test.jpg"), true, "jpg");
            texture = TextureIO.newTexture(data);
            System.out.println("hi");
            if (texture == null) {
                System.err.println("Error loading texture");
                return null;
            }
        } catch (IOException e) {

        }
        gl.glEnable(GL_TEXTURE_2D);
        assert texture != null;
        texture.bind(gl);
        textureID = texture.getTextureObject();
        System.out.println(textureID);
        gl.glEnable(GL_TEXTURE_2D);
        texture.bind(gl);

        textureID = texture.getTextureObject();
        System.out.println(textureID);
// Set texture parameters
        gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
        gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
        gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
        return texture;
    }

    public void render(Camera camera, Vector3 location, GL gl, Texture texture) {
//        Matrix4f model = camera.initModel(location);



    }
}
