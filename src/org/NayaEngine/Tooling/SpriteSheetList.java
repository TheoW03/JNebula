package org.NayaEngine.Tooling;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.io.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.nio.file.Files.copy;

/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * (add ability to remove)
 * @Javadoc
 */
public class SpriteSheetList {
    public String file, type;
    public float[][] spriteTexCoords;
    public Texture texture;
    public GL2 gl;

    public SpriteSheetList(String file,
                           String type,
                           int numRows, int numCols,
                           int spriteWidth, int spriteHeight, int offset) {
        this.file = file;
        this.type = type;
        this.gl = gl;
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

    private void loadSpriteSheet(int spriteHeight, int spriteWidth, int numRows, int numCols, int offset) {
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
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public SpriteSheetList(String file, String type, int numRows, int numCols) throws IOException {
        this.file = file;
        this.type = type;
        spriteTexCoords = new float[numRows * numCols][8];
        loadTexture();
        BufferedImage newImage = new BufferedImage(texture.getWidth(), texture.getHeight(), BufferedImage.TYPE_INT_RGB);
        BufferedImage image = ImageIO.read(new File(file));
        dynamicallyLoadBounds(image);
    }


    public <T> T findMostFrequent(ArrayList<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }

        Map<T, Long> frequencyMap = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return frequencyMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public Color bgColor(BufferedImage img) {
        ArrayList<Color> colors = new ArrayList<>();
        for (int x = 0; x < texture.getWidth(); x++) {
            for (int y = 0; y < texture.getHeight(); y++) {
                int color = img.getRGB(x, y);
                int blue = color & 0xff;
                int green = (color & 0xff00) >> 8;
                int red = (color & 0xff0000) >> 16;

                colors.add(new Color(color));
            }
        }
        return findMostFrequent(colors);

    }

    public Color createColor(int color) {
        int blue = color & 0xff;
        int green = (color & 0xff00) >> 8;
        int red = (color & 0xff0000) >> 16;
        return new Color(color);
    }

    public void calcHeight(ArrayList<Point> a) {

    }

    public void dynamicallyLoadBounds(BufferedImage img) {
        List<Integer> HorizeantleEdges = new ArrayList<>();
        List<Integer> whiteSpace = new ArrayList<>();
        Color bgColor = bgColor(img);
        for (int y = 0; y < img.getHeight(); y++) {
            int count = 0;
            int countWhiteSpace = 0;
            for (int x = 0; x < img.getWidth(); x++) {
                Color c = new Color(img.getRGB(x, y));
                if (c.equals(bgColor)) {
                    if (count != 0) {
                        HorizeantleEdges.add(count);
                        count = 0;
                    }
                    countWhiteSpace++;
                    continue;
                }
                count++;
            }
            whiteSpace.add(countWhiteSpace);
        }
        Optional<Integer> gap = whiteSpace.stream()
                .filter(n -> n != texture.getWidth())
                .max(Integer::compareTo);
        Optional<Integer> count2 = HorizeantleEdges.stream()
                .max(Integer::compareTo);
        Optional<Integer> count2min = HorizeantleEdges.stream()
                .min(Integer::compareTo);
        System.out.println(gap.get());
        System.out.println(count2.get());
        List<Integer> verticleEdges = new ArrayList<>();
//        int x = 0; x < img.getWidth(); x++
        for (int x = 0; x < img.getWidth(); x++) {
            int count = 0;
            for (int y = 0; y < img.getHeight(); y++) {
                Color c = new Color(img.getRGB(x, y));
                if (c.equals(bgColor)) {
                    if (count != 0) {
                        verticleEdges.add(count);
                        count = 0;
                    }
                    continue;
                }
                count++;
            }
        }
        Optional<Integer> count3 = verticleEdges.stream()
                .filter(n -> n != texture.getHeight())
                .max(Integer::compareTo);

        System.out.println(count3.get());


    }


}

