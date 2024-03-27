
public class Player extends Object {
    private DataBase database = new DataBase();
    private List_Bullet bullets;

    public Player () {
        setImage(database.getPlayer_Image());
        setArea();
        setSpeed(database.getPlayer_Speed());
        bullets = new List_Bullet(this);
        setListBullets(bullets);
        setHP(database.getPlayer_HP());
    }

    public void getDamage(Object object) {}

    @Override
    public void update() {}
}
