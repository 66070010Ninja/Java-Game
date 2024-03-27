
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
                check_enemy(enemy_01);
            }
            else if (enemis.getList().get(i) instanceof Enemy_02) {
                Enemy_02 enemy_02 = (Enemy_02)enemis.getList().get(i);
                check_enemy(enemy_02);
            }
            else if (enemis.getList().get(i) instanceof Enemy_03) {
                Enemy_03 enemy_03 = (Enemy_03)enemis.getList().get(i);
                check_enemy(enemy_03);
            }
        }
    }

    public void check_enemy(Object enemy) {
        if (enemy != null && enemy.getImage() != database.getNull_Image()) {
            bullets = player.getList_Bullet();
            for (int i = 0; i < bullets.getBullets().size(); i++) {
                Bullet bullet = bullets.getBullets().get(i);
                area = new Area(bullet.getShape());
                area.intersect(enemy.getShape());
                if (!area.isEmpty()) {
                    enemy.setImage(database.getNull_Image());
                    bullets.getBullets().remove(bullet);
                }
            }

            area = new Area(player.getShape());
            area.intersect(enemy.getShape());
            if (!area.isEmpty()) {
                enemy.setImage(database.getNull_Image());
                player.getDamage(enemy);
            }
        }
        if (enemy != null && enemy.getList_Bullet() != null) {
            bullets = enemy.getList_Bullet();
            for (int i = 0; i < bullets.getBullets().size(); i++) {
                Bullet bullet = bullets.getBullets().get(i);
                area = new Area(bullet.getShape());
                area.intersect(player.getShape());
                if (!area.isEmpty()) {
                    bullets.getBullets().remove(bullet);
                    player.getDamage(bullet);
                }
            }
        }
    }
}
