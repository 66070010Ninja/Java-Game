// Packge
package Game_Object;

// Import
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Enemy {

    private double x;
    private double y;
    private float speed = 0.3f;
    private final Image image;
    private final Area enemyShap;

    public Enemy() {
        image = new ImageIcon(getClass().getResource("/Img/Enemy/Enemy-01.png")).getImage();
        Path2D p = new Path2D.Double();
        p.moveTo(0, 0);
        p.lineTo(0, getHeight());
        p.lineTo(getWidth(), getHeight());
        p.lineTo(getWidth(), 0);
        enemyShap = new Area(p);
    }

    public void update() {
        x -= getSpeed();
    }

    public void changeLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g2) {
        AffineTransform oldTransform = g2.getTransform();
        g2.translate(x, y);
        AffineTransform tran = new AffineTransform();

        g2.drawImage(image, tran, null);

        g2.setTransform(oldTransform);

        // Test
        Shape shape = getShape();
        g2.setColor(Color.RED);
        g2.draw(shape);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public float getSpeed() {
        return speed;
    }

    public double getWidth() {
        return image.getWidth(null);
    }

    public double getHeight() {
        return image.getHeight(null);
    }

    public Area getShape() {
        AffineTransform afx = new AffineTransform();
        afx.translate(x, y);
        return new Area(afx.createTransformedShape(enemyShap));
    }

    public boolean check(int width, int height) {
        Rectangle size = getShape().getBounds();
        if (x < -size.getWidth() || y < -size.getHeight() || x > width || y > height) {
            return false;
        }
        else {
            return true;
        }
    }
}
