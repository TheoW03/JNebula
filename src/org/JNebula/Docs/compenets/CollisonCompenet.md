# Collider Component

This lets you check for collisions


<details>
<summary><b>Vars</b></summary>

---

``public boolean showHitBox``

shows the hitbox of the collider

---

</details>


<details>
<summary><b>Methods</b></summary>

----
``public boolean isCollided(ColliderCompenet collider)``

this checks if its a collider
returns true or false. if collides or not.


---------------

``public boolean rayCollides(ColliderCompenet collider)``


this uses ray casting and checks collisons with rays.
you can either have 
returns either true or false


* a list of rays
* or a single ray (coming soon)

it will default to false or
if you didn't define the ray in constructor
</details>
