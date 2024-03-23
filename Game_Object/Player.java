// Package
package Game_Object;

// Import
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Player {

    private double x;
    private double y;
    private float speed = 5f;
    private final Image image;
    private final Area playerShap;

    public Player() {
        image = new ImageIcon(getClass().getResource("/Player/Still/Player_still.png")).getImage();
        Path2D p = new Path2D.Double();
        p.moveTo(0, 0);
        p.lineTo(0, getHeight());
        p.lineTo(getWidth(), getHeight());
        p.lineTo(getWidth(), 0);
        playerShap = new Area(p);
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
        g2.setColor(Color.GREEN);
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
        return new Area(afx.createTransformedShape(playerShap));
    }
}
