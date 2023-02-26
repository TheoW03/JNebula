import NayaEngine.GameObjects.SpriteObject;
import NayaEngine.math.NVector;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class RendererTest implements GLEventListener {

    public SpriteObject s,s2;
    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        GL gl = glAutoDrawable.getGL().getGL2();
        s = new SpriteObject("src/maxwell.png", "png", new NVector(0, 0, 0), gl);
        s2 = new SpriteObject("src/test.jpg", "jpg", new NVector(10, 10, 0), gl);
    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
//        GL2 gl = glAutoDrawable.getGL().getGL2();
//        NayaEngine.Tooling.loadShader sh = new NayaEngine.Tooling.loadShader();
//        int[] buffer = new int[3];
//        int[] buffer2 = new int[3];
//        sh.bindBuffer(gl, buffer);
//        sh.bindBuffer(gl, buffer2);
//        String vertexShaders1 = "";
//        String vertexShaders2 = "";
//        String fragShaders1 = "";
//
//        String fragShaders2 = "";
//        try {
//            vertexShaders1 = sh.processShader("VertexSprite.glsl");
//            fragShaders1 = sh.processShader("SpriteFrag.glsl");
//            vertexShaders2 = sh.processShader("VertexSprite.glsl");
//            fragShaders2 = sh.processShader("SpriteFrag.glsl");
//        } catch (IOException ignored) {
//
//        }
//        sh.setupSpriteBuffer(s2.vertices,s2.indicies, s2.textureCoords, buffer,gl);
//        sh.setupSpriteBuffer(s.vertices,s.indicies, s.textureCoords, buffer2,gl);
//        int shaderPrograms1 = sh.loadShaders(vertexShaders1, fragShaders1, (GL2) gl);
//        int shaderPrograms2 = sh.loadShaders(vertexShaders2, fragShaders2, (GL2) gl);
//        int positionAttrib = gl.glGetAttribLocation(shaderPrograms1, "vPos");
//        int positionAttrib2 = gl.glGetAttribLocation(shaderPrograms2, "vPos");
//        sh.vertexAttrib(positionAttrib,buffer[0],gl);
//        sh.vertexAttrib(positionAttrib2,buffer2[0],gl);
//        gl.glVertexAttribPointer(positionAttrib, 3, GL_FLOAT, false, 0, 0);
//        gl.glVertexAttribPointer(positionAttrib2, 3, GL_FLOAT, false, 0, 0);
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }
}
