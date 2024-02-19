// Import
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Class Player
public class Player extends JPanel implements ActionListener {
    private Image Player;
    private Timer timer;
    private int position_x = 0, position_y = 0;

    public Player() {
        Player = new ImageIcon("Player/Player.png").getImage();
        timer = new Timer(1, this);
        timer.start();
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(Player, position_x, position_y, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        position_x += 1;
        repaint();
    }
}
