package map.tile;

import graphics.Screen;
import graphics.Sprite;

public abstract class Tile {

    private int x;
    private int y;

    public Sprite sprite;

    //-----Tiles Collection--------------------

    public final static Tile ASPHALT = new AsphaltTile(Sprite.ASPHALT);

    //-----------------------------------------

    public Tile(Sprite sprite) {
        this.sprite = sprite;
    }

    public void draw(int x, int y, Screen screen){

    }

    public boolean solid(){
        return false;
    }
}
