import javax.swing.*;
import java.awt.*;

public class Game extends Canvas implements Runnable{

    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 800;
    private static final int HEIGTH = 600;
    private static final String GAMENAME = "Day-Z";
    private static JFrame gameFrame;
    private static Thread thread;
    private static volatile boolean working;

    private Game() {
        setPreferredSize(new Dimension(WIDTH,HEIGTH));

        gameFrame = new JFrame(GAMENAME);
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
        Thread.sleep(1000);
        myGame.stop();

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
        System.out.println("Thread is stopped");
    }

    @Override
    public void run() {

        while(working) {
            System.out.println("Thread activated");
        }


    }
}