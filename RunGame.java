
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class RunGame extends JPanel{
    private DataBase database = new DataBase();
    private BufferedImage image;
    private Graphics2D g2D;
    private Thread thread;

    private BackGround bg;
    private Pause_Menu pause;
    private CheckHitBox checkhitbox;
    private Player player;
    private List_Enemy enemis;
    private List_Item items;
    private Victory victory;

    //
    private Menu_Draw menu = new Menu_Draw();
    //

    public RunGame() {
        image = new BufferedImage((int)database.getScreen().getWidth(), (int)database.getScreen().getHeight(), BufferedImage.TYPE_INT_ARGB);
        g2D = image.createGraphics();
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    }

    public void start() {
        thread = new Thread(new Runnable() {
            public void run() {
                while (database.getStart()) {
                    long start_time = System.nanoTime();

                    if (player.getPause() == false) {
                        drawBackground();
                        drawGame();
                        update();
                        render();
                    }
                    else {
                        DataBase_Menu.State = DataBase_Menu.STATE.PAUSE;
                        drawPause();
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
        initKeyboard();
        thread.start();
    }

    public void initObjectGame() {
        bg = new BackGround();
        player = new Player();
        player.setEnemy_Left(15);
        enemis = new List_Enemy();
        items = new List_Item(player, enemis);
        checkhitbox = new CheckHitBox(player, enemis, items);
        victory = new Victory();
        pause = new Pause_Menu();
    }

    public void initKeyboard() {
        new Key(player, this);
    }

    public void drawBackground() {
        bg.draw(g2D, null);
    }
    public void drawGame() {
        if (player.getEnemy_Left() == 0) {
            enemis.draw(g2D, null);
            items.draw(g2D, null);
            player.draw(g2D, null);
            victory.draw(g2D, null);
        }
        else {
            enemis.draw(g2D, null);
            items.draw(g2D, null);
            player.draw(g2D, null);
        }
    }

    public void drawPause() {
        //menu.draw(g2D);
        pause.draw(g2D, null);
        menu.draw(g2D);
    }

    public void update() {
        checkhitbox.checkhitbox();
    }

    public void render() {
        Graphics g = getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
    }
}
