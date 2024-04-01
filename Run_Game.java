
import java.awt.*;
import javax.swing.*;

public class Run_Game {

    private Graphics2D g2D;
    private Sound BG_Sound;
    private Sound Game_Over_Sound;

    private JPanel panel;
    private BackGround bg;
    private Pause_Menu pause;
    private CheckHitBox checkhitbox;
    private Player player;
    private List_Enemy enemis;
    private List_Item items;
    private Victory victory;
    private Victory_Next_Level next_Level;
    private Continue continue1;
    private Menu_Button menu_Button;
    private Game_Over game_over;
    private Retry retry;
    private Retry_Victory retry_Victory;
    private Menu_Button_02 menu_Button_02;
    private boolean playsound = false;
    private boolean oversound = false;
    private Play play;
    private Menu menu;
    private Menu_Button_03 menu_Button_03;
    private Level_Game<Integer> level;
    private Level_Game<Integer> level_now;

    public Run_Game(Graphics2D g2D, JPanel panel, Play play, Menu menu, Level_Game<Integer> level, Level_Game<Integer> level_now) {
        this.g2D = g2D;
        this.level = level;
        this.level_now = level_now;
        this.menu = menu;
        this.panel = panel;
        this.play = play;
        BG_Sound = new Sound();
        Game_Over_Sound = new Sound();
        initObjectGame();
        initKeyboard();
    }

    public void start() {

        if (player.getEnemy_Left() == 0 && player.get_HP() > 0) {
            drawBackground();
            drawVictory();
            updateVictory();
        }
        else if (player.getPause() == false && player.get_HP() > 0) {
            drawBackground();
            drawGame();
            update();
            if (playsound == false) {
                BG_Sound.Sound_BG();
                playsound = true;
            }
        }
        else if (player.get_HP() <= 0) {
            if (oversound == false) {
                Game_Over_Sound.Sound_Game_Over();
                drawBackground();
                drawGame();
                update();
                oversound = true;
            }
            drawGameOver();
            updateGameOver();
        }
        else if (player.getPause() == true) {
            drawBackground();
            drawPause();
            updatePause();
        }
    }

    public void initObjectGame() {
        bg = new BackGround();
        player = new Player();
        switch (level.getlevel_game()) {
            case(1):
                player.setEnemy_Left(50);
                break;
            case(2):
                player.setEnemy_Left(60);
                break;
            case(3):
                player.setEnemy_Left(70);
                break;
        }
        enemis = new List_Enemy(level);
        items = new List_Item(player, enemis);
        checkhitbox = new CheckHitBox(player, enemis, items, bg);
        victory = new Victory();
        pause = new Pause_Menu();
        continue1 = new Continue(player);
        menu_Button = new Menu_Button(play, BG_Sound);
        menu_Button_02 = new Menu_Button_02(play, BG_Sound);
        game_over = new Game_Over();
        retry = new Retry(BG_Sound, menu);
        retry_Victory = new Retry_Victory(BG_Sound, menu);
        next_Level = new Victory_Next_Level(BG_Sound, menu, level, level_now);
        menu_Button_03 = new Menu_Button_03(play, BG_Sound);
    }

    public void initKeyboard() {
        new Key(player, panel);
        new Mouse(panel, continue1);
        new Mouse(panel, menu_Button);
        new Mouse(panel, retry);
        new Mouse(panel, menu_Button_02);
        new Mouse(panel, next_Level);
        new Mouse(panel, retry_Victory);
        new Mouse(panel, menu_Button_03);
    }

    public void drawBackground() {
        bg.draw(g2D, null);
    }
    public void drawGame() {
        enemis.draw(g2D, null);
        items.draw(g2D, null);
        player.draw(g2D, null);
    }

    public void drawPause() {
        pause.draw(g2D, null);
        continue1.darw(g2D);
        menu_Button.darw(g2D);
    }

    public void drawGameOver() {
        game_over.draw(g2D, null);
        retry.darw(g2D);
        menu_Button_02.darw(g2D);
    }

    public void drawVictory() {
        victory.draw(g2D, null);
        if (level.getlevel_game() != 3) {
            next_Level.darw(g2D);
        }
        retry_Victory.darw(g2D);
        menu_Button_03.darw(g2D);
    }

    public void updatePause() {
        continue1.update();
        menu_Button.update();
    }

    public void updateGameOver() {
        retry.update();
        menu_Button_02.update();
    }

    public void updateVictory() {
        next_Level.update();
        retry_Victory.update();
        menu_Button_03.update();
    }

    public void update() {
        checkhitbox.checkhitbox();
    }
}
