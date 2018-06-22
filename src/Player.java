import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
    public int x;
    public int y;
    public BufferedImage image;
    public int vectocityX;
    public int vectocityY;

    public Player(int x, int y, BufferedImage image, int vectocityX, int vectocityY) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.vectocityX = vectocityX;
        this.vectocityY = vectocityY;
    }
    public Player(){

    }
    public void run(){
        this.x = this.vectocityX;
        this.y = this.vectocityY;
    }
    public void render(Graphics graphics){graphics.drawImage(this.image,this.x,this.y,20,20,null);}
}

