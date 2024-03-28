
public class Enemy_03 extends Object implements Check {
    private DataBase database = new DataBase();
    private List_Bullet bullets;

    public Enemy_03() {
        setImage(database.getEnemy_03_Image());
        setArea();
        setSpeed(database.getEnemy_03_Speed());
        bullets = new List_Bullet(this);
        setListBullets(bullets);
        setHP(database.getEnemy_03_HP());
        setHP_Image(database.getHP_Image());
        setMax_HP_Image(database.getMax_HP_Image(), database.getEnemy_03_HP());
        setCount_Dead(database.getCount_Dead());
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
        setX(getX() - getSpeed());
    }

    public void getDamage(Object object) {
        
    }
}
