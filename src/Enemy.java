import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class Enemy extends GameObject {
    public Vecto2D velocity;
    public BufferedImage image;

    private List<BulletEnemy> bulletEnemies;
    private int count = 0;


    public Enemy() {
        this.position = new Vecto2D();
        this.velocity = new Vecto2D();
        this.renderer = new ImageRenderer("resources/images/circle.png",20,20);
        this.bulletEnemies = new ArrayList<>();
    }


    public void run() {
        super.run();
        this.position.addUp(this.velocity);
//        if (this.count == 30) {
//            for (double angle = 0.0; angle < 360.0; angle += 360.0 / 20.0) {//xet ban vong tron dung for ban 360 do
//                BulletEnemy bulletEnemy = new BulletEnemy();
//                bulletEnemy.position.set(this.position);
//                bulletEnemy.velocity.set(new Vecto2D(3.0f, 0.0f).rotate(angle));
//                this.bulletEnemies.add(bulletEnemy);
//            }
//            this.count = 0;
//        } else {
//            this.count += 1;
//        }
        Player player = GameObjectManager.instance.findPlayer();
        if (player != null) {
            Vecto2D velocity = player.position
                    .subtract(this.position)
                    .normalize()
                    .multiply(1.5f);
        }
        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());
    }

    public void render(Graphics graphics) {
        super.render(graphics);
        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
    }


}

