
//menu by pure

import javax.swing.*;
import java.awt.Graphics;
//
import java.awt.event.*;

// JPanel Main_Game
public class Menu extends JPanel implements ActionListener {
    private Timer timer;
    private DataBase database = new DataBase();
    //menu
    private Menu_Draw ddraw;
    // private DataBase_Menu data = new DataBase_Menu();
    public static enum STATE{
        START,
        MENU,
        MODE,
        LEVEL
    };

    //ตัวกำหนดเมนู

    public Menu() {
        timer = new Timer(1, this);
        timer.start();
        setOpaque(false);
        setFocusable(true);
        ddraw = new Menu_Draw();
        // data = new DataBase_Menu();
        setSize((int)database.getScreen().getWidth(), (int)database.getScreen().getHeight());
    }

    // Paint
    public void paint(Graphics g) {
        ddraw.draw(g);
    }

    // repaint
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
