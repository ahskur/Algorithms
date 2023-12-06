class Triangle implements Movable {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double perimeter() {
        double side1 = a.distance(b);
        double side2 = b.distance(c);
        double side3 = c.distance(a);
        return side1 + side2 + side3;
    }
    public void translate(int dx, int dy) {
        a.translate(dx, dy);
        b.translate(dx, dy);
        c.translate(dx, dy);
    }
    public String toString() {
        return "Triangle(" + a + ", " + b + ", " + c + ")";
    }
    private Point getA() {
        return a;
    }

    private Point getB() {
        return b;
    }

    private Point getC() {
        return c;
    }

    private Point[] getPoints() {
        Point[] points = {a, b, c};
        return points;
    }
}
