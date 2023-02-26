package org.NayaEngine.Compenents.DifferentCompenents;

import org.NayaEngine.Compenents.iComponent;
import com.jogamp.opengl.util.texture.Texture;

import java.util.Arrays;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class SpriteComponents implements iComponent {
    public Texture texture;
    public int[] indicies;
    public float[] textureCoords;
    public SpriteComponents(Texture texture) {
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

    @Override
    public String toString() {
        return "SpriteComponent";
    }
}
