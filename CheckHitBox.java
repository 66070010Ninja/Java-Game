
import java.awt.geom.*;

public class CheckHitBox {
    private DataBase database = new DataBase();
    private Player player;
    private List_Enemy enemis;
    private List_Bullet bullets;
    private Area area;

    public CheckHitBox(Player player, List_Enemy enemis) {
        this.player = player;
        this.enemis = enemis;
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
    }

    public void checkhitbox(Object enemy) {
        if (enemy != null && enemy.getImage() != database.getNull_Image()) {
            bullets = player.getList_Bullet();
            for (int i = 0; i < bullets.getBullets().size(); i++) {
                Bullet bullet = bullets.getBullets().get(i);
                area = new Area(bullet.getShape());
                area.intersect(enemy.getShape());
                if (!area.isEmpty()) {
                    enemy.getDamage(bullet.getAttack_to_HP());
                    bullets.getBullets().remove(bullet);
                }
                if (enemy.get_HP() <= 0) {
                    enemy.setImage(database.getDead_Image());
                }
                if (enemy.getImage() == database.getDead_Image() && enemy.getCount_Dead() <= 0) {
                    enemy.setImage(database.getNull_Image());
                }
                else if (enemy.getImage() == database.getDead_Image()) {
                    enemy.setCount_Dead(enemy.getCount_Dead() - 1);
                }
            }

            area = new Area(player.getShape());
            area.intersect(enemy.getShape());
            if (!area.isEmpty() && enemy.getImage() != database.getNull_Image()) {
                enemy.setImage(database.getDead_Image());
                enemy.setHP(0);
            }
        }

        if (enemy != null && enemy.getList_Bullet() != null) {
            bullets = enemy.getList_Bullet();
            for (int i = 0; i < bullets.getBullets().size(); i++) {
                Bullet bullet = bullets.getBullets().get(i);
                area = new Area(bullet.getShape());
                area.intersect(player.getShape());
                if (!area.isEmpty() && enemy instanceof Enemy_04) {
                }
                else if (!area.isEmpty()) {
                    bullets.getBullets().remove(bullet);
                }
            }
        }
    }
}
