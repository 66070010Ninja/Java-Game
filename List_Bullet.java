
import java.awt.*;
import java.util.*;

public class List_Bullet {
    private DataBase database = new DataBase();
    private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    private int count_reload_bullet = 0;
    private Thread thread;
    private Player player = null;
    private Enemy_01 enemy_01 = null;
    private Enemy_03 enemy_03 = null;
    private Enemy_04 enemy_04 = null;
    private Enemy_05 enemy_05 = null;

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
        else if (object instanceof Enemy_04) {
            enemy_04 = (Enemy_04)object;
        }
        else if (object instanceof Enemy_05) {
            enemy_05 = (Enemy_05)object;
        }
        thread = new Thread(new Runnable() {
            public void run() {
                while (database.getStart()) {
                    if (database.getPlayer_Reload_Bullet() <= count_reload_bullet && player != null && !player.getImage().equals(database.getNull_Image())) {
                        bullets.add(new Bullet(player.getX()+player.getWidth()-25, player.getY()+25, player, 0));
                        count_reload_bullet = 0;
                    }
                    else if (database.getEnemy_01_Reload_Bullet() <= count_reload_bullet && enemy_01 != null && object.getImage() != database.getNull_Image() && object.getImage() != database.getDead_Image()) {
                        bullets.add(new Bullet(enemy_01.getX()+10, enemy_01.getY()+45, enemy_01, 0));
                        count_reload_bullet = 0;
                    }
                    else if (database.getEnemy_03_Reload_Bullet() <= count_reload_bullet && enemy_03 != null && object.getImage() != database.getNull_Image() && object.getImage() != database.getDead_Image()) {
                        bullets.add(new Bullet(enemy_03.getX()+10, enemy_03.getY() + enemy_03.getHeight()/2 - 10, enemy_03, 1));
                        bullets.add(new Bullet(enemy_03.getX()+10, enemy_03.getY() + enemy_03.getHeight()/2 - 10, enemy_03, 2));
                        bullets.add(new Bullet(enemy_03.getX()+10, enemy_03.getY() + enemy_03.getHeight()/2 - 10, enemy_03, 3));
                        count_reload_bullet = 0;
                    }
                    else if (database.getEnemy_04_Reload_Bullet() <= count_reload_bullet && enemy_04 != null && object.getImage() != database.getNull_Image() && object.getImage() != database.getDead_Image()) {
                        if (bullets.size() == 0 && !enemy_04.getAttack()) {
                            bullets.add(new Bullet(enemy_04.getX() - 1900, enemy_04.getY() + enemy_04.getHeight() - 49, enemy_04, 0));
                            enemy_04.setAttack(true);
                        }
                        else if (bullets.size() == 1 && enemy_04.getAttack()) {
                            bullets.remove(0);
                            enemy_04.setAttack(false);
                        }
                        count_reload_bullet = 0;
                    }
                    else if (enemy_04 != null && (object.getImage() == database.getNull_Image() || object.getImage() == database.getDead_Image())) {
                        if (bullets.size() > 0) {
                            bullets.remove(0);
                        }
                        if (enemy_04.getAttack() && count_reload_bullet == database.getTime_Attack()) {
                            enemy_04.setAttack(false);
                        }
                    }
                    else if (database.getEnemy_05_Reload_Bullet() <= count_reload_bullet && enemy_05 != null && object.getImage() != database.getNull_Image()) {
                        bullets.add(new Bullet(enemy_05.getX()+30, enemy_05.getY() + enemy_05.getHeight(), enemy_05, 0));
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
