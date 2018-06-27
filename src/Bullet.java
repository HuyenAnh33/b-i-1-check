import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet {
    public BufferedImage image;
    public Vecto2D position;
    public Vecto2D velocity;

    public Bullet(){
        this.position = new Vecto2D();
        this.velocity = new Vecto2D();
    }
    public void run(){

        this.position.addUp(velocity);
    }
    public void render(Graphics graphics){
        graphics.drawImage(this.image,(int)this.position.x,(int)this.position.y,5,5,null);
    }
}
