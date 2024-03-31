//new by pure

import java.awt.*;

public class BackGround_Level extends Object {
    private DataBase_Menu data = new DataBase_Menu();
    private DataBase database = new DataBase();

    public BackGround_Level () {
        setImage(data.getBG_Mode_Image().getScaledInstance((int)database.getScreen().getWidth(), (int)database.getScreen().getHeight(), Image.SCALE_SMOOTH));
        setArea();
    }

    @Override
    public void update() {}
}
