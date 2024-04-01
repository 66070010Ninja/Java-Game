
public class Credit extends Button {

    private DataBase database = new DataBase();
    private DataBase_Menu data = new DataBase_Menu();
    private MDI_Credit mdi;

    public Credit(MDI_Credit mdi) {
        this.mdi = mdi;
        setImage(data.getCredit_Image());
        setImage_H(data.getCredit_H_Image());
        changeLocation(database.getScreen().getWidth() - data.getCredit_Image().getWidth(null) - 200, 600);
    }

    @Override
    public void update() {
        if (getOnClick()) {
            setOnClick(false);
            mdi.setVisible_MDI(true);
        }
    }
}
