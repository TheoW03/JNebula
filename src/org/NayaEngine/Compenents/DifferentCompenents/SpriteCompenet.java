package org.NayaEngine.Compenents.DifferentCompenents;

import org.NayaEngine.Compenents.iCompenet;
import com.jogamp.opengl.util.texture.Texture;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class SpriteCompenet implements iCompenet {
    public Texture texture;
    public int[] indicies;
    public float[] textureCoords;
    public SpriteCompenet(Texture texture) {
        this.indicies = new int[]{0, 1, 2, 3};  // Index buffer for a quad

        this.textureCoords = new float[]{
                0.0f, 0.0f,           // Bottom-left texture coordinate
                1.0f, 0.0f,           // Bottom-right texture coordinate
                0.0f, 1.0f,           // Top-left texture coordinate
                1.0f, 1.0f           // Top-right texture coordinate
        };
        this.texture = texture;
    }
    public int getID(){
        return texture.getTextureObject();
    }
}
