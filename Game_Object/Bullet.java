// Package
package Game_Object;

// Import
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Bullet {

    private double x;
    private double y;
    private float speed = 4f;
    private final Image image;
    private final Area bulletShap;

    public Bullet(double x, double y) {
        this.image = new ImageIcon(getClass().getResource("/Img/Bullet/Player/Bullet.gif")).getImage();
        this.x = x;
        this.y = y;
        Path2D p = new Path2D.Double();
        p.moveTo(0, 0);
        p.lineTo(0, getHeight());
        p.lineTo(getWidth(), getHeight());
        p.lineTo(getWidth(), 0);
        bulletShap = new Area(p);
    }

    public void update() {
        x += speed;
    }

    public boolean check(int width, int height) {
        if (x < -getWidth() || y < -getHeight() || x > width || y > height) {
            return false;
        }
        else {
            return true;
        }
    }

    public void draw(Graphics2D g2) {
        AffineTransform oldTransform = g2.getTransform();
        g2.translate(x, y);
        AffineTransform tran = new AffineTransform();

        g2.drawImage(image, tran, null);

        g2.setTransform(oldTransform);

        // Test
        Shape shape = getShape();
        g2.setColor(Color.BLUE);
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
        return new Area(afx.createTransformedShape(bulletShap));
    }
}
