import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy {
    public int x;
    public int y;
    public BufferedImage image;
    public int veclocityX;
    public int veclocityY;

    public Enemy(int x, int y, BufferedImage image, int veclocityX, int veclocityY) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.veclocityX = veclocityX;
        this.veclocityY = veclocityY;
    }
    public Enemy(){

    }
    public void run(){
        this.x +=veclocityX;
        this.y +=veclocityY;
    }
    public void render(Graphics graphics){graphics.drawImage(image,this.x,this.y,10,10,null);}
}
