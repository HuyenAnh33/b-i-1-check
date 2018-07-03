import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Player extends GameObject{

    public Vecto2D velocity;
    public double angle = 0.0;
    public PlayerAttack playerAttack;
    public Random random;

    public Player() {
        this.position =  new Vecto2D();
        this.renderer = new PolygonRenderer(
                Color.RED,
                new Vecto2D(),
                new Vecto2D(0, 16),
                new Vecto2D(20, 8)

        );

        this.velocity = new Vecto2D(3.5f, 0);
        this.playerAttack = new PlayerShoot();

    }
    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        ((PolygonRenderer) this.renderer).angle = this.angle;// ep kieu renderer ve poly
        this.playerAttack.run(this);
        this.backtoScreen();
    }
        private void backtoScreen(){
        if (this.position.x < 0)this.position.set(1024,this.random.nextInt(600));
        if (this.position.x > 1024)this.position.set(0,this.random.nextInt(600));
            if (this.position.y < 0)this.position.set(this.random.nextInt(1024),600);
            if (this.position.y > 600)this.position.set(this.random.nextInt(1024),0);

        }
        @Override
        public void render (Graphics graphics){
           super.render(graphics);
            ((PlayerShoot) this.playerAttack)
                    .bulletPlayers
                    .forEach(bulletPlayer -> bulletPlayer.render(graphics));
        }

    }

