
public class Continue extends Button {

    private DataBase database = new DataBase();
    private DataBase_Menu data = new DataBase_Menu();
    private Player player;

    public Continue(Player player) {
        this.player = player;
        setImage(data.getContinuse_Image());
        setImage_H(data.getContinuse_H_Image());
        changeLocation(database.getScreen().getWidth()/2.0 - data.getContinuse_Image().getWidth(null)/2.0, 300);
    }

    @Override
    public void update() {
        if (getOnClick()) {
            setOnClick(false);
            player.setPause(false);
        }
    }
}
