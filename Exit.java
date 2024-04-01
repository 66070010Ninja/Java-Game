public class Exit extends Button {
    
    private DataBase_Menu data = new DataBase_Menu();
    private DataBase database = new DataBase();

    public Exit() {
        setImage(data.getExit_Image());
        setImage_H(data.getExit_H_Image());
        changeLocation(database.getScreen().getWidth()/2.0 - data.getExit_Image().getWidth(null)/2.0, 800);
    }

    @Override
    public void update() {
        if (getOnClick()) {
            setOnClick(false);
            System.exit(0);
        }
    }
}
