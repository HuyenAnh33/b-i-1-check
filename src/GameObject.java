import java.awt.*;

public class GameObject {
    public Vecto2D position;
    public Renderer renderer;

    public GameObject(){
        this.position = new Vecto2D();
    }
    public void run(){

    }
    public void render(Graphics graphics){
        if (this.renderer != null){
            this.renderer.render(graphics, this.position);
        }
    }
}
