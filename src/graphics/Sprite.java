package graphics;

import java.awt.*;

public final class Sprite {
    private final int side;
    private int x;
    private int y;
    private SpritesSheet spritesSheet;
    public int[] pixels;

    //-----Sprites Collection-----------------------
    public final static Sprite ASPHALT = new Sprite(32,0,0, SpritesSheet.desert);
    public final static Sprite EMPTY = new Sprite(32,0x000000);

    //----------------------------------------------



    public Sprite(final int side,final int column,final int row, final SpritesSheet spritesSheet) {
        this.side = side;
        this.x = column * side;
        this.y = row * side;
        this.spritesSheet = spritesSheet;

        pixels = new int[side * side];

        for (int i = 0; i < side; i++) { //Extraction of sprites
            for (int j = 0; j < side; j++) {
                pixels[j + i * side] = spritesSheet.pixels[(j + this.x) + (i + this.y) * spritesSheet.getWidth()];
            }
        }
    }

    public Sprite(final int side, final int color) {
        this.side = side;
        pixels = new int[side * side];

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = color;
        }
    }

    public int getSide() {
        return side;
    }
}
