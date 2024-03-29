
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
        setEnemy_Left(50);
        setType_Bullet(database.get_Type_Bullet());
    }

    public void getItem(Item item) {
        switch (item.get_Type_Item()) {
            case 1:
                setAttack(getAttack_to_HP()*2);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                if (get_HP()+20 > get_Max_HP()) {
                    setHP(get_Max_HP());
                }
                else {
                    setHP(get_HP() + 20);
                }
                break;
            case 5:
                setType_Bullet(1);
                break;
            case 6:
                setType_Bullet(2);
                break;
            case 7:
                setType_Bullet(3);
                break;
            case 8:
                setType_Bullet(4);
                break;
        }
    }

    @Override
    public void update() {}
}
