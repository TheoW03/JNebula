package Compenents.DifferentCompenents;

import Compenents.iCompenet;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureData;

import java.util.*;
import java.io.*;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class SpriteCompenet implements iCompenet {
    public Texture texture;
    public SpriteCompenet(Texture texture) {
        this.texture = texture;
    }
    public int getID(){
        return texture.getTextureObject();
    }
}
