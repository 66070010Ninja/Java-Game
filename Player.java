// Import
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Object Player
public class Player implements KeyListener {
    private Image Player;
    private Image Player_move;
    private Image Player_shoot;
    private Image Player_shoot_and_move;
    private int position_x = 0, position_y = 500;
    private int speed = 10;

    // Player
    public Player() {
        Player = new ImageIcon("Player/Player.png").getImage();
        Player_move = new ImageIcon("Player/Sprite-0002-move.gif").getImage();
        Player_shoot = new ImageIcon("Player/Sprite-0002-shoot.gif").getImage();
        Player_shoot_and_move = new ImageIcon("Player/Sprite-0002-shootandmove.gif").getImage();
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
        return  Player_shoot_and_move;
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

    // Setter
    public void setPostion_X(int x) {
        position_x = x;
    }
    public void setPostion_Y(int y) {
        position_y = y;
    }

    // Get Key Player
    public boolean upPressed, downPressed, leftPressed, rightPressed, attackPressed;

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            upPressed = true;
        }
        else if (code == KeyEvent.VK_DOWN) {
            downPressed = true;
        }
        else if (code == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
        else if (code == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
        else if (code == KeyEvent.VK_0) {
            attackPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            upPressed = false;
        }
        else if (code == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        else if (code == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        else if (code == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
        else if (code == KeyEvent.VK_0) {
            attackPressed = false;
        }
    }
}
