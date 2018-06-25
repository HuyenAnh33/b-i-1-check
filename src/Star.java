import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Star {
    public BufferedImage image;
    public Vecto2D position;
    public Vecto2D velocity;
    Random random;

    public Star(int i, int i1){
    this.position = new Vecto2D();
    this.velocity = new Vecto2D();
    }
    public void run() {
        this.position.addUp(velocity);

    }
    public void render(Graphics graphics){
    graphics.drawImage(this.image,(int)this.position.x,(int)this.position.y,5,5,null);
    }
}






