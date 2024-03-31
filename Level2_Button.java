//new by pure

import java.awt.Image;

public class Level2_Button extends Button {

    private DataBase_Menu data = new DataBase_Menu();
    private DataBase database = new DataBase();

    public Level2_Button() {
        if ((data.getState() == DataBase_Menu.STATE.LEVEL_SELECT2) || (data.getState() == DataBase_Menu.STATE.LEVEL_SELECTBOSS)){
            setImage(data.getLevel_02_Image().getScaledInstance((int)(959 / 3.5), (int)(914 / 3.5), Image.SCALE_SMOOTH));
            setImage_H(data.getLevel_02_H_Image().getScaledInstance((int)(959 / 3.5), (int)(914 / 3.5), Image.SCALE_SMOOTH));
        } else {
            setImage(data.getLevel_Locked_Image().getScaledInstance((int)(959 / 3.5), (int)(914 / 3.5), Image.SCALE_SMOOTH));
            setImage_H(data.getLevel_Locked_Image().getScaledInstance((int)(959 / 3.5), (int)(914 / 3.5), Image.SCALE_SMOOTH));
        }
        changeLocation((int)database.getScreen().getWidth()/4 + 600 - data.getLevel_02_Image().getWidth(null)/4, 300);
    }

    @Override
    public void update() {
        if (getOnClick() == true) {
        }
    }
}
