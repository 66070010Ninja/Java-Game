
//draw menu by pure

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Menu_Draw extends JFrame{
    Dimension ScreenSize;
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
        g.drawImage(img.getBg(), -30, 0, null);
        if (DataBase_Menu.button == 0){
            g.drawImage(img.getPlay(),720, 470, null);
            g.drawImage(img.getExit(), 775, 800, null);
        }
        if (DataBase_Menu.button == 1){
            g.drawImage(img.getPlayHovered(),720, 470, null);
            g.drawImage(img.getExit(), 775, 800, null);
        }
        if (DataBase_Menu.button == 2){
            g.drawImage(img.getPlay(), 720, 470, null);
            g.drawImage(img.getExitHovered(), 775, 800, null);

        }
    }
    //mode menu 
    public void drawModeMenu(){
        
        g.drawImage(img.getBgMode(), -30, 0, null);
        if (DataBase_Menu.button == 0){
            g.drawImage(img.getNormal(),450, 100, null);
            g.drawImage(img.getEndless(),450, 400, null);
        }
        if (DataBase_Menu.button == 1){
            g.drawImage(img.getNormalHovered(),450, 100, null);
            g.drawImage(img.getEndless(),450, 400, null);
        }
        if (DataBase_Menu.button == 2){
            g.drawImage(img.getNormal(),450, 100, null);
            g.drawImage(img.getEndlessHovered(),450, 400, null);
        }
    }
    public void update(Graphics g) {
        repaint();
        paint(g);
     }
    


}
