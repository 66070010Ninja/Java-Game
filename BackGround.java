
public class BackGround extends Object {
    private DataBase database = new DataBase();

    public BackGround () {
        setImage(database.getBG_Image());
        setArea();
    }

    @Override
    public void update() {}
}
