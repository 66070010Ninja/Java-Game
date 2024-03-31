//new by pure

import java.awt.Image;

public class LevelBoss_Button extends Button {

    private DataBase_Menu data = new DataBase_Menu();
    private DataBase database = new DataBase();

    public LevelBoss_Button() {
        if ((data.getState() == DataBase_Menu.STATE.LEVEL_SELECTBOSS)){
            setImage(data.getBoss_Image().getScaledInstance((int)(633 / 3.5), (int)(851 / 3.5), Image.SCALE_SMOOTH));
            setImage_H(data.getBoss_H_Image().getScaledInstance((int)(633 / 3.5), (int)(851 / 3.5), Image.SCALE_SMOOTH));
        } else {
            setImage(data.getBoss_Locked_Image().getScaledInstance((int)(633 / 3.5), (int)(851 / 3.5), Image.SCALE_SMOOTH));
            setImage_H(data.getBoss_Locked_Image().getScaledInstance((int)(633 / 3.5), (int)(851 / 3.5), Image.SCALE_SMOOTH));
        }
        changeLocation((int)database.getScreen().getWidth()/4 + 1000 - data.getBoss_Image().getWidth(null)/4, 300);
    }

    @Override
    public void update() {
        if (getOnClick() == true) {
        }
    }
}
