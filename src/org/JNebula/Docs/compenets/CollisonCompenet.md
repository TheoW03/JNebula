# collider compenet


----
``isCollided(ColliderCompenet collider)``

this checks if its a collider
returns true or false. uses an in-house algorithm. that derived off ray
marching. the distance functions to be specific :3.


---------------


``public boolean ray_collides(ColliderCompenet collider)``


this uses ray casting and checks collisons with rays.
you can either have 
returns either true or false


* a list of rays
* or a single ray (coming soon)

it will default to false or
if you didn't define the ray in constructor
