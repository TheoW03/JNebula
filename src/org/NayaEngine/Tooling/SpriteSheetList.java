package org.NayaEngine.Tooling;

import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;

import java.util.*;
import java.io.*;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class SpriteSheetList {
    public String file, type;
    public float[][] spriteTexCoords;
    public Texture texture;

    public SpriteSheetList(String file,
                           String type,
                           int numRows, int numCols,
                           int spriteWidth, int spriteHeight, int offset) {
        this.file = file;
        this.type = type;
        spriteTexCoords = new float[numRows * numCols][8];
        System.out.println(numRows);
        System.out.println(numCols);
        loadTexture();
        float width = texture.getWidth();
        float height = texture.getHeight();
//        int spriteWidth = 64;
//        int spriteHeight = 64;
        int i2 = 0;
        float spriteY = height - spriteHeight;
        float spriteX = 0;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                int spriteIndex = row * numCols + col;

                float topY = (spriteY + spriteHeight) / height;
                float rightX = (spriteX + spriteHeight) / width;
                float leftX = spriteX / width;
                float bottomY = spriteY / height;
                float[] textureCoords = new float[]{
                        leftX, bottomY,
                        rightX, bottomY,
                        leftX, topY,
                        rightX, topY
                };
                System.out.println("textureds");
//                System.out.println(Arrays.toString(texCoords));
                spriteTexCoords[i2] = textureCoords;
                spriteX += spriteWidth - offset;
                if (spriteX >= width) {
                    spriteX = 0;
                    spriteY -= spriteHeight + offset;
                }
                i2++;
            }
        }
    }

    private void loadTexture() {
        try {

            TextureData data = TextureIO.newTextureData(GLProfile.getDefault(), new File(file), true, type);
            this.texture = TextureIO.newTexture(data);
            System.out.println("hi");
            if (texture == null) {
                System.err.println("Error loading texture");
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public float[] getTexture(int index) {
        if (index < spriteTexCoords.length) {
            return null;
        }
        return spriteTexCoords[index];
    }

    public float[][] getSection(int startingIndex, int endingIndex) {
        return Arrays.copyOfRange(spriteTexCoords, startingIndex, endingIndex);
    }

}

