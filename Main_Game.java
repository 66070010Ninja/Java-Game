
// Import
import javax.swing.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;

// JPanel Main_Game
public class Main_Game extends JPanel implements ActionListener {
    private int width = 1920, height = 1080;
    private Timer timer;
    private Blackguard bg;
    private Player player;
    private KeyHandler keyH;

    public Main_Game() {
        setOpaque(false);
        bg = new Blackguard();
        player = new Player();
        keyH = new KeyHandler();
        addKeyListener(keyH);
        setFocusable(true);

        setSize(width, height);
        timer = new Timer(1, this);
        timer.start();
    }

    public void paint(Graphics g) {
        Graphics g2D = (Graphics2D) g;
        g2D.drawImage(bg.getBlackguard(), 0, 0, null);
        if ((keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) && keyH.attackPressed == true) {
            g2D.drawImage(player.getPlayer_Shoot_and_Move(), player.getPosition_X(), player.getPosition_Y(), null);
        }
        else if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
            g2D.drawImage(player.getPlayer_Move(), player.getPosition_X(), player.getPosition_Y(), null);
        }
        else if (keyH.attackPressed == true) {
            g2D.drawImage(player.getPlayer_Shoot(), player.getPosition_X(), player.getPosition_Y(), null);
        }
        else {
            g2D.drawImage(player.getPlayer(), player.getPosition_X(), player.getPosition_Y(), null);
        }
    }

    // Draw and Update
    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }

    // Contro Player
    public void update() {
        if (keyH.upPressed == true && player.getPosition_Y() >= 500) {
            player.setPostion_Y(player.getPosition_Y() - player.getSpeed());
        }
        if (keyH.downPressed == true && player.getPosition_Y() <= height - player.getHeight()*2) {
            player.setPostion_Y(player.getPosition_Y() + player.getSpeed());
        }
        if (keyH.leftPressed == true && player.getPosition_X() >= 0) {
            player.setPostion_X(player.getPosition_X() - player.getSpeed());
        }
        if (keyH.rightPressed == true && player.getPosition_X() <= width - player.getWidth()){
            player.setPostion_X(player.getPosition_X() + player.getSpeed());
        }
    }
}
