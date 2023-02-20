import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.io.*;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class loadShader {

    /**
     * @return shader content
     */
    public String processShader(String fileName) throws IOException {
        String file = "src/shaders/" + fileName;
        StringBuilder t = new StringBuilder();
        try {
            ArrayList<String> a = (ArrayList<String>) Files.readAllLines(Path.of(file), StandardCharsets.UTF_8);
            a.forEach(contents -> {
                t.append(contents);
                t.append("\n");
            });
        } catch (IOException e) {
            System.out.println(e);
            return "error getting file";
        }

        return t.toString();
    }

    public int loadShaders(String vertexShaderS, String fragShader, GL2 gl2) {
        int shaderProgram = gl2.glCreateProgram();
        int vertexShader = gl2.glCreateShader(GL2.GL_VERTEX_SHADER);
        gl2.glShaderSource(vertexShader, 1, new String[]{vertexShaderS}, null);
        System.out.println(vertexShader);
        gl2.glCompileShader(vertexShader);
        int[] sucess = new int[1];
        gl2.glGetShaderiv(vertexShader, GL2.GL_COMPILE_STATUS, sucess, 0);
        if (sucess[0] == GL2.GL_FALSE) {
            int[] logLength = new int[1];
            gl2.glGetShaderiv(vertexShader, GL2.GL_INFO_LOG_LENGTH, logLength, 0);

            ByteBuffer infoLog = ByteBuffer.allocate(logLength[0]);
            gl2.glGetShaderInfoLog(vertexShader, logLength[0], null, infoLog);
            String logString = new String(infoLog.array(), 0, logLength[0]);
            System.err.println(logString);
        }
        gl2.glAttachShader(shaderProgram, vertexShader);

// Compile and attach the fragment shader
        int fragmentShader = gl2.glCreateShader(GL2.GL_FRAGMENT_SHADER);
        gl2.glShaderSource(fragmentShader, 1, new String[]{fragShader}, null);
        gl2.glCompileShader(fragmentShader);
        gl2.glAttachShader(shaderProgram, fragmentShader);
        sucess = new int[1];
        gl2.glGetShaderiv(fragmentShader, GL2.GL_COMPILE_STATUS, sucess, 0);

        if (sucess[0] == GL2.GL_FALSE) {
            int[] logLength = new int[1];
            gl2.glGetShaderiv(fragmentShader, GL2.GL_INFO_LOG_LENGTH, logLength, 0);

            ByteBuffer infoLog = ByteBuffer.allocate(logLength[0]);
            gl2.glGetShaderInfoLog(fragmentShader, logLength[0], null, infoLog);
            String logString = new String(infoLog.array(), 0, logLength[0]);
            System.err.println(logString);
        }
        gl2.glLinkProgram(shaderProgram);

        gl2.glUseProgram(shaderProgram);

        return shaderProgram;

    }
    public int[] setVBO(GL gl, int vboLength){
        int[] buffers = new int[vboLength];
        gl.glGenBuffers(vboLength, buffers, 0);
        return buffers;
    }
    public String setUnformVar(String name, float[] vector){

        return "";
    }


}
