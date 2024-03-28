
public class Player extends Object {
    private DataBase database = new DataBase();
    private List_Bullet bullets;

    public Player () {
        setImage(database.getPlayer_Image());
        setArea();
        setSpeed(database.getPlayer_Speed());
        bullets = new List_Bullet(this);
        setListBullets(bullets);
        setHP_Image(database.getHP_Player_Image());
        setMax_HP_Image(database.getHP_Player_Null_Image(), database.getPlayer_HP());
        setCount_Dead(database.getCount_Dead());
        changeLocation(100, 100);
    }

    @Override
    public void update() {}
}
