
public class Play extends Button {

    private DataBase_Menu data = new DataBase_Menu();
    private DataBase database = new DataBase();
    private boolean selection;

    public Play() {
        setImage(data.getPlay_Image());
        setImage_H(data.getPlay_H_Image());
        changeLocation(database.getScreen().getWidth()/2.0 - data.getPlay_Image().getWidth(null)/2.0, 470);
        setSelection(false);
    }

    public boolean getSelection() {
        return selection;
    }

    public void setSelection(boolean selection) {
        this.selection = selection;
    }

    @Override
    public void update() {
        if (getOnClick()) {
            setOnClick(false);
            setSelection(true);
        }
    }
}
