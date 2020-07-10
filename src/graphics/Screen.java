package graphics;

public final class Screen {

    public final int[] pixels;
    private final int width;
    private final int heigth;

    public Screen(int width, int heigth) {
        this.width = width;
        this.heigth = heigth;

        pixels = new int[this.width * this.heigth];
    }

    public void clean(){ //Leave the black screen
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    public void draw(final int compensationX, final int compensationY){ //Repainting method

        for (int i = 0; i < heigth; i++) {
            int positionY = i + compensationY;
                if(positionY < 0 || positionY >= heigth) continue; //Limit map output
            for (int j = 0; j < width; j++) {
                int positionX = j + compensationX;
                if(positionX < 0 || positionX >= width) continue; //Limit map output
            }
        }

    }
}
