
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class Menu extends JPanel {
    private DataBase database = new DataBase();
    private BufferedImage image;
    private Graphics2D g2D;
    private Thread thread;

    private BackGround_Menu bg;
    private Play play;
    private Exit exit;
    private Credit credit = null;
    private boolean play_game = false;
    private boolean play_sound = false;
    private Selection_Level selection_Level_mode;
    private Run_Game rungame = null;
    private boolean reset_game = true;
    private Level_Game<Integer> level;
    private Level_Game<Integer> level_now;
    private MDI_Credit mdi_credit = new MDI_Credit();
    private Sound sound = new Sound();

    public void setReset_Game(boolean reset_game) {
        this.reset_game = reset_game;
    }

    public Menu() {
        image = new BufferedImage((int)database.getScreen().getWidth(), (int)database.getScreen().getHeight(), BufferedImage.TYPE_INT_ARGB);
        g2D = image.createGraphics();
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        level = new Level_Game<>();
        level_now = new Level_Game<>();
        level.setlevel_game(0);
        level_now.setlevel_game(1);
    }

    public void start() {
        thread = new Thread(new Runnable() {
            public void run() {
                while (database.getStart()) {
                    long start_time = System.nanoTime();

                    if (mdi_credit.getVisible() && getComponentCount() == 0) {
                        drawBackground();
                        drawButton();
                        update();
                        render();
                        add(mdi_credit, 0);
                        try {
                            Thread.sleep(3000);
                        }
                        catch (Exception e) {}
                        remove(0);
                        mdi_credit.setVisible_MDI(false);
                    }
                    else if (!play.getSelection()) {
                        if (play_sound == false) {
                            sound.Sound_Menu();
                            play_sound = true;
                        }
                        drawBackground();
                        drawButton();
                        update();
                        render();
                        rungame = null;
                        play_game = false;
                        reset_game = true;
                        level.setlevel_game(0);
                        selection_Level_mode = null;
                    }
                    else if (rungame != null && reset_game == true) {
                        sound.stop();
                        rungame = new Run_Game(g2D, getJPanel(), play, getMenu(), level, level_now);
                        render();
                        reset_game = false;
                    }
                    else if (rungame != null) {
                        rungame.start();
                        render();
                    }
                    else if (play.getSelection() && rungame == null) {
                        play_sound = false;
                        if (level_now.getlevel_game() == 1 && selection_Level_mode == null) {
                            update();
                            selection_Level_mode = new Selection_Level(g2D, getJPanel(), level_now, level, play_game);
                        }
                        else if (level_now.getlevel_game() == 2 && selection_Level_mode == null) {
                            selection_Level_mode = new Selection_Level(g2D, getJPanel(), level_now, level, play_game);
                        }
                        else if (level_now.getlevel_game() == 3 && selection_Level_mode == null) {
                            selection_Level_mode = new Selection_Level(g2D, getJPanel(), level_now, level, play_game);
                        }
                        selection_Level_mode.start();
                        if (selection_Level_mode.getSelection().getlevel_game() == 1 && rungame == null) {
                            rungame = new Run_Game(g2D, getJPanel(), play, getMenu(), level, level_now);
                            selection_Level_mode.start();
                        }
                        else if (selection_Level_mode.getSelection().getlevel_game() == 2 && rungame == null) {
                            rungame = new Run_Game(g2D, getJPanel(), play, getMenu(), level, level_now);
                            selection_Level_mode.start();
                        }
                        else if (selection_Level_mode.getSelection().getlevel_game() == 3 && rungame == null) {
                            rungame = new Run_Game(g2D, getJPanel(), play, getMenu(), level, level_now);
                            selection_Level_mode.start();
                        }
                        render();
                    }

                    long time = System.nanoTime() - start_time;
                    if (time < database.getTarget_Time()) {
                        try {
                            Thread.sleep(database.getSleep(time));
                        }
                        catch (InterruptedException ie) {
                            ie.printStackTrace();
                        }
                    }
                }
            }
        });
        initObjectGame();
        initMouse();
        thread.start();
    }

    public void initObjectGame() {
        bg = new BackGround_Menu();
        play = new Play();
        exit = new Exit();
        credit = new Credit(mdi_credit);
    }

    public void initMouse() {
        new Mouse(this, play);
        new Mouse(this, exit);
        new Mouse(this, credit);
    }

    public void drawBackground() {
        bg.draw(g2D, null);
    }
    public void drawButton() {
        play.darw(g2D);
        credit.darw(g2D);
        exit.darw(g2D);
    }

    public void update() {
        play.update();
        credit.update();
        exit.update();
    }

    public void render() {
        Graphics g = getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
    }

    public JPanel getJPanel() {
        return this;
    }

    public Menu getMenu() {
        return this;
    }
}
