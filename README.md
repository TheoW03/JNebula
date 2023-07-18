# JNebula v1.0.0 In-Dev

a component based graphics engine
coded in java 

<p>coded by: TheoW03 </p>


# Getting Started

<details>
<summary><b>No JSON editor</b></summary>


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
    
    //if you use the object editor it requires Scene object.java
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
        InitObjects.InstantiateObjects(gameObjectArrayList); //inits list
        GameObject render1Instance = InitObjects.Find("render1");
    }
}


```
</details>
<br>
<details> 

<summary><b> JSON editor</b></summary>

warning: The JSON editor isn't fully functional and may have some bugs. or some specific test cases where 
its unusable. 

```JSON
[
  {
    "name": "render1",
    "isActive": true,
    "components": [
      {
        "component_name": "org.JNebula.Components.DifferentComponents.TransformComponent",
        "location": {
          "x": 100,
          "y": 100,
          "z": 0
        }
      },
      {
        "component_name": "org.JNebula.Components.DifferentComponents.SpriteComponent",
        "file": "${path to image}",
        "type": "jpg"
      }
    ]
  }
]
```


```JAVA
import org.JNebula.GameObjects.GameRenderer;

public class Main {
    public static void main(String[] args) throws IOException {
        GameRenderer starterCode = new StarterCode(); //for step 3 if you get a not defined error then
        Window.InitWindow(640, 480, "example window", starterCode);
    }
}

```


```JAVA
public class StarterCode extends GameRenderer {
    public InitObjects initObject;

    //if you use the object editor it requires Scene object.java
    //runs 1st frame
    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        super.init(glAutoDrawable);
        ObjectEditorJSON js = new ObjectEditorJSON("${PATH TO JSON}"); //JSON code
        gameObjectArrayList = js.objects;
    }
    //runs every frame. 
    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        Init.InstantiateObjects(gameObjectArrayList); //inits list
    }
}
```
</details>



# Documentation

* <a href = https://github.com/TheoW03/JNebula/tree/master/src/org/JNebula/Docs>Documentation v1.0.0 </a>

# Demo 

* <a href = https://github.com/TheoW03/JNebula/tree/master/src/DemoGame> Demo v1.0.0 </a>

# contributors

T-A-B


