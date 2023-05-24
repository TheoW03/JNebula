package org.JNebula.Components.DifferentComponents;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;
import org.JNebula.Components.iComponent;
import com.jogamp.opengl.util.texture.Texture;
import org.JNebula.Tooling.Colors;
import org.JNebula.Tooling.SpriteSheetList;
import org.JNebula.Tooling.LoadShader;
import org.JNebula.math.Vector3;
import org.joml.Vector3f;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class SpriteComponent extends iComponent {

    String file;
    public boolean wireFrame = false;
    String type;
    public int textureID;
    public int[] indices;
    private float[] textureCoords;
    public float width, height;
    private float[] normals;

    private float currentFrame = 0;
    private float[][] spriteTexCoords;
    private Texture texture;
    private int FPS = 0;
    public int numOfVertices;

    public int scaleHeight, scaleWidth;

    public Colors color;
    public float[] defualtVertices;
    float[][] vertices;


    /**
     * @param c sprite without a texture
     */
    public SpriteComponent(Colors c) {
        this.color = c;
        gl.glEnable(GL.GL_BLEND);
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
    }

    /**
     * @param file
     * @param type
     * @param c    sprite with texture.
     */
    public SpriteComponent(String file, String type, Colors c) {

        this.color = c;
        this.file = file;
        this.type = type;
        System.out.println(this.file);
//        this.vertices = new float[][]{
//                {-1.0f, -1.0f, 0.0f},
//                {1.0f, -1.0f, 0.0f},
//                {-1.0f, 1.0f, 0.0f},
//                {1.0f, 1.0f, 0.0f}
//        };
//        textureCoords = new float[]{
//                0.0f, 0.0f,           // Bottom-left texture coordinate
//                1.0f, 0.0f,           // Bottom-right texture coordinate
//                0.0f, 1.0f,           // Top-left texture coordinate
//                1.0f, 1.0f            // Top-right texture coordinate
//        };
//        normals = new float[]{
//                0.0f, 1.0f,
//                0.0f, 1.0f,
//                0.0f, 1.0f,
//                0.0f, 1.0f,
//        };
//        spriteTexCoords = new float[1][textureCoords.length];
//        spriteTexCoords[0] = textureCoords;
        this.textureID = 0;
//        loadTexture();
//        scaleXY(100, 100);
//        System.out.println(texture.getHeight() + " " + texture.getWidth());

    }


    public SpriteComponent(float[] textureCoords, SpriteSheetList spriteSheetList, Colors c) {
        this.color = c;
        this.texture = spriteSheetList.texture;
        this.textureID = 0;
    }

    /**
     * @param spriteSheetList
     * @param FPS
     * @param c               sprite sheet animation
     */
    public SpriteComponent(SpriteSheetList spriteSheetList, int FPS, Colors c) {
        this.color = c;
        spriteTexCoords = spriteSheetList.spriteTexCoords;
        this.texture = spriteSheetList.texture;
        this.textureID = 0;
        this.FPS = FPS;
    }

    @Override
    public void init(float dt) {
        this.vertices = new float[][]{
                {-1.0f, -1.0f, 0.0f},
                {1.0f, -1.0f, 0.0f},
                {-1.0f, 1.0f, 0.0f},
                {1.0f, 1.0f, 0.0f}
        };
        if (spriteTexCoords == null) {
            textureCoords = new float[]{
                    0.0f, 0.0f,           // Bottom-left texture coordinate
                    1.0f, 0.0f,           // Bottom-right texture coordinate
                    0.0f, 1.0f,           // Top-left texture coordinate
                    1.0f, 1.0f            // Top-right texture coordinate
            };
            spriteTexCoords = new float[1][textureCoords.length];
            spriteTexCoords[0] = textureCoords;

        }

        normals = new float[]{
                0.0f, 1.0f,
                0.0f, 1.0f,
                0.0f, 1.0f,
                0.0f, 1.0f,
        };
        this.textureID = 0;
        scaleXY(100, 100);
        if (scaleHeight != 0 && scaleWidth != 0) {
            scaleXY(scaleWidth, scaleHeight);
        }

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
        getCenterPoints();

    }

    private float[] multiplyMatrixVector(float[][] s, float[] v) {
        int rows = s.length;
        int cols = s[0].length;
        float[] result = new float[rows];
        for (int i = 0; i < rows; i++) {
            float sum = 0.0f;
            for (int j = 0; j < cols; j++) {
                sum += s[i][j] * v[j];
            }
            result[i] = sum;
        }
        return result;
    }

    public void scaleXY(float sx, float sy) {
        scaleX(sx);
        scaleY(sy);
    }


    public void scaleX(float sx) {
        Vector3[] mv = getVecticesAsVector();
        float centerX = (vertices[0][0] + vertices[1][0] + vertices[2][0] + vertices[3][0]) / 4.0f; // Calculate center point
        float[][] scaleMatrix = {
                {sx, 0.0f, 0.0f},
                {0.0f, 1.0f, 0.0f},
                {0.0f, 0.0f, 1.0f}
        }; // Create scale matrix
        for (int i = 0; i < vertices.length; i++) {
            vertices[i][0] -= centerX; // Translate to origin
            vertices[i] = multiplyMatrixVector(scaleMatrix, vertices[i]); // Apply non-uniform scale
            vertices[i][0] += centerX; // Translate back to original position
        }
        this.width *= sx;
    }


    public void scaleY(float sy) {
        float centerY = (vertices[0][1] + vertices[1][1] + vertices[2][1] + vertices[3][1]) / 4.0f; // Calculate center point
        System.out.println(Arrays.toString(vertices[0]) + " " + Arrays.toString(vertices[1]) + " " + Arrays.toString(vertices[2]));
        float[][] scaleMatrix = {
                {1.0f, 0.0f, 0.0f},
                {0.0f, sy, 0.0f},
                {0.0f, 0.0f, 1.0f}
        }; // Create scale matrix
        for (int i = 0; i < vertices.length; i++) {
            this.vertices[i][0] -= centerY; // Translate to origin
            this.vertices[i] = multiplyMatrixVector(scaleMatrix, vertices[i]); // Apply non-uniform scale
            this.vertices[i][0] += centerY; // Translate back to original position
        }
        this.height *= sy;
        System.out.println(Arrays.toString(vertices[0]) + " " + Arrays.toString(vertices[1]) + " " + Arrays.toString(vertices[2]));
        System.out.println("after set height in scale y");
    }

    public Vector3 get_size() {
        System.out.println("w: " + width + " " + height);
        return new Vector3(width, height);
    }

    public void setHeight() {
        Vector3[] a = getVecticesAsVector();
        float[] v1 = vertices[0];
        float[] v2 = vertices[1];
        float[] v3 = vertices[2];
        float[] v4 = vertices[3];
        float width = new Vector3f(v1).distance(new Vector3f(v2));
        float height = new Vector3f(v1).distance(new Vector3f(v3));
        this.height = ((height / 10)) * 2;
        this.width = (((width / 10)));
        System.out.println(height + " " + width);
    }

    /**
     * @return
     */
    public Vector3[] getCenterPoints() {
        setHeight();
        Vector3 a = this.gameObject.transform.location;
        Vector3[] centPoints = new Vector3[5];
        centPoints[0] = new Vector3((a.x + (width / 2)), (a.y + (height / 2)));
        centPoints[1] = new Vector3((a.x - (width / 2)), (a.y + (height / 2)));
        centPoints[2] = new Vector3((a.x - (width / 2)), (a.y - (height / 2)));
        centPoints[3] = new Vector3((a.x + (width / 2)), (a.y - (height / 2))); // D:
        centPoints[4] = a;
        System.out.println(Arrays.toString(centPoints));
        System.out.println(a);

        return centPoints;
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
        gl.glEnable(GL_TEXTURE_2D);
        System.out.println("file: " + file);
        System.out.println("load texture");
        if (file != null) {

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

//                    System.exit(1);
                } catch (IOException e) {
                }
            }
            setHeight();

        }

        System.out.println(width);
        System.out.println("width: " + height);

        assert texture != null;
        if (this.texture != null) {
            texture.bind(gl);
            this.textureID = texture.getTextureObject();
            System.out.println(textureID);
// Set texture parameters
            gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
            gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
            gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
            gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
            gl.glEnable(GL_BLEND);
            gl.glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        }


    }

    public Vector3 get_sV() {
        return new Vector3(width, height);
    }

    public Vector3[] getVecticesAsVector() {
        if(vertices == null){
            return new Vector3[4];
        }
        Vector3[] vertix = new Vector3[4];
        for (int r = 0; r < vertices.length; r++) {
            vertix[r] = new Vector3(vertices[r][0], vertices[r][1], vertices[r][2]);
        }
        return vertix;
    }

    /**
     * @param dt gl will be passed here.
     */


    @Override
    public void update(float dt) {
        System.out.println("update works :D");

    }

    public void scaleVertex(int v, float scale) {
        float[] vertex = vertices[v];
        for (int i = 0; i < vertex.length; i++) {
            vertex[i] *= scale;
        }
        vertices[v] = vertex;
    }

    /**
     * sets vaertices defualt
     */
    public void setVerticesDefault() {
        this.vertices = new float[][]{
                {-1.0f, -1.0f, 0.0f},
                {1.0f, -1.0f, 0.0f},
                {-1.0f, 1.0f, 0.0f},
                {1.0f, 1.0f, 0.0f}
        };

        scale(100);

    }

    public float[][] getVertices() {
        return vertices;
    }

    public void scale(float value) {
        for (int r = 0; r < vertices.length; r++) {
            for (int c = 0; c < vertices[r].length; c++) {
                vertices[r][c] = vertices[r][c] * value;
            }
        }
        setHeight();
    }

    public float[] oneDto2D(float[][] v) {
        int i = 0;
        float[] a = new float[v.length * 4];
        for (int r = 0; r < v.length; r++) {
            for (int c = 0; c < v[0].length; c++) {
                a[i] = v[r][c];
                i++;
            }
        }
        return a;

    }

    /**
     * @param shaderProgram
     * @param sh
     */
    @Override
    public void sendtoGPU(int shaderProgram, LoadShader sh) {
        System.out.println("send to sprite GPU");
        if (this.texture == null) {
            int location = gl.glGetUniformLocation(shaderProgram, "textureExists");
            gl.glUniform1f(location, 1);
        } else {
            int location = gl.glGetUniformLocation(shaderProgram, "textureExists");
            gl.glUniform1f(location, 0);
        }
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
        this.indices = new int[]{0, 2, 1,
                1, 3, 2,
                1, 2, 3};
        gl.glGenBuffers(3, buffers, 0);
        gl.glEnable(GL_TEXTURE_2D);
        gl.glBindBuffer(GL_ARRAY_BUFFER, buffers[0]);
        gl.glBufferData(GL_ARRAY_BUFFER, oneDto2D(vertices).length * 4L + textureCoords.length * 4L, null, GL_STATIC_DRAW);

        gl.glBufferSubData(GL_ARRAY_BUFFER, 0, oneDto2D(vertices).length * 4, FloatBuffer.wrap(oneDto2D(vertices)));
        gl.glBindBuffer(GL_ARRAY_BUFFER, buffers[0]);

        gl.glBufferSubData(GL_ARRAY_BUFFER, oneDto2D(vertices).length * 4, textureCoords.length * 4, FloatBuffer.wrap(textureCoords));
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
        gl.glVertexAttribPointer(texCoordAttrib, 2, GL_FLOAT, false, 0, oneDto2D(vertices).length * 4L);
        gl.glBindBuffer(GL_ARRAY_BUFFER, 0);
        int colorLocation = gl.glGetUniformLocation(shaderProgram, "color_of_sprite");
        if (color != null) {
            gl.glUniform3f(colorLocation, color.r2, color.g2, color.b2);
        } else {
            gl.glUniform3f(colorLocation, 1, 1, 1);

        }


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
        gl.glUniform1i(textureSamplerLoc, 0);
    }

    @Override
    public String toString() {
        return "sprite compenent " + texture;
    }
}
