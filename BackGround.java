
import java.awt.*;

public class BackGround extends Object {
    private DataBase database = new DataBase();

    public BackGround () {
        setImage(database.getBG_Image().getScaledInstance((int)database.getScreen().getWidth(), (int)database.getScreen().getHeight(), Image.SCALE_SMOOTH));
        setArea();
    }

    @Override
    public void update() {}
}
