
import java.awt.*;

public class BackGround_Level extends Object {

    private DataBase database = new DataBase();

    public BackGround_Level() {
        setImage(database.getBG_Selection_Level().getScaledInstance((int)database.getScreen().getWidth(), (int)database.getScreen().getHeight(), Image.SCALE_SMOOTH));
        setArea();
    }
    @Override
    public void update() {}
}
