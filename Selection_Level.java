
import java.awt.*;
import javax.swing.*;

public class Selection_Level extends JPanel {

    private Graphics2D g2D;

    private BackGround_Level bg;
    private Level_01 level_01;
    private Level_02 level_02;
    private Level_BOSS level_BOSS;
    private JPanel panel;
    private Level_Game<Integer> level_now;
    private Level_Game<Integer> level;
    private boolean play_game;

    public Selection_Level(Graphics2D g2D, JPanel panel, Level_Game<Integer> level_now, Level_Game<Integer> level, boolean play_game) {
        this.g2D = g2D;
        this.panel = panel;
        this.level_now = level_now;
        this.level = level;
        this.play_game = play_game;
        initObjectGame();
        initMouse();
    }

    public void start() {
        draw();
        update();
    }

    public void initObjectGame() {
        bg = new BackGround_Level();
        level_01 = new Level_01(level, play_game);
        level_02 = new Level_02(level, level_now.getlevel_game(), play_game);
        level_BOSS = new Level_BOSS(level, level_now.getlevel_game(), play_game);
    }
    public void initMouse() {
        new Mouse(panel, level_01);
        new Mouse(panel, level_02);
        new Mouse(panel, level_BOSS);
    }

    public void draw() {
        bg.draw(g2D, null);
        level_01.darw(g2D);
        level_02.darw(g2D);
        level_BOSS.darw(g2D);
    }
    public void update() {
        level_01.update();
        level_02.update();
        level_BOSS.update();
    }

    public Level_Game<Integer> getSelection() {
        return level;
    }
}
