
import java.awt.geom.*;

public class CheckHitBox {
    private DataBase database = new DataBase();
    private Player player;
    private List_Enemy enemis;
    private List_Bullet bullets;
    private List_Item items;
    private Area area;

    public CheckHitBox(Player player, List_Enemy enemis, List_Item items) {
        this.player = player;
        this.enemis = enemis;
        this.items = items;
    }

    public void checkhitbox() {
        for (int i = 0; i < enemis.getList().size(); i++) {
            if (enemis.getList().get(i) instanceof Enemy_01) {
                Enemy_01 enemy_01 = (Enemy_01)enemis.getList().get(i);
                checkhitbox(enemy_01);
            }
            else if (enemis.getList().get(i) instanceof Enemy_02) {
                Enemy_02 enemy_02 = (Enemy_02)enemis.getList().get(i);
                checkhitbox(enemy_02);
            }
            else if (enemis.getList().get(i) instanceof Enemy_03) {
                Enemy_03 enemy_03 = (Enemy_03)enemis.getList().get(i);
                checkhitbox(enemy_03);
            }
            else if (enemis.getList().get(i) instanceof Enemy_04) {
                Enemy_04 enemy_04 = (Enemy_04)enemis.getList().get(i);
                checkhitbox(enemy_04);
            }
            else if (enemis.getList().get(i) instanceof Enemy_05) {
                Enemy_05 enemy_05 = (Enemy_05)enemis.getList().get(i);
                checkhitbox(enemy_05);
            }
        }
        if (player.getGolden_Time() != 0) {
            player.setGolden_Time(player.getGolden_Time() - 1);
        }
    }

    public void checkhitbox(Object enemy) {
        if (enemy != null && enemy.getImage() != database.getNull_Image()) {
            bullets = player.getList_Bullet();
            for (int i = 0; i < bullets.getBullets().size(); i++) {
                Bullet bullet = bullets.getBullets().get(i);
                area = new Area(bullet.getShape());
                area.intersect(enemy.getShape());
                if (!area.isEmpty() && !enemy.getImage().equals(database.getDead_Image()) && !enemy.getImage().equals(database.getNull_Image())) {
                    if (bullet.getType_Bullet() == 1 || bullet.getType_Bullet() == 3 || bullet.getType_Bullet() == 4) {
                        enemy.getDamage(bullet.getAttack_to_HP());
                        bullets.getBullets().remove(bullet);
                    }
                    else if (bullet.getType_Bullet() == 2) {
                        enemy.getDamage(bullet.getAttack_to_HP());
                    }
                }
                if (enemy.get_HP() <= 0 && !enemy.getImage().equals(database.getDead_Image()) && !enemy.getImage().equals(database.getNull_Image())) {
                    enemy.setImage(database.getDead_Image());
                    player.setEnemy_Left(player.getEnemy_Left() -1);
                }
                if (player.get_HP() <= 0) {
                    player.setImage(database.getDead_Image());
                }

                if (enemy.getImage() == database.getDead_Image() && enemy.getCount_Dead() <= 0) {
                    enemy.setImage(database.getNull_Image());
                }
                else if (enemy.getImage() == database.getDead_Image()) {
                    enemy.setCount_Dead(enemy.getCount_Dead() - 1);
                }

                if (player.getImage() == database.getDead_Image() && player.getCount_Dead() <= 0) {
                    player.setImage(database.getNull_Image());
                }
                else if (player.getImage() == database.getDead_Image()) {
                    player.setCount_Dead(player.getCount_Dead() - 1);
                }
            }

            area = new Area(player.getShape());
            area.intersect(enemy.getShape());
            if (!area.isEmpty() && !enemy.getImage().equals(database.getDead_Image()) && !enemy.getImage().equals(database.getNull_Image()) && player.getGolden_Time() <= 0) {
                enemy.setImage(database.getDead_Image());
                enemy.setHP(0);
                player.getDamage(enemy.getAttack_to_HP());
                player.setEnemy_Left(player.getEnemy_Left() -1);
            }
        }

        if (enemy != null && enemy.getList_Bullet() != null) {
            bullets = enemy.getList_Bullet();
            for (int i = 0; i < bullets.getBullets().size(); i++) {
                Bullet bullet = bullets.getBullets().get(i);
                area = new Area(bullet.getShape());
                area.intersect(player.getShape());
                if (!area.isEmpty() && enemy instanceof Enemy_04) {
                    player.getDamage(bullet.getAttack_to_HP());
                }
                else if (!area.isEmpty()) {
                    player.getDamage(bullet.getAttack_to_HP());
                    bullets.getBullets().remove(bullet);
                }
            }
        }

        for (int i = 0; i < items.getItems().size(); i++) {
            Item item = items.getItems().get(i);
            area = new Area(item.getShape());
            area.intersect(player.getShape());
            if (!area.isEmpty()) {
                items.getItems().remove(item);
                player.getItem(item);
            }
        }
    }
}
