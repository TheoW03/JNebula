package org.NayaEngine.Compenents.DifferentCompenents;


import org.NayaEngine.Compenents.iCompenet;
import com.jogamp.common.nio.Buffers;
import com.jogamp.opengl.GL2;

import java.nio.FloatBuffer;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class VertexShaderCompenet implements iCompenet {
    private final GL2 gl;
    public int shaderProgram;

    public VertexShaderCompenet(int shaderProgram, GL2 gl) {
        this.gl = gl;

        this.shaderProgram = shaderProgram;
    }

    public void bindVertexAttrib(int attrib) {
        gl.glEnableVertexAttribArray(attrib);
    }

    public void allocateMatrices(CameraCompenent c, int matLoc) {
        FloatBuffer matBufferP = Buffers.newDirectFloatBuffer(1024);
        c.projectMatrix.get(matBufferP);
        gl.glUniformMatrix4fv(matLoc, 1, false, matBufferP);
        matBufferP.clear();

    }

}
