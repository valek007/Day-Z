package graphics;

import map.tile.Tile;

import java.util.Arrays;

public final class Screen {

    public final int[] pixels;
    private final int width;
    private final int height;
    private int differenceX;
    private int differenceY;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;

        pixels = new int[width * height];
    }

    public void clean(){ //Leave the black screen
        Arrays.fill(pixels, 0);
    }

    public void drawTile(int compensationX, int compensationY, Tile tile){

        compensationX -= differenceX;
        compensationY -= differenceY;

        for (int i = 0; i < tile.sprite.getSide(); i++) {
            int positionY = i + compensationY;
            for (int j = 0; j < tile.sprite.getSide(); j++) {
                int positionX = j + compensationX;
                if(positionX < 0 || positionX >= width || positionY < 0 || positionY >= height) break; //Limit map output
                pixels[positionX + positionY * width] = tile.sprite.pixels[j + i * tile.sprite.getSide()];//Draw Tile on Screen
            }
        }
    }

    public void establishDifference(final int differenceX,final int differenceY){
        this.differenceX = differenceX;
        this.differenceY = differenceY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
