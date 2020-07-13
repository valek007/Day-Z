package map.tile;

import graphics.Screen;
import graphics.Sprite;

public class Tile {

    public final static int SIDE = 32;

    private int x;
    private int y;

    public Sprite sprite;

    //-----Tiles Collection--------------------

    public final static Tile EMPTY = new Tile(Sprite.EMPTY);
    public final static Tile BLUE_UP_LEFT_CORNER = new Tile(Sprite.BLUE_UP_LEFT_CORNER);
    public final static Tile BLUE_UP_BORDER = new Tile(Sprite.BLUE_UP_BORDER);
    public final static Tile BLUE_UP_RIGHT_CORNER = new Tile(Sprite.BLUE_UP_RIGHT_CORNER);
    public final static Tile BLUE_LEFT_BORDER = new Tile(Sprite.BLUE_LEFT_BORDER);
    public final static Tile BLUE_TILE = new Tile(Sprite.BLUE_TILE);
    public final static Tile BLUE_RIGHT_BORDER = new Tile(Sprite.BLUE_RIGHT_BORDER);
    public final static Tile BLUE_DOWN_LEFT_CORNER = new Tile(Sprite.BLUE_DOWN_LEFT_CORNER );
    public final static Tile BLUE_DOWN_BORDER = new Tile(Sprite.BLUE_DOWN_BORDER);
    public final static Tile BLUE_DOWN_RIGHT_CORNER = new Tile(Sprite.BLUE_DOWN_RIGHT_CORNER);
    public final static Tile BLUE_DOWN_DOOR = new Tile(Sprite.BLUE_DOWN_DOOR);
    public final static Tile BLUE_RIGHT_DOOR = new Tile(Sprite.BLUE_RIGHT_DOOR);
    public final static Tile BLUE_LEFT_DOOR = new Tile(Sprite.BLUE_LEFT_DOOR);
    public final static Tile BLUE_DOUBLE_SMALL_LEFT_CORNER = new Tile(Sprite.BLUE_DOUBLE_SMALL_LEFT_CORNER);
    public final static Tile BLUE_VERTICAL_DOUBLE_BORDER = new Tile(Sprite.BLUE_VERTICAL_DOUBLE_BORDER);
    public final static Tile BLUE_DOUBLE_SMALL_RIGHT_CORNER = new Tile(Sprite.BLUE_DOUBLE_SMALL_RIGHT_CORNER);
    public final static Tile BLUE_DOUBLE_SMALL_DOWN_CORNER = new Tile(Sprite.BLUE_DOUBLE_SMALL_DOWN_CORNER);
    public final static Tile RED_UP_LEFT_CORNER = new Tile(Sprite.RED_UP_LEFT_CORNER);
    public final static Tile RED_UP_BORDER = new Tile(Sprite.RED_UP_BORDER);
    public final static Tile RED_UP_RIGHT_CORNER = new Tile(Sprite.RED_UP_RIGHT_CORNER);
    public final static Tile RED_LEFT_BORDER = new Tile(Sprite.RED_LEFT_BORDER);
    public final static Tile RED_TILE  = new Tile(Sprite.RED_TILE );
    public final static Tile RED_RIGHT_BORDER = new Tile(Sprite.RED_RIGHT_BORDER);
    public final static Tile RED_DOWN_LEFT_CORNER = new Tile(Sprite.RED_DOWN_LEFT_CORNER);
    public final static Tile RED_DOWN_BORDER = new Tile(Sprite.RED_DOWN_BORDER);
    public final static Tile RED_DOWN_RIGHT_CORNER = new Tile(Sprite.RED_DOWN_RIGHT_CORNER);
    public final static Tile RED_LEFT_DOOR = new Tile(Sprite.RED_LEFT_DOOR);
    public final static Tile RED_RIGHT_DOOR = new Tile(Sprite.RED_RIGHT_DOOR);
    public final static Tile RED_SPECIAL_DOOR = new Tile(Sprite.RED_SPECIAL_DOOR);
    public final static Tile RED_DOUBLE_SMALL_LEFT_CORNER = new Tile(Sprite.RED_DOUBLE_SMALL_LEFT_CORNER);
    public final static Tile RED_UP_SMALL_LEFT_CORNER = new Tile(Sprite.RED_UP_SMALL_LEFT_CORNER);
    public final static Tile RED_DOUBLE_SMALL_RIGHT_CORNER = new Tile(Sprite.RED_DOUBLE_SMALL_RIGHT_CORNER);
    public final static Tile TOP_BLOCK = new Tile(Sprite.TOP_BLOCK);
    public final static Tile BACKGROUND_WALL_COLOR = new Tile(Sprite.BACKGROUND_WALL_COLOR);
    public final static Tile TOP_ZEBRA_BLOCK = new Tile(Sprite.TOP_ZEBRA_BLOCK);
    public final static Tile FIRST_COMPUTER_BLOCK = new Tile(Sprite.FIRST_COMPUTER_BLOCK);
    public final static Tile SECOND_COMPUTER_BLOCK = new Tile(Sprite.SECOND_COMPUTER_BLOCK);
    public final static Tile ZEBRA_BLOCK = new Tile(Sprite.ZEBRA_BLOCK);
    public final static Tile WALL_BLOCK = new Tile(Sprite.WALL_BLOCK);

    //-----------------------------------------

    public Tile(Sprite sprite) {
        this.sprite = sprite;
    }

    //---Tile draws himself------------------------
    public void draw(int x, int y, Screen screen){
        screen.drawTile(x << 5, y << 5,this);
    }

    public boolean solid(){
        return false;
    }
}
