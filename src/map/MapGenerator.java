package map;

import java.util.Random;

public class MapGenerator extends Map{

    private final static Random RANDOM = new Random();

    public MapGenerator(int width, int height) {
        super(width, height);
    }

    protected void createMap(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                tiles[j + i * width] = RANDOM.nextInt(3);
            }
        }
    }
}
