# GameEngine2D v1.0.0


the naya engine.

2D game engine coded by me TheoW03

written in java

# installation

1. <p>download these 2 dependecies
---
*    version: 2.3.2 JOGL (openGL)
* https://jar-download.com/artifacts/org.jogamp.gluegen/gluegen-rt
---
 *   version 1.10.5 JOML (Matrix math)
 * https://jar-download.com/artifacts/org.joml

---
*    requires java 17
* https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
---
# usage

main

```JAVA
import org.NayaEngine.GameObjects.GameRenderer;

public class Main {
    public static void main(String[] args) throws IOException {
        GameRenderer starterCode = new StarterCode(); //for step 3 if you get a not defined error then
        Window.InitWindow(640, 480, "example window", starterCode);
    }
}

```
---

renderer class
```JAVA
public class StarterCode extends GameRenderer {
    public InitObjects initObject;
    //runs 1st frame
    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        super.init(glAutoDrawable); 
        GameObject obj = new GameObject("starterObj"); // you can name it what you want
        obj.AddCompenent(new CameraComponent(new Vector3(0,0,0))); //not required if you dont add it will default to 0,0
        obj.AddCompenent(new SpriteComponents("sprite.png","png",null)); //the null is a color
        obj.AddCompenent(new TransformComponent(new Vector3(0,0,0)));
        gameObjectArrayList.add(obj);
        initObject = new InitObjects();
    }
    //runs every frame. 
    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        initObject.InstiateObjects(gameObjectArrayList); //inits list
    }
}

```


