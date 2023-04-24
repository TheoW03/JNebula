package DemoGame;

import com.jogamp.opengl.GLAutoDrawable;
import org.NayaEngine.Compenents.DifferentCompenents.ColliderCompenet;
import org.NayaEngine.Compenents.DifferentCompenents.SpriteComponents;
import org.NayaEngine.Compenents.DifferentCompenents.TransformComponent;
import org.NayaEngine.GameObjects.GameObject;
import org.NayaEngine.GameObjects.GameRenderer;
import org.NayaEngine.GameObjects.InitObjects;
import org.NayaEngine.Tooling.Colors;
import org.NayaEngine.Tooling.Input;
import org.NayaEngine.math.Vector3;

import java.awt.event.KeyEvent;
import java.util.*;
import java.io.*;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class DemoRenderer extends GameRenderer {
    GameObject paddle1, paddle2, ball;
    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        super.init(glAutoDrawable);
        paddle1 = new GameObject("paddle1");
        paddle2 = new GameObject("paddle2");
        ball = new GameObject("ball");


        ball.AddCompenent(new SpriteComponents(new Colors(1,1,1)));
        paddle1.AddCompenent(new SpriteComponents("src/sprites/test.jpg","jpg",null));
        paddle2.AddCompenent(new SpriteComponents("src/DemoGame/assets/paddle_asset.PNG","png",null));
        instantiate = new InitObjects();
        gameObjectArrayList.add(paddle1);
        gameObjectArrayList.add(paddle2);
        gameObjectArrayList.add(ball);
        paddle1.AddCompenent(new TransformComponent(new Vector3(30,100)));
        paddle2.AddCompenent(new TransformComponent(new Vector3(170,100)));
        paddle1.AddCompenent(new ColliderCompenet());

        ball.AddCompenent(new TransformComponent(new Vector3(100,100)));
        ball.AddCompenent(new ColliderCompenet());

        System.out.println("init");
        instantiate = new InitObjects();
        paddle1.GetCompenent(SpriteComponents.class).scaleX(0.25f);
        paddle2.GetCompenent(SpriteComponents.class).scaleX(0.25f);
        ball.GetCompenent(SpriteComponents.class).scaleXY(0.25f,0.20f);
//        System.exit(0);
    }

    Vector3 bt = Vector3.left;
    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        instantiate.InstiateObjects(gameObjectArrayList);

        if(Input.getKey()== KeyEvent.VK_S){
            paddle1.transform.transform(Vector3.down);
        }
        if(Input.getKey()== KeyEvent.VK_W){
            paddle1.transform.transform(Vector3.up);
        }
        ball.transform.transform(bt);
        if(ball.GetCompenent(ColliderCompenet.class).isCollided(paddle1.GetCompenent(ColliderCompenet.class))){
            bt = Vector3.right;
        }else {
            bt = Vector3.left;
        }



    }
}
