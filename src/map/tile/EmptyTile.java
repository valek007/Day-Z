package map.tile;

import graphics.Screen;
import graphics.Sprite;

public class EmptyTile extends Tile{

    public EmptyTile(Sprite sprite) {
        super(sprite);
    }

    //---Tile draws himself------------------------
    @Override
    public void draw(int x, int y, Screen screen) {
        screen.drawTile(x, y,this);
    }

    @Override
    public boolean solid() {
        return super.solid();
    }
}
