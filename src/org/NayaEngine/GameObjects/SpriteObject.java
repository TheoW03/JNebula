package org.NayaEngine.GameObjects;

import org.NayaEngine.Compenents.ManageCompenents;
import org.NayaEngine.Compenents.DifferentCompenents.SpriteCompenet;
import org.NayaEngine.Compenents.DifferentCompenents.TranformCompenet;
import org.NayaEngine.Compenents.iCompenet;
import org.NayaEngine.math.NVector;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static com.jogamp.opengl.GL.*;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class SpriteObject implements GameBehavior {
    public Texture spriteTexture;
    private NVector location;
//    private com.NayaEngine.Tooling.Camera camera;
    private GL gl;
    public float[] vertices, textureCoords;
    public int[] indicies;
    public int textureID;
    private float velocity;
    private ManageCompenents compenents;
    public ArrayList<String> compenetsString;
    /**
     * @param location xyz
     * @param type     png or JPG
     * @param gl       GL ref
     */
    public SpriteObject(String fileName, String type, NVector location, GL gl) {
        this.location = location;
//        this.camera = new com.NayaEngine.Tooling.Camera(location);
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
        loadTexture(fileName,type);
        addDefuaultCompenets();
        compenents = new ManageCompenents();
    }

    private void addDefuaultCompenets(){

        compenents.AddCompenet("TransformComponent", new TranformCompenet(location));
        compenents.AddCompenet("SpriteComponent", new SpriteCompenet(spriteTexture));
    }

//
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

    @Override
    public iCompenet GetCompenent(String name) {
        return compenents.GetCompenent(name);
    }

    @Override
    public void AddCompenent(String name, iCompenet compenet) {
        compenents.AddCompenet(compenet.toString(),compenet);
    }

    @Override
    public void GetCompenentList(String name, iCompenet compenet) {

    }
//
//    public Matrix4f getProjectionMatrix() {
//        return camera.getProjection();
//    }
//
//    public Matrix4f getViewMatrix() {
//        return camera.viewMatrix();
//    }
//
//    public void updateLocation(NVector location) {
//        this.camera = new com.NayaEngine.Tooling.Camera(location);
//    }


}
