
// Import
import javax.swing.*;
import java.awt.*;

// Object Bullet
public class Bullet {
    private Image Bullet_Player;
    private int speed;
    private int position_x, position_y;

    // Bullet
    public Bullet(int x, int y, int speed) {
        position_x = x;
        position_y = y;
        this.speed = speed;
        Bullet_Player = new ImageIcon("Bullet/Sprite-0003.gif").getImage();
    }

    // Getter
    public Image getBullet_Player() {
        return Bullet_Player;
    }
    public int getSpeed() {
        return speed;
    }
    public int getPosition_X() {
        return position_x;
    }
    public int getPosition_Y() {
        return position_y;
    }

    // Setter
    public void setPostion_X(int x) {
        position_x = x;
    }
    public void setPostion_Y(int y) {
        position_y = y;
    }

    // Update
    public void update() {
        setPostion_X(position_x + speed);
    }
}
