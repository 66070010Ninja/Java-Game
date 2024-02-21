// Import
import javax.swing.*;
import java.awt.*;

// Object Blackguard
public class Blackguard {
    private Image Bg_Stage;

    public Blackguard() {
        Bg_Stage = new ImageIcon("Bg Stage 1/alt.gif").getImage();
    }
    public Image getBlackguard() {
        return Bg_Stage;
    }
}
