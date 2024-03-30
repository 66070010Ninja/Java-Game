//menu by pure

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Windows extends JFrame {
    private DataBase database = new DataBase();
    private DataBase_Menu datamenu = new DataBase_Menu();
    private RunGame rungame = new RunGame();
    private Menu menu = new Menu();
    private MouseInput mouse1 = new MouseInput();

    private MDI mdi = new MDI();
    // private Menu_Draw d = new Menu_Draw();

    public Windows() {
        setTitle("Ocean War 2077");
        setSize((int)database.getScreen().getWidth(), (int)database.getScreen().getHeight());
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
        addMouseMotionListener(mouse1);
        addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    int m_x = e.getX();
                    int m_y = e.getY();
                    if (DataBase_Menu.State == DataBase_Menu.STATE.MENU){
                        if ((m_x >= (720) && m_x <= (720) + datamenu.getWidthPlay())&&(m_y >= 470 && m_y <= 470 + datamenu.getHeightPlay())){
                            DataBase_Menu.State = DataBase_Menu.STATE.MODE;
                        } else if ((m_x >= (775) && m_x <= (775) + datamenu.getWidthExit())&&(m_y >= 800 && m_y <= 800 + datamenu.getHeightExit())){
                            System.exit(1);
                        }
                    }
                    else if (DataBase_Menu.State == DataBase_Menu.STATE.MODE){
                        if ((m_x >= (450) && m_x <= (450) + datamenu.getWidthMode())&&(m_y >= (100) && m_y <= (100) + datamenu.getHeightMode())){
                            remove(menu);
                            removeMouseListener(this);
                            rungame.start();
                        }
                    }
                }
            });
        add(mdi);
        add(menu);
        add(rungame);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);
    }

}
