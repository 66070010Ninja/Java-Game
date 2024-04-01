public class Victory_Next_Level extends Button {

    private DataBase database = new DataBase();
    private DataBase_Menu data = new DataBase_Menu();
    private Sound sound;
    private Menu menu;
    private Level_Game<Integer> level;
    private Level_Game<Integer> level_now;

    public Victory_Next_Level(Sound sound, Menu menu, Level_Game<Integer> level, Level_Game<Integer> level_now) {
        this.sound = sound;
        this.menu = menu;
        this.level = level;
        this.level_now = level_now;
        setImage(data.getNext_Level_Image());
        setImage_H(data.getNext_Level_H_Image());
        changeLocation(database.getScreen().getWidth()/2.0 + 250, 600);
    }

    @Override
    public void update() {
        if (getOnClick()) {
            level.setlevel_game(level.getlevel_game() + 1);
            if (level.getlevel_game() > level_now.getlevel_game()) {
                level_now.setlevel_game(level.getlevel_game());
            }
            menu.setReset_Game(true);
            sound.stop();
            setOnClick(false);
        }
    }
}
