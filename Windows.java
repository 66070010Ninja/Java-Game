
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Windows extends JFrame {
    private DataBase database = new DataBase();
    private Menu menu;

    public Windows() {
        setTitle("Ocean War 2077");
        setSize((int)database.getScreen().getWidth(), (int)database.getScreen().getHeight());
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
        menu = new Menu();
        add(menu);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                menu.start();
            }
        });
        setUndecorated(true);
        setVisible(true);
    }
}
