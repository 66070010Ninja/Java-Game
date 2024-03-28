
import java.awt.*;
import java.util.*;

public class List_Enemy {
    private DataBase database = new DataBase();
    private Thread thread;
    private ArrayList<Object> enemis = new ArrayList<Object>();

    public List_Enemy() {
        thread = new Thread(new Runnable() {
            public void run() {
                while (database.getStart()) {
                    addEnemy();
                    try {
                        Thread.sleep(5000);
                    }
                    catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

    public void addEnemy() {
        Random random = new Random();
        int y;

        Enemy_01 enemy_01 = new Enemy_01();
        y = random.nextInt((int)database.getScreen().getHeight() - (int)enemy_01.getHeight());
        enemy_01.changeLocation((int)database.getScreen().getWidth(), y);
        enemis.add(enemy_01);

        Enemy_02 enemy_02 = new Enemy_02();
        y = random.nextInt((int)database.getScreen().getHeight() - (int)enemy_02.getHeight());
        enemy_02.changeLocation((int)database.getScreen().getWidth(), y);
        enemis.add(enemy_02);

        Enemy_03 enemy_03 = new Enemy_03();
        y = random.nextInt((int)database.getScreen().getHeight() - (int)enemy_03.getHeight());
        enemy_03.changeLocation((int)database.getScreen().getWidth(), y);
        enemis.add(enemy_03);

        Enemy_04 enemy_04 = new Enemy_04();
        y = random.nextInt((int)database.getScreen().getHeight() - (int)enemy_04.getHeight());
        enemy_04.changeLocation((int)database.getScreen().getWidth(), y);
        enemis.add(enemy_04);

        Enemy_05 enemy_05 = new Enemy_05();
        enemy_05.changeLocation((int)database.getScreen().getWidth(), 0);
        enemis.add(enemy_05);
    }

    public void draw(Graphics2D g2D, Color color) {
        for (int i = 0; i < enemis.size(); i++) {
            if (enemis.get(i) instanceof Enemy_01) {
                Enemy_01 enemy = (Enemy_01)enemis.get(i);
                if (enemy != null) {
                    enemy.draw(g2D, color);
                    enemy.update();
                }
            }
            else if (enemis.get(i) instanceof Enemy_02) {
                Enemy_02 enemy = (Enemy_02)enemis.get(i);
                if (enemy != null) {
                    enemy.draw(g2D, color);
                    enemy.update();
                }
            }
            else if (enemis.get(i) instanceof Enemy_03) {
                Enemy_03 enemy = (Enemy_03)enemis.get(i);
                if (enemy != null) {
                    enemy.draw(g2D, color);
                    enemy.update();
                }
            }
            else if (enemis.get(i) instanceof Enemy_04) {
                Enemy_04 enemy = (Enemy_04)enemis.get(i);
                if (enemy != null) {
                    enemy.draw(g2D, color);
                    enemy.update();
                }
            }
            else if (enemis.get(i) instanceof Enemy_05) {
                Enemy_05 enemy = (Enemy_05)enemis.get(i);
                if (enemy != null) {
                    enemy.draw(g2D, color);
                    enemy.update();
                }
            }
            update();
        }
    }

    public void update() {
        for (int i = 0; i < enemis.size(); i++) {
            if (enemis.get(i) instanceof Enemy_01) {
                Enemy_01 enemy = (Enemy_01)enemis.get(i);
                if (enemy != null && !enemy.check()) {
                    enemis.remove(enemy);
                }
            }
            else if (enemis.get(i) instanceof Enemy_02) {
                Enemy_02 enemy = (Enemy_02)enemis.get(i);
                if (enemy != null && !enemy.check() && enemy.getImage() == database.getNull_Image()) {
                    enemis.remove(enemy);
                }
            }
            else if (enemis.get(i) instanceof Enemy_03) {
                Enemy_03 enemy = (Enemy_03)enemis.get(i);
                if (enemy != null && !enemy.check()) {
                    enemis.remove(enemy);
                }
            }
            else if (enemis.get(i) instanceof Enemy_04) {
                Enemy_04 enemy = (Enemy_04)enemis.get(i);
                if (enemy != null && !enemy.check()) {
                    enemis.remove(enemy);
                }
            }
            else if (enemis.get(i) instanceof Enemy_05) {
                Enemy_05 enemy = (Enemy_05)enemis.get(i);
                if (enemy != null && !enemy.check()) {
                    enemis.remove(enemy);
                }
            }
        }
    }

    public ArrayList<Object> getList() {
        return enemis;
    }
}
