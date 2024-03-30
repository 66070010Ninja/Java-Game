
import java.awt.event.*;
import javax.swing.*;

public class Key {

    private DataBase database = new DataBase();
    private boolean key_up;
    private boolean key_down;
    private boolean key_right;
    private boolean key_left;
    private Thread thread;

    public Key(Player player, JPanel panel) {
        panel.requestFocus();
        panel.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W && player.getEnemy_Left() != 0 && !player.getPause()) {
                    set_Key_Up(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_S && player.getEnemy_Left() != 0 && !player.getPause()) {
                    set_Key_Down(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_A && player.getEnemy_Left() != 0 && !player.getPause()) {
                    set_Key_Left(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_D && player.getEnemy_Left() != 0 && !player.getPause()) {
                    set_Key_Right(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (player.getPause() == false) {
                        player.setPause(true);
                    }
                    else {
                        player.setPause(false);
                    }
                }
            }
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    set_Key_Up(false);
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    set_Key_Down(false);
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    set_Key_Left(false);
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    set_Key_Right(false);
                }
            }
        });
        thread = new Thread(new Runnable() {
            public void run() {
                while (database.getStart()) {
                    if (get_Key_Up() && player.getY() >= 0) {
                        player.changeLocation(player.getX(), player.getY() - player.getSpeed());
                    }
                    if (get_Key_Down() && player.getY() <= (int)database.getScreen().getHeight() - player.getHeight()) {
                        player.changeLocation(player.getX(), player.getY() + player.getSpeed());
                    }
                    if (get_Key_Left() && player.getX() >= 0) {
                        player.changeLocation(player.getX() - player.getSpeed(), player.getY());
                    }
                    if (get_Key_Right() && player.getX() <= (int)database.getScreen().getWidth() - player.getWidth()) {
                        player.changeLocation(player.getX() + player.getSpeed(), player.getY());
                    }
                    try {
                        Thread.sleep(5);
                    }
                    catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

    public boolean get_Key_Up() {
        return key_up;
    }
    public boolean get_Key_Down() {
        return key_down;
    }
    public boolean get_Key_Right() {
        return key_right;
    }
    public boolean get_Key_Left() {
        return key_left;
    }

    public void set_Key_Up(boolean key) {
        key_up = key;
    }
    public void set_Key_Down(boolean key) {
        key_down = key;
    }
    public void set_Key_Right(boolean key) {
        key_right = key;
    }
    public void set_Key_Left(boolean key) {
        key_left = key;
    }
}
