
import java.awt.*;
import java.awt.geom.*;

public abstract class Object {
    private double x;
    private double y;
    private int hp;
    private float speed;
    private Image image;
    private List_Bullet bullets = null;
    private Area area;
    private Path2D path2D = new Path2D.Double();

    public void draw(Graphics2D g2D, Color color) {
        AffineTransform oldTransform = g2D.getTransform();
        g2D.translate(getX(), getY());
        AffineTransform tran = new AffineTransform();

        g2D.drawImage(getImage(), tran, null);

        g2D.setTransform(oldTransform);

        if (bullets != null) {
            bullets.draw(g2D, color);
        }

        if (color != null) {
            Shape shape = getShape();
            g2D.setColor(color);
            g2D.draw(shape);
        }
    }

    public void setHP(int hp) {
        this.hp = hp;
    }
    public void setListBullets(List_Bullet bullets) {
        this.bullets = bullets;
    }
    public void setImage(Image image) {
        this.image = image;
    }
    public void setArea() {
        path2D.moveTo(0, 0);
        path2D.lineTo(0, getHeight());
        path2D.lineTo(getWidth(), getHeight());
        path2D.lineTo(getWidth(), 0);
        area =  new Area(path2D);
    }
    public void changeLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public List_Bullet getList_Bullet() {
        return bullets;
    }
    public int get_HP() {
        return hp;
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
    public Image getImage() {
        return image;
    }
    public double getWidth() {
        return image.getWidth(null);
    }
    public double getHeight() {
        return image.getHeight(null);
    }
    public Area getArea() {
        return area;
    }
    public Area getShape() {
        AffineTransform afx = new AffineTransform();
        afx.translate(getX(), getY());
        return new Area(afx.createTransformedShape(getArea()));
    }

    public abstract void update();
}
