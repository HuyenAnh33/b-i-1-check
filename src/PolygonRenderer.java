import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class PolygonRenderer implements Renderer{
    private Polygon polygon;
    public double angle =  0.0;
    public Color color;
    private List<Vecto2D> vertices;

    public PolygonRenderer(Color color, Vecto2D...vertices){//tuong ung voi khai bao mang va bat buoc phai viet cuoi cung
        this.color =color;
        this.vertices = Arrays.asList(vertices);
        this.polygon = new Polygon();

    }
    @Override
    public void render(Graphics graphics, Vecto2D position) {
        this.polygon.reset();
        Vecto2D center = this.vertices
                .stream()
                .reduce(new Vecto2D(), (v1, v2) -> v1.add(v2))// chi dung cho mang va co bien khoi tao,truyen vao gia tri ban dau (0,0).Trâ ve 2 bien v1 và v2 roi duyet qua tat ca phan tu cua mang(phep +).luon co 2 phan khoi tao va truyen vao
                .multiply(1.0f / (float) this.vertices.size())
                .rotate(this.angle);
        Vecto2D translation = position.subtract(center);
        this.vertices
                .stream()
                .map(vertex -> vertex.rotate(angle))// tra ve 1 list moi va khong thay doi list cu
                .map(vertex -> vertex.add(translation))
                .forEach(vertex -> polygon.addPoint((int) vertex.x, (int) vertex.y));

        graphics.setColor(this.color);
        graphics.fillPolygon(this.polygon);

    }
}
