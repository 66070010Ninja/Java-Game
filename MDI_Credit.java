
import javax.swing.*;

public class MDI_Credit extends JInternalFrame {
    private DataBase_Menu data = new DataBase_Menu();
    private DataBase database = new DataBase();
    private boolean visible;
    public MDI_Credit() {
        super("Credit", true, true, true, true);
        ImageIcon credit = new ImageIcon(data.getCredit_DMI_Image());
        JLabel bg = new JLabel("", credit, JLabel.CENTER);
        bg.setBounds(0, 0, 480, 270);
        add(bg);
        setSize(480, 270);
        setLocation((int)database.getScreen().getWidth()/2 - credit.getImage().getWidth(null)/2, ABORT);
    }

    public void setVisible_MDI(boolean visible) {
        setVisible(visible);
        this.visible = visible;
    }

    public boolean getVisible() {
        return visible;
    }
}
