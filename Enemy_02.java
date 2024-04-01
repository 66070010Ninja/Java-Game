
public class Enemy_02 extends Object implements Check {
    private DataBase database = new DataBase();
    private boolean turn_back = false;
    private int round = 1;

    public Enemy_02() {
        setImage(database.getEnemy_02_Image());
        setArea();
        setSpeed(database.getEnemy_02_Speed());
        setHP(database.getEnemy_02_HP());
        setHP_Image(database.getHP_Image());
        setMax_HP_Image(database.getMax_HP_Image(), database.getEnemy_02_HP());
        setCount_Dead(database.getCount_Dead());
        setAttack(database.get_Enemy_02_Attack());
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
        if (getX() < -(int)getWidth() && turn_back == false && getImage() != database.getNull_Image() && round != 0) {
            turn_back = true;
            setImage(database.getEnemy_02_Turn_Back_Image());
            round--;
        }
        else if (getX() > (int)database.getScreen().getWidth() && turn_back == true && getImage() != database.getNull_Image()) {
            turn_back = false;
            setImage(database.getEnemy_02_Image());
        }
        else if (getX() < -(int)getWidth() && turn_back == false && getImage() != database.getNull_Image()) {
            setImage(database.getNull_Image());
        }
    }
}
