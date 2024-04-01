
import java.awt.*;

public class Level_01 extends Button {

    private DataBase database = new DataBase();
    private DataBase_Menu data = new DataBase_Menu();
    private Level_Game<Integer> level;
    private boolean play;

    public Level_01(Level_Game<Integer> level, boolean play) {
        this.level = level;
        this.play = play;
        setImage(data.getLevel_01_Image().getScaledInstance((int)(959 / 3.5), (int)(914 / 3.5), Image.SCALE_SMOOTH));
        setImage_H(data.getLevel_01_H_Image().getScaledInstance((int)(959 / 3.5), (int)(914 / 3.5), Image.SCALE_SMOOTH));
        changeLocation((int)database.getScreen().getWidth()/4 + 150 - data.getLevel_01_Image().getWidth(null)/4, 300);
    }

    public boolean getPlay() {
        return play;
    }
    
    @Override
    public void update() {
        if (getOnClick()) {
            setOnClick(false);
            level.setlevel_game(1);
            play = true;
        }
    }
}
