//data image by pure

import java.awt.Image;

import javax.swing.ImageIcon;

public class DataBase_Menu{

    public static STATE State = STATE.MENU;
    public static int num = 1;
    public static int button = 1;
    public static enum STATE{
        MENU,
        MODE,
        LEVEL
    };

    //BG
    private final Image bg = new ImageIcon("Img/Menu/title.png").getImage();
    private final ImageIcon iconbg = new ImageIcon(bg);
    private final Image bg_mode = new ImageIcon("Img/Menu/Mode_select.png").getImage();

    //Button
    private final Image play = new ImageIcon("Img/Menu/Play.png").getImage().getScaledInstance((int)(1024 / 2), (int)(768 / 2), Image.SCALE_DEFAULT);
    private final Image exit = new ImageIcon("Img/Menu/Exit.png").getImage().getScaledInstance((int)(1024 / 2.5), (int)(768 / 2.5), Image.SCALE_DEFAULT);
    private final Image credit = new ImageIcon("Img/Menu/Credit.png").getImage().getScaledInstance((int)(768 / 4), (int)(768 / 4), Image.SCALE_DEFAULT);

    //mode
    private final Image normal = new ImageIcon("Img/Menu/NORMAL.png").getImage();
    private final Image endless = new ImageIcon("Img/Menu/ENDLESS.png").getImage();

    //interact mouse
    private final Image play_tp = new ImageIcon("Img/Menu/Play_hovered.png").getImage().getScaledInstance((int)(1024 / 2), (int)(768 / 2), Image.SCALE_DEFAULT);
    private final Image exit_tp = new ImageIcon("Img/Menu/Exit_hovered.png").getImage().getScaledInstance((int)(1024 / 2.5), (int)(768 / 2.5), Image.SCALE_DEFAULT);
    private final Image credit_tp = new ImageIcon("Img/Menu/Credit_hovered.png").getImage().getScaledInstance((int)(768 / 4), (int)(768 / 4), Image.SCALE_DEFAULT);
    private final Image normal_tp = new ImageIcon("Img/Menu/NORMAL_hovered.png").getImage();
    private final Image endless_tp = new ImageIcon("Img/Menu/ENDLESS_hovered.png").getImage();

    //Getter img
    public ImageIcon getBgIcon(){
        return iconbg;
    }
    
    public Image getBg(){
        return bg;
    }

    public Image getBgMode(){
        return bg_mode;
    }

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

    //Getter Width & Height

    public int getWidthBG() {
        return bg.getWidth(null);
    }

    public int getHeightBG() {
        return bg.getHeight(null);
    }

    public int getWidthMode() {
        return normal.getWidth(null);
    }

    public int getHeightMode() {
        return normal.getHeight(null);
    }

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
    
}