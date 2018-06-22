import java.awt.*;
import java.awt.image.BufferedImage;

public class Star {
    public int x;
    public int y;
    public BufferedImage image;
    public int veclocityX;
    public int VeclocityY;

    public Star(int x, int y, BufferedImage image, int veclocityX, int veclocityY) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.veclocityX = veclocityX;
        VeclocityY = veclocityY;
    }
    public Star(){

    }
    public void run(){
        this.x += this.veclocityX;
        this.y += this.VeclocityY;
    }
    public void render(Graphics graphics){
        graphics.drawImage(this.image,this.x,this.y,5,5,null);
    }



}






