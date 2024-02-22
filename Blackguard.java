// Import
import javax.swing.*;
import java.awt.*;

// Object Blackguard
public class Blackguard {
    private Image Bg_Stage;

    // Blackguard
    public Blackguard() {
        Bg_Stage = new ImageIcon("Bg Stage 1/alt.gif").getImage();
    }

    // Getter
    public Image getBlackguard() {
        return Bg_Stage;
    }
}
