import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;
import org.NayaEngine.GameObjects.GameRenderer;

import java.awt.event.ActionEvent;
import java.util.*;
import java.io.*;

import static com.jogamp.opengl.fixedfunc.GLLightingFunc.*;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class Renderer2 extends GameRenderer {
    public Renderer2() {

    }

    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        // Load texture
        Texture texture = null;


        // Enable textures


        // Bind texture
        assert texture != null;


        // Set texture parameters

    }
float i = 0;
    float count = 0.01f;
    public void display(GLAutoDrawable drawable) {
        Texture texture = null;
        try {
            texture = TextureIO.newTexture(new File("src/sprites/maxwell.png"), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        GL2 gl = drawable.getGL().getGL2();
        texture.bind(gl);
        gl.glEnable(GL2.GL_TEXTURE_2D);
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);// Clear the color buffer to the clear color
//        gl.glClearColor(0.1f, 0.5f, 0.2f, 0.0f);
        gl.glEnable(GL_LIGHTING);
// Set up a directional light source
        float[] light_position = { 1.0f, 0.0f, 0.5f, 0.0f };
        float[] light_ambient = { 0.2f, 1.0f, 1.0f, 1.0f };
        float[] light_diffuse = { 1.0f, 0.8f, 0.8f, 1.0f };
        float[] light_specular = { 0.5f, 1.0f, 1.0f, 1.0f };

        float[] materialAmbient = {0.5f, i, 0.2f, 1.0f}; // r, g, b, a
        float[] materialDiffuse = {1.0f, 0.8f, i, 1.0f}; // r, g, b, a
        float[] materialSpecular = {0.01f, i, 0.5f, 1.0f};// r, g, b, a
        float materialShininess = i; // specular exponent
        gl.glLightfv(GL_LIGHT0, GL_POSITION, light_position, 0);
        gl.glLightfv(GL_LIGHT0, GL_AMBIENT, light_ambient, 0);
        gl.glLightfv(GL_LIGHT0, GL_DIFFUSE, light_diffuse, 0);
        gl.glLightfv(GL_LIGHT0, GL_SPECULAR, light_specular, 0);
        gl.glEnable(GL_LIGHT0);

//         Set up the material properties
        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT, materialAmbient, 0);
        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_DIFFUSE, materialDiffuse, 0);
        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, materialSpecular, 0);
        gl.glMaterialf(GL2.GL_FRONT_AND_BACK, GL2.GL_SHININESS, materialShininess);
        gl.glEnable(GL_NORMALIZE);

        // Clear the color buffer
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_S, GL2.GL_REPEAT);
        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_T, GL2.GL_REPEAT);
        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_MIN_FILTER, GL2.GL_NEAREST);
        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_MAG_FILTER, GL2.GL_NEAREST);

        // Set color to white
        gl.glColor3f(1.0f, 1.0f, 1.0f);

        // Render a quad with the texture
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex2f(-1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex2f(1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex2f(1.0f, 1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex2f(-1.0f, 1.0f);
        gl.glEnd();

        // Disable textures
        gl.glDisable(GL2.GL_TEXTURE_2D);

        // Draw the texture
        gl.glDrawArrays(GL2.GL_QUADS, 0, 4);
        System.out.println(i);
        i += count;
        if(i > 1.0f){
            count = -0.01f;
        }else if(i < 0){
            count = 0.01f;
        }

    }


}
