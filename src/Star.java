import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Star {
    public BufferedImage image;
    public Vecto2D position;
    public Vecto2D velocity;

    public Star(){
    this.position = new Vecto2D();
    this.velocity = new Vecto2D();
    this.image = image;
    }


    public void run() {
        this.position.addUp(this.velocity);

    }
    public void render(Graphics graphics){
    graphics.drawImage(this.image,(int)this.position.x,(int)this.position.y,10,10,null);
    }
}






