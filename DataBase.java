
import java.awt.*;
import javax.swing.*;

public class DataBase {
    // DataBase
    private final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private final boolean start = true;
    private final int FPS = 60;
    private final int target_time = (int)Math.pow(10, 9) / FPS;
    private final int count_dead = 100;

    // Menu Pause
    private final Image BG_Pause = new ImageIcon(getClass().getResource("/Img/Pause/Pause.png")).getImage();

    // Victory
    private final Image Victory_Image = new ImageIcon(getClass().getResource("/Img/Victory/Victory.png")).getImage();

    // Item
    private final Image Item_DM2 = new ImageIcon(getClass().getResource("/Img/Item/Icon-DM2.png")).getImage();
    private final Image Item_Explosion = new ImageIcon(getClass().getResource("/Img/Item/Icon-Explosion.png")).getImage();
    private final Image Item_FR2 = new ImageIcon(getClass().getResource("/Img/Item/Icon-FR2.png")).getImage();
    private final Image Item_Heal = new ImageIcon(getClass().getResource("/Img/Item/Icon-Heal.png")).getImage();
    private final Image Item_Type_Bullet_01 = new ImageIcon(getClass().getResource("/Img/Item/Icon-Mmain.png")).getImage();
    private final Image Item_Type_Bullet_02 = new ImageIcon(getClass().getResource("/Img/Item/Icon-RK.png")).getImage();
    private final Image Item_Type_Bullet_03 = new ImageIcon(getClass().getResource("/Img/Item/Icon-RP.png")).getImage();
    private final Image Item_Type_Bullet_04 = new ImageIcon(getClass().getResource("/Img/Item/Icon-SP.png")).getImage();
    private final float Item_speed = 3f;

    // Null
    private final Image null_Image = new ImageIcon(getClass().getResource("/Img/Dead/Null.png")).getImage();

    // Dead
    private final Image dead_Image = new ImageIcon(getClass().getResource("/Img/Dead/Dead.gif")).getImage();

    // HP
    private final Image Max_HP_Image = new ImageIcon(getClass().getResource("/Img/HP/HP_02.png")).getImage();
    private final Image HP_Image = new ImageIcon(getClass().getResource("/Img/HP/HP_01.png")).getImage();

    // HP Player
    private final Image player_HP_Image = new ImageIcon(getClass().getResource("/Img/HP/health-UI1.png")).getImage();
    private final Image player_HP_Null_Image = new ImageIcon(getClass().getResource("/Img/HP/health-UI-heal1.png")).getImage();

    // Player
    private final Image player_Image = new ImageIcon(getClass().getResource("/Img/Player/Player.png")).getImage();
    private final Image player_get_damege_Image = new ImageIcon(getClass().getResource("/Img/Player/Player_GetDamage.gif")).getImage();
    private final int player_hp = 100;
    private final float player_speed = 5f;
    private final int player_time_golden = 1000;
    private int type_bullet_player = 1;
    private int player_attack = 50;

    // Icon
    private final Image icon_bullet_type_01 = new ImageIcon(getClass().getResource("/Img/Icon/Main-UI1.png")).getImage();
    private final Image icon_bullet_type_02 = new ImageIcon(getClass().getResource("/Img/Icon/Rocket-UI1.png")).getImage();
    private final Image icon_bullet_type_03 = new ImageIcon(getClass().getResource("/Img/Icon/RP-UI1.png")).getImage();
    private final Image icon_bullet_type_04 = new ImageIcon(getClass().getResource("/Img/Icon/SP-UI1.png")).getImage();
    private final Image Change_Type_Bullet_01 = new ImageIcon(getClass().getResource("/Img/Icon/Main-UI-change.gif")).getImage();
    private final Image Change_Type_Bullet_02 = new ImageIcon(getClass().getResource("/Img/Icon/Rocket-UI-change.gif")).getImage();
    private final Image Change_Type_Bullet_03 = new ImageIcon(getClass().getResource("/Img/Icon/RP-UI-change.gif")).getImage();
    private final Image Change_Type_Bullet_04 = new ImageIcon(getClass().getResource("/Img/Icon/SP-UI-change.gif")).getImage();
    private final Image Icon_DM2_Image = new ImageIcon(getClass().getResource("/Img/Icon/Icon-DM2.gif")).getImage();
    private final Image Icon_FR2_Image = new ImageIcon(getClass().getResource("/Img/Icon/Icon-FR2.gif")).getImage();
    private final int delay_change_bullet = 100;
    private final int time_use_icon_DM2 = 1000;
    private final int time_use_icon_FR2 = 1000;

    // Bullet
    private final Image bullet_player_Type_01_Image = new ImageIcon(getClass().getResource("/Img/Bullet/Bullet_Player_Type_01.png")).getImage();
    private final Image bullet_player_Type_02_Image = new ImageIcon(getClass().getResource("/Img/Bullet/Bullet_Player_Type_02.gif")).getImage();
    private final Image bullet_player_Type_03_Image = new ImageIcon(getClass().getResource("/Img/Bullet/Bullet_Player_Type_03.gif")).getImage();
    private final Image bullet_player_Type_04_Image = new ImageIcon(getClass().getResource("/Img/Bullet/Bullet_Player_Type_04.png")).getImage();
    private final float bullet_player_speed_Type_01 = 8f;
    private final float bullet_player_speed_Type_02 = 8f;
    private final float bullet_player_speed_Type_03 = 8f;
    private final float bullet_player_speed_Type_04 = 8f;
    private final int reload_bullet_Type_01 = 100;
    private final int reload_bullet_Type_02 = 200;
    private final int reload_bullet_Type_03 = 30;
    private final int reload_bullet_Type_04 = 100;

    // Enemy 01
    private final Image enemy_01_Image = new ImageIcon(getClass().getResource("/Img/Enemy/Enemy_01.gif")).getImage();
    private final int enemy_01_hp = 100;
    private final float enemy_01_speed = 3f;
    private final int enemy_01_reload_bullet = 500;
    private final int enemy_01_attack = 20;

    // Enemy 02
    private final Image enemy_02_Image = new ImageIcon(getClass().getResource("/Img/Enemy/Enemy_02.gif")).getImage();
    private final Image enemy_02_turn_back_Image = new ImageIcon(getClass().getResource("/Img/Enemy/Enemy_02_Turn_Back.gif")).getImage();
    private final int enemy_02_hp = 100;
    private final float enemy_02_speed = 5f;
    private final int enemy_02_attack = 20;

    // Enemy 03
    private final Image enemy_03_Image = new ImageIcon(getClass().getResource("/Img/Enemy/Enemy_03.gif")).getImage();
    private final int enemy_03_hp = 100;
    private final float enemy_03_speed = 3f;
    private final int enemy_03_reload_bullet = 300;
    private final int enemy_03_attack = 20;

    // Enemy 04
    private final Image enemy_04_Image = new ImageIcon(getClass().getResource("/Img/Enemy/Enemy_04.gif")).getImage();
    private final int enemy_04_hp = 100;
    private final float enemy_04_speed = 2f;
    private final int enemy_04_reload_bullet = 500;
    private final int time_attack = 100;
    private final int enemy_04_attack = 20;

    // Enemy 05
    private final Image enemy_05_Image = new ImageIcon(getClass().getResource("/Img/Enemy/Enemy_05.gif")).getImage();
    private final int enemy_05_hp = 100;
    private final float enemy_05_speed = 4f;
    private final int enemy_05_reload_bullet = 300;
    private final int enemy_05_attack = 20;

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
    public int getDelay_Change_Bullet() {
        return delay_change_bullet;
    }

    // Image
    public Image getIcon_DM2() {
        return Icon_DM2_Image;
    }
    public Image getIcon_FR2() {
        return Icon_FR2_Image;
    }
    public Image getVictory_Image() {
        return Victory_Image;
    }
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
    public Image getPlayer_Get_Damage_Image() {
        return player_get_damege_Image;
    }
    public Image getBullet_Player_Type_01_Image() {
        return bullet_player_Type_01_Image;
    }
    public Image getBullet_Player_Type_02_Image() {
        return bullet_player_Type_02_Image;
    }
    public Image getBullet_Player_Type_03_Image() {
        return bullet_player_Type_03_Image;
    }
    public Image getBullet_Player_Type_04_Image() {
        return bullet_player_Type_04_Image;
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
    public Image getHP_Player_Image() {
        return player_HP_Image;
    }
    public Image getHP_Player_Null_Image() {
        return player_HP_Null_Image;
    }
    public Image getIcon_Bullet_Type_01() {
        return icon_bullet_type_01;
    }
    public Image getIcon_Bullet_Type_02() {
        return icon_bullet_type_02;
    }
    public Image getIcon_Bullet_Type_03() {
        return icon_bullet_type_03;
    }
    public Image getIcon_Bullet_Type_04() {
        return icon_bullet_type_04;
    }
    public Image getIcon_Change_01_Image() {
        return Change_Type_Bullet_01;
    }
    public Image getIcon_Change_02_Image() {
        return Change_Type_Bullet_02;
    }
    public Image getIcon_Change_03_Image() {
        return Change_Type_Bullet_03;
    }
    public Image getIcon_Change_04_Image() {
        return Change_Type_Bullet_04;
    }
    public Image getItem_DM2_Image() {
        return Item_DM2;
    }
    public Image getItem_Explosion_Image() {
        return Item_Explosion;
    }
    public Image getItem_FR2_Image() {
        return Item_FR2;
    }
    public Image getItem_Heal_Image() {
        return Item_Heal;
    }
    public Image getItem_Type_Bullet_01_Image() {
        return Item_Type_Bullet_01;
    }
    public Image getItem_Type_Bullet_02_Image() {
        return Item_Type_Bullet_02;
    }
    public Image getItem_Type_Bullet_03_Image() {
        return Item_Type_Bullet_03;
    }
    public Image getItem_Type_Bullet_04_Image() {
        return Item_Type_Bullet_04;
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
    public int getTime_Use_DM2() {
        return time_use_icon_DM2;
    }
    public int getTime_Use_FR2() {
        return time_use_icon_FR2;
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
    public float getBullet_Player_Speed_Type_01() {
        return bullet_player_speed_Type_01;
    }
    public float getBullet_Player_Speed_Type_02() {
        return bullet_player_speed_Type_02;
    }
    public float getBullet_Player_Speed_Type_03() {
        return bullet_player_speed_Type_03;
    }
    public float getBullet_Player_Speed_Type_04() {
        return bullet_player_speed_Type_04;
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
    public float getItem_Speed() {
        return Item_speed;
    }

    // Reload
    public int getPlayer_Reload_Bullet_Type_01() {
        return reload_bullet_Type_01;
    }
    public int getPlayer_Reload_Bullet_Type_02() {
        return reload_bullet_Type_02;
    }
    public int getPlayer_Reload_Bullet_Type_03() {
        return reload_bullet_Type_03;
    }
    public int getPlayer_Reload_Bullet_Type_04() {
        return reload_bullet_Type_04;
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
    public int getPlayer_Time_Golden() {
        return player_time_golden;
    }

    public int get_Type_Bullet() {
        return type_bullet_player;
    }

    // UI
    public Image getBG_Pause() {
        return BG_Pause;
    }
}
