//mouse action by pure
////////////////

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseMotionListener, MouseListener{
    private DataBase_Menu menu = new DataBase_Menu();
    private DataBase database = new DataBase();

    @Override
    public void mouseDragged(MouseEvent e) {

    }
    public void mouseMoved (MouseEvent e) {

        int m_x = e.getX();
        int m_y = e.getY();
        if (DataBase_Menu.State == DataBase_Menu.STATE.MENU){
            if ((m_x >= (720) && m_x <= (720) + menu.getWidthPlay())&&(m_y >= 470 && m_y <= 470 + menu.getHeightPlay())){
                DataBase_Menu.button = 1;
            } else if ((m_x >= (775) && m_x <= (775) + menu.getWidthExit())&&(m_y >= 800 && m_y <= 800 + menu.getHeightExit())){
                DataBase_Menu.button = 2;
            // } else if ((m_x >= (1450) && m_x <= (1450) + menu.getWidthCredit())&&(m_y >= 510 && m_y <= 510 + menu.getHeightCredit())){
            //     DataBase_Menu.button = 3;
            } else {
                DataBase_Menu.button = 0;
            }
        } else if (DataBase_Menu.State == DataBase_Menu.STATE.MODE){
            if ((m_x >= (450) && m_x <= (450) + menu.getWidthMode())&&(m_y >= (100) && m_y <= (100) + menu.getHeightMode())){
                DataBase_Menu.button = 1;
            } else if ((m_x >= (450) && m_x <= (450) + menu.getWidthMode())&&(m_y >= (400) && m_y <= (400) + menu.getHeightMode())){
                DataBase_Menu.button = 2;
            } else {
                DataBase_Menu.button = 0;
            }
        } else if (DataBase_Menu.State == DataBase_Menu.STATE.LEVEL_SELECT1){
            if ((m_x >= ((int)database.getScreen().getWidth()/4 + 50 - menu.getWidthLevel()/2) && 
            m_x <= ((int)database.getScreen().getWidth()/4 + 50 - menu.getWidthLevel()/2) + menu.getWidthLevel())
            &&(m_y >= (300) && m_y <= (300) + menu.getHeightLevel())){
                DataBase_Menu.button = 1;
            } else {
                DataBase_Menu.button = 0;
            }
        } else if (DataBase_Menu.State == DataBase_Menu.STATE.PAUSE){
            if ((m_x >= ((int)database.getScreen().getWidth()/2  - menu.getConti().getWidth(null)/2) && 
            m_x <= ((int)database.getScreen().getWidth()/2  - menu.getConti().getWidth(null)/2) + menu.getWidthConti())
            &&(m_y >= (400) && m_y <= (400) + menu.getHeightConti())){
                DataBase_Menu.button = 1;
            } else if ((m_x >= ((int)database.getScreen().getWidth()/2  - menu.getMenu().getWidth(null)/2) && 
            m_x <= ((int)database.getScreen().getWidth()/2  - menu.getMenu().getWidth(null)/2) + menu.getWidthConti())
            &&(m_y >= (600) && m_y <= (600) + menu.getHeightMenu())){
                DataBase_Menu.button = 2;
            } else {
                DataBase_Menu.button = 0;
}
    }
}
    @Override
    public void mouseClicked(MouseEvent e) {
        // int m_x = e.getX();
        // int m_y = e.getY();
        //      if (DataBase_Menu.State == DataBase_Menu.STATE.MENU){
        //         if ((m_x >= (720) && m_x <= (720) + menu.getWidthPlay())&&(m_y >= 470 && m_y <= 470 + menu.getHeightPlay())){
        //             DataBase_Menu.State = DataBase_Menu.STATE.MODE;
        //         } else if ((m_x >= (775) && m_x <= (775) + menu.getWidthExit())&&(m_y >= 800 && m_y <= 800 + menu.getHeightExit())){
        //                 System.exit(1);
        //                 }
        //             }  else if (DataBase_Menu.State == DataBase_Menu.STATE.MODE){
        //                 if ((m_x >= (450) && m_x <= (450) + menu.getWidthMode())&&(m_y >= (100) && m_y <= (100) + menu.getHeightMode())){
        //                     DataBase_Menu.State = DataBase_Menu.STATE.LEVEL_SELECT1;
        //                     // remove(menu);
        //                     // removeMouseListener(this);
        //                     // rungame.start();
        //                 }
        //             } else if (DataBase_Menu.State == DataBase_Menu.STATE.LEVEL_SELECT1){
        //                 if ((m_x >= ((int)database.getScreen().getWidth()/4 + 50 - menu.getWidthLevel()/2) && 
        //                 m_x <= ((int)database.getScreen().getWidth()/4 + 50 - menu.getWidthLevel()/2) + menu.getWidthLevel())
        //                 &&(m_y >= (300) && m_y <= (300) + menu.getHeightLevel())){
        //                     // remove(menu);
        //                     // removeMouseListener(this);
    }
    @Override
    public void mousePressed(MouseEvent e) {
        

    }
    @Override
    public void mouseReleased(MouseEvent e) {
        

    }
    @Override
    public void mouseEntered(MouseEvent e) {
        

    }
    @Override
    public void mouseExited(MouseEvent e) {
        

    }

}
