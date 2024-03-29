
import java.awt.*;
import java.util.*;

public class List_Enemy {
    private DataBase database = new DataBase();
    private Thread thread;
    private ArrayList<Object> enemis = new ArrayList<Object>();
    private int time = 5000;
    private int round = 1;

    public List_Enemy() {
        thread = new Thread(new Runnable() {
            public void run() {
                while (database.getStart()) {
                    if (round <= 5) {
                        Wave_11();
                    }
                    else if (round <= 10) {
                        Wave_01();
                    }
                    else if (round > 10) {
                        Random random = new Random();
                        int x = random.nextInt(0, 2);
                        if (x == 1) {
                            Wave_02();
                        }
                        else {
                            Wave_03();
                        }
                    }
                    try {
                        Thread.sleep(time);
                    }
                    catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

    public void Wave_01() {
        Random random = new Random();
        int y;

        for (int i = 0; i < 3; i++) {
            Enemy_01 enemy_01 = new Enemy_01();
            y = random.nextInt((int)database.getScreen().getHeight() - (int)database.getEnemy_01_Image().getHeight(null));
            enemy_01.changeLocation((int)database.getScreen().getWidth() + i*(int)database.getEnemy_01_Image().getHeight(null) + 50, y);
            enemis.add(enemy_01);
        }

        // Enemy_02 enemy_02 = new Enemy_02();
        // y = random.nextInt((int)database.getScreen().getHeight() - (int)enemy_02.getHeight());
        // enemy_02.changeLocation((int)database.getScreen().getWidth(), y);
        // enemis.add(enemy_02);

        // Enemy_03 enemy_03 = new Enemy_03();
        // y = random.nextInt((int)database.getScreen().getHeight() - (int)enemy_03.getHeight());
        // enemy_03.changeLocation((int)database.getScreen().getWidth(), y);
        // enemis.add(enemy_03);

        // Enemy_04 enemy_04 = new Enemy_04();
        // y = random.nextInt((int)database.getScreen().getHeight() - (int)enemy_04.getHeight());
        // enemy_04.changeLocation((int)database.getScreen().getWidth(), y);
        // enemis.add(enemy_04);

        // Enemy_05 enemy_05 = new Enemy_05();
        // enemy_05.changeLocation((int)database.getScreen().getWidth(), 0);
        // enemis.add(enemy_05);

        round++;
    }

    public void Wave_02() {
        Random random = new Random();
        int f = 1;
        int y;
        int x;
        for (int i = 0; i < 3; i++) {
            x = random.nextInt(0, 2);
            if ((x == 1 && f != 0) || (i == 2 && f != 0)) {
                Enemy_02 enemy_02 = new Enemy_02();
                y = random.nextInt((int)database.getScreen().getHeight() - (int)enemy_02.getHeight());
                enemy_02.changeLocation((int)database.getScreen().getWidth() + i*(int)database.getEnemy_02_Image().getHeight(null) + 50 , y);
                enemis.add(enemy_02);
                f--;
            }
            else {
                Enemy_01 enemy_01 = new Enemy_01();
                y = random.nextInt((int)database.getScreen().getHeight() - (int)database.getEnemy_01_Image().getHeight(null));
                enemy_01.changeLocation((int)database.getScreen().getWidth() + i*(int)database.getEnemy_01_Image().getHeight(null) + 50, y);
                enemis.add(enemy_01);
            }
        }
        round++;
    }

    public void Wave_03() {
        Random random = new Random();
        int f = 1;
        int y;
        int x;
        for (int i = 0; i < 3; i++) {
            x = random.nextInt(0, 2);
            if ((x == 1 && f != 0) || (i == 2 && f != 0)) {
                Enemy_01 enemy_01 = new Enemy_01();
                y = random.nextInt((int)database.getScreen().getHeight() - (int)database.getEnemy_01_Image().getHeight(null));
                enemy_01.changeLocation((int)database.getScreen().getWidth() + i*(int)database.getEnemy_01_Image().getHeight(null) + 50, y);
                enemis.add(enemy_01);
                f--;
            }
            else {
                Enemy_02 enemy_02 = new Enemy_02();
                y = random.nextInt((int)database.getScreen().getHeight() - (int)enemy_02.getHeight());
                enemy_02.changeLocation((int)database.getScreen().getWidth() + i*(int)database.getEnemy_02_Image().getHeight(null) + 50 , y);
                enemis.add(enemy_02);
            }
        }
        round++;
    }

    public void Wave_04() {
        Random random = new Random();
        int y;
    
        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    Enemy_01 enemy_01 = new Enemy_01();
                    y = random.nextInt((int)database.getScreen().getHeight() - (int)database.getEnemy_01_Image().getHeight(null));
                    enemy_01.changeLocation((int)database.getScreen().getWidth() + i*(int)database.getEnemy_01_Image().getHeight(null) + 50, y);
                    enemis.add(enemy_01);
                    break;
                case 1:
                    Enemy_02 enemy_02 = new Enemy_02();
                    y = random.nextInt((int)database.getScreen().getHeight() - (int)enemy_02.getHeight());
                    enemy_02.changeLocation((int)database.getScreen().getWidth() + i*(int)database.getEnemy_02_Image().getHeight(null) + 50 , y);
                    enemis.add(enemy_02);
                    break;
                case 2:
                    // Enemy_03 enemy_03 = new Enemy_03();
                    // y = random.nextInt((int)database.getScreen().getHeight() - (int)enemy_03.getHeight());
                    // enemy_03.changeLocation((int)database.getScreen().getWidth() + i*(int)database.getEnemy_02_Image().getHeight(null) + 50 , y);
                    // enemis.add(enemy_03);
                    // break;
                    Enemy_03 enemy_03 = new Enemy_03();
                    y = random.nextInt((int)database.getScreen().getHeight() - (int)enemy_03.getHeight());
                    enemy_03.changeLocation((int)database.getScreen().getWidth(), y);
                    enemis.add(enemy_03);
                    break;
            }
        }
        round++;
    }

    public void Wave_05() {
        Random random = new Random();
        int y;
    
        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    Enemy_01 enemy_01 = new Enemy_01();
                    y = random.nextInt((int)database.getScreen().getHeight() - (int)database.getEnemy_01_Image().getHeight(null));
                    enemy_01.changeLocation((int)database.getScreen().getWidth() + i*(int)database.getEnemy_01_Image().getHeight(null) + 50, y);
                    enemis.add(enemy_01);
                    break;
                case 1:
                    Enemy_02 enemy_02 = new Enemy_02();
                    y = random.nextInt((int)database.getScreen().getHeight() - (int)enemy_02.getHeight());
                    enemy_02.changeLocation((int)database.getScreen().getWidth() + i*(int)database.getEnemy_02_Image().getHeight(null) + 50 , y);
                    enemis.add(enemy_02);
                    break;
                case 2:
                    Enemy_05 enemy_05 = new Enemy_05();
                    enemy_05.changeLocation((int)database.getScreen().getWidth(), 0);
                    enemis.add(enemy_05);
                    break;
            }
        }
        round++;
    }

    public void Wave_06() {
        Random random = new Random();
        int y;
    
        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    Enemy_01 enemy_01 = new Enemy_01();
                    y = random.nextInt((int)database.getScreen().getHeight() - (int)database.getEnemy_01_Image().getHeight(null));
                    enemy_01.changeLocation((int)database.getScreen().getWidth() + i*(int)database.getEnemy_01_Image().getHeight(null) + 50, y);
                    enemis.add(enemy_01);
                    break;
                case 1:
                    Enemy_03 enemy_03 = new Enemy_03();
                    y = random.nextInt((int)database.getScreen().getHeight() - (int)enemy_03.getHeight());
                    enemy_03.changeLocation((int)database.getScreen().getWidth(), y);
                    enemis.add(enemy_03);
                    break;
                case 2:
                    Enemy_05 enemy_05 = new Enemy_05();
                    enemy_05.changeLocation((int)database.getScreen().getWidth(), 0);
                    enemis.add(enemy_05);
                    break;
            }
        }
        round++;
    }

    public void Wave_07() {
        Random random = new Random();
        int y;
    
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    Enemy_01 enemy_01 = new Enemy_01();
                    y = random.nextInt((int)database.getScreen().getHeight() - (int)database.getEnemy_01_Image().getHeight(null));
                    enemy_01.changeLocation((int)database.getScreen().getWidth() + i*(int)database.getEnemy_01_Image().getHeight(null) + 50, y);
                    enemis.add(enemy_01);
                    break;
                case 1:
                    Enemy_02 enemy_02 = new Enemy_02();
                    y = random.nextInt((int)database.getScreen().getHeight() - (int)enemy_02.getHeight());
                    enemy_02.changeLocation((int)database.getScreen().getWidth() + i*(int)database.getEnemy_02_Image().getHeight(null) + 50 , y);
                    enemis.add(enemy_02);
                    break;
                case 2:
                    Enemy_03 enemy_03 = new Enemy_03();
                    y = random.nextInt((int)database.getScreen().getHeight() - (int)enemy_03.getHeight());
                    enemy_03.changeLocation((int)database.getScreen().getWidth(), y);
                    enemis.add(enemy_03);
                    break;
                case 3:
                    Enemy_05 enemy_05 = new Enemy_05();
                    enemy_05.changeLocation((int)database.getScreen().getWidth(), 0);
                    enemis.add(enemy_05);
                    break;
            }
        }
        round++;
    }

    public void Wave_08() {
        Random random = new Random();
        int y;
    
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    Enemy_02 enemy_02_1 = new Enemy_02();
                    y = random.nextInt((int) database.getScreen().getHeight() - (int) enemy_02_1.getHeight());
                    enemy_02_1.changeLocation((int) database.getScreen().getWidth() + i * (int) database.getEnemy_02_Image().getHeight(null) + 50, y);
                    enemis.add(enemy_02_1);
                    break;
                case 1:
                    Enemy_02 enemy_02_2 = new Enemy_02();
                    y = random.nextInt((int) database.getScreen().getHeight() - (int) enemy_02_2.getHeight());
                    enemy_02_2.changeLocation((int) database.getScreen().getWidth() + i * (int) database.getEnemy_02_Image().getHeight(null) + 50, y);
                    enemis.add(enemy_02_2);
                    break;
                case 2:
                    Enemy_03 enemy_03 = new Enemy_03();
                    y = random.nextInt((int) database.getScreen().getHeight() - (int) enemy_03.getHeight());
                    enemy_03.changeLocation((int) database.getScreen().getWidth(), y);
                    enemis.add(enemy_03);
                    break;
                case 3:
                    Enemy_05 enemy_05 = new Enemy_05();
                    enemy_05.changeLocation((int) database.getScreen().getWidth(), 0);
                    enemis.add(enemy_05);
                    break;
            }
        }
        round++;
    }

    public void Wave_09() {
        Random random = new Random();
        int y;
    
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    Enemy_01 enemy_01 = new Enemy_01();
                    y = random.nextInt((int)database.getScreen().getHeight() - (int)database.getEnemy_01_Image().getHeight(null));
                    enemy_01.changeLocation((int)database.getScreen().getWidth() + i*(int)database.getEnemy_01_Image().getHeight(null) + 50, y);
                    enemis.add(enemy_01);
                    break;
                case 1:
                    Enemy_02 enemy_02 = new Enemy_02();
                    y = random.nextInt((int)database.getScreen().getHeight() - (int)enemy_02.getHeight());
                    enemy_02.changeLocation((int)database.getScreen().getWidth() + i*(int)database.getEnemy_02_Image().getHeight(null) + 50 , y);
                    enemis.add(enemy_02);
                    break;
                case 2:
                    Enemy_03 enemy_03 = new Enemy_03();
                    y = random.nextInt((int) database.getScreen().getHeight() - (int) enemy_03.getHeight());
                    enemy_03.changeLocation((int) database.getScreen().getWidth(), y);
                    enemis.add(enemy_03);
                    break;
                case 3:
                    Enemy_04 enemy_04 = new Enemy_04();
                    y = random.nextInt((int)database.getScreen().getHeight() - (int)enemy_04.getHeight());
                    enemy_04.changeLocation((int)database.getScreen().getWidth(), y);
                    enemis.add(enemy_04);
                    break;
            }
        }
        round++;
    }

    public void Wave_10() {
        Random random = new Random();
        int y;
    
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    Enemy_01 enemy_01 = new Enemy_01();
                    y = random.nextInt((int)database.getScreen().getHeight() - (int)database.getEnemy_01_Image().getHeight(null));
                    enemy_01.changeLocation((int)database.getScreen().getWidth() + i*(int)database.getEnemy_01_Image().getHeight(null) + 50, y);
                    enemis.add(enemy_01);
                    break;
                case 1:
                    Enemy_03 enemy_03 = new Enemy_03();
                    y = random.nextInt((int) database.getScreen().getHeight() - (int) enemy_03.getHeight());
                    enemy_03.changeLocation((int) database.getScreen().getWidth(), y);
                    enemis.add(enemy_03);
                    break;
                case 2:
                    Enemy_04 enemy_04_1 = new Enemy_04();
                    y = random.nextInt((int)database.getScreen().getHeight() - (int)enemy_04_1.getHeight());
                    enemy_04_1.changeLocation((int)database.getScreen().getWidth(), y);
                    enemis.add(enemy_04_1);
                    break;
                case 3:
                    Enemy_04 enemy_04_2 = new Enemy_04();
                    y = random.nextInt((int)database.getScreen().getHeight() - (int)enemy_04_2.getHeight());
                    enemy_04_2.changeLocation((int)database.getScreen().getWidth(), y);
                    enemis.add(enemy_04_2);
                    break;
            }
        }
        round++;
    }

    public void Wave_11() {
        Random random = new Random();
        int y;
        int delay = 2500;
    
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    Enemy_03 enemy_03 = new Enemy_03();
                    y = random.nextInt((int) database.getScreen().getHeight() - (int) enemy_03.getHeight());
                    enemy_03.changeLocation((int) database.getScreen().getWidth(), y);
                    enemis.add(enemy_03);
                    break;
                case 1:
                    Enemy_04 enemy_04_1 = new Enemy_04();
                    y = random.nextInt((int) database.getScreen().getHeight() - (int) enemy_04_1.getHeight());
                    enemy_04_1.changeLocation((int) database.getScreen().getWidth(), y);
                    enemis.add(enemy_04_1);
                    break;
                case 2:
                    Enemy_05 enemy_05_1 = new Enemy_05();
                    enemy_05_1.changeLocation((int) database.getScreen().getWidth(), 0);
                    enemis.add(enemy_05_1);
                    break;
                case 3:
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Enemy_05 enemy_05_2 = new Enemy_05();
                    enemy_05_2.changeLocation((int) database.getScreen().getWidth(), 0);
                    enemis.add(enemy_05_2);
                    break;
            }
        }
        round++;
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