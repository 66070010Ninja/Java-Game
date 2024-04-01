
import java.awt.*;

public class BackGround_Menu extends Object {
    private DataBase_Menu data = new DataBase_Menu();
    private DataBase database = new DataBase();

    public BackGround_Menu () {
        setImage(data.getBG_Image().getScaledInstance((int)database.getScreen().getWidth(), (int)database.getScreen().getHeight(), Image.SCALE_SMOOTH));
        setArea();
    }

    @Override
    public void update() {}
}
