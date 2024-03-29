
public class Bullet extends Object {
    private DataBase database = new DataBase();
    private Object object;
    private int type_bullet;

    public Bullet(double x, double y, Object object, int type_bullet) {
        this.object = object;
        this.type_bullet = type_bullet;
        setX(x);
        setY(y);
        if (object instanceof Player && type_bullet == 0) {
            setImage(database.getBullet_Player_Type_01_Image());
            setArea();
            setSpeed(database.getBullet_Player_Speed());
            setAttack(database.get_Player_Attack());
            setType_Bullet(1);
        }
        else if (object instanceof Player && type_bullet == 1) {
            setImage(database.getBullet_Player_Type_02_Image());
            setArea();
            setSpeed(database.getBullet_Player_Speed());
            setAttack(database.get_Player_Attack());
            setType_Bullet(2);
        }
        else if (object instanceof Player && type_bullet == 2) {
            setImage(database.getBullet_Player_Type_03_Image());
            setArea();
            setSpeed(database.getBullet_Player_Speed());
            setAttack(database.get_Player_Attack());
            setType_Bullet(3);
        }
        else if (object instanceof Player && type_bullet == 3 || type_bullet == 4 || type_bullet == 5) {
            setImage(database.getBullet_Player_Type_04_Image());
            setArea();
            setSpeed(database.getBullet_Player_Speed());
            setAttack(database.get_Player_Attack());
            setType_Bullet(4);
        }
        else if (object instanceof Enemy_01) {
            setImage(database.getBullet_Enemy_01_Image());
            setArea();
            setSpeed(database.getBullet_Enemy_01_Speed());
            setAttack(database.get_Enemy_01_Attack());
        }
        else if (object instanceof Enemy_03) {
            setImage(database.getBullet_Enemy_03_Image());
            setArea();
            setSpeed(database.getBullet_Enemy_03_Speed());
            setAttack(database.get_Enemy_01_Attack());
        }
        else if (object instanceof Enemy_04) {
            setImage(database.getBullet_Enemy_04_Image());
            setArea();
            setAttack(database.get_Enemy_04_Attack());
        }
        else if (object instanceof Enemy_05) {
            setImage(database.getBullet_Enemy_05_Image());
            setArea();
            setSpeed(database.getBullet_Enemy_05_Speed());
            setAttack(database.get_Enemy_05_Attack());
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
        if (object instanceof Player && type_bullet == 0 || type_bullet == 2) {
            setX(getX() + getSpeed());
        }
        else if (object instanceof Player && type_bullet == 1) {
            setX(getX() + getSpeed()/2);
        }
        else if (object instanceof Player && type_bullet == 3) {
            setX(getX() + getSpeed());
            setY(getY() + getSpeed()/3);
        }
        else if (object instanceof Player && type_bullet == 4) {
            setX(getX() + getSpeed());
        }
        else if (object instanceof Player && type_bullet == 5) {
            setX(getX() + getSpeed());
            setY(getY() - getSpeed()/3);
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
        else if (object instanceof Enemy_05 && type_bullet == 0) {
            setX(getX() - getSpeed());
            setY(getY() + getSpeed()/2);
        }
    }
}
