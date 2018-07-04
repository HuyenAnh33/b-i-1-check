import java.awt.*;

public class BulletEnemy extends  GameObject{
    public Vecto2D velocity;
    public BulletEnemy(){
        this.position = new Vecto2D();
        this.velocity = new Vecto2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 5,5);
    }
    public void run(){
        super.run();
        this.position.addUp(this.velocity);


    }
    public void render(Graphics graphics){

        super.render(graphics);
    }
}
