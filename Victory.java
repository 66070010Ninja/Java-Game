
public class Victory extends Object {

    private DataBase database = new DataBase();

    public Victory() {
        setImage(database.getVictory_Image());
        setArea();
    }

    @Override
    public void update() {}
}
