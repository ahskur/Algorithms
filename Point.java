class Point implements Movable {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point p) {
        return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
    }

    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}