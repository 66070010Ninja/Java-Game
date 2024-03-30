
public class Player extends Object {
    private DataBase database = new DataBase();
    private List_Bullet bullets;
    private int reload_bullet;
    private int delay_change_bullet;
    private int time_use_icon_DM2;
    private int time_use_icon_FR2;
    private boolean use_DM2 = false;
    private boolean use_FR2 = false;
    private boolean pause = false;

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
        setType_Bullet(database.get_Type_Bullet());
        if (getType_Bullet() == 1) {
            setReload_Bullet(database.getPlayer_Reload_Bullet_Type_01());
        }
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }
    public boolean getPause() {
        return pause;
    }

    public void setTime_Use_Icon_DM2(int time_use_icon_DM2) {
        this.time_use_icon_DM2 = time_use_icon_DM2;
        if (this.time_use_icon_DM2 <= 0) {
            use_DM2 = false;
        }
        else {
            use_DM2 = true;
        }
    }
    public void setTime_Use_Icon_FR2(int time_use_icon_FR2) {
        this.time_use_icon_FR2 = time_use_icon_FR2;
        if (this.time_use_icon_FR2 <= 0) {
            use_FR2 = false;

            if (getType_Bullet() == 1) {
                setReload_Bullet(database.getPlayer_Reload_Bullet_Type_01());
            }
            else if (getType_Bullet() == 2) {
                setReload_Bullet(database.getPlayer_Reload_Bullet_Type_02());
            }
            else if (getType_Bullet() == 3) {
                setReload_Bullet(database.getPlayer_Reload_Bullet_Type_03());
            }
            else if (getType_Bullet() == 4) {
                setReload_Bullet(database.getPlayer_Reload_Bullet_Type_04());
            }

        }
        else if (use_FR2 == false){
            setReload_Bullet(getReload_Bullet()/2);
            use_FR2 = true;
        }
    }
    public int getTime_Use_DM2() {
        return time_use_icon_DM2;
    }
    public int getTime_Use_FR2() {
        return time_use_icon_FR2;
    }
    public boolean getUse_DM2() {
        return use_DM2;
    }
    public boolean getUse_FR2() {
        return use_FR2;
    }

    public void setDelay_Change_Bullet(int delay_change_bullet) {
        this.delay_change_bullet = delay_change_bullet;
    }
    public void setReload_Bullet(int reload_bullet) {
        this.reload_bullet = reload_bullet;
    }
    public int getReload_Bullet() {
        return reload_bullet;
    }

    public void getItem(Item item) {
        switch (item.get_Type_Item()) {
            case 1:
                setTime_Use_Icon_DM2(database.getTime_Use_DM2());
                break;
            case 2:
                break;
            case 3:
                setTime_Use_Icon_FR2(database.getTime_Use_FR2());
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
                setReload_Bullet(database.getPlayer_Reload_Bullet_Type_01());
                setDelay_Change_Bullet(database.getDelay_Change_Bullet());
                break;
            case 6:
                setType_Bullet(2);
                setReload_Bullet(database.getPlayer_Reload_Bullet_Type_02());
                setDelay_Change_Bullet(database.getDelay_Change_Bullet());
                break;
            case 7:
                setType_Bullet(3);
                setReload_Bullet(database.getPlayer_Reload_Bullet_Type_03());
                setDelay_Change_Bullet(database.getDelay_Change_Bullet());
                break;
            case 8:
                setType_Bullet(4);
                setReload_Bullet(database.getPlayer_Reload_Bullet_Type_04());
                setDelay_Change_Bullet(database.getDelay_Change_Bullet());
                break;
        }
    }

    public int getDelay_Change_Bullet() {
        return delay_change_bullet;
    }

    @Override
    public void update() {}
}
