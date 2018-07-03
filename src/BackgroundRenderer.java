import java.awt.*;

public class BackgroundRenderer implements Renderer {
    private Color color = Color.BLACK;
    public BackgroundRenderer(){

    }
    public void render(Graphics graphics, Vecto2D position) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,1024,600);

    }
}
