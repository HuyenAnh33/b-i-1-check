public class Vecto2D {
    public float x;
    public float y;

    public Vecto2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vecto2D() {
        this.x = 0;
        this.y = 0;
    }

    public Vecto2D set(float x, float y) {//truyen gia tri cho bien
        this.x = x;
        this.y = y;
        return this;
    }

    public Vecto2D set(Vecto2D vecto2D) {
        return this.set(vecto2D.x, vecto2D.y);
    }

    public Vecto2D addUp(float x, float y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public Vecto2D addUp(Vecto2D vecto2D) {
        return this.addUp(vecto2D.x, vecto2D.y);
    }

    public Vecto2D add(float x, float y) {
        return new Vecto2D(this.x + x, this.y + y);
    }

    public Vecto2D add(Vecto2D vecto2D) {
        return this.add(vecto2D.x, vecto2D.y);
    }

    public Vecto2D subtracBy(float x, float y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    public Vecto2D subtracBy(Vecto2D vecto2D) {
        return this.subtracBy(vecto2D.x, vecto2D.y);
    }

    public Vecto2D subtract(float x, float y) {
        return new Vecto2D(this.x - x, this.y - y);
    }

    public Vecto2D subtract(Vecto2D vecto2D) {

        return this.subtract(vecto2D.x, vecto2D.y);
    }

    public Vecto2D multiply(float number) {
        this.x *= number;
        this.y *= number;
        return this;
    }

    public float length() {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public Vecto2D copy() {
        return new Vecto2D(this.x, this.y);
    }

    public Vecto2D normalize() {
        float length = this.length();
        return new Vecto2D(this.x / length, this.y / length);
    }

    public Vecto2D rotate(double angle) {
        double radians = Math.toRadians(angle);
        float cos = (float) Math.cos(radians);
        float sin = (float) Math.sin(radians);
        return new Vecto2D(this.x * cos - this.y * sin, this.x * sin + this.y * cos);
    }

}

