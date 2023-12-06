public class Geometry {
   public static void main(String[] args) {
      // Create points
      Point p1 = new Point(0, 0);
      Point p2 = new Point(1, 1);
      Point p3 = new Point(3, 0);

      // Create line
      Line line = new Line(p1, p2);

      // Create triangle
      Triangle triangle = new Triangle(p1, p2, p3);

      // Print points
      System.out.println(p1.toString());
      System.out.println(p2.toString());
      System.out.println(p3.toString());

      // Print Line
      System.out.println(line.toString());

      // Print Triangle
      System.out.println(triangle.toString());

      // Print length and perimeter
      System.out.println("Length of Line: " + line.length());
      System.out.println("Perimeter of Triangle: " + triangle.perimeter());
   }
}
