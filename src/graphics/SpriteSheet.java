package graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {

    public final int[] pixels;
    private final int width;
    private final int heigth;

    public SpriteSheet(String url, int width, int heigth) {
        this.width = width;
        this.heigth = heigth;
        pixels = new int[width*heigth];

        try {
            BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(url));
            image.getRGB(0,0,width,heigth,pixels,0,width);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
