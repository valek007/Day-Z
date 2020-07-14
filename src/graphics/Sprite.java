package graphics;

public class Sprite {
    private final int side;
    private int x;
    private int y;
    private SpritesSheet spritesSheet;
    public int[] pixels;

    //-----Sprites Collection-----------------------
    public final static Sprite EMPTY = new Sprite(32,0x000000);

    public final static Sprite BLUE_UP_LEFT_CORNER = new Sprite(32,0,0,0,SpritesSheet.office);
    public final static Sprite BLUE_UP_BORDER = new Sprite(32,1,0,0,SpritesSheet.office);
    public final static Sprite BLUE_UP_RIGHT_CORNER = new Sprite(32,2,0,0,SpritesSheet.office);
    public final static Sprite BLUE_LEFT_BORDER = new Sprite(32,0,1,0,SpritesSheet.office);
    public final static Sprite BLUE_TILE = new Sprite(32,1,1,0,SpritesSheet.office);
    public final static Sprite BLUE_RIGHT_BORDER = new Sprite(32,2,1,0,SpritesSheet.office);
    public final static Sprite BLUE_DOWN_LEFT_CORNER = new Sprite(32,0,2,0,SpritesSheet.office);
    public final static Sprite BLUE_DOWN_BORDER = new Sprite(32,1,2,0,SpritesSheet.office);
    public final static Sprite BLUE_DOWN_RIGHT_CORNER = new Sprite(32,2,2,0,SpritesSheet.office);
    public final static Sprite BLUE_DOWN_DOOR = new Sprite(32,3,0,0,SpritesSheet.office);
    public final static Sprite BLUE_RIGHT_DOOR = new Sprite(32,3,1,0,SpritesSheet.office);
    public final static Sprite BLUE_LEFT_DOOR = new Sprite(32,3,2,0,SpritesSheet.office);
    public final static Sprite BLUE_DOUBLE_SMALL_LEFT_CORNER = new Sprite(32,4,0,0,SpritesSheet.office);
    public final static Sprite BLUE_VERTICAL_DOUBLE_BORDER = new Sprite(32,4,1,0,SpritesSheet.office);
    public final static Sprite BLUE_DOUBLE_SMALL_RIGHT_CORNER = new Sprite(32,4,2,0,SpritesSheet.office);
    public final static Sprite BLUE_DOUBLE_SMALL_DOWN_CORNER = new Sprite(32,4,3,0,SpritesSheet.office);
    public final static Sprite RED_UP_LEFT_CORNER = new Sprite(32,5,0,0,SpritesSheet.office);
    public final static Sprite RED_UP_BORDER = new Sprite(32,6,0,0,SpritesSheet.office);
    public final static Sprite RED_UP_RIGHT_CORNER = new Sprite(32,7,0,0,SpritesSheet.office);
    public final static Sprite RED_LEFT_BORDER = new Sprite(32,5,1,0,SpritesSheet.office);
    public final static Sprite RED_TILE = new Sprite(32,6,1,0,SpritesSheet.office);
    public final static Sprite RED_RIGHT_BORDER = new Sprite(32,7,1,0,SpritesSheet.office);
    public final static Sprite RED_DOWN_LEFT_CORNER = new Sprite(32,5,2,0,SpritesSheet.office);
    public final static Sprite RED_DOWN_BORDER = new Sprite(32,6,2,0,SpritesSheet.office);
    public final static Sprite RED_DOWN_RIGHT_CORNER = new Sprite(32,7,2,0,SpritesSheet.office);
    public final static Sprite RED_LEFT_DOOR = new Sprite(32,8,0,0,SpritesSheet.office);
    public final static Sprite RED_RIGHT_DOOR = new Sprite(32,8,1,0,SpritesSheet.office);
    public final static Sprite RED_SPECIAL_DOOR = new Sprite(32,8,2,0,SpritesSheet.office);
    public final static Sprite RED_SPECIAL_DOOR_RIGHT = new Sprite(32,8,2,4,SpritesSheet.office);
    public final static Sprite RED_SPECIAL_DOOR_LEFT = new Sprite(32,8,2,4,SpritesSheet.office);
    public final static Sprite RED_DOUBLE_SMALL_LEFT_CORNER = new Sprite(32,9,0,0,SpritesSheet.office);
    public final static Sprite RED_UP_SMALL_LEFT_CORNER = new Sprite(32,9,1,0,SpritesSheet.office);
    public final static Sprite RED_DOUBLE_SMALL_RIGHT_CORNER = new Sprite(32,9,2,0,SpritesSheet.office);
    public final static Sprite TOP_BLOCK = new Sprite(32,0,3,0,SpritesSheet.office);
    public final static Sprite BACKGROUND_WALL_COLOR = new Sprite(32,1,3,0,SpritesSheet.office);
    public final static Sprite TOP_ZEBRA_BLOCK = new Sprite(32,2,3,0,SpritesSheet.office);
    public final static Sprite FIRST_COMPUTER_BLOCK = new Sprite(32,0,4,0,SpritesSheet.office);
    public final static Sprite SECOND_COMPUTER_BLOCK = new Sprite(32,1,4,0,SpritesSheet.office);
    public final static Sprite ZEBRA_BLOCK = new Sprite(32,2,4,0,SpritesSheet.office);
    public final static Sprite WALL_BLOCK = new Sprite(32,0,5,0,SpritesSheet.office);

    //----------------------------------------------



    public Sprite(final int side,final int column,final int row,final int version, final SpritesSheet spritesSheet) {
        this.side = side;
        this.x = column * side;
        this.y = row * side;
        this.spritesSheet = spritesSheet;

        pixels = new int[side * side];

       loadSprite(version);
    }

    public Sprite(final int side, final int color) {
        this.side = side;
        pixels = new int[side * side];

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = color;
        }
    }

    public int getSide() {
        return side;
    }

    public void loadSprite(int version){

        if(version == 0){
            normalLoad();
        }else{
            handledLoad(version);
        }
    }

    public void normalLoad(){

        for (int i = 0; i < side; i++) { //Extraction of sprites
            for (int j = 0; j < side; j++) {
                pixels[j + i * side] = spritesSheet.pixels[(j + this.x) + (i + this.y) * spritesSheet.getWidth()];
            }
        }
    }

    public void handledLoad(int version){
        int[] temporaryPixels = loadTemporaryPixels();

        switch (version){
            case 1: reverseY(temporaryPixels); break;
            case 2: reverseX(temporaryPixels); break;
            case 3: reverseXY(temporaryPixels); break;
            case 4: rotate90L(temporaryPixels); break;
            case 5: rotate90R(temporaryPixels); break;
            case 6: rotate90L_reverseY(temporaryPixels); break;
            case 7: rotate90D_reverseY(temporaryPixels); break;
            default: normalLoad();
        }
    }

    public int[] loadTemporaryPixels(){

        int[] temporaryPixels = new int[side * side];
        for (int y = 0; y < side; y++) { //Extraction of sprites
            for (int x = 0; x < side; x++) {
                temporaryPixels[x + y * side] = spritesSheet.pixels[(x + this.x) + (y + this.y) * spritesSheet.getWidth()];
            }
        }

        return temporaryPixels;
    }


    //Case 1
    public void reverseX(int[] temporaryPixels){

        int i = 0;
        for (int y = 0; y < side; y++) {
            for (int x = side - 1; x > -1; x--) {
                pixels[i] = temporaryPixels[x + y * side];
                i++;
            }
        }
    }
    //Case 2
    public void reverseY(int[] temporaryPixels){

        int i = 0;
        for (int y = side - 1; y > -1; y--) {
            for (int x = 0; x < side; x++) {
                pixels[i] = temporaryPixels[x + y * side];
                i++;
            }
        }
    }
    //Case 3
    public void reverseXY(int[] temporaryPixels){

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = temporaryPixels[temporaryPixels.length -1 -i];
        }

    }
    //Case 4
    public void rotate90L(int[] temporaryPixels){

        int i = 0;
        for (int x = side - 1; x > -1; x--) {
            for (int y = 0; y < side; y++) {
                pixels[i] = temporaryPixels[x + y * side];
                i++;
            }
        }
    }
    //Case 5
    public void rotate90R(int[] temporaryPixels){

        int i = 0;
        for (int x = 0; x < side; x++) {
            for (int y = side - 1; y > -1; y--) {
                pixels[i] = temporaryPixels[x + y * side];
                i++;
            }
        }

    }
    //Case 6
    public void rotate90L_reverseY(int[] temporaryPixels){
        int i = 0;
        for (int x = 0; x < side; x++) {
            for (int y = 0; y < side; y++) {
                pixels[i] = temporaryPixels[x + y * side];
                i++;
            }
        }

    }
    //Case 7
    public void rotate90D_reverseY(int[] temporaryPixels){
        int i = 0;
        for (int x = side - 1; x > -1; x--) {
            for (int y = side - 1; y > -1; y--) {
                pixels[i] = temporaryPixels[x + y * side];
                i++;
            }
        }
    }

}
