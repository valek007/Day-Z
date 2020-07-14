package graphics;

import entities.creatures.Player;
import map.tile.Tile;

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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void drawTile(int compensationX, int compensationY, Tile tile){

        compensationX -= differenceX;
        compensationY -= differenceY;

        for (int i = 0; i < tile.sprite.getSide(); i++) {
            int positionY = i + compensationY;
            for (int j = 0; j < tile.sprite.getSide(); j++) {
                int positionX = j + compensationX;
                if(positionX < -tile.sprite.getSide() || positionX >= width || positionY < 0 || positionY >= height) break; //Limit map output
                if(positionX < 0) positionX = 0;
                pixels[positionX + positionY * width] = tile.sprite.pixels[j + i * tile.sprite.getSide()];//Draw Tile on Screen
            }
        }
    }

    public void establishDifference(final int differenceX,final int differenceY){
        this.differenceX = differenceX;
        this.differenceY = differenceY;
    }
    
    public void drawPlayer(int compensationX, int compensationY, Player player){

        compensationX -= differenceX;
        compensationY -= differenceY;

        for (int i = 0; i < player.getSprite().getSide(); i++) {
            int positionY = i + compensationY;
            for (int j = 0; j < player.getSprite().getSide(); j++) {
                int positionX = j + compensationX;
                if(positionX < -player.getSprite().getSide() || positionX >= width || positionY < 0 || positionY >= height) break; //Limit map output
                if(positionX < 0) positionX = 0;
                pixels[positionX + positionY * width] = player.getSprite().pixels[j + i * player.getSprite().getSide()];//Draw Player on Screen
            }
        }
    
    }
}
