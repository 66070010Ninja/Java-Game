
public class Enemy_04 extends Object implements Check {
    private DataBase database = new DataBase();
    private List_Bullet bullets;
    private boolean attack = false;

    public Enemy_04() {
        setImage(database.getEnemy_04_Image());
        setArea();
        setSpeed(database.getEnemy_04_Speed());
        bullets = new List_Bullet(this);
        setListBullets(bullets);
        setHP(database.getEnemy_04_HP());
        setHP_Image(database.getHP_Image());
        setMax_HP_Image(database.getMax_HP_Image(), database.getEnemy_04_HP());
        setCount_Dead(database.getCount_Dead());
        setAttack(database.get_Enemy_04_Attack());
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
        if (getX() >= (int)database.getScreen().getWidth()-getWidth() - 20) {
            setX(getX() - getSpeed());
        }
        else if (getImage() == database.getNull_Image()) {
            setX(getX() - getSpeed());
        }
    }

    public void setAttack(boolean attack) {
        this.attack = attack;
    }
    public boolean getAttack() {
        return attack;
    }
}
