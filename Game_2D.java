
// Import
import javax.swing.*;

// JFrame Game_2D
public class Game_2D extends JFrame {
    private int width = 1920, height = 1080;

    // Game 2D
    public Game_2D() {
        setTitle("Game 2D");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Main_Game main = new Main_Game();
        add(main);

        setSize(width, height);
        setLocation(0, 0);
        setVisible(true);
    }

    // Test Run
    public static void main(String[] args) {
        new Game_2D();
    }
}
