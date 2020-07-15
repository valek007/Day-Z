package map;

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

    /*protected void createMap(){

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
                case 0xffd6d875: tileCatalog[i] = Tile.RED_SPECIAL_DOOR_RIGHT; continue;
                case 0xffc8cb2f: tileCatalog[i] = Tile.RED_SPECIAL_DOOR_LEFT; continue;
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
    }*/

    protected void createMap(){

        for (int i = 0; i < pixels.length; i++) {

            switch (pixels[i]){
                case 0xffdbd4c0: tileCatalog[i] = Tile.SUBWAY_FLOOR; continue;
                case 0xff908c83: tileCatalog[i] = Tile.SUBWAY_FLOOR_LEFT; continue;
                case 0xff605b50: tileCatalog[i] = Tile.SUBWAY_FLOOR_RIGHT; continue;
                case 0xff7a6737: tileCatalog[i] = Tile.SUBWAY_FLOOR_UP; continue;
                case 0xff70102a: tileCatalog[i] = Tile.SUBWAY_ENTRY; continue;
                case 0xffb80987: tileCatalog[i] = Tile.SUBWAY_ENTRY_LEFT; continue;
                case 0xff873c72: tileCatalog[i] = Tile.SUBWAY_ENTRY_RIGHT; continue;
                case 0xff283390: tileCatalog[i] = Tile.SUBWAY_CORNER_BOTTOM_LEFT; continue;
                case 0xff2d356d: tileCatalog[i] = Tile.SUBWAY_CORNER_BOTTOM_RIGHT; continue;
                case 0xff414593: tileCatalog[i] = Tile.SUBWAY_CORNER_TOP_LEFT; continue;
                case 0xff1219b5: tileCatalog[i] = Tile.SUBWAY_CORNER_TOP_RIGHT; continue;
                case 0xff119331: tileCatalog[i] = Tile.SUBWAY_CORNER_TOP_LEFT_WIDE; continue;
                case 0xff153d1f: tileCatalog[i] = Tile.SUBWAY_CORNER_TOP_RIGHT_WIDE; continue;
                case 0xffbdab83: tileCatalog[i] = Tile.SUBWAY_CORNER_LEFT_IRREGULAR; continue;
                case 0xffbda368: tileCatalog[i] = Tile.SUBWAY_CORNER_RIGHT_IRREGULAR; continue;
                case 0xffd51f50: tileCatalog[i] = Tile.SUBWAY_CORNER_TOP_LEFT_IRREGULAR; continue;
                case 0xffa72e4e: tileCatalog[i] = Tile.SUBWAY_CORNER_TOP_RIGHT_IRREGULAR; continue;
                case 0xffb83636: tileCatalog[i] = Tile.SUBWAY_EARTH; continue;
                case 0xffbea10b: tileCatalog[i] = Tile.SUBWAY_WALL; continue;
                case 0xff0c367d: tileCatalog[i] = Tile.SUBWAY_WALL_LEFT; continue;
                case 0xff1a3561: tileCatalog[i] = Tile.SUBWAY_WALL_RIGHT; continue;
                case 0xffe07821: tileCatalog[i] = Tile.SUBWAY_WALL_CENTER; continue;
                case 0xff656bbd: tileCatalog[i] = Tile.SUBWAY_DOOR; continue;
                case 0xff126b0e: tileCatalog[i] = Tile.SUBWAY_ACCESS_CONTROL; continue;
                case 0xff23d71a: tileCatalog[i] = Tile.SUBWAY_CARTEL; continue;
                case 0xfffeee9d: tileCatalog[i] = Tile.SUBWAY_EXTINGUISHER; continue;
                default: tileCatalog[i] = Tile.EMPTY;
            }
        }
    }
}
