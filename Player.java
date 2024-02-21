// Import
import javax.swing.*;
import java.awt.*;

// Object Player
public class Player {
    private Image Player;
    private int position_x = 0, position_y = 0;
    private int speed = 10;

    public Player() {
        Player = new ImageIcon("Player/Player.png").getImage();
    }
    public Image getPlayer() {
        return Player;
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
