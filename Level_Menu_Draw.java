import java.awt.Graphics;

import javax.swing.JFrame;

public class Level_Menu_Draw extends JFrame{
    private DataBase database = new DataBase();
    //public int width, height;
    private Graphics g;
    private DataBase_Menu img = new DataBase_Menu(); 

    //draw here
    public void draw(Graphics g){
        this.g = g;
        g.drawImage(img.getBgMode(), 0, 0, (int)database.getScreen().getWidth(), (int)database.getScreen().getHeight(), null);
        if (DataBase_Menu.State == DataBase_Menu.STATE.LEVEL_SELECT1){
            drawLevelUnlock1();
        } if (DataBase_Menu.State == DataBase_Menu.STATE.LEVEL_SELECT2){
            //drawLevelUnlock2();
        } if (DataBase_Menu.State == DataBase_Menu.STATE.LEVEL_SELECTBOSS){
            //drawLevelUnlockBoss();
        }
    }
    public void drawLevelUnlock1(){
        if (DataBase_Menu.button == 0){
            g.drawImage(img.getLevel1(), (int)database.getScreen().getWidth()/4 + 50 - img.getWidthLevel()/2, 300, null);
            g.drawImage(img.getLevelLock(), (int)database.getScreen().getWidth()/4 + 500 - img.getWidthLevel()/2, 300, null);
            g.drawImage(img.getBossLock(), (int)database.getScreen().getWidth()/4 + 950 - img.getWidthBoss()/2, 300, null);
        } if (DataBase_Menu.button == 1){
            g.drawImage(img.getLevel1Hovered(), (int)database.getScreen().getWidth()/4 + 50 - img.getWidthLevel()/2, 300, null);
            g.drawImage(img.getLevelLock(), (int)database.getScreen().getWidth()/4 + 500 - img.getWidthLevel()/2, 300, null);
            g.drawImage(img.getBossLock(), (int)database.getScreen().getWidth()/4 + 950 - img.getWidthBoss()/2, 300, null);
        } 
    }
    public void update(Graphics g) {
        repaint();
        paint(g);
     }

}
