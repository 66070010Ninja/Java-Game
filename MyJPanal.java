// Import
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Class MyJPanal
public class MyJPanal extends JPanel implements ActionListener {
    private Image Bg_Stage_1;
    private Timer timer;

    // กำหนด JPanal
    public MyJPanal() {
        Bg_Stage_1 = new ImageIcon("Bg Stage 1/alt gif.gif").getImage();
        timer = new Timer(1, this);
        timer.start();
    }

    // วาด Graphics
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(Bg_Stage_1, 0, 0, null);
    }

    // ตัวทำให้รูปภาพเคลื่อนไหว
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
