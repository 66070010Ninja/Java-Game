
// Package
package Main_Game;

// Import
import Game_Componet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Main
public class Main extends JFrame {

    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public Main() {
        setTitle("Ocean War 2077");
        setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        PanelGame panelGame = new PanelGame();
        add(panelGame);
        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent  e) {
                panelGame.start();
            }
        });
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setVisible(true);
    }

}
