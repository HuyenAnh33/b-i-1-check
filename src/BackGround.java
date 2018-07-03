import javafx.scene.layout.Background;

import java.awt.*;

public class BackGround extends GameObject{
    public BackGround(){
        this.renderer = new BackgroundRenderer();
    }

    public void render(Graphics graphics){
        super.render(graphics);
        graphics.fillRect(0,0,1024,600);

    }
}
