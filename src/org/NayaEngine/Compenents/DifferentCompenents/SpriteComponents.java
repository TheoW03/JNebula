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
public class SpriteComponents extends iComponent {

    @Override
    public void init(float dt) {
        super.init(dt);
        System.out.println("start");
    }

    @Override
    public void update(float dt) {
        System.out.println("update works :D");

    }

    @Override
    public String toString() {
        return "getComepent works";
    }
}
