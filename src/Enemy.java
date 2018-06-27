import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy {
    public Vecto2D position;
    public Vecto2D velocity;
    public BufferedImage image;


    public Enemy(){
        this.position = new Vecto2D();
        this.velocity = new Vecto2D();
        this.image = image;
    }
    public void run(){

        this.position.addUp(this.velocity);
    }
    public void render(Graphics graphics){
        graphics.drawImage(this.image,(int)this.position.x,(int)this.position.y,10,10,null);}
}

