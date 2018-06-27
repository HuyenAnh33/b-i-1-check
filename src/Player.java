import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;

public class Player {
    public Vecto2D position;
    private List<Vecto2D> vertices;
    private Polygon polygon;
    public Vecto2D velocity;
    public double angle = 0.0;

    public Player() {
        this.position = new Vecto2D();
        this.vertices = Arrays.asList(
                new Vecto2D(),
                new Vecto2D(0, 16),
                new Vecto2D(20, 8)
        );
        this.polygon = new Polygon();
        this.velocity = new Vecto2D(3.5f, 0);
    }
    public void run() {
        this.position.addUp(this.velocity);

    }

    public void render(Graphics graphics) {
        this.polygon.reset();
        Vecto2D center = this.vertices
                .stream()
                .reduce(new Vecto2D(), (v1, v2) -> v1.add(v2))
                .multiply(1 / this.vertices.size())
                .rotate(this.angle);
Vecto2D translation = this.position.subtract(center);
this.vertices
        .stream()
        .map(vertex -> vertex.rotate(angle) )
        .map(vertex -> vertex.add(translation) )
        .forEach(vertex -> polygon.addPoint((int)vertex.x,(int)vertex.y ));

        graphics.setColor(Color.RED);
        graphics.fillPolygon(this.polygon);
    }
}

