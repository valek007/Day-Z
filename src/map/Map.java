package map;

import graphics.Screen;

public abstract class Map {

    private int width;
    private int height;
    private int[] tiles;

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

    public void createMap(){

    }

    public void update(){

    }

    public void draw(int compensationX, int compensationY, Screen screen){

    }
}
