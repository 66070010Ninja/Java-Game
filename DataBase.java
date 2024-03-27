
import java.awt.*;
import javax.swing.*;

public class DataBase {
    // DataBase
    private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private boolean start = true;
    private int FPS = 60;
    private int target_time = (int)Math.pow(10, 9) / FPS;

    // Null
    private Image null_Image = new ImageIcon(getClass().getResource("/Img/Dead/Null.png")).getImage();

    // Player
    private Image player_Image = new ImageIcon(getClass().getResource("/Img/Player/Player.png")).getImage();
    private int player_hp = 100;
    private float player_speed = 5f;
    private int reload_bullet = 100;

    // Bullet
    private Image bullet_player_Image = new ImageIcon(getClass().getResource("/Img/Bullet/Bullet_Player.gif")).getImage();
    private float bullet_player_speed = 5f;

    // Enemy 01
    private Image enemy_01_Image = new ImageIcon(getClass().getResource("/Img/Enemy/Enemy_01.gif")).getImage();
    private int enemy_01_hp = 100;
    private float enemy_01_speed = 3f;
    private int enemy_01_reload_bullet = 200;

    // Enemy 02
    private Image enemy_02_Image = new ImageIcon(getClass().getResource("/Img/Enemy/Enemy_02.gif")).getImage();
    private int enemy_02_hp = 100;
    private float enemy_02_speed = 5f;

    // Enemy 03
    private Image enemy_03_Image = new ImageIcon(getClass().getResource("/Img/Enemy/Enemy_03.gif")).getImage();
    private int enemy_03_hp = 100;
    private float enemy_03_speed = 3f;
    private int enemy_03_reload_bullet = 300;

    // Bullet Enemy 01
    private Image bullet_enemy_01_Image = new ImageIcon(getClass().getResource("/Img/Bullet/Bullet_Enemy_01.gif")).getImage();
    private float bullet_enemy_01_speed = 5f;

    // Bullet Enemy 03
    private Image bullet_enemy_03_Image = new ImageIcon(getClass().getResource("/Img/Bullet/Bullet_Enemy_03.png")).getImage();
    private float bullet_enemy_03_speed = 5f;

    // Back Ground
    private Image bg_Image = new ImageIcon(getClass().getResource("/Img/Back Ground/bg.gif")).getImage();

    // Setter
    public void SetPlayer_Reload_Bullet(int reload_bullet) {
        this.reload_bullet = reload_bullet;
    }

    // Getter
    public Dimension getScreen() {
        return screen;
    }
    public boolean getStart() {
        return start;
    }
    public int getTarget_Time() {
        return target_time;
    }
    public long getSleep(long time) {
        return (target_time - time) / (int)Math.pow(10, 6);
    }

    // Image
    public Image getBG_Image() {
        return bg_Image;
    }
    public Image getNull_Image() {
        return null_Image;
    }
    public Image getPlayer_Image() {
        return player_Image;
    }
    public Image getBullet_Player_Image() {
        return bullet_player_Image;
    }
    public Image getEnemy_01_Image() {
        return enemy_01_Image;
    }
    public Image getEnemy_02_Image() {
        return enemy_02_Image;
    }
    public Image getEnemy_03_Image() {
        return enemy_03_Image;
    }
    public Image getBullet_Enemy_01_Image() {
        return bullet_enemy_01_Image;
    }
    public Image getBullet_Enemy_03_Image() {
        return bullet_enemy_03_Image;
    }

    // HP
    public int getPlayer_HP() {
        return player_hp;
    }
    public int getEnemy_01_HP() {
        return enemy_01_hp;
    }
    public int getEnemy_02_HP() {
        return enemy_02_hp;
    }
    public int getEnemy_03_HP() {
        return enemy_03_hp;
    }

    // Speed
    public float getPlayer_Speed() {
        return player_speed;
    }
    public float getEnemy_01_Speed() {
        return enemy_01_speed;
    }
    public float getEnemy_02_Speed() {
        return enemy_02_speed;
    }
    public float getEnemy_03_Speed() {
        return enemy_03_speed;
    }
    public float getBullet_Player_Speed() {
        return bullet_player_speed;
    }
    public float getBullet_Enemy_01_Speed() {
        return bullet_enemy_01_speed;
    }
    public float getBullet_Enemy_03_Speed() {
        return bullet_enemy_03_speed;
    }

    // Reload
    public int getPlayer_Reload_Bullet() {
        return reload_bullet;
    }
    public int getEnemy_01_Reload_Bullet() {
        return enemy_01_reload_bullet;
    }
    public int getEnemy_03_Reload_Bullet() {
        return enemy_03_reload_bullet;
    }
}
