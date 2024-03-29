
import java.util.*;

public class Item extends Object {

    private DataBase database = new DataBase();
    private int type_item;
    private Random random;

    public Item(Object object) {
        random = new Random();
        type_item = random.nextInt(1, 9);;
        if (type_item == 1) {
            setImage(database.getItem_DM2_Image());
        }
        else if (type_item == 2) {
            setImage(database.getItem_Explosion_Image());
        }
        else if (type_item == 3) {
            setImage(database.getItem_FR2_Image());
        }
        else if (type_item == 4) {
            setImage(database.getItem_Heal_Image());
        }
        else if (type_item == 5) {
            setImage(database.getItem_Type_Bullet_01_Image());
        }
        else if (type_item == 6) {
            setImage(database.getItem_Type_Bullet_02_Image());
        }
        else if (type_item == 7) {
            setImage(database.getItem_Type_Bullet_03_Image());
        }
        else if (type_item == 8) {
            setImage(database.getItem_Type_Bullet_04_Image());
        }
        setArea();
        setSpeed(database.getItem_Speed());
        changeLocation(object.getX(), object.getY());
    }

    public int get_Type_Item() {
        return type_item;
    }

    public boolean check() {
        if (getX() < -(int)database.getScreen().getWidth() || getY() < -(int)database.getScreen().getHeight() || getX() > (int)database.getScreen().getWidth() || getY() > (int)database.getScreen().getHeight()) {
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
}
