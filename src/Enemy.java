import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemy {
    public Vecto2D position;
    public Vecto2D velocity;
    public BufferedImage image;
    public Random random = new Random();
    public int countBullet = 0;

    List<Bullet> bullets;


    public Enemy() {
        this.position = new Vecto2D();
        this.velocity = new Vecto2D();
        this.createBullet();
        this.bullets =new ArrayList<>();
    }
    public Enemy(BufferedImage image, Vecto2D position, Vecto2D velocity){
        this.image = image;
        this.position = new Vecto2D(position.x,position.y);
        this.velocity = new Vecto2D();
    }

    public void createBullet(){
        if (this.countBullet == 20) {

            try {
                BufferedImage bufferedImage = ImageIO.read(new File("resources/images/powerup_shield.png"));
                Bullet bullet = new Bullet(bufferedImage,this.position,this.velocity);
                this.bullets.add(bullet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.countBullet = 0;
        }else {
            this.countBullet += 1;
        }
    }
    public void run() {
        this.bullets.forEach(bullet -> bullet.run());
        this.position.addUp(this.velocity);
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int) this.position.x, (int) this.position.y, 30, 30, null);
        this.bullets.forEach(bullet -> bullet.render(graphics));
    }
//    public void render(Graphics graphics, int width,int height){
//        graphics.drawImage(this.image,(int) this.position.x,(int)this.position.y, width, height,null);
//
//    }

}

