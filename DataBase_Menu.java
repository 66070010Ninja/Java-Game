//data image by pure

import java.awt.Image;

import javax.swing.ImageIcon;

public class DataBase_Menu{

    public static STATE State = STATE.MENU;
    public static int num = 1;
    public static int button = 1;
    public static boolean run = false;
    public static enum STATE{
        MENU,
        MODE,
        PAUSE,
        LEVEL_SELECT1,
        LEVEL_SELECT2,
        LEVEL_SELECTBOSS,
        LEVEL1,
        LEVEL
        
    };

    //BG
    private final Image bg = new ImageIcon(getClass().getResource("/Img/Back Ground/ocean war.png")).getImage();
    private final Image bg_mode = new ImageIcon(getClass().getResource("/Img/Back Ground/mode_wall.png")).getImage();

    //Button
    private final Image play = new ImageIcon(getClass().getResource("/Img/Menu/Play.png")).getImage().getScaledInstance((int)(1024 / 2), (int)(768 / 2), Image.SCALE_SMOOTH);
    private final Image exit = new ImageIcon(getClass().getResource("/Img/Menu/Exit.png")).getImage().getScaledInstance((int)(1024 / 2.5), (int)(768 / 2.5), Image.SCALE_SMOOTH);
    private final Image credit = new ImageIcon(getClass().getResource("Img/Menu/Credit.png")).getImage().getScaledInstance((int)(768 / 4), (int)(768 / 4), Image.SCALE_SMOOTH);

    //mode
    private final Image normal = new ImageIcon(getClass().getResource("/Img/Menu/NORMAL.png")).getImage();
    private final Image endless = new ImageIcon(getClass().getResource("/Img/Menu/ENDLESS.png")).getImage();

    //level
    private final Image lv1 = new ImageIcon(getClass().getResource("/Img/Level/Level1.png")).getImage().getScaledInstance((int)(959 / 3.5), (int)(914 / 3.5), Image.SCALE_SMOOTH);
    private final Image lv2 = new ImageIcon(getClass().getResource("/Img/Level/Level2.png")).getImage().getScaledInstance((int)(959 / 3.5), (int)(914 / 3.5), Image.SCALE_SMOOTH);
    private final Image boss = new ImageIcon(getClass().getResource("/Img/Level/Boss.png")).getImage().getScaledInstance((int)(633 / 3.5), (int)(851 / 3.5), Image.SCALE_SMOOTH);
    private final Image lv_locked = new ImageIcon(getClass().getResource("/Img/Level/Locked_hovered.png")).getImage().getScaledInstance((int)(959 / 3.5), (int)(914 / 3.5), Image.SCALE_SMOOTH);
    private final Image boss_locked = new ImageIcon(getClass().getResource("/Img/Level/Bosslocked.png")).getImage().getScaledInstance((int)(633 / 3.5), (int)(851 / 3.5), Image.SCALE_SMOOTH);

    //pause
    private final Image conti = new ImageIcon(getClass().getResource("/Img/Pause/Continue.png")).getImage().getScaledInstance((int)(986 / 2.5), (int)(306 / 2.5), Image.SCALE_SMOOTH);
    private final Image menu = new ImageIcon(getClass().getResource("/Img/Pause/Menu.png")).getImage().getScaledInstance((int)(987 / 3.5), (int)(425 / 3.5), Image.SCALE_SMOOTH);
    
    //interact mouse
    private final Image play_tp = new ImageIcon(getClass().getResource("/Img/Menu/Play_hovered.png")).getImage().getScaledInstance((int)(1024 / 2), (int)(768 / 2), Image.SCALE_SMOOTH);
    private final Image exit_tp = new ImageIcon(getClass().getResource("/Img/Menu/Exit_hovered.png")).getImage().getScaledInstance((int)(1024 / 2.5), (int)(768 / 2.5), Image.SCALE_SMOOTH);
    private final Image credit_tp = new ImageIcon(getClass().getResource("/Img/Menu/Credit_hovered.png")).getImage().getScaledInstance((int)(768 / 4), (int)(768 / 4), Image.SCALE_SMOOTH);
    
    private final Image normal_tp = new ImageIcon(getClass().getResource("/Img/Menu/NORMAL_hovered.png")).getImage();
    private final Image endless_tp = new ImageIcon(getClass().getResource("/Img/Menu/ENDLESS_hovered.png")).getImage();
    
    private final Image lv1_tp = new ImageIcon(getClass().getResource("/Img/Level/Level1_hovered.png")).getImage().getScaledInstance((int)(959 / 3.5), (int)(914 / 3.5), Image.SCALE_SMOOTH);;
    private final Image lv2_tp = new ImageIcon(getClass().getResource("/Img/Level/Level2_hovered.png")).getImage().getScaledInstance((int)(959 / 3.5), (int)(914 / 3.5), Image.SCALE_SMOOTH);
    private final Image boss_tp = new ImageIcon(getClass().getResource("/Img/Level/Boss_hovered.png")).getImage().getScaledInstance((int)(633 / 3.5), (int)(851 / 3.5), Image.SCALE_SMOOTH);

    private final Image conti_tp = new ImageIcon(getClass().getResource("/Img/Pause/Continue_h.png")).getImage().getScaledInstance((int)(986 / 2.5), (int)(306 / 2.5), Image.SCALE_SMOOTH);
    private final Image menu_tp = new ImageIcon(getClass().getResource("/Img/Pause/Menu_h.png")).getImage().getScaledInstance((int)(987 / 3.5), (int)(425 / 3.5), Image.SCALE_SMOOTH);
    //Getter img
    //BG
    public Image getBg(){
        return bg;
    }
    public Image getBgMode(){
        return bg_mode;
    }
    //main menu
    public Image getPlay(){
        return play;
    }
    public Image getPlayHovered(){
        return play_tp;
    }
    public Image getExit(){
        return exit;
    }
    public Image getExitHovered(){
        return exit_tp;
    }
    public Image getCredit(){
        return credit;
    }
    public Image getCreditHovered(){
        return credit_tp;
    }
    //mode
    public Image getNormal(){
        return normal;
    }
    public Image getNormalHovered(){
        return normal_tp;
    }
    public Image getEndless(){
        return endless;
    }
    public Image getEndlessHovered(){
        return endless_tp;
    }
    //level
    public Image getLevel1(){
        return lv1;
    }
    public Image getLevel1Hovered(){
        return lv1_tp;
    }
    public Image getLevel2(){
        return lv2;
    }
    public Image getLevel2Hovered(){
        return lv2_tp;
    }
    public Image getBoss(){
        return boss;
    }
    public Image getBossHovered(){
        return boss_tp;
    }
    public Image getLevelLock(){
        return lv_locked;
    }
    public Image getBossLock(){
        return boss_locked;
    }
    //Pause
    public Image getConti(){
        return conti;
    }
    public Image getContiHovered(){
        return conti_tp;
    }
    public Image getMenu(){
        return menu;
    }
    public Image getMenuHovered(){
        return menu_tp;
    }


    //Getter Width & Height
    //bg
    public int getWidthBG() {
        return bg.getWidth(null);
    }
    public int getHeightBG() {
        return bg.getHeight(null);
    }
    //mode
    public int getWidthMode() {
        return normal.getWidth(null);
    }
    public int getHeightMode() {
        return normal.getHeight(null);
    }
    //main menu
    public int getWidthPlay() {
        return play.getWidth(null);
    }
    public int getHeightPlay() {
        return play.getHeight(null);
    }
    public int getWidthExit() {
        return exit.getWidth(null);
    }
    public int getHeightExit() {
        return exit.getHeight(null);
    }
    public int getWidthCredit() {
        return credit.getWidth(null);
    }
    public int getHeightCredit() {
        return credit.getHeight(null);
    }
    //level
    public int getWidthLevel() {
        return lv1.getWidth(null);
    }
    public int getHeightLevel() {
        return lv1.getHeight(null);
    }
    public int getWidthBoss() {
        return boss.getWidth(null);
    }
    public int getHeightBoss() {
        return boss.getHeight(null);
    }
    //pause
    public int getWidthConti() {
        return conti.getWidth(null);
    }
    public int getHeightConti() {
        return conti.getHeight(null);
    }
    public int getWidthMenu() {
        return conti.getWidth(null);
    }
    public int getHeightMenu() {
        return conti.getHeight(null);
    }
    
}