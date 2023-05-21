package org.JNebula.Tooling;


/**
 * @author Theo willis
 * @version 1.0.0
 * ~ project outline here ~
 * @Javadoc
 */
public class Colors {
    public static final String BLUE = "0000FF";
    public static final String RED = "FF0000";
    public static final String GREEN = "00FF00";
    public static final String WHITE = "FFFFFF";
    public static final String BLACK = "000000";

    public float r2,g2,b2;
    public Colors(float r,float g,float b){
        this.r2 =r;
        this.b2 = b;
        this.g2 = g;

    }
    public static float[] colorHex(String color) {
        String r = String.valueOf(color.charAt(0) + color.charAt(1));
        String g = String.valueOf(color.charAt(2) + color.charAt(3));
        String b = String.valueOf(color.charAt(4) + color.charAt(5));
        return new float[]{
                (float) Integer.parseInt(r, 16) / 256,
                (float) Integer.parseInt(g, 16) / 256,
                (float) Integer.parseInt(b, 16) / 256};
    }

    public static float[] colorRGB(int r, int g, int b) {
        return new float[]{
                (float) r / 256,
                (float) g / 256,
                (float) b / 256};
    }

    @Override
    public String toString() {
        return r2 + " "+g2+" "+b2;
    }
}
