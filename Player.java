
// Import
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

// Object Player
public class Player implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed, attackPressed;
    private Image Player;
    private Image Player_move;
    private Image Player_shoot;
    private Image Player_shoot_and_move;
    private int position_x = 0, position_y = 500;
    private int speed;
    private LinkedList<Bullet> bullets = new LinkedList<Bullet>();
    private Bullet bullet;
    private int height_screen, width_screen;

    // Player
    public Player(int height_screen, int width_screen, int speed) {
        Player = new ImageIcon("Player/Player.png").getImage();
        Player_move = new ImageIcon("Player/Sprite-0002-move.gif").getImage();
        Player_shoot = new ImageIcon("Player/Sprite-0002-shoot.gif").getImage();
        Player_shoot_and_move = new ImageIcon("Player/Sprite-0002-shootandmove.gif").getImage();
        this.height_screen = height_screen;
        this.width_screen = width_screen;
        this.speed = speed;
    }

    // Getter
    public Image getPlayer() {
        return Player;
    }

    public Image getPlayer_Move() {
        return Player_move;
    }

    public Image getPlayer_Shoot() {
        return Player_shoot;
    }

    public Image getPlayer_Shoot_and_Move() {
        return Player_shoot_and_move;
    }

    public int get_Height_Screen() {
        return height_screen;
    }

    public int get_Width_Screen() {
        return width_screen;
    }

    public int getPosition_X() {
        return position_x;
    }

    public int getPosition_Y() {
        return position_y;
    }

    public int getWidth() {
        return Player.getWidth(null);
    }

    public int getHeight() {
        return Player.getHeight(null);
    }

    public int getSpeed() {
        return speed;
    }

    public LinkedList<Bullet> getBullets() {
        return bullets;
    }

    // Setter
    public void setPostion_X(int x) {
        position_x = x;
    }

    public void setPostion_Y(int y) {
        position_y = y;
    }

    // Bullet Player
    public void updateBullet() {
        for (int i = 0; i < bullets.size(); i++) {
            bullet = bullets.get(i);

            if (bullet.getPosition_X() > get_Width_Screen()) {
                removeBullet(bullet);
            }

            bullet.update();
        }
    }

    public void addBullet(Bullet bullet) {
        bullets.add(bullet);
    }

    public void removeBullet(Bullet bullet) {
        bullets.remove(bullet);
    }

    // Get Key Player
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            upPressed = true;
        } else if (code == KeyEvent.VK_DOWN) {
            downPressed = true;
        } else if (code == KeyEvent.VK_LEFT) {
            leftPressed = true;
        } else if (code == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        } else if (code == KeyEvent.VK_NUMPAD0) {
            attackPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            upPressed = false;
        } else if (code == KeyEvent.VK_DOWN) {
            downPressed = false;
        } else if (code == KeyEvent.VK_LEFT) {
            leftPressed = false;
        } else if (code == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        } else if (code == KeyEvent.VK_NUMPAD0) {
            attackPressed = false;
        }
    }
}
