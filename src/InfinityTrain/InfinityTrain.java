package InfinityTrain;

import DemoGame.DemoRenderer;
import TestStuff.RendererTest2D;
import org.JNebula.Tooling.Window;

import java.util.*;
import java.io.*;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class InfinityTrain {


    /**
     *
     * @param args Ig you found my wierd fan game lul :3 enjoy.
     */

    public static void main(String[] args) {
        Window.InitWindow(640, 480, "JNebula Demo 2: good guys popping bad guys", new InfinityTRainRender());
    }
}
