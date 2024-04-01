
import java.awt.*;
import java.util.*;

public class List_Item {
    private DataBase database = new DataBase();
    private ArrayList<Item> items = new ArrayList<Item>();
    private Thread thread;
    private int time = 1;

    public List_Item(Player player, List_Enemy enemis) {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (database.getStart()) {
                    for (int i = 0; i < enemis.getList().size(); i++) {
                        Object object = enemis.getList().get(i);
                        if (items.size() != 0) {
                            break;
                        }
                        else if ((player.getEnemy_Left()%5 == 0) && items.size() == 0 && object.getImage().equals(database.getDead_Image())) {
                            items.add(new Item(object));
                            break;
                        }
                    }
                    try {
                        Thread.sleep(time);
                    }
                    catch  (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

    public void draw(Graphics2D g2D, Color color) {
        for (int i = 0; i < items.size(); i++) {
            Item item = (Item)items.get(i);
            if (item != null) {
                item.draw(g2D, color);
                item.update();
                update();
            }
        }
    }

    public void update() {
        for (int i = 0; i < items.size(); i++) {
            Item item = (Item)items.get(i);
            if (item != null && !item.check()) {
                items.remove(item);
            }
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
