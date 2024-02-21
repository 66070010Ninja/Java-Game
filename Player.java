// Import
import javax.swing.*;
import java.awt.*;

// Object Player
public class Player {
    private Image Player;
    private Image Player_move;
    private Image Player_shoot;
    private Image Player_shoot_and_move;
    private int position_x = 0, position_y = 500;
    private int speed = 10;

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
    public void setPostion_X(int x) {
        position_x = x;
    }
    public void setPostion_Y(int y) {
        position_y = y;
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
}
