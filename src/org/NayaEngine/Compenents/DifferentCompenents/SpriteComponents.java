package org.NayaEngine.Compenents.DifferentCompenents;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;
import org.NayaEngine.Compenents.iComponent;
import com.jogamp.opengl.util.texture.Texture;
import org.NayaEngine.Tooling.Colors;
import org.NayaEngine.Tooling.SpriteSheetList;
import org.NayaEngine.Tooling.loadShader;
import org.NayaEngine.math.Vector3;
import org.joml.Vector3f;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
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
    public float width, height;
    private float[] normals;

    private float currentFrame = 0;
    private float[][] spriteTexCoords;
    private Texture texture;
    private int FPS;

    public Colors color;

    public SpriteComponents(String file, String type) {

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
        spriteTexCoords = new float[1][textureCoords.length];
        spriteTexCoords[0] = textureCoords;
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = vertices[i] * 100.0f;
        }
        this.textureID = 0;
        loadTexture();
        System.out.println(texture.getHeight() + " "+texture.getWidth());

    }

    public SpriteComponents(String file,
                            String type,
                            int numRows, int numCols,
                            int FPS, int spriteWidth, int spriteHeight, int offset) {
        vertices = new float[]{
                -1.0f, -1.0f, 0.0f,   // Bottom-left vertex
                1.0f, -1.0f, 0.0f,    // Bottom-right vertex
                -1.0f, 1.0f, 0.0f,    // Top-left vertex
                1.0f, 1.0f, 0.0f      // Top-right vertex
        };
        System.out.println("works");
        this.file = file;
        this.type = type;
        this.gl = gl;
        this.FPS = FPS;
        spriteTexCoords = new float[numRows * numCols][8];
        this.textureID = 0;
        System.out.println(numRows);
        System.out.println(numCols);
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = vertices[i] * 100.0f;
        }
        loadTexture();
//        float width = texture.getWidth();
//        float height = texture.getHeight();
//        int spriteWidth = 64;
//        int spriteHeight = 64;
        int i2 = 0;
        float spriteY = height - spriteHeight;
        float spriteX = 0;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                int spriteIndex = row * numCols + col;

                float topY = (spriteY + spriteHeight) / height;
                float rightX = (spriteX + spriteHeight) / width;
                float leftX = spriteX / width;
                float bottomY = spriteY / height;
                float[] textureCoords = new float[]{
                        leftX, bottomY,
                        rightX, bottomY,
                        leftX, topY,
                        rightX, topY
                };
                System.out.println("textureds");
//                System.out.println(Arrays.toString(texCoords));
                spriteTexCoords[i2] = textureCoords;
                spriteX += spriteWidth - offset;
                if (spriteX >= width) {
                    spriteX = 0;
                    spriteY -= spriteHeight + offset;
                }
                i2++;
            }
        }


    }

    public SpriteComponents(float[] textureCoords, SpriteSheetList spriteSheetList) {
        vertices = new float[]{
                -1.0f, -1.0f, 0.0f,   // Bottom-left vertex
                1.0f, -1.0f, 0.0f,    // Bottom-right vertex
                -1.0f, 1.0f, 0.0f,    // Top-left vertex
                1.0f, 1.0f, 0.0f      // Top-right vertex
        };
        normals = new float[]{
                0.0f, 1.0f,
                0.0f, 1.0f,
                0.0f, 1.0f,
                0.0f, 1.0f,
        };
        spriteTexCoords = new float[1][textureCoords.length];
        spriteTexCoords[0] = textureCoords;
        this.texture = spriteSheetList.texture;
        this.textureID = 0;
        this.gl = gl;
        loadTexture();
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = vertices[i] * 100.0f;
        }


    }

    public SpriteComponents(float[][] textureCoords, SpriteSheetList spriteSheetList, int FPS) {
        vertices = new float[]{
                -1.0f, -1.0f, 0.0f,   // Bottom-left vertex
                1.0f, -1.0f, 0.0f,    // Bottom-right vertex
                -1.0f, 1.0f, 0.0f,    // Top-left vertex
                1.0f, 1.0f, 0.0f      // Top-right vertex
        };
        normals = new float[]{
                0.0f, 1.0f,
                0.0f, 1.0f,
                0.0f, 1.0f,
                0.0f, 1.0f,
        };
        spriteTexCoords = textureCoords;
        this.texture = spriteSheetList.texture;
        this.textureID = 0;
        this.gl = gl;
        this.FPS = FPS;
        loadTexture();
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = vertices[i] * 100.0f;
        }
    }

    public SpriteComponents(Colors color, GL4 gl) {
        this.gl = gl;
        this.color = color;

    }

    public Vector3 get_size(){
        System.out.println("w: "+width +" "+height);
        return  new Vector3(width,height-4);
//        return new Vector3(vertices[3]/4,vertices[3]/2);
    }
    public void setHeight() {
        Vector3[] a = getVecticesAsVector();
//        AC = C - A = (2, 2) - (0, 0) = (2, 2)
//        BD = D - B = (0, 2) - (2, 0) = (-2, 2)
//        double width = Math.sqrt( Math.pow(a[2].x - a[1].x, 2) + Math.pow(a[2].y- a[1].y, 2));
//        double height = Math.sqrt( Math.pow(a[1].x - a[0].x, 2) + Math.pow(a[1].y - a[0].y, 2));
        float[] v1 = { vertices[0], vertices[1], vertices[2] };
        float[] v2 = { vertices[9], vertices[10], vertices[11] };
        float[] v3 = { vertices[0], vertices[1], vertices[2] };
        float[] v4 = { vertices[3], vertices[4], vertices[5] };
        float length = new Vector3f(v1).distance(new Vector3f(v2));
        float width = new Vector3f(v3).distance(new Vector3f(v4));
//        Vector3 AC = new Vector3((a[1].x - a[0].x), (a[1].y - a[0].y));
//        Vector3 BD = new Vector3((a[2].x - a[3].x), (a[2].y - a[3].y));
//        System.exit(0);
//        this.width = (float) (AC.magnitude() * Math.cos(45));
//        this.height = (float) (BD.magnitude() * Math.sin(45));
        System.out.println("width: "+(length/10)*2+" "+(width/10));
//        System.exit(0);
        this.height = (length/10)*2;
        this.width = (width/10);
    }


    public Vector3 getCenter() {
        Vector3[] a = getVecticesAsVector();
        float centerX = 0;
        float centerY = 0;
        for (int i = 0; i < a.length; i++) {
            centerX += a[i].x;
            centerY += a[i].y;
        }
        centerX /= 4;
        centerY /= 4;

        return new Vector3(centerX, centerY);
    }

    private void loadTexture() {
        if (this.texture == null) {
            try {
                gl.glEnable(GL.GL_BLEND);
                gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
                TextureData data = TextureIO.newTextureData(GLProfile.getDefault(), new File(file), true, type);
                this.texture = TextureIO.newTexture(data);
                System.out.println("hi");
                if (texture == null) {
                    System.err.println("Error loading texture");
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        setHeight();
//        width = texture.getWidth();
//        height = texture.getHeight();
        System.out.println(width);
        System.out.println("width: " + height);
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

    public Vector3 get_sV(){
        return new Vector3(width,height);
    }

    public Vector3[] getVecticesAsVector() {
        Vector3[] vertix = new Vector3[4];
        vertix[0] = new Vector3(vertices[0], vertices[1]);
        vertix[1] = new Vector3(vertices[3], vertices[4]);
        vertix[2] = new Vector3(vertices[6], vertices[7]);
        vertix[3] = new Vector3(vertices[9], vertices[10]);
        return vertix;
    }

    /**
     * @param dt gl will be passed here.
     */


    @Override
    public void init(float dt) {
        loadTexture();
        if (FPS != 0) {
            Timer animationTimer = new Timer(1000 / FPS, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    currentFrame++;
                    System.out.println("current frame" + currentFrame);
                    if (currentFrame > spriteTexCoords.length) {
                        currentFrame = 0;
                    }
                }
            });

            animationTimer.start();
        }


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

    public float[] getVertices() {
        return vertices;
    }

    public void scale(float value) {
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] *= value;
        }
    }

    /**
     * @param shaderProgram
     * @param sh
     */
    @Override
    public void sendtoGPU(int shaderProgram, loadShader sh) {
        System.out.println("send to GPU");

//        textureCoords = spriteTexCoords[(int) currentFrame];
        if (currentFrame > spriteTexCoords.length) {
            currentFrame = 0;
        }
        try {
            textureCoords = spriteTexCoords[(int) currentFrame];
        } catch (ArrayIndexOutOfBoundsException e) {
            currentFrame = 0;
            textureCoords = spriteTexCoords[(int) currentFrame];
        }

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
// Wrap frame counter around at end of animation
        if (currentFrame >= spriteTexCoords.length) {
            currentFrame = 0;
        }
//        if (FPS != 0) {
//            try {
//                Thread.sleep(1000 / FPS);
//            } catch (InterruptedException e) {
//                System.out.println("er");
//            }
//        }

        gl.glUniform1i(textureSamplerLoc, 0);
    }

    @Override
    public String toString() {
        return "getComepent works";
    }
}
