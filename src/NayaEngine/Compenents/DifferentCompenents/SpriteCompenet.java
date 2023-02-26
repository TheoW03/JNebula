package NayaEngine.Compenents.DifferentCompenents;

import NayaEngine.Compenents.iCompenet;
import com.jogamp.opengl.util.texture.Texture;


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
