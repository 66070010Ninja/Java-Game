// //new by pure

// import java.awt.*;
// import java.awt.image.*;
// import javax.swing.*;

// public class SelectLevel extends JPanel {
//     private DataBase database = new DataBase();
//     private BufferedImage image;
//     private Graphics2D g2D;
//     private Thread thread;

//     private BackGround_Level bg;
//     private Level1_Button lv1;
//     private Level2_Button lv2;
//     private LevelBoss_Button lvboss;

    

//     public SelectLevel() {
//         image = new BufferedImage((int)database.getScreen().getWidth(), (int)database.getScreen().getHeight(), BufferedImage.TYPE_INT_ARGB);
//         g2D = image.createGraphics();
//         g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//         g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//     }

//     public void start() {
//         thread = new Thread(new Runnable() {
//             public void run() {
//                 while (database.getStart()) {
//                     long start_time = System.nanoTime();

                    
//                     drawBackground();
//                     drawButton();
//                     update();
//                     render();

//                     long time = System.nanoTime() - start_time;
//                     if (time < database.getTarget_Time()) {
//                         try {
//                             Thread.sleep(database.getSleep(time));
//                         }
//                         catch (InterruptedException ie) {
//                             ie.printStackTrace();
//                         }
//                     }
//                 }
//             }
//         });
//         initObjectGame();
//         initMouse();
//         thread.start();
//     }

//     public void initObjectGame() {
//         bg = new BackGround_Level();
//         lv1 = new Level1_Button();
//         lv2 = new Level2_Button();
//         lvboss = new LevelBoss_Button();
//     }

//     public void initMouse() {
//         new Mouse(this, lv1);
//         new Mouse(this, lv2);
//         new Mouse(this, lvboss);
//     }

//     public void drawBackground() {
//         bg.draw(g2D, null);
//     }

//     public void drawButton() {
//         lv1.darw(g2D);
//         lv2.darw(g2D);
//         lvboss.darw(g2D);
//     }

//     public void update() {
//         lv1.update();
//         lv2.update();
//         lvboss.update();
//     }

//     public void render() {
//         Graphics g = getGraphics();
//         g.drawImage(image, 0, 0, null);
//         g.dispose();
//     }
// }


import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class SelectLevel extends JPanel {
    private DataBase database = new DataBase();
    private BufferedImage image;
    private Graphics2D g2D;
    private Thread thread;
    private JFrame frame;

    private BackGround_Level bg;
    private Level1_Button lv1;
    private Level2_Button lv2;
    private LevelBoss_Button lvboss;
    private RunGame rungame;
    private boolean game_start;
    private Status Status = new Status();

    public boolean check = false;
    public boolean added = false;
    //
    public boolean played = false;
    //

    public SelectLevel(JFrame frame) {

        image = new BufferedImage((int)database.getScreen().getWidth(), (int)database.getScreen().getHeight(), BufferedImage.TYPE_INT_ARGB);
        g2D = image.createGraphics();
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        this.frame = frame;
        Status.setStatus("Level");
    }

    public void start() {
        thread = new Thread(new Runnable() {
            public void run() {
                while (database.getStart()) {
                    long start_time = System.nanoTime();

                    System.out.println(Status.getStatus());
                    if ((Status.getStatus() == "Level")) {
                        
                        drawBackground();
                        drawButton();
                        update();
                        render();
                        //RunGame rg = new RunGame(g2D, rungame, Status);
                    }
                    else if (Status.getStatus() == "Game") {
                        //rungame = new RunGame(g2D, this, Status);
                        rungame.start();
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
        bg = new BackGround_Level();
        lv1 = new Level1_Button(game_start, Status);
        lv2 = new Level2_Button();
        lvboss = new LevelBoss_Button();
        rungame = new RunGame(g2D, this, Status);
        frame.add(rungame);
        game_start = false;
    }

    public void initMouse() {
        new Mouse(this, lv1);
        new Mouse(this, lv2);
        new Mouse(this, lvboss);
    }

    public void drawBackground() {
        bg.draw(g2D, null);
    }
    public void drawButton() {
        lv1.darw(g2D);
        lv2.darw(g2D);
        lvboss.darw(g2D);
    }

    public void update() {
        lv1.update();
        lv2.update();
        lvboss.update();
        
    }

    public void render() {
        Graphics g = getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
    }

    public JFrame getJFrame() {
        return frame;
    }
}
