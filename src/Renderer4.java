import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLAutoDrawable;
import org.JNebula.GameObjects.GameRenderer;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class Renderer4 extends GameRenderer {

    float i = 0;
    GL4 gl;
    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        gl = glAutoDrawable.getGL().getGL4();


    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
//        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);// Clear the color buffer to the clear color
////        gl.glClearColor(0.1f, 0.5f, 0.2f, 0.0f);
//        gl = glAutoDrawable.getGL().getGL4();
//        gl.glEnable(GL_LIGHTING);
//
//
//// Set up a directional light source
//        float[] light_position = { 1.0f, 0.0f, 0.5f, 0.0f };
//        float[] light_ambient = { 0.2f, 1.0f, 1.0f, 1.0f };
//        float[] light_diffuse = { 1.0f, 0.8f, 0.8f, 1.0f };
//        float[] light_specular = { 0.5f, 1.0f, 1.0f, 1.0f };
//
//        float[] materialAmbient = {1.0f, 0.2f, 0.2f, 1.0f}; // r, g, b, a
//        float[] materialDiffuse = {1.0f, 0.8f, 0.8f, 1.0f}; // r, g, b, a
//        float[] materialSpecular = {1.0f, 0.5f, 0.5f, 1.0f};// r, g, b, a
//        float materialShininess = 0.6f; // specular exponent
//        gl.glLightfv(GL_LIGHT0, GL_POSITION, light_position, 0);
//        gl.glLightfv(GL_LIGHT0, GL_AMBIENT, light_ambient, 0);
//        gl.glLightfv(GL_LIGHT0, GL_DIFFUSE, light_diffuse, 0);
//        gl.glLightfv(GL_LIGHT0, GL_SPECULAR, light_specular, 0);
//        gl.glEnable(GL_LIGHT0);
//
////         Set up the material properties
//        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT, materialAmbient, 0);
//        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_DIFFUSE, materialDiffuse, 0);
//        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, materialSpecular, 0);
//        gl.glMaterialf(GL2.GL_FRONT_AND_BACK, GL2.GL_SHININESS, materialShininess);
//        gl.glEnable(GL_NORMALIZE);
//        // Draw a rectangle
//        if(Input.getKey() == KeyEvent.VK_W){
//            System.out.println("W pressed");
//        }
//        if(Input.getMouseCode() == MouseEvent.BUTTON1){
//            System.out.println("clicked pressed");
//        }
//        gl.glBegin(GL2.GL_QUADS);
//        gl.glNormal3f(0.0f, 0.0f, i); // surface normal
//        gl.glVertex2f(0.0f, 0.0f);
//        gl.glVertex2f(1.0f, 0.0f);
//        gl.glVertex2f(1.0f, 1.0f);
//        gl.glVertex2f(0.0f, 1.0f);
//        gl.glEnd();
//        gl.glBegin(GL2.GL_QUADS);
//        gl.glVertex2f(0.0f, 0.0f);
////        gl.glNormal3f(0.0f, 0.0f, 1.0f); // surface normal
//        gl.glVertex2f(-1.0f, 0.0f);
//        gl.glVertex2f(-1.0f, -1.0f);
//        gl.glVertex2f(0.0f, 1.0f);
//        gl.glEnd();
//        i = i+0.01f;
    }
}
