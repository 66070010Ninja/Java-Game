
import java.awt.*;

public abstract class Button {

    private double x;
    private double y;
    private Image image;
    private Image image_h;
    private boolean hover = false;
    private boolean onclick = false;

    public void darw(Graphics2D g2D) {
        if (getHover() == true) {
            g2D.drawImage(getImage_H(), (int)getX(), (int)getY(), null);
        }
        else {
            g2D.drawImage(getImage(), (int)getX(), (int)getY(), null);
        }
    }

    public void setOnClick(boolean onclick) {
        this.onclick = onclick;
    }
    public boolean getOnClick() {
        return onclick;
    }

    public void changeLocation(double x, double y) {
        setX(x);
        setY(y);
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void setImage(Image image) {
        this.image = image;
    }
    public void setImage_H(Image image_h) {
        this.image_h = image_h;
    }
    public void setHover(boolean hover) {
        this.hover = hover;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public Image getImage() {
        return image;
    }
    public Image getImage_H() {
        return image_h;
    }
    public boolean getHover() {
        return hover;
    }

    public abstract void update();
}
