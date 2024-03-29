import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class MDI extends JInternalFrame{
    public MDI(){
        super("Credit", true, true, true,true);
        getContentPane().add(new JLabel());
        setSize(400,200);
        setLocation(100, 400);
        setVisible(true);
    }
}
