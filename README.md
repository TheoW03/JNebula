# JNebula 2D v1.0.0
<p>coded by: TheoW03 and T-A-B</p>

# Getting Started

main

```JAVA
import org.JNebula.GameObjects.GameRenderer;

public class Main {
    public static void main(String[] args) throws IOException {
        GameRenderer starterCode = new StarterCode(); //for step 3 if you get a not defined error then
        Window.InitWindow(640, 480, "example window", starterCode);
    }
}

```
---

your renderer class
```JAVA
public class StarterCode extends GameRenderer {
    public InitObjects initObject;
    //runs 1st frame
    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        super.init(glAutoDrawable); 
        GameObject obj = new GameObject("starterObj"); // you can name it what you want
        obj.AddComponent(new CameraComponent(new Vector3(0,0,0))); //not required if you dont add it will default to 0,0
        obj.AddComponent(new SpriteComponents("sprite.png","png",null)); //the null is a color
        obj.AddComponent(new TransformComponent(new Vector3(0,0,0)));
        gameObjectArrayList.add(obj);
    }
    //runs every frame. 
    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        Init.InstantiateObjects(gameObjectArrayList); //inits list
    }
}

```


