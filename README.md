# GameEngine2D


the naya engine.

2D game engine coded by me TheoW03


how to get started  



1. start a new class That uses GLeventListener 
and get a window on the screen using openGL event listner
   (future update i may abstract it)

2. Once you do that, create a new class
implements GL eventListener.

   
create a new GameObject

name what you want and add comepents,
like this

```GameObject.AddCompenent()```

to Edit the compenent use

``GameObject.GetCompenent(Compenent.class)``

as of right now each compenent is required a sprite

but im going to fix it you wont need to 

to remove

``GameObject.RemoveCompenent(Compenent.class)``

you can also add your own scripts have it

``extend iComponent``

``update(dt)``
runs every frame

``init(dt)`` is the 1st frame

enjoy :)

![img.png](img.png)
example of how it looks ^

in the future I plan to add a text based gameObject editor

and physics. and lighting.