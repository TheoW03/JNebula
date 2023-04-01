package org.NayaEngine.Compenents.DifferentCompenents;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;
import org.NayaEngine.Compenents.iComponent;
import com.jogamp.opengl.util.texture.Texture;
import org.NayaEngine.Tooling.loadShader;
import org.NayaEngine.math.Vector3;

import java.io.File;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;

import static com.jogamp.opengl.GL.*;
import static com.jogamp.opengl.GL.GL_CLAMP_TO_EDGE;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class SpriteComponents extends iComponent {

    String file;
    String type;
    public int textureID;
    public int[] indices;
    private float[] vertices, textureCoords;
    public float width,height;
    private float[] normals;
    public SpriteComponents(String file, String type, GL2 gl) {
        this.file = file;
        this.type = type;
        this.gl = gl;
        vertices = new float[]{
                -1.0f, -1.0f, 0.0f,   // Bottom-left vertex
                1.0f, -1.0f, 0.0f,    // Bottom-right vertex
                -1.0f, 1.0f, 0.0f,    // Top-left vertex
                1.0f, 1.0f, 0.0f      // Top-right vertex
        };
        textureCoords = new float[]{
                0.0f, 0.0f,           // Bottom-left texture coordinate
                1.0f, 0.0f,           // Bottom-right texture coordinate
                0.0f, 1.0f,           // Top-left texture coordinate
                1.0f, 1.0f            // Top-right texture coordinate
        };
        normals = new float[]{
                0.0f, 1.0f,
                0.0f, 1.0f,
                0.0f, 1.0f,
                0.0f, 1.0f,
        };
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = vertices[i] * 100.0f;
        }
        this.textureID = 0;
        loadTexture();

    }

    public void setHeight(){
        Vector3[] a = getVecticesAsVector();
//        AC = C - A = (2, 2) - (0, 0) = (2, 2)
//        BD = D - B = (0, 2) - (2, 0) = (-2, 2)
        Vector3 AC = new Vector3((a[0].x - a[2].x), (a[0].y - a[2].y));
        Vector3 BD = new Vector3((a[1].x - a[3].x),(a[1].y - a[3].y));
        this.width = (float) (AC.magnitude()*Math.cos(45));
        this.height = (float) ( BD.magnitude()*Math.sin(45));
    }
    private void loadTexture() {
        Texture texture = null;
        try {
            gl.glEnable(GL.GL_BLEND);
            gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
            TextureData data = TextureIO.newTextureData(GLProfile.getDefault(), new File(file), true, type);
            texture = TextureIO.newTexture(data);
            System.out.println("hi");
            if (texture == null) {
                System.err.println("Error loading texture");
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        setHeight();
//        width = texture.getWidth();
//        height = texture.getHeight();
        System.out.println(width);
        System.out.println("width: "+height);
        gl.glEnable(GL_TEXTURE_2D);
        assert texture != null;
        texture.bind(gl);
        this.textureID = texture.getTextureObject();
        System.out.println(textureID);
// Set texture parameters
        gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
        gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
        gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);


    }
    public Vector3[] getVecticesAsVector(){
        Vector3[] vertix = new Vector3[4];
        vertix[0] = new Vector3(vertices[0], vertices[1]);
        vertix[1] = new Vector3(vertices[3], vertices[4]);
        vertix[2] = new Vector3(vertices[6], vertices[7]);
        vertix[3] = new Vector3(vertices[9], vertices[10]);
        return vertix;
    }
    /**
     *
     * @param dt
     * gl will be passed here.
     */

    @Override
    public void init(float dt) {
        loadTexture();
    }


    @Override
    public void update(float dt) {
        System.out.println("update works :D");

    }

    /**
     * sets vaertices defualt
     */
    public void setVerticesDefault() {
        vertices = new float[]{
                -1.0f, -1.0f, 0.0f,   // Bottom-left vertex
                1.0f, -1.0f, 0.0f,    // Bottom-right vertex
                -1.0f, 1.0f, 0.0f,    // Top-left vertex
                1.0f, 1.0f, 0.0f      // Top-right vertex
        };

        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = vertices[i] * 100.0f;
        }
    }
    public float[] getVertices(){
        return vertices;
    }

    public void scale(float value) {
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] *= value;
        }
    }

    /**
     *
     * @param shaderProgram
     * @param sh
     */
    @Override
    public void sendtoGPU(int shaderProgram, loadShader sh) {
        System.out.println("send to GPU");


        int[] buffers = new int[3];
        indices = new int[]{0, 1, 2, 3};  // Index buffer for a quad

        gl.glGenBuffers(3, buffers, 0);
        gl.glEnable(GL_TEXTURE_2D);
        gl.glBindBuffer(GL_ARRAY_BUFFER, buffers[0]);
        gl.glBufferData(GL_ARRAY_BUFFER, vertices.length * 4 + textureCoords.length * 4, null, GL_STATIC_DRAW);

        gl.glBufferSubData(GL_ARRAY_BUFFER, 0, vertices.length * 4, FloatBuffer.wrap(vertices));
        gl.glBindBuffer(GL_ARRAY_BUFFER, buffers[0]);

        gl.glBufferSubData(GL_ARRAY_BUFFER, vertices.length * 4, textureCoords.length * 4, FloatBuffer.wrap(textureCoords));
        gl.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, buffers[2]);

        gl.glBufferData(GL_ELEMENT_ARRAY_BUFFER, indices.length * 4, IntBuffer.wrap(indices), GL_STATIC_DRAW);

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

        gl.glActiveTexture(GL_TEXTURE0);
        gl.glBindTexture(GL_TEXTURE_2D, textureID);
//        gl.glEnable(GL.GL_BLEND);
//        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
        int textureSamplerLoc = gl.glGetUniformLocation(shaderProgram, "tSample");
        System.out.println("texture: " + textureSamplerLoc);
        gl.glUniform1i(textureSamplerLoc, 0);
    }

    @Override
    public String toString() {
        return "getComepent works";
    }
}
