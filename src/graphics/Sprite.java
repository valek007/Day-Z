package graphics;

public final class Sprite {
    private final int side;
    private int x;
    private int y;
    private final SpritesSheet spritesSheet;

    public int[] pixels;


    public Sprite(final int side,final int column,final int row, final SpritesSheet spritesSheet) {
        this.side = side;
        this.x = column * side;
        this.y = row * side;
        this.spritesSheet = spritesSheet;

        pixels = new int[this.side*this.side];

        for (int i = 0; i < side; i++) { //Extraction of sprites
            for (int j = 0; j < side; j++) {
                pixels[j + i * side] = spritesSheet.pixels[(x + this.x) + (y + this.y) * spritesSheet.getWidth()];
            }
        }
    }
}
