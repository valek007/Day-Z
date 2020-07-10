package graphics;

public final class Sprite {
    private final int side;
    private final int x;
    private final int y;
    private final SpritesSheet spritesSheet;
    public int[] pixels;

    //-----Sprites Collection-----------------------
    public final static Sprite ASPHALT = new Sprite(32,0,0, SpritesSheet.desert);

    //----------------------------------------------



    public Sprite(final int side,final int column,final int row, final SpritesSheet spritesSheet) {
        this.side = side;
        this.x = column * side;
        this.y = row * side;
        this.spritesSheet = spritesSheet;

        pixels = new int[side * side];

        for (int i = 0; i < side; i++) { //Extraction of sprites
            for (int j = 0; j < side; j++) {
                pixels[j + i * side] = spritesSheet.pixels[(j + this.x) + (i + this.y) * spritesSheet.getWidth()];
            }
        }
    }

    public int getSide() {
        return side;
    }
}
