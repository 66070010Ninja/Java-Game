
import java.awt.*;

public class Level_BOSS extends Button {

    private DataBase database = new DataBase();
    private DataBase_Menu data = new DataBase_Menu();
    private Level_Game<Integer> level;
    private int level_now;
    private boolean play;

    public Level_BOSS(Level_Game<Integer> level, int level_now, boolean play) {
        this.level = level;
        this.level_now = level_now;
        this.play = play;
        if (level_now >= 3) {
            setImage(data.getBoss_Image().getScaledInstance((int)(633 / 3.5), (int)(851 / 3.5), Image.SCALE_SMOOTH));
            setImage_H(data.getBoss_H_Image().getScaledInstance((int)(633 / 3.5), (int)(851 / 3.5), Image.SCALE_SMOOTH));
        }
        else {
            setImage(data.getBoss_Locked_Image().getScaledInstance((int)(633 / 3.5), (int)(851 / 3.5), Image.SCALE_SMOOTH));
            setImage_H(data.getBoss_Locked_Image().getScaledInstance((int)(633 / 3.5), (int)(851 / 3.5), Image.SCALE_SMOOTH));
        }
        changeLocation((int)database.getScreen().getWidth()/4 + 1000 - data.getBoss_Image().getWidth(null)/4, 300);
    }

    public boolean getPlay() {
        return play;
    }

    @Override
    public void update() {
        if (getOnClick() && level_now >= 3) {
            setOnClick(false);
            level.setlevel_game(3);
            play = true;
        }
    }
}
