import control.Keyboard;
import graphics.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class Game extends Canvas implements Runnable{

    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final String GAME_NAME = "Day-Z";
    private static JFrame gameFrame;
    private static Thread thread;
    private static Keyboard keyboard;
    private static Screen screen;
    private static volatile boolean working;
    private static int x = 0;
    private static int y = 0;

    private static int ups = 0; //Update Per Second
    private static int fps = 0; //Frame Per Second

    //-----Convert image from pixels in RGB------------------------------
    private static final BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private static final int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    private Game() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        screen = new Screen(WIDTH, HEIGHT);

        keyboard = new Keyboard();
        addKeyListener(keyboard);

        gameFrame = new JFrame();
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setResizable(false);
        gameFrame.setLayout(new BorderLayout());
        gameFrame.add(this, BorderLayout.CENTER);
        gameFrame.pack();
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException {

        Game myGame = new Game();
        myGame.initialize();

    }

    private synchronized void initialize(){

        working = true;
        thread = new Thread(this, "Graphics");
        thread.start();
    }

    private synchronized void stop() {

        working = false;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void updateGraphics(){

        keyboard.update();

        if(keyboard.up) y++;
        if(keyboard.down) y--;
        if(keyboard.left) x++;
        if(keyboard.right) x--;

        ups++;
    }

    private void drawGraphics(){

        //---------BufferStrategy help the processor when he draw images--------------
        BufferStrategy bufferStrategy = getBufferStrategy();
        
        if(bufferStrategy == null) {
            createBufferStrategy(3);
            return;
        }

        screen.clean();
        screen.draw(x,y);

        System.arraycopy(screen.pixels,0,pixels,0,pixels.length); //Faster way for copy dates from one array in other
        Graphics g = bufferStrategy.getDrawGraphics();
        g.drawImage(image,0,0,getWidth(),getHeight(),null);
        g.dispose(); //Clean g
        bufferStrategy.show();
        //----------------------------------------------------------------------------
        fps++;
    }

    @Override
    public void run() {

        //-----Image Draw Timer Variables--------------------------
        final int NS_PER_SECOND = 1_000_000_000; //NS: Nano Seconds (1M is total of NS in one Second)
        final byte UPS_TARGET = 60;//UPS: Updates per Second
        final double NS_PER_UPDATE = NS_PER_SECOND / UPS_TARGET;

        long updateReference = System.nanoTime();
        long counterReference = System.nanoTime();

        double timeElapsed;
        double delta = 0;

        //---------------------------------------------------------

        requestFocus(); //Focus on gameFrame

        while(working) { //Main Loop of the Game with image draw timer
            final long startLoop = System.nanoTime();
            timeElapsed = startLoop - updateReference;
            updateReference = startLoop;
            delta += timeElapsed / NS_PER_UPDATE;

            while(delta>=1){
                updateGraphics();
                delta--;
            }
            drawGraphics();

            if(System.nanoTime() - counterReference > NS_PER_SECOND){
                gameFrame.setTitle(GAME_NAME +" || UPS:" +ups+ " || FPS: "+fps);
                ups = 0; fps = 0;
                counterReference = System.nanoTime();
            }
        }
    }
}