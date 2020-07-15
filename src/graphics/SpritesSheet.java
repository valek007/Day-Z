package graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpritesSheet {

    public final int[] pixels;
    private final int width;
    private final int height;

    //-----SpritesSheet Collection-----------------------
    //public static SpritesSheet office = new SpritesSheet("/textures/spritesSheet.png", 320, 320);

    public static SpritesSheet subway = new SpritesSheet("/textures/spritesSheet2.png", 256, 64);
    public static SpritesSheet player = new SpritesSheet("/hero/rambo-spritesSheet.png", 192, 192);



    //----------------------------------------------

    public SpritesSheet(String route, int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];

        BufferedImage image;
        try {
            image = ImageIO.read(SpritesSheet.class.getResource(route));
            image.getRGB(0,0,width, height, pixels,0,width);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getWidth() {
        return width;
    }
}
