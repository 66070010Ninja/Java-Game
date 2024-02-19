// Import
import javax.swing.*;

// Class Game2D
public class Game2D {
    public int width = 1920, height = 1080;
    private JFrame f1;

    // ประกาศสร้าง class
    public Game2D() {
        f1 = new JFrame("Game 2D");
        MyJPanal p1 = new MyJPanal();
        Player p2 = new Player();

        f1.add(p1);

        f1.setSize(width, height);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setLocation(0, 0);
        f1.setVisible(true);
    }

    // RUN Coding
    public static void main(String[] args) {
        new Game2D();
    }
}
