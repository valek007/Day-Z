package map;

import graphics.Screen;

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

    public void draw(int compensationX, int compensationY, Screen screen){

        int west = compensationX >>5;//ByteShifting == /32
        int east = (compensationX + screen.getWidth()) >>5;
        int north = compensationY >>5;
        int south = (compensationY + screen.getHeight()) >>5;
    }
}
