
// Import
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;

// JPanel Main_Game
public class Main_Game extends JPanel implements ActionListener {
    private Timer timer;
    private Blackguard bg;
    private Player player;

    // Main Game
    public Main_Game() {
        bg = new Blackguard();
        player = new Player(bg.getHeight(), bg.getWidth(), 10);
        timer = new Timer(1, this);
        timer.start();
        setOpaque(false);
        setFocusable(true);
        setSize(bg.getWidth(), bg.getHeight());
        addKeyListener(player);
    }

    // Paint
    public void paint(Graphics g) {
        Graphics g2D = (Graphics2D) g;

        // BG
        g2D.drawImage(bg.getBlackguard(), 0, 0, null);

        // Player (Animation)
        if ((player.upPressed == true || player.downPressed == true || player.leftPressed == true
                || player.rightPressed == true) && player.attackPressed == true) {
            g2D.drawImage(player.getPlayer_Shoot_and_Move(), player.getPosition_X(), player.getPosition_Y(), null);
        } else if (player.upPressed == true || player.downPressed == true || player.leftPressed == true
                || player.rightPressed == true) {
            g2D.drawImage(player.getPlayer_Move(), player.getPosition_X(), player.getPosition_Y(), null);
        } else if (player.attackPressed == true) {
            g2D.drawImage(player.getPlayer_Shoot(), player.getPosition_X(), player.getPosition_Y(), null);
        } else {
            g2D.drawImage(player.getPlayer(), player.getPosition_X(), player.getPosition_Y(), null);
        }

        // Bullet (Movement)
        for (int i = 0; i < player.getBullets().size(); i++) {
            g2D.drawImage(player.getBullets().get(i).getBullet_Player(), player.getBullets().get(i).getPosition_X(), player.getBullets().get(i).getPosition_Y(), getFocusCycleRootAncestor());
        }
    }

    // Draw and Update
    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        player.updateBullet();
        repaint();
    }

    // Contro Player
    public void update() {
        if (player.upPressed == true && player.getPosition_Y() >= 500) {
            player.setPostion_Y(player.getPosition_Y() - player.getSpeed());
        }
        if (player.downPressed == true && player.getPosition_Y() <= bg.getHeight() - player.getHeight() * 2) {
            player.setPostion_Y(player.getPosition_Y() + player.getSpeed());
        }
        if (player.leftPressed == true && player.getPosition_X() >= 0) {
            player.setPostion_X(player.getPosition_X() - player.getSpeed());
        }
        if (player.rightPressed == true && player.getPosition_X() <= bg.getWidth() - player.getWidth()) {
            player.setPostion_X(player.getPosition_X() + player.getSpeed());
        }
        if (player.attackPressed == true) {
            player.addBullet(new Bullet(player.getPosition_X(), player.getPosition_Y(), 15));
        }
    }
}
