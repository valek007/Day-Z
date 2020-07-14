package map;

import graphics.Screen;
import map.tile.Tile;

public abstract class Map {

    protected int width;
    protected int height;
    protected int[] tiles;
    protected  Tile[] tileCatalog;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;

        tiles = new int[width * height];

        createMap();
    }

    public Map(String route){
        loadMap(route);
        createMap();
    }

    protected void loadMap(String route) {
    }

    protected void createMap(){
    }

    public void update(){

    }

    public void draw(final int compensationX,final int compensationY,final Screen screen){

        screen.establishDifference(compensationX, compensationY);

        int west = compensationX >>5;//ByteShifting == /32
        int east = (compensationX + screen.getWidth() + Tile.SIDE) >>5;
        int north = compensationY >>5;
        int south = (compensationY + screen.getHeight() + Tile.SIDE) >>5;

        for (int i = north; i < south; i++) {
            for (int j = west; j < east; j++) {
                //getTile(j, i).draw(j, i, screen); //Random createMap
                if(j < 0 || i < 0 || j >= width || i >= height){
                    Tile.EMPTY.draw(j,i,screen);
                }else{
                    tileCatalog[j + i * width].draw(j,i,screen);
                }
            }
        }
    }

    public Tile getTile(final int x, final int y){

        if(x < 0 || y < 0 || x >= width || y >= height){
            return Tile.EMPTY;
        }
        switch (tiles[x + y * width]){
            case 0: return Tile.BLUE_UP_LEFT_CORNER;
            case 1: return Tile.BLUE_UP_BORDER;
            case 2: return Tile.BLUE_UP_RIGHT_CORNER;
            case 3: return Tile.BLUE_LEFT_BORDER;
            case 4: return Tile.BLUE_TILE;
            case 5: return Tile.BLUE_RIGHT_BORDER;
            case 6: return Tile.BLUE_DOWN_LEFT_CORNER;
            case 7: return Tile.BLUE_DOWN_BORDER;
            case 8: return Tile.BLUE_DOWN_RIGHT_CORNER;
            case 9: return Tile.BLUE_DOWN_DOOR;
            case 10: return Tile.BLUE_RIGHT_DOOR;
            case 11: return Tile.BLUE_LEFT_DOOR;
            case 12: return Tile.BLUE_DOUBLE_SMALL_LEFT_CORNER;
            case 13: return Tile.BLUE_VERTICAL_DOUBLE_BORDER;
            case 14: return Tile.BLUE_DOUBLE_SMALL_RIGHT_CORNER;
            case 15: return Tile.RED_UP_LEFT_CORNER;
            case 16: return Tile.RED_UP_BORDER;
            case 17: return Tile.RED_UP_RIGHT_CORNER;
            case 18: return Tile.RED_LEFT_BORDER;
            case 19: return Tile.RED_TILE;
            case 20: return Tile.RED_RIGHT_BORDER;
            case 21: return Tile.RED_DOWN_LEFT_CORNER;
            case 22: return Tile.RED_DOWN_BORDER;
            case 23: return Tile.RED_DOWN_RIGHT_CORNER;
            case 24: return Tile.RED_LEFT_DOOR;
            case 25: return Tile.RED_RIGHT_DOOR;
            case 26: return Tile.RED_SPECIAL_DOOR;
            case 27: return Tile.RED_DOUBLE_SMALL_LEFT_CORNER;
            case 28: return Tile.RED_UP_SMALL_LEFT_CORNER;
            case 29: return Tile.RED_DOUBLE_SMALL_RIGHT_CORNER;
            case 30: return Tile.TOP_BLOCK;
            case 31: return Tile.BACKGROUND_WALL_COLOR;
            case 32: return Tile.TOP_ZEBRA_BLOCK;
            case 33: return Tile.FIRST_COMPUTER_BLOCK;
            case 34: return Tile.SECOND_COMPUTER_BLOCK;
            case 35: return Tile.ZEBRA_BLOCK;
            case 36: return Tile.WALL_BLOCK;
            case 37: return Tile.RED_SPECIAL_DOOR_RIGHT;

            default: return Tile.EMPTY;
        }
    }
}
