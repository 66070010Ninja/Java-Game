
//draw menu by pure

import java.awt.Graphics;

import javax.swing.JFrame;

public class Menu_Draw extends JFrame{
    private DataBase database = new DataBase();
    public int width, height;
    private Graphics g;
    private DataBase_Menu img = new DataBase_Menu(); 


    //draw here
    public void draw(Graphics g){
        this.g = g;
        if (DataBase_Menu.State == DataBase_Menu.STATE.MENU){
            drawStartMenu();
        } if (DataBase_Menu.State == DataBase_Menu.STATE.MODE){
            drawModeMenu();
    }
}
    //start menu
    public void drawStartMenu(){
        g.drawImage(img.getBg(), 0, 0, (int)database.getScreen().getWidth(), (int)database.getScreen().getHeight(), null);
        if (DataBase_Menu.button == 0){
            g.drawImage(img.getPlay(), (int)database.getScreen().getWidth()/2 - img.getPlay().getWidth(null)/2, 470, null);
            g.drawImage(img.getExit(), (int)database.getScreen().getWidth()/2 - img.getExit().getWidth(null)/2, 800, null);
        }
        if (DataBase_Menu.button == 1){
            g.drawImage(img.getPlayHovered(),(int)database.getScreen().getWidth()/2 - img.getPlayHovered().getWidth(null)/2, 470, null);
            g.drawImage(img.getExit(), (int)database.getScreen().getWidth()/2 - img.getExit().getWidth(null)/2, 800, null);
        }
        if (DataBase_Menu.button == 2){
            g.drawImage(img.getPlay(), (int)database.getScreen().getWidth()/2 - img.getPlay().getWidth(null)/2, 470, null);
            g.drawImage(img.getExitHovered(), (int)database.getScreen().getWidth()/2 - img.getExitHovered().getWidth(null)/2, 800, null);

        }
    }
    //mode menu
    public void drawModeMenu(){
        
        g.drawImage(img.getBgMode(), 0, 0, (int)database.getScreen().getWidth(), (int)database.getScreen().getHeight(), null);
        if (DataBase_Menu.button == 0){
            g.drawImage(img.getNormal(), (int)database.getScreen().getWidth()/2 - img.getNormal().getWidth(null)/2, 100, null);
            g.drawImage(img.getEndless(),(int)database.getScreen().getWidth()/2 - img.getEndless().getWidth(null)/2, 400, null);
        }
        if (DataBase_Menu.button == 1){
            g.drawImage(img.getNormalHovered(), (int)database.getScreen().getWidth()/2 - img.getNormalHovered().getWidth(null)/2, 100, null);
            g.drawImage(img.getEndless(),(int)database.getScreen().getWidth()/2 - img.getEndless().getWidth(null)/2, 400, null);
        }
        if (DataBase_Menu.button == 2){
            g.drawImage(img.getNormal(),(int)database.getScreen().getWidth()/2 - img.getNormal().getWidth(null)/2, 100, null);
            g.drawImage(img.getEndlessHovered(),(int)database.getScreen().getWidth()/2 - img.getEndlessHovered().getWidth(null)/2, 400, null);
        }
    }
    public void update(Graphics g) {
        repaint();
        paint(g);
     }
    


}
