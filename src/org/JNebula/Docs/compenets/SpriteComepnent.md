# Sprite Component

### constructors

render a Square

```public SpriteComponent(Colors c);```

render a sprite from a file

```public SpriteComponent(String file, String type, Colors c);```

render a single sprite from a spritesheet

```public SpriteComponent(float[] textureCoords, SpriteSheetList spriteSheetList, Colors c);```

render 2d animation

```public SpriteComponent(SpriteSheetList spriteSheetList, int FPS, Colors c);```



methods
---

 ```   public void scaleX(float sx);```

scales width

   ``` public void scaleY(float sy);```

scales height

``` public void scaleXY(float sy, float sx);```

scales width and height


