package map;

import graphics.Screen;
import map.tile.Tile;

public abstract class Map {

    protected int width;
    protected int height;
    protected int[] tiles;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;

        tiles = new int[width * height];

        createMap();
    }

    public Map(String url){
        loadMap(url);
    }

    private void loadMap(String url) {
    }

    protected void createMap(){

    }

    public void update(){

    }

    public void draw(final int compensationX,final int compensationY,final Screen screen){

        int west = compensationX >>5;//ByteShifting == /32
        int east = (compensationX + screen.getWidth()) >>5;
        int north = compensationY >>5;
        int south = (compensationY + screen.getHeight()) >>5;
    }

    public Tile getTile(final int x, final int y){
        switch (tiles[x + y * width]){
            case 0: return Tile.ASPHALT;
            default: return null;
        }
    }
}
