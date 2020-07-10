package graphics;

import map.tile.Tile;

import java.util.Arrays;

public final class Screen {

    public final int[] pixels;
    private final int width;
    private final int height;

    //---temporary Sprite variables-------
    private final static int SPRITE_SIDE = 32;
    private final static int SPRITE_MASK = SPRITE_SIDE-1;

    //------------------------------------

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;

        pixels = new int[width * height];
    }

    public void clean(){ //Leave the black screen
        Arrays.fill(pixels, 0);
    }

    //---temporary (Draw Screen testing)----------
    public void draw(final int compensationX, final int compensationY){ //Repainting method

        for (int i = 0; i < height; i++) {
            int positionY = i + compensationY;
                if(positionY < 0 || positionY >= height) continue; //Limit map output
            for (int j = 0; j < width; j++) {
                int positionX = j + compensationX;
                if(positionX < 0 || positionX >= width) continue; //Limit map output

                //---temporary (Draw Screen testing)----------
                pixels[positionX + positionY * width] = Sprite.ASPHALT.pixels[(j & SPRITE_MASK) + (i & SPRITE_MASK) * SPRITE_SIDE];
            }
        }
    }

    public void drawTile(int compensationX, int compensationY, Tile tile){

        for (int i = 0; i < tile.sprite.getSide(); i++) {
            int positionY = i + compensationY;
            for (int j = 0; j < tile.sprite.getSide(); j++) {
                int positionX = j + compensationX;
                if(positionX < 0 || positionX >= width || positionY < 0 || positionY >= height) break; //Limit map output
                pixels[positionX + positionY * width] = tile.sprite.pixels[j + i * tile.sprite.getSide()];//Draw Tile on Screen
            }
        }

    }
}
