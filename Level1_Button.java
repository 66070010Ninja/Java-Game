//new by pure

import java.awt.Image;

public class Level1_Button extends Button {

    private DataBase_Menu data = new DataBase_Menu();
    private DataBase database = new DataBase();
    private Status Status;
    public Level1_Button(boolean game_start, Status Status) {
        this.Status = Status;
        setImage(data.getLevel_01_Image().getScaledInstance((int)(959 / 3.5), (int)(914 / 3.5), Image.SCALE_SMOOTH));
        setImage_H(data.getLevel_01_H_Image().getScaledInstance((int)(959 / 3.5), (int)(914 / 3.5), Image.SCALE_SMOOTH));
        changeLocation((int)database.getScreen().getWidth()/4 + 150 - data.getLevel_01_Image().getWidth(null)/4, 300);
    }

    @Override
    public void update() {
        if (getOnClick() == true && Status.getStatus() == "Level") {
            setOnClick(false);
            Status.setStatus("Game");
        }
        else {
            setOnClick(false);
        }
    }
    }
