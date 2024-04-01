
import java.awt.*;
import javax.swing.*;

public class DataBase_Menu {

    // BG
    private final Image bg = new ImageIcon(getClass().getResource("/Img/Back Ground/ocean war.png")).getImage();
    private final Image bg_mode = new ImageIcon(getClass().getResource("/Img/Back Ground/mode_wall.png")).getImage();

    // Button
    private final Image play = new ImageIcon(getClass().getResource("/Img/Menu/Play.png")).getImage();
    private final Image exit = new ImageIcon(getClass().getResource("/Img/Menu/Exit.png")).getImage();
    private final Image credit = new ImageIcon(getClass().getResource("Img/Menu/Credit.png")).getImage();

    // Mode
    private final Image normal = new ImageIcon(getClass().getResource("/Img/Menu/NORMAL.png")).getImage();
    private final Image endless = new ImageIcon(getClass().getResource("/Img/Menu/ENDLESS.png")).getImage();

    // Level
    private final Image lv1 = new ImageIcon(getClass().getResource("/Img/Level/Level1.png")).getImage();
    private final Image lv2 = new ImageIcon(getClass().getResource("/Img/Level/Level2.png")).getImage();
    private final Image boss = new ImageIcon(getClass().getResource("/Img/Level/Boss.png")).getImage();
    private final Image lv_locked = new ImageIcon(getClass().getResource("/Img/Level/Locked_hovered.png")).getImage();
    private final Image boss_locked = new ImageIcon(getClass().getResource("/Img/Level/Bosslocked.png")).getImage();

    // Pause
    private final Image continues = new ImageIcon(getClass().getResource("/Img/Pause/Continue.png")).getImage();
    private final Image menu = new ImageIcon(getClass().getResource("/Img/Pause/Menu.png")).getImage();

    // Game Over
    private final Image retry = new ImageIcon(getClass().getResource("/Img/Game Over/Retry.png")).getImage();
    private final Image menu_02 = new ImageIcon(getClass().getResource("/Img/Game Over/Menu.png")).getImage();

    // Game Victory
    private final Image retry_victory = new ImageIcon(getClass().getResource("/Img/Game Over/Retry.png")).getImage();
    private final Image next_level = new ImageIcon(getClass().getResource("/Img/Victory/Next Level.png")).getImage();

    //interact mouse
    private final Image play_h = new ImageIcon(getClass().getResource("/Img/Menu/Play_hovered.png")).getImage();
    private final Image exit_h = new ImageIcon(getClass().getResource("/Img/Menu/Exit_hovered.png")).getImage();
    private final Image credit_h = new ImageIcon(getClass().getResource("/Img/Menu/Credit_hovered.png")).getImage();
    
    private final Image normal_h = new ImageIcon(getClass().getResource("/Img/Menu/NORMAL_hovered.png")).getImage();
    private final Image endless_h = new ImageIcon(getClass().getResource("/Img/Menu/ENDLESS_hovered.png")).getImage();
    
    private final Image lv1_h = new ImageIcon(getClass().getResource("/Img/Level/Level1_hovered.png")).getImage();
    private final Image lv2_h = new ImageIcon(getClass().getResource("/Img/Level/Level2_hovered.png")).getImage();
    private final Image boss_h = new ImageIcon(getClass().getResource("/Img/Level/Boss_hovered.png")).getImage();

    private final Image continues_h = new ImageIcon(getClass().getResource("/Img/Pause/Continue h.png")).getImage();
    private final Image menu_h = new ImageIcon(getClass().getResource("/Img/Pause/Menu h.png")).getImage();

    private final Image retry_h = new ImageIcon(getClass().getResource("/Img/Game Over/Retry_H.png")).getImage();
    private final Image menu_02_h = new ImageIcon(getClass().getResource("/Img/Game Over/Menu_H.png")).getImage();

    private final Image retry_victory_h = new ImageIcon(getClass().getResource("/Img/Game Over/Retry_H.png")).getImage();
    private final Image next_level_h = new ImageIcon(getClass().getResource("/Img/Victory/Next Level H.png")).getImage();

    private final Image credit_MDI = new ImageIcon(getClass().getResource("/Img/MDI/credit.png")).getImage().getScaledInstance((int)(1920 / 2), (int)(1080 / 2), Image.SCALE_SMOOTH);

    // Getter
    public Image getBG_Image() {
        return bg;
    }
    public Image getBG_Mode_Image() {
        return bg_mode;
    }
    public Image getPlay_Image() {
        return play;
    }
    public Image getExit_Image() {
        return exit;
    }
    public Image getCredit_Image() {
        return credit;
    }
    public Image getPlay_H_Image() {
        return play_h;
    }
    public Image getExit_H_Image() {
        return exit_h;
    }
    public Image getCredit_H_Image() {
        return credit_h;
    }
    public Image getNormal_Image() {
        return normal;
    }
    public Image getEndless_Image() {
        return endless;
    }
    public Image getNormal_H_Image() {
        return normal_h;
    }
    public Image getEndless_H_Image() {
        return endless_h;
    }
    public Image getLevel_01_Image() {
        return lv1;
    }
    public Image getLevel_02_Image() {
        return lv2;
    }
    public Image getBoss_Image() {
        return boss;
    }
    public Image getLevel_Locked_Image() {
        return lv_locked;
    }
    public Image getBoss_Locked_Image() {
        return boss_locked;
    }
    public Image getLevel_01_H_Image() {
        return lv1_h;
    }
    public Image getLevel_02_H_Image() {
        return lv2_h;
    }
    public Image getBoss_H_Image() {
        return boss_h;
    }
    public Image getContinuse_Image() {
        return continues;
    }
    public Image getMenu_Image() {
        return menu;
    }
    public Image getContinuse_H_Image() {
        return continues_h;
    }
    public Image getMenu_H_Image() {
        return menu_h;
    }

    public Image getRetry_Image() {
        return retry;
    }
    public Image getRetry_H_Image() {
        return retry_h;
    }
    public Image getMenu_02_Image() {
        return menu_02;
    }
    public Image getMenu_02_H_Image() {
        return menu_02_h;
    }

    public Image getRetry_Victory_Image() {
        return retry_victory;
    }
    public Image getNext_Level_Image() {
        return next_level;
    }
    public Image getRetry_Victory_H_Image() {
        return retry_victory_h;
    }
    public Image getNext_Level_H_Image() {
        return next_level_h;
    }

    public Image getCredit_DMI_Image() {
        return credit_MDI;
    }

}
