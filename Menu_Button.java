
public class Menu_Button extends Button {

    private DataBase database = new DataBase();
    private DataBase_Menu data = new DataBase_Menu();
    private Play play;
    private Sound sound;

    public Menu_Button(Play play, Sound sound) {
        this.play = play;
        this.sound = sound;
        setImage(data.getMenu_Image());
        setImage_H(data.getMenu_H_Image());
        changeLocation(database.getScreen().getWidth()/2.0 - data.getMenu_Image().getWidth(null)/2.0, 500);
    }

    public Play getPlay() {
        return play;
    }

    @Override
    public void update() {
        if (getOnClick()) {
            setOnClick(false);
            sound.stop();
            play.setSelection(false);
            play.setOnClick(false);
        }
    }
}
