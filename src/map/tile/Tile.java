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
    /*
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
    public final static Tile RED_SPECIAL_DOOR_RIGHT = new Tile(Sprite.RED_SPECIAL_DOOR_RIGHT);
    public final static Tile RED_SPECIAL_DOOR_LEFT = new Tile(Sprite.RED_SPECIAL_DOOR_LEFT);
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
     */
    //---------------SUBWAY TILES--------------------

    public final static Tile SUBWAY_FLOOR = new Tile(Sprite.SUBWAY_FLOOR);
    public final static Tile SUBWAY_FLOOR_LEFT = new Tile(Sprite.SUBWAY_FLOOR_LEFT);
    public final static Tile SUBWAY_FLOOR_RIGHT = new Tile(Sprite.SUBWAY_FLOOR_RIGHT);
    public final static Tile SUBWAY_FLOOR_UP = new Tile(Sprite.SUBWAY_FLOOR_UP);
    public final static Tile SUBWAY_ENTRY = new Tile(Sprite.SUBWAY_ENTRY);
    public final static Tile SUBWAY_ENTRY_LEFT = new Tile(Sprite.SUBWAY_ENTRY_LEFT);
    public final static Tile SUBWAY_ENTRY_RIGHT = new Tile(Sprite.SUBWAY_ENTRY_RIGHT);
    public final static Tile SUBWAY_CORNER_BOTTOM_LEFT = new Tile(Sprite.SUBWAY_CORNER_BOTTOM_LEFT);
    public final static Tile SUBWAY_CORNER_BOTTOM_RIGHT = new Tile(Sprite.SUBWAY_CORNER_BOTTOM_RIGHT);
    public final static Tile SUBWAY_CORNER_TOP_LEFT = new Tile(Sprite.SUBWAY_CORNER_TOP_LEFT);
    public final static Tile SUBWAY_CORNER_TOP_RIGHT = new Tile(Sprite.SUBWAY_CORNER_TOP_RIGHT);
    public final static Tile SUBWAY_CORNER_TOP_LEFT_WIDE = new Tile(Sprite.SUBWAY_CORNER_TOP_LEFT_WIDE);
    public final static Tile SUBWAY_CORNER_TOP_RIGHT_WIDE = new Tile(Sprite.SUBWAY_CORNER_TOP_RIGHT_WIDE);
    public final static Tile SUBWAY_CORNER_LEFT_IRREGULAR = new Tile(Sprite.SUBWAY_CORNER_LEFT_IRREGULAR);
    public final static Tile SUBWAY_CORNER_RIGHT_IRREGULAR = new Tile(Sprite.SUBWAY_CORNER_RIGHT_IRREGULAR);
    public final static Tile SUBWAY_CORNER_TOP_LEFT_IRREGULAR = new Tile(Sprite.SUBWAY_CORNER_TOP_LEFT_IRREGULAR);
    public final static Tile SUBWAY_CORNER_TOP_RIGHT_IRREGULAR = new Tile(Sprite.SUBWAY_CORNER_TOP_RIGHT_IRREGULAR);
    public final static Tile SUBWAY_EARTH = new Tile(Sprite.SUBWAY_EARTH);
    public final static Tile SUBWAY_WALL = new Tile(Sprite.SUBWAY_WALL);
    public final static Tile SUBWAY_WALL_LEFT = new Tile(Sprite.SUBWAY_WALL_LEFT);
    public final static Tile SUBWAY_WALL_RIGHT = new Tile(Sprite.SUBWAY_WALL_RIGHT);
    public final static Tile SUBWAY_WALL_CENTER = new Tile(Sprite.SUBWAY_WALL_CENTER);
    public final static Tile SUBWAY_DOOR = new Tile(Sprite.SUBWAY_DOOR);
    public final static Tile SUBWAY_ACCESS_CONTROL = new Tile(Sprite.SUBWAY_ACCESS_CONTROL);
    public final static Tile SUBWAY_CARTEL = new Tile(Sprite.SUBWAY_CARTEL);
    public final static Tile SUBWAY_EXTINGUISHER = new Tile(Sprite.SUBWAY_EXTINGUISHER);

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
