class Line implements Movable {
    private Point start;
    private Point end;
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
    public double length() {
        return start.distance(end);
    }
    public void translate(int dx, int dy) {
        start.translate(dx, dy);
        end.translate(dx, dy);
    }

    public String toString() {
        return "Line(" + start + ", " + end + ")";
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }
}
