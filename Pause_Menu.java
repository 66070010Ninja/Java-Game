
public class Pause_Menu extends Object {

    private DataBase database = new DataBase();

    public Pause_Menu() {
        setImage(database.getBG_Pause());
        setArea();
        changeLocation((int)database.getScreen().getWidth()/2 - getImage().getWidth(null)/2, (int)database.getScreen().getHeight()/2 - getImage().getHeight(null)/2);
    }

    @Override
    public void update() {}
}
