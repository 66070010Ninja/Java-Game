public class Retry_Victory extends Button {

    private DataBase_Menu data = new DataBase_Menu();
    private DataBase database = new DataBase();
    private Sound sound;
    private Menu menu;

    public Retry_Victory(Sound sound, Menu menu) {
        this.sound = sound;
        this.menu = menu;
        setImage(data.getRetry_Victory_Image());
        setImage_H(data.getRetry_Victory_H_Image());
        changeLocation(database.getScreen().getWidth()/2.0 - data.getRetry_Image().getWidth(null)/2.0, 600);
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
