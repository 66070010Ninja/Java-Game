//mouse action by pure
////////////////

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseMotionListener{
    private DataBase_Menu menu = new DataBase_Menu();

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
}
    }
}

