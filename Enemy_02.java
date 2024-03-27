
public class Enemy_02 extends Object {
    private DataBase database = new DataBase();
    private boolean turn_back = false;

    public Enemy_02() {
        setImage(database.getEnemy_02_Image());
        setArea();
        setSpeed(database.getEnemy_02_Speed());
        setHP(database.getEnemy_02_HP());
    }

    public boolean check() {
        if (getX() < -(int)getWidth() || getX() > (int)database.getScreen().getWidth()) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public void update() {
        if (!turn_back) {
            setX(getX() - getSpeed());
        }
        else {
            setX(getX() + getSpeed());
        }
        if (getX() < -(int)getWidth()) {
            turn_back = true;
        }
        else if (getX() > (int)database.getScreen().getWidth()) {
            turn_back = false;
        }
    }
}
