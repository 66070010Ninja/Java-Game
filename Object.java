
import java.awt.*;
import java.awt.geom.*;

public abstract class Object {
    private double x;
    private double y;
    private int hp;
    private int max_hp;
    private int attack;
    private float speed;
    private Image image;
    private Image hp_image;
    private Image max_hp_image;
    private List_Bullet bullets = null;
    private Area area;
    private Path2D path2D = new Path2D.Double();
    private int count_dead;

    public void draw(Graphics2D g2D, Color color) {

        g2D.drawImage(getImage(), (int)getX(), (int)getY(), null);

        if ((this instanceof Enemy_01 || this instanceof Enemy_02 || this instanceof Enemy_03 || this instanceof Enemy_04 || this instanceof Enemy_05) && get_HP() > 0) {
            g2D.drawImage(getMax_HP_Image(), (int)getX(), (int)getY() + (int)getHeight() + 10, null);
            g2D.drawImage(getHP_Image(), (int)getX(), (int)getY() + (int)getHeight() + 10, null);
        }

        if (bullets != null) {
            bullets.draw(g2D, color);
        }

        if (color != null) {
            Shape shape = getShape();
            g2D.setColor(color);
            g2D.draw(shape);
        }
    }

    public void setCount_Dead(int count_dead) {
        this.count_dead = count_dead;
    }
    public void setAttack(int attack) {
        this.attack = attack;
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
    public void setHP_Image(Image hp_Image) {
        hp_image = hp_Image.getScaledInstance((int)getWidth(), (int)hp_Image.getHeight(null), Image.SCALE_SMOOTH);
    }
    public void setHP_Image() {
        int true_hp = (int)((double)get_HP()/(double)get_Max_HP()*(double)getWidth());
        if (true_hp > 0) {
            hp_image = hp_image.getScaledInstance(true_hp, (int)hp_image.getHeight(null), Image.SCALE_SMOOTH);
        }
    }
    public void setMax_HP_Image(Image max_Image, int max_hp) {
        max_hp_image = max_Image.getScaledInstance((int)getWidth(), (int)max_Image.getHeight(null), Image.SCALE_SMOOTH);
        this.max_hp = max_hp;
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
    public int getCount_Dead() {
        return count_dead;
    }
    public int get_HP() {
        return hp;
    }
    public int get_Max_HP() {
        return max_hp;
    }
    public int getAttack_to_HP() {
        return attack;
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
    public Image getHP_Image() {
        return hp_image;
    }
    public Image getMax_HP_Image() {
        return max_hp_image;
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

    public void getDamage(int damage) {
        setHP(get_HP() - damage);
        setHP_Image();
    }

    public abstract void update();
}
