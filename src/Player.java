import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    public Vecto2D position;
    private List<Vecto2D> vertices;
    private Polygon polygon;
    public Vecto2D velocity;
    public double angle = 0.0;
    public int countBullet = 0;
     List<Bullet>Bullets;

    public Player() {
        this.position = new Vecto2D();
        this.vertices = Arrays.asList(
                new Vecto2D(),
                new Vecto2D(0, 16),
                new Vecto2D(20, 8)
        );
        this.polygon = new Polygon();
        this.velocity = new Vecto2D(3.5f, 0);

        this.Bullets = new ArrayList<>();

    }

    public void run() {
        this.Bullets.forEach(bullet ->bullet.run() );
        this.position.addUp(this.velocity);
        this.createBullet();
    }
    public void createBullet() {
        if (this.countBullet == 20) {

            try {
                BufferedImage bufferedImage = ImageIO.read(new File("resources/images/circle.png"));
                Bullet bullet = new Bullet(bufferedImage, this.position, this.velocity);
                this.Bullets.add(bullet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            countBullet = 0;

        } else {
            countBullet += 1;
        }
    }

        public void render (Graphics graphics){
            this.polygon.reset();
            Vecto2D center = this.vertices
                    .stream()
                    .reduce(new Vecto2D(), (v1, v2) -> v1.add(v2))// chi dung cho mang va co bien khoi tao,truyen vao gia tri ban dau (0,0).Trâ ve 2 bien v1 và v2 roi duyet qua tat ca phan tu cua mang(phep +).luon co 2 phan khoi tao va truyen vao
                    .multiply(1.0f / (float) this.vertices.size())
                    .rotate(this.angle);
            Vecto2D translation = this.position.subtract(center);
            this.vertices
                    .stream()
                    .map(vertex -> vertex.rotate(angle))// tra ve 1 list moi va khong thay doi list cu
                    .map(vertex -> vertex.add(translation))
                    .forEach(vertex -> polygon.addPoint((int) vertex.x, (int) vertex.y));

            graphics.setColor(Color.RED);
            graphics.fillPolygon(this.polygon);
            this.Bullets.forEach(bullet -> bullet.render(graphics));
        }

    }

