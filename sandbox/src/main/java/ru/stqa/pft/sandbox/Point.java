package ru.stqa.pft.sandbox;

public class Point {


    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static double distance(Point p1, Point p2) {
        double dx = p2.x - p1.x;
        double dy = p2.y - p2.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
    public static void main(String[] args) {
        Point p1 = new Point(3.2, 2.3);
        Point p2 = new Point(4.1, 1.1);
        System.out.println("Odległość pomiędzy punktem (" + p1.x + " , " + p1.y + ") a punktem (" + p2.x + " , " + p2.y + " ) wynosi " + distance(p1, p2));

}
}

