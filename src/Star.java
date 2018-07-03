import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Star extends GameObject {
    public Vecto2D velocity;

    public Star(){
    this.velocity = new Vecto2D();
    this.renderer = new ImageRenderer("resources/images/star.png", 5,5);

}
    @Override// run override lai ham cha
    public void run() {
        super.run();// goi ten ham run cua ham cha
        this.position.addUp(this.velocity);

    }

}






