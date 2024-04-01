
import java.awt.event.*;
import javax.swing.*;

public class Mouse {
    private Button button;
    private Play play = null;
    private Retry retry = null;
    private Exit exit = null;
    private Menu_Button menu_Button = null;
    private Menu_Button_02 menu_Button_02 = null;
    private Menu_Button_03 menu_Button_03 = null;
    private Continue continue1 = null;
    private Victory_Next_Level next_lexl = null;
    private Retry_Victory retry_Victory = null;
    private Credit credit = null;
    private Level_01 level_01 = null;
    private Level_02 level_02 = null;
    private Level_BOSS level_BOSS = null;
    private int x;
    private int y;

    public Mouse (JPanel panel, Button button) {
        if (button instanceof Play) {
            play = (Play)button;
        }
        else if (button instanceof Retry) {
            retry = (Retry)button;
        }
        else if (button instanceof Exit) {
            exit = (Exit)button;
        }
        else if (button instanceof Menu_Button) {
            menu_Button = (Menu_Button)button;
        }
        else if (button instanceof Menu_Button_02) {
            menu_Button_02 = (Menu_Button_02)button;
        }
        else if (button instanceof Continue) {
            continue1 = (Continue)button;
        }
        else if (button instanceof Victory_Next_Level) {
            next_lexl = (Victory_Next_Level)button;
        }
        else if (button instanceof Retry_Victory) {
            retry_Victory = (Retry_Victory)button;
        }
        else if (button instanceof Menu_Button_03) {
            menu_Button_03 = (Menu_Button_03)button;
        }
        else if (button instanceof Credit) {
            credit = (Credit)button;
        }
        else if (button instanceof Level_01) {
            level_01 = (Level_01)button;
        }
        else if (button instanceof Level_02) {
            level_02 = (Level_02)button;
        }
        else if (button instanceof Level_BOSS) {
            level_BOSS = (Level_BOSS)button;
        }

        panel.requestFocus();
        panel.addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e){}
            public void mouseMoved(MouseEvent e){
                x = e.getX();
                y = e.getY();
                boolean check = x >= button.getX() && x <= button.getX()+button.getImage().getWidth(null) && y >= button.getY() && y <= button.getY()+button.getImage().getHeight(null);
                if (check && play != null) {
                    button.setHover(true);
                }
                else if (check && retry != null) {
                    button.setHover(true);
                }
                else if (check && exit != null) {
                    button.setHover(true);
                }
                else if (check && menu_Button != null) {
                    button.setHover(true);
                }
                else if (check && menu_Button_02 != null) {
                    button.setHover(true);
                }
                else if (check && continue1 != null) {
                    button.setHover(true);
                }
                else if (check && next_lexl != null) {
                    button.setHover(true);
                }
                else if (check && retry_Victory != null) {
                    button.setHover(true);
                }
                else if(check && menu_Button_03 != null) {
                    button.setHover(true);
                }
                else if (check && credit != null) {
                    button.setHover(true);
                }
                else if (check && level_01 != null) {
                    button.setHover(true);
                }
                else if (check && level_02 != null) {
                    button.setHover(true);
                }
                else if (check && level_BOSS != null) {
                    button.setHover(true);
                }
                else {
                    button.setHover(false);
                }
            }
        });
        panel.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e){
                if (button.getHover() == true && play  != null) {
                    button.setOnClick(true);
                }
                else if (button.getHover() == true && retry != null) {
                    button.setOnClick(true);
                }
                else if (button.getHover() == true && exit != null) {
                    button.setOnClick(true);
                }
                else if (button.getHover() == true && menu_Button != null) {
                    button.setOnClick(true);
                }
                else if (button.getHover() == true && menu_Button_02 != null) {
                    button.setOnClick(true);
                }
                else if (button.getHover() == true && continue1 != null) {
                    button.setOnClick(true);
                }
                else if (button.getHover() == true && next_lexl != null) {
                    button.setOnClick(true);
                }
                else if (button.getHover() == true && retry_Victory !=null) {
                    button.setOnClick(true);
                }
                else if (button.getHover() == true && menu_Button_03 != null) {
                    button.setOnClick(true);
                }
                else if (button.getHover() == true && credit != null) {
                    button.setOnClick(true);
                }
                else if (button.getHover() == true && level_01 != null) {
                    button.setOnClick(true);
                }
                else if (button.getHover() == true && level_02 != null) {
                    button.setOnClick(true);
                }
                else if (button.getHover() == true && level_BOSS != null) {
                    button.setOnClick(true);
                }
                else {
                    button.setOnClick(false);
                }
            }
            public void mousePressed(MouseEvent e){}
            public void mouseReleased(MouseEvent e){}
            public void mouseEntered(MouseEvent e){}
            public void mouseExited(MouseEvent e){}
        });
    }

    public Button getButton() {
        return button;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
