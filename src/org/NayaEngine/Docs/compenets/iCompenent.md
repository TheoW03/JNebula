# icompenent


``GL2 gl`` this is the openGL context.

---

``public void init(float dt)``
gets called at the start frame. with dt as delta time
---
`` public void update(float dt) ``
gets called at every frame. dt as delta time
----
`` public void sendtoGPU(int shaderProgram, loadShader sh)``
this is meant for if you have shaders. its what you call to send
the uniform vars stuff to the GPU

---
if you want custom scripts. have it inherit this

