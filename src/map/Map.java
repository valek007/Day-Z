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

    //------Random Tiles---------------------------
    public Tile getTile(final int x, final int y){

        if(x < 0 || y < 0 || x >= width || y >= height){
            return Tile.EMPTY;
        }
        switch (tiles[x + y * width]){
            case 0:
            case 1:
            default: return Tile.EMPTY;
        }
    }
    public Tile getCatalogTile(int position){
        return tileCatalog[position];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
