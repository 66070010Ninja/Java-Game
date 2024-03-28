
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class RunGame extends JPanel{
    private DataBase database = new DataBase();
    private BufferedImage image;
    private Graphics2D g2D;
    private Thread thread;

    private BackGround bg;
    private CheckHitBox checkhitbox;
    private Player player;
    private List_Enemy enemis;

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
                    drawBackground();
                    drawGame();
                    update();
                    render();
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
        enemis = new List_Enemy();
        checkhitbox = new CheckHitBox(player, enemis);
    }

    public void initKeyboard() {
        new Key(player, this);
    }

    public void drawBackground() {
        bg.draw(g2D, null);
    }
    public void drawGame() {
        player.draw(g2D, Color.GREEN);
        enemis.draw(g2D, Color.RED);
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
