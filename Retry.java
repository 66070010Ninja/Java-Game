
public class Retry extends Button {

    private DataBase_Menu data = new DataBase_Menu();
    private DataBase database = new DataBase();
    private Sound sound;
    private Menu menu;

    public Retry(Sound sound, Menu menu) {
        this.sound = sound;
        this.menu = menu;
        setImage(data.getRetry_Image());
        setImage_H(data.getRetry_H_Image());
        changeLocation(database.getScreen().getWidth()/2.0 - data.getRetry_Image().getWidth(null)/2.0, 530);
    }

    @Override
    public void update() {
        if (getOnClick()) {
            menu.setReset_Game(true);
            sound.stop();
            setOnClick(false);
        }
    }
}
