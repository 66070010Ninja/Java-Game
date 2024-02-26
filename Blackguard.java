
// Import
import javax.swing.*;
import java.awt.*;

// Object Blackguard
public class Blackguard {
    private int width, height;
    private Image Bg_Stage;

    // Blackguard
    public Blackguard() {
        Bg_Stage = new ImageIcon("Bg Stage 1/alt.gif").getImage();
        width = Bg_Stage.getWidth(null);
        height = Bg_Stage.getHeight(null);
    }

    // Getter
    public Image getBlackguard() {
        return Bg_Stage;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}
