package map;

import graphics.Sprite;
import map.tile.Tile;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MapLoader extends Map{

    private int[] pixels;

    public MapLoader(String route) {
        super(route);
    }

    protected void loadMap(String route){
        try {
            BufferedImage image = ImageIO.read(MapLoader.class.getResource(route));
            width = image.getWidth();
            height = image.getHeight();

            tileCatalog = new Tile[width * height];
            pixels = new int[width * height];
            image.getRGB(0, 0, width, height, pixels, 0, width);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void createMap(){

        for (int i = 0; i < pixels.length; i++) {

            switch (pixels[i]){
                case 0xff293597: tileCatalog[i] = Tile.BLUE_UP_LEFT_CORNER; continue;
                case 0xff2c3fc1: tileCatalog[i] = Tile.BLUE_UP_BORDER; continue;
                case 0xff272e70: tileCatalog[i] = Tile.BLUE_UP_RIGHT_CORNER; continue;
                case 0xff354fda: tileCatalog[i] = Tile.BLUE_LEFT_BORDER; continue;
                case 0xff7588d8: tileCatalog[i] = Tile.BLUE_TILE; continue;
                case 0xff313758: tileCatalog[i] = Tile.BLUE_RIGHT_BORDER; continue;
                case 0xff354181: tileCatalog[i] = Tile.BLUE_DOWN_LEFT_CORNER; continue;
                case 0xff283390: tileCatalog[i] = Tile.BLUE_DOWN_BORDER; continue;
                case 0xff2d356d: tileCatalog[i] = Tile.BLUE_DOWN_RIGHT_CORNER; continue;
                case 0xff32bac3: tileCatalog[i] = Tile.BLUE_DOWN_DOOR; continue;
                case 0xff36848a: tileCatalog[i] = Tile.BLUE_RIGHT_DOOR; continue;
                case 0xff2ca3ad: tileCatalog[i] = Tile.BLUE_LEFT_DOOR; continue;
                case 0xff4a6b95: tileCatalog[i] = Tile.BLUE_DOUBLE_SMALL_LEFT_CORNER; continue;
                case 0xff273ad5: tileCatalog[i] = Tile.BLUE_VERTICAL_DOUBLE_BORDER; continue;
                case 0xff447c80: tileCatalog[i] = Tile.BLUE_DOUBLE_SMALL_RIGHT_CORNER; continue;
                case 0xff2ba1a9: tileCatalog[i] = Tile.BLUE_DOUBLE_SMALL_DOWN_CORNER; continue;
                case 0xff220c0c: tileCatalog[i] = Tile.RED_UP_LEFT_CORNER; continue;
                case 0xff8d623a: tileCatalog[i] = Tile.RED_UP_BORDER; continue;
                case 0xffb6814e: tileCatalog[i] = Tile.RED_UP_RIGHT_CORNER; continue;
                case 0xffe07821: tileCatalog[i] = Tile.RED_LEFT_BORDER; continue;
                case 0xffddae7f: tileCatalog[i] = Tile.RED_TILE; continue;
                case 0xffd27228: tileCatalog[i] = Tile.RED_RIGHT_BORDER; continue;
                case 0xff7f4d29: tileCatalog[i] = Tile.RED_DOWN_LEFT_CORNER; continue;
                case 0xff7f6246: tileCatalog[i] = Tile.RED_DOWN_BORDER; continue;
                case 0xffc08b57: tileCatalog[i] = Tile.RED_DOWN_RIGHT_CORNER; continue;
                case 0xffe5bf41: tileCatalog[i] = Tile.RED_LEFT_DOOR; continue;
                case 0xffdcad4b: tileCatalog[i] = Tile.RED_RIGHT_DOOR; continue;
                case 0xffdcb22f: tileCatalog[i] = Tile.RED_SPECIAL_DOOR; continue;
                case 0xffe6934c: tileCatalog[i] = Tile.RED_DOUBLE_SMALL_LEFT_CORNER; continue;
                case 0xffb0642d: tileCatalog[i] = Tile.RED_UP_SMALL_LEFT_CORNER; continue;
                case 0xff95694a: tileCatalog[i] = Tile.RED_DOUBLE_SMALL_RIGHT_CORNER; continue;
                case 0xffaa43ac: tileCatalog[i] = Tile.TOP_BLOCK; continue;
                case 0xff382f10: tileCatalog[i] = Tile.BACKGROUND_WALL_COLOR; continue;
                case 0xff632635: tileCatalog[i] = Tile.TOP_ZEBRA_BLOCK; continue;
                case 0xff77316a: tileCatalog[i] = Tile.FIRST_COMPUTER_BLOCK; continue;
                case 0xffd568d7: tileCatalog[i] = Tile.SECOND_COMPUTER_BLOCK; continue;
                case 0xffe55b87: tileCatalog[i] = Tile.ZEBRA_BLOCK; continue;
                case 0xff864287: tileCatalog[i] = Tile.WALL_BLOCK; continue;
                default: tileCatalog[i] = Tile.EMPTY;

            }
        }
    }
}
