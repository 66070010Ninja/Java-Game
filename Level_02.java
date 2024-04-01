
import java.awt.*;

public class Level_02 extends Button {

    private DataBase database = new DataBase();
    private DataBase_Menu data = new DataBase_Menu();
    private Level_Game<Integer> level;
    private int level_now;
    private boolean play;

    public Level_02(Level_Game<Integer> level, int level_now, boolean play) {
        this.level = level;
        this.level_now = level_now;
        this.play = play;
        if (level_now >= 2) {
            setImage(data.getLevel_02_Image().getScaledInstance((int)(959 / 3.5), (int)(914 / 3.5), Image.SCALE_SMOOTH));
            setImage_H(data.getLevel_02_H_Image().getScaledInstance((int)(959 / 3.5), (int)(914 / 3.5), Image.SCALE_SMOOTH));
        }
        else {
            setImage(data.getLevel_Locked_Image().getScaledInstance((int)(959 / 3.5), (int)(914 / 3.5), Image.SCALE_SMOOTH));
            setImage_H(data.getLevel_Locked_Image().getScaledInstance((int)(959 / 3.5), (int)(914 / 3.5), Image.SCALE_SMOOTH));
        }
        changeLocation((int)database.getScreen().getWidth()/4 + 600 - data.getLevel_02_Image().getWidth(null)/4, 300);
    }

    public boolean getPlay() {
        return play;
    }

    @Override
    public void update() {
        if (getOnClick() && level_now >= 2) {
            setOnClick(false);
            level.setlevel_game(2);
            play = true;
        }
    }
}
