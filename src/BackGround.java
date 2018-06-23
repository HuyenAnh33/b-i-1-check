import java.awt.*;

public class BackGround {
    public int positionX;
    public int positionY;
    public Color color;
    public  int width;
    public int height;

    public BackGround(int x, int y, Color color, int width, int height) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.color = color;
        this.width = width;
        this.height = height;
    }


    public BackGround (){

    }

    public void render(Graphics graphics){
        graphics.setColor(this.color);

    }
}
