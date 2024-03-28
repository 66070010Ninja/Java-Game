
import java.awt.*;
import javax.swing.*;

public class DataBase {
    // DataBase
    private final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private final boolean start = true;
    private final int FPS = 60;
    private final int target_time = (int)Math.pow(10, 9) / FPS;
    private final int count_dead = 100;

    // Null
    private final Image null_Image = new ImageIcon(getClass().getResource("/Img/Dead/Null.png")).getImage();

    // Dead
    private final Image dead_Image = new ImageIcon(getClass().getResource("/Img/Dead/Dead.gif")).getImage();

    // HP
    private final Image Max_HP_Image = new ImageIcon(getClass().getResource("/Img/HP/HP_02.png")).getImage();
    private final Image HP_Image = new ImageIcon(getClass().getResource("/Img/HP/HP_01.png")).getImage();

    // Player
    private final Image player_Image = new ImageIcon(getClass().getResource("/Img/Player/Player.png")).getImage();
    private final int player_hp = 100;
    private final float player_speed = 5f;
    private int player_attack = 20;
    private int reload_bullet = 100;

    // Bullet
    private final Image bullet_player_Image = new ImageIcon(getClass().getResource("/Img/Bullet/Bullet_Player.gif")).getImage();
    private final float bullet_player_speed = 5f;

    // Enemy 01
    private final Image enemy_01_Image = new ImageIcon(getClass().getResource("/Img/Enemy/Enemy_01.gif")).getImage();
    private final int enemy_01_hp = 100;
    private final float enemy_01_speed = 3f;
    private final int enemy_01_reload_bullet = 200;
    private final int enemy_01_attack = 10;

    // Enemy 02
    private final Image enemy_02_Image = new ImageIcon(getClass().getResource("/Img/Enemy/Enemy_02.gif")).getImage();
    private final Image enemy_02_turn_back_Image = new ImageIcon(getClass().getResource("/Img/Enemy/Enemy_02_Turn_Back.gif")).getImage();
    private final int enemy_02_hp = 100;
    private final float enemy_02_speed = 5f;
    private final int enemy_02_attack = 10;

    // Enemy 03
    private final Image enemy_03_Image = new ImageIcon(getClass().getResource("/Img/Enemy/Enemy_03.gif")).getImage();
    private final int enemy_03_hp = 100;
    private final float enemy_03_speed = 3f;
    private final int enemy_03_reload_bullet = 300;
    private final int enemy_03_attack = 10;

    // Enemy 04
    private final Image enemy_04_Image = new ImageIcon(getClass().getResource("/Img/Enemy/Enemy_04.gif")).getImage();
    private final int enemy_04_hp = 100;
    private final float enemy_04_speed = 2f;
    private final int enemy_04_reload_bullet = 500;
    private final int time_attack = 100;
    private final int enemy_04_attack = 10;

    // Enemy 05
    private final Image enemy_05_Image = new ImageIcon(getClass().getResource("/Img/Enemy/Enemy_05.gif")).getImage();
    private final int enemy_05_hp = 100;
    private final float enemy_05_speed = 4f;
    private final int enemy_05_reload_bullet = 300;
    private final int enemy_05_attack = 10;

    // Bullet Enemy 01
    private final Image bullet_enemy_01_Image = new ImageIcon(getClass().getResource("/Img/Bullet/Bullet_Enemy_01.gif")).getImage();
    private final float bullet_enemy_01_speed = 5f;

    // Bullet Enemy 03
    private final Image bullet_enemy_03_Image = new ImageIcon(getClass().getResource("/Img/Bullet/Bullet_Enemy_03.png")).getImage();
    private final float bullet_enemy_03_speed = 5f;

    // Bullet Enemy 04
    private final Image bullet_enemy_04_Image = new ImageIcon(getClass().getResource("/Img/Bullet/Bullet_Enemy_04.png")).getImage();

    // Bullet Enemy 05
    private final Image bullet_enemy_05_Image = new ImageIcon(getClass().getResource("/Img/Bullet/Bullet_Enemy_05.png")).getImage();
    private final float bullet_enemy_05_speed = 5f;

    // Back Ground
    private final Image bg_Image = new ImageIcon(getClass().getResource("/Img/Back Ground/bg.gif")).getImage();

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
    public int getCount_Dead() {
        return count_dead;
    }

    // Image
    public Image getBG_Image() {
        return bg_Image;
    }
    public Image getNull_Image() {
        return null_Image;
    }
    public Image getDead_Image() {
        return dead_Image;
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
    public Image getEnemy_02_Turn_Back_Image() {
        return enemy_02_turn_back_Image;
    }
    public Image getEnemy_03_Image() {
        return enemy_03_Image;
    }
    public Image getEnemy_04_Image() {
        return enemy_04_Image;
    }
    public Image getEnemy_05_Image() {
        return enemy_05_Image;
    }
    public Image getBullet_Enemy_01_Image() {
        return bullet_enemy_01_Image;
    }
    public Image getBullet_Enemy_03_Image() {
        return bullet_enemy_03_Image;
    }
    public Image getBullet_Enemy_04_Image() {
        return bullet_enemy_04_Image;
    }
    public Image getBullet_Enemy_05_Image() {
        return bullet_enemy_05_Image;
    }
    public Image getMax_HP_Image() {
        return Max_HP_Image;
    }
    public Image getHP_Image() {
        return HP_Image;
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
    public int getEnemy_04_HP() {
        return enemy_04_hp;
    }
    public int getEnemy_05_HP() {
        return enemy_05_hp;
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
    public float getEnemy_04_Speed() {
        return enemy_04_speed;
    }
    public float getEnemy_05_Speed() {
        return enemy_05_speed;
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
    public float getBullet_Enemy_05_Speed() {
        return bullet_enemy_05_speed;
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
    public int getEnemy_04_Reload_Bullet() {
        return enemy_04_reload_bullet;
    }
    public int getEnemy_05_Reload_Bullet() {
        return enemy_05_reload_bullet;
    }

    // Time Attack
    public int getTime_Attack() {
        return time_attack;
    }
    public int get_Player_Attack() {
        return player_attack;
    }
    public int get_Enemy_01_Attack() {
        return enemy_01_attack;
    }
    public int get_Enemy_02_Attack() {
        return enemy_02_attack;
    }
    public int get_Enemy_03_Attack() {
        return enemy_03_attack;
    }
    public int get_Enemy_04_Attack() {
        return enemy_04_attack;
    }
    public int get_Enemy_05_Attack() {
        return enemy_05_attack;
    }
}
