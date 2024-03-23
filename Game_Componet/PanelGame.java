// Package
package Game_Componet;

// Import
import Game_Object.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;

// PanelGame
public class PanelGame extends JPanel {

    private Graphics2D g2;
    private BufferedImage image;
    private int width;
    private int height;
    private Thread thread;
    private boolean start = true;
    private Key key;
    private int shotTime;

    // Game FPS
    private final int FPS = 60;
    private final int Target_Time = (int) Math.pow(10, 9) / FPS;

    // Game Object
    private Player player;
    private List<Bullet> bullets;
    private List<Enemy> enemies;

    public void start() {
        width = getWidth();
        height = getHeight();
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2 = image.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (start) {
                    long startTime = System.nanoTime();
                    drawBackground();
                    drawGame();
                    render();
                    long time = System.nanoTime() - startTime;
                    if (time < Target_Time) {
                        long sleep = (Target_Time - time) / (int) Math.pow(10, 6);
                        sleep(sleep);
                    }
                }
            }
        });
        initObjectGame();
        initKeyboard();
        initBullet();
        thread.start();
    }

    private void addEnemy() {
        Random ran = new Random();
        Enemy enemy = new Enemy();
        int location_Y = ran.nextInt(height - (int) enemy.getHeight()) + 25;
        enemy.changeLocation(width, location_Y);
        enemies.add(enemy);
    }

    private void initObjectGame() {
        player = new Player();
        enemies = new ArrayList<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (start) {
                    addEnemy();
                    sleep(3000);
                }
            }
        }).start();
    }

    private void initBullet() {
        bullets = new ArrayList<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (start) {
                    for (int i = 0; i < bullets.size(); i++) {
                        Bullet bullet = bullets.get(i);
                        if (bullet != null) {
                            bullet.update();
                            checkBullet(bullet);
                            if (!bullet.check(width, height)) {
                                bullets.remove(bullet);
                            }
                        }
                    }
                    sleep(1);
                }
            }
        }).start();
    }

    private void initKeyboard() {
        key = new Key();
        requestFocus();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    key.set_Key_Up(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    key.set_Key_Down(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    key.set_Key_Left(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    key.set_Key_Right(true);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    key.set_Key_Up(false);
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    key.set_Key_Down(false);
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    key.set_Key_Left(false);
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    key.set_Key_Right(false);
                }
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (start) {
                    if (key.get_Key_Up() && player.getY() >= 0) {
                        player.changeLocation(player.getX(), player.getY() - player.getSpeed());
                    }
                    if (key.get_Key_Down() && player.getY() <= height - player.getHeight()) {
                        player.changeLocation(player.getX(), player.getY() + player.getSpeed());
                    }
                    if (key.get_Key_Left() && player.getX() >= 0) {
                        player.changeLocation(player.getX() - player.getSpeed(), player.getY());
                    }
                    if (key.get_Key_Right() && player.getX() <= width - player.getWidth()) {
                        player.changeLocation(player.getX() + player.getSpeed(), player.getY());
                    }
                    if (shotTime == 0) {
                        bullets.add(0, new Bullet(player.getX() + player.getWidth() - 25, player.getY() + 25));
                    }
                    shotTime++;
                    if (shotTime == 50) {
                        shotTime = 0;
                    }
                    for (int i = 0; i < enemies.size(); i++) {
                        Enemy enemy = enemies.get(i);
                        if (enemy != null) {
                            enemy.update();
                            if (!enemy.check(width, height)) {
                                enemies.remove(enemy);
                                System.out.println("Remove");
                            }
                        }
                    }
                    sleep(5);
                }
            }
        }).start();
    }

    private void sleep(long sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

    private void checkBullet(Bullet bullet) {
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            if (enemy != null) {
                Area area = new Area(bullet.getShape());
                area.intersect(enemy.getShape());
                if (!area.isEmpty()) {
                    enemies.remove(enemy);
                    bullets.remove(bullet);
                }
            }
        }
    }

    private void drawBackground() {
        g2.setColor(new Color(30, 30, 30));
        g2.fillRect(0, 0, width, height);
    }

    private void drawGame() {
        player.draw(g2);
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            if (bullet != null) {
                bullet.draw(g2);
            }
        }
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            if (enemy != null) {
                enemy.draw(g2);
            }
        }
    }

    private void render() {
        Graphics g = getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
    }
}
