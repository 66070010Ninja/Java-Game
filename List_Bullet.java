
import java.awt.*;
import java.util.*;

public class List_Bullet {
    private DataBase database = new DataBase();
    private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    private int count_reload_bullet = 0;
    private Thread thread;
    private Player player;
    private Enemy_01 enemy_01;
    private Enemy_03 enemy_03;

    public List_Bullet(Object object) {
        if (object instanceof Player) {
            player = (Player)object;
        }
        else if (object instanceof Enemy_01) {
            enemy_01 = (Enemy_01)object;
        }
        else if (object instanceof Enemy_03) {
            enemy_03 = (Enemy_03)object;
        }
        thread = new Thread(new Runnable() {
            public void run() {
                while (database.getStart()) {
                    if (database.getPlayer_Reload_Bullet() == count_reload_bullet && object instanceof Player) {
                        bullets.add(new Bullet(player.getX()+player.getWidth()-25, player.getY()+25, player, 0));
                        count_reload_bullet = 0;
                    }
                    else if (database.getEnemy_01_Reload_Bullet() == count_reload_bullet && object instanceof Enemy_01 && object.getImage() != database.getNull_Image()) {
                        bullets.add(new Bullet(enemy_01.getX()+25, enemy_01.getY()+25, enemy_01, 0));
                        count_reload_bullet = 0;
                    }
                    else if (database.getEnemy_03_Reload_Bullet() == count_reload_bullet && object instanceof Enemy_03 && object.getImage() != database.getNull_Image()) {
                        bullets.add(new Bullet(enemy_03.getX()+25, enemy_03.getY()+25, enemy_03, 1));
                        bullets.add(new Bullet(enemy_03.getX()+25, enemy_03.getY()+25, enemy_03, 2));
                        bullets.add(new Bullet(enemy_03.getX()+25, enemy_03.getY()+25, enemy_03, 3));
                        count_reload_bullet = 0;
                    }
                    count_reload_bullet++;
                    try {
                        Thread.sleep(5);
                    }
                    catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

    public void draw(Graphics2D g2D, Color color) {
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            if (bullet != null) {
                bullet.draw(g2D, color);
                bullet.update();
                update();
            }
        }
    }

    public void update() {
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            if (bullet != null && !bullet.check()) {
                bullets.remove(bullet);
            }
        }
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }
}
