# input

``
public static Vector3 mouseLocation;``


this is the location of the mouse on screen. it uses 

JFrame coordinates and not transformed openGL matrix coords. 

---

   ``` public static boolean getKey(int keyCode);```
   
this returns what key is pressed
   
it uses java.awt.event.KeyEvent for the key enums

https://docs.oracle.com/javase/8/docs/api/java/awt/event/KeyEvent.html

---


``` public static boolean getMouse(int mouseCode);```

this returns true if the mouse code param matches what input was taken

it uses java.awt.event.MouseEvent for the button enums


https://docs.oracle.com/javase/8/docs/api/java/awt/event/MouseEvent.html

