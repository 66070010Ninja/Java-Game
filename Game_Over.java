public class Game_Over extends Object {

    private DataBase database = new DataBase();

    public Game_Over() {
        setImage(database.getGameOver_Image());
        setArea();
        changeLocation((int)database.getScreen().getWidth()/2 - getImage().getWidth(null)/2, (int)database.getScreen().getHeight()/2 - getImage().getHeight(null)/2);
    }

    @Override
    public void update() {}
}
