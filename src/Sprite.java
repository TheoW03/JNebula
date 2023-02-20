import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;
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
    private GL2 gl;
    private float[] vertices;
    private Texture spriteImage;
    private float[] textureCoords;
    private int[] indices;
    private Texture texture;

    public Sprite(float[] vertices,float[] textureCoords, int[] indices) {
        this.vertices = vertices;
        this.textureCoords = textureCoords;
        this.indices = indices;
    }

    /**
     *
     * @param fileName file being the file location
     * @param type .png or .jpg
     * @return textire else null
     */
    public Texture loadSprite(GL gl, String fileName, String type){

        try {
            TextureData data = TextureIO.newTextureData(GLProfile.getDefault(),new File(fileName), true, type);
            texture = TextureIO.newTexture(data);
            if (texture == null) {
                System.err.println("Error loading texture");
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        gl.glEnable(GL_TEXTURE_2D);
        assert texture != null;
        texture.bind(gl);
        gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
        gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
        gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
        gl.glEnable(GL_TEXTURE_2D);
        return texture;
    }

    public Texture getTexture(){
        return texture;
    }
    public int getID(){
        return texture.getTextureObject();
    }

    /**
     *
     * @param buffers buffered array and sets up the indices, vertices and texture coords.
     * @return
     */
    public int[] setBuffer(GL gl,int[] buffers){

        gl.glBindBuffer(GL_ARRAY_BUFFER, buffers[0]);
        gl.glBufferData(GL_ARRAY_BUFFER, vertices.length * 4 + textureCoords.length * 4, null, GL_STATIC_DRAW);

        gl.glBufferSubData(GL_ARRAY_BUFFER, 0, vertices.length * 4, FloatBuffer.wrap(vertices));
        gl.glBindBuffer(GL_ARRAY_BUFFER, buffers[0]);

        gl.glBufferSubData(GL_ARRAY_BUFFER, vertices.length * 4, textureCoords.length * 4, FloatBuffer.wrap(textureCoords));
        gl.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, buffers[2]);

        gl.glBufferData(GL_ELEMENT_ARRAY_BUFFER, indices.length * 4, IntBuffer.wrap(indices), GL_STATIC_DRAW);
        return buffers;
    }

    /**
     *
     * @return just do average
     */
    public Vector getLocation(){
        return new Vector(0,0,0);
    }


}
