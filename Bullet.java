
public class Bullet extends Object {
    private DataBase database = new DataBase();
    private Object object;
    private int type_bullet;

    public Bullet(double x, double y, Object object, int type_bullet) {
        this.object = object;
        this.type_bullet = type_bullet;
        setX(x);
        setY(y);
        if (object instanceof Player) {
            setImage(database.getBullet_Player_Image());
            setArea();
            setSpeed(database.getBullet_Player_Speed());
        }
        else if (object instanceof Enemy_01) {
            setImage(database.getBullet_Enemy_01_Image());
            setArea();
            setSpeed(database.getBullet_Enemy_01_Speed());
        }
        else if (object instanceof Enemy_03) {
            setImage(database.getBullet_Enemy_03_Image());
            setArea();
            setSpeed(database.getBullet_Enemy_03_Speed());
        }
    }

    public boolean check() {
        if (getX() < -(int)database.getScreen().getWidth() || getY() < -(int)database.getScreen().getHeight() || getX() > (int)database.getScreen().getWidth() || getY() > (int)database.getScreen().getHeight()) {
            return false;
        }
        else {
            return true;
        }
    }

    public Object getObject() {
        return object;
    }

    @Override
    public void update() {
        if (object instanceof Player && type_bullet == 0) {
            setX(getX() + getSpeed());
        }
        else if (object instanceof Enemy_01 && type_bullet == 0) {
            setX(getX() - getSpeed());
        }
        else if (object instanceof Enemy_03 && type_bullet == 1) {
            setX(getX() - getSpeed());
            setY(getY() + getSpeed()/3);
        }
        else if (object instanceof Enemy_03 && type_bullet == 2) {
            setX(getX() - getSpeed());
        }
        else if (object instanceof Enemy_03 && type_bullet == 3) {
            setX(getX() - getSpeed());
            setY(getY() - getSpeed()/3);
        }
    }
}
