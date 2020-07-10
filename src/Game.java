import control.Keyboard;
import graphics.Screen;
import map.Map;
import map.MapGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class Game extends Canvas implements Runnable{

    private final static ImageIcon icon = new ImageIcon(Game.class.getResource("/icon/icon.png"));
    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final String GAME_NAME = "Day-Z";

    private static JFrame gameFrame;
    private static Thread thread;
    private static Keyboard keyboard;
    private static Screen screen;
    private static Map map;
    private static volatile boolean working;
    private static int x = 0;
    private static int y = 0;

    private static String COUNTER_UPS = "";
    private static String COUNTER_FPS = "";
    private static int ups = 0; //Update Per Second
    private static int fps = 0; //Frame Per Second

    //-----Convert image from pixels in RGB------------------------------
    private static final BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private static final int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    private Game() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        screen = new Screen(WIDTH, HEIGHT);

        map = new MapGenerator(128,128);

        keyboard = new Keyboard();
        addKeyListener(keyboard);

        gameFrame = new JFrame(GAME_NAME);
        gameFrame.setUndecorated(true);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setResizable(false);
        gameFrame.setIconImage(icon.getImage());
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

        if(keyboard.up) y--;
        if(keyboard.down) y++;
        if(keyboard.left) x--;
        if(keyboard.right) x++;
        if(keyboard.escape) System.exit(0);

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
        map.draw(x, y, screen);

        System.arraycopy(screen.pixels,0,pixels,0,pixels.length); //Faster way for copy dates from one array in other
        Graphics g = bufferStrategy.getDrawGraphics();
        g.drawImage(image,0,0,getWidth(),getHeight(),null);
        g.setColor(Color.RED);
        g.fillOval(WIDTH/2,HEIGHT/2,32,32);
        g.drawString(COUNTER_UPS,10,20);
        g.drawString(COUNTER_FPS,10,35);
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

                COUNTER_UPS = "UPS: "+ups;
                COUNTER_FPS = "FPS: "+fps;
                ups = 0; fps = 0;
                counterReference = System.nanoTime();
            }
        }
    }
}