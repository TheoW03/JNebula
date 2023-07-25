package InfinityTrain;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import org.JNebula.GameObjects.GameRenderer;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class infinityTrainRender extends GameRenderer {
    @Override
    public void update(float dt, GL2 gl) {
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT); // clears the screen with the background color

    }
}
