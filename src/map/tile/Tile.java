package map.tile;

import graphics.Screen;
import graphics.Sprite;

public abstract class Tile {

    private int x;
    private int y;

    public Sprite sprite;

    //-----Tiles Collection--------------------

    public final static Tile ASPHALT = new AsphaltTile(Sprite.ASPHALT);
    public final static Tile EMPTY = new AsphaltTile(Sprite.EMPTY);

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
