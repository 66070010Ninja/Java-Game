
import java.awt.geom.*;

public class CheckHitBox {
    private DataBase database = new DataBase();
    private Player player;
    private List_Enemy enemis;
    private List_Bullet bullets;
    private List_Item items;
    private BackGround background;
    private Area area;
    private Sound sound = new Sound();

    public CheckHitBox(Player player, List_Enemy enemis, List_Item items, BackGround background) {
        this.player = player;
        this.enemis = enemis;
        this.items = items;
        this.background = background;
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
        if (player.getTime_Use_Explosion() != 0) {
            player.setTime_Use_Explosion(player.getTime_Use_Explosion() - 1);
        }
    }

    public void checkhitbox(Object enemy) {
        if (enemy != null && enemy.getImage() != database.getNull_Image()) {
            bullets = player.getList_Bullet();
            for (int i = 0; i < bullets.getBullets().size(); i++) {
                Bullet bullet = bullets.getBullets().get(i);
                area = new Area(bullet.getShape());
                area.intersect(enemy.getShape());
                if (!area.isEmpty() && !enemy.getImage().equals(database.getDead_Image()) && !enemy.getImage().equals(database.getNull_Image()) && player.getEnemy_Left() != 0) {
                    if (player.getUse_DM2()) {
                        enemy.getDamage(bullet.getAttack_to_HP()*2);
                    }
                    else {
                        enemy.getDamage(bullet.getAttack_to_HP());
                    }
                    bullets.getBullets().remove(bullet);
                }
                if (enemy.get_HP() <= 0 && !enemy.getImage().equals(database.getDead_Image()) && !enemy.getImage().equals(database.getNull_Image())) {
                    enemy.setImage(database.getDead_Image());
                    sound.Sound_Enemy_Boom();
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

            area = new Area(enemy.getShape());
            area.intersect(background.getShape());
            if (area.isEmpty() && player.getTime_Use_Explosion() != 0 && !enemy.getImage().equals(database.getDead_Image()) && !enemy.getImage().equals(database.getNull_Image())) {
                enemy.setImage(database.getDead_Image());
                enemy.setHP(0);
                sound.Sound_Enemy_Boom();
                player.setEnemy_Left(player.getEnemy_Left() -1);
            }

            area = new Area(player.getShape());
            area.intersect(enemy.getShape());
            if (!area.isEmpty() && !enemy.getImage().equals(database.getDead_Image()) && !enemy.getImage().equals(database.getNull_Image()) && player.getGolden_Time() == 0 && !player.getImage().equals(database.getNull_Image()) && player.getEnemy_Left() != 0) {
                enemy.setImage(database.getDead_Image());
                enemy.setHP(0);
                player.getDamage(enemy.getAttack_to_HP());
                sound.Sound_get_Damage();
                sound.Sound_Enemy_Boom();
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
                    sound.Sound_get_Damage();
                }
                else if (!area.isEmpty() && player.getGolden_Time() == 0 && player.getEnemy_Left() != 0) {
                    player.getDamage(bullet.getAttack_to_HP());
                    sound.Sound_get_Damage();
                    bullets.getBullets().remove(bullet);
                }
            }
        }

        for (int i = 0; i < items.getItems().size(); i++) {
            Item item = items.getItems().get(i);
            area = new Area(item.getShape());
            area.intersect(player.getShape());
            if (!area.isEmpty() && player.getEnemy_Left() != 0) {
                items.getItems().remove(item);
                player.getItem(item);
                sound.Sound_Get_Item();
            }
        }
    }
}
