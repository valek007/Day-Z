import javax.swing.*;
import java.awt.*;

public class Game extends Canvas{

    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 800;
    private static final int HEIGTH = 600;
    private static final String GAMENAME = "Day-Z";
    private static JFrame gameFrame;
    private static Thread thread;

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

    public static void main(String[] args) {

        Game myGame = new Game();
    }
}