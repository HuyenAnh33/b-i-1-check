import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bullet {
    public BufferedImage image;
    public Vecto2D position;
    public Vecto2D velocity;



    public Bullet(){
        this.position = new  Vecto2D();
        this.velocity = new  Vecto2D();
        try {
            this.image = ImageIO.read(new File("resources/images/powerup_shield.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public Bullet(Vecto2D position, Vecto2D velocity) {
        this.position = new Vecto2D(position.x, position.y);
        this.velocity = new Vecto2D(velocity.x, velocity.y);
        try {
            this.image = ImageIO.read(new File("resources/images/powerup_shield.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Bullet(BufferedImage image, Vecto2D position, Vecto2D velocity){
        this.position = new Vecto2D(position.x,position.y);
        this.velocity = new Vecto2D(velocity.x,velocity.y);
        this.image = image;

    }
    public void run(){

        this.position.addUp(velocity);
    }
    public void render(Graphics graphics){
        graphics.drawImage(this.image,(int)this.position.x,(int)this.position.y,15,15,null);
    }
    public void render(Graphics graphics, int width,int height ){
        graphics.drawImage(this.image,(int)this.position.x,(int)this.position.y,width,height,null);
    }


}
