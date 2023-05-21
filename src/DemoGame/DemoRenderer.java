package DemoGame;

import com.jogamp.opengl.GLAutoDrawable;
import org.JNebula.Compenents.DifferentCompenents.ColliderComponent;
import org.JNebula.Compenents.DifferentCompenents.SpriteComponent;
import org.JNebula.Compenents.DifferentCompenents.TransformComponent;
import org.JNebula.GameObjects.GameObject;
import org.JNebula.GameObjects.GameRenderer;
import org.JNebula.GameObjects.InitObjects;
import org.JNebula.Tooling.Colors;
import org.JNebula.Tooling.Input;
import org.JNebula.math.Vector3;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class DemoRenderer extends GameRenderer implements KeyListener {
    GameObject paddle1, paddle2, ball;

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        super.init(glAutoDrawable);
        paddle1 = new GameObject("paddle1");
        paddle2 = new GameObject("paddle2");
        ball = new GameObject("ball");


        ball.AddComponent(new SpriteComponent(new Colors(1, 1, 1)));
        paddle1.AddComponent(new SpriteComponent("src/DemoGame/assets/paddle_asset.PNG", "png", null));
        paddle2.AddComponent(new SpriteComponent("src/DemoGame/assets/paddle_asset.PNG", "png", null));
        Init = new InitObjects();
        gameObjectArrayList.add(paddle1);
        gameObjectArrayList.add(paddle2);
        gameObjectArrayList.add(ball);
        paddle1.AddComponent(new TransformComponent(new Vector3(30, 100)));
        paddle2.AddComponent(new TransformComponent(new Vector3(170, 100)));
        paddle1.AddComponent(new ColliderComponent());
        paddle2.AddComponent(new ColliderComponent());
        ball.AddComponent(new TransformComponent(new Vector3(100, 100)));
        ball.AddComponent(new ColliderComponent());
        System.out.println("init");
        paddle1.GetCompenent(SpriteComponent.class).scaleX(0.25f);
        paddle2.GetCompenent(SpriteComponent.class).scaleX(0.25f);
        ball.GetCompenent(SpriteComponent.class).scaleXY(0.2f, 0.2f);
//        System.exit(0);
    }

    Vector3 bt = Vector3.left;

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        Init.InstantiateObjects(gameObjectArrayList);

        if(Input.getKey()== KeyEvent.VK_S){
            paddle1.transform.transform(Vector3.down);
        }
        if(Input.getKey()== KeyEvent.VK_W){
            paddle1.transform.transform(Vector3.up);
        }
        if(Input.getKey()== KeyEvent.VK_DOWN){
            paddle2.transform.transform(Vector3.down);
        }
        if(Input.getKey()== KeyEvent.VK_UP){
            paddle2.transform.transform(Vector3.up);
        }
        ball.transform.transform(bt);
        if (paddle1.GetCompenent(ColliderComponent.class).isCollided(ball.GetCompenent(ColliderComponent.class))) {
            float min = -0.5f;
            float max = 0.5f;
            float randomNum = (float) (Math.random() * (max - min) + min);
            bt = new Vector3(1, randomNum);
        }
        if (paddle2.GetCompenent(ColliderComponent.class).isCollided(ball.GetCompenent(ColliderComponent.class))) {
            float min = -0.5f;
            float max = 0.5f;
            float randomNum = (float) (Math.random() * (max - min) + min);
            bt = new Vector3(-1, randomNum);
        }
        if (ball.transform.location.y > 200) {
            bt = new Vector3(bt.x, -bt.y);
        } else if (ball.transform.location.y < 0) {
            bt = new Vector3(bt.x, bt.y);
        }

    }
//    @Override
//    public void keyPressed(KeyEvent e) {
//        if (e.getKeyCode() == KeyEvent.VK_S) {
//            paddle1.transform.transform(Vector3.down);
//
//        }
//        if (e.getKeyCode() == KeyEvent.VK_W) {
//            paddle1.transform.transform(Vector3.up);
//        }
//        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//            paddle2.transform.transform(Vector3.down);
//        }
//        if (e.getKeyCode() == KeyEvent.VK_UP) {
//            paddle2.transform.transform(Vector3.up);
//        }
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//        if (e.getKeyCode() == KeyEvent.VK_S) {
//            paddle1.transform.transform(Vector3.zero);
//        }
//        if (e.getKeyCode() == KeyEvent.VK_W) {
//            paddle1.transform.transform(Vector3.zero);
//        }
//        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//            paddle2.transform.transform(Vector3.zero);
//        }
//        if (e.getKeyCode() == KeyEvent.VK_UP) {
//            paddle2.transform.transform(Vector3.zero);
//        }
//    }



}
