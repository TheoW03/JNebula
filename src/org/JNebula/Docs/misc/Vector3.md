# Vector3 


``public float x,y;``


<h2>direction vectors constants</h2>

    public static Vector3 down = new Vector3(0,-1,0);
    public static Vector3 right = new Vector3(1,0,0);
    public static Vector3 left = new Vector3(-1,0,0);
    public static Vector3 zero = new Vector3(0,0,0); //zero vector >:3 sends shivers



```public float dotProduct(Vector3 product)``` its the sum of the vector component multiplied

```public float magnitude()``` length SQRT(x^2+y^2+z^2)

```public Vector3 unitVector()``` a vector Such that its length = 1, found by scaling 1/magnitude

