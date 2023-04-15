# collider compenet

```inherits ICompenet```


``isCollided(ColliderCompenet collider)``

this checks if its a collider
returns true or false. uses an inhouse algorithm. that derived off ray
marching. the distance functions.


---------------


``ray_collides(ColliderCompenet collider)`` 


this uses ray casting and checks collisons with rays.
you can either have 
returns either true or false


* a list of rays
* or a single ray

it will default to false 
if you didn't define the ray in constructor

all defined in constructor