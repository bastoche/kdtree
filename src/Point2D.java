public class Point2D implements Comparable<Point2D> {

    private final double x;
    private final double y;


    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    public double distanceTo(Point2D that) {
        return Math.sqrt(distanceSquaredTo(that));
    }

    public double distanceSquaredTo(Point2D that) {
        return (x - that.x) * (x - that.x) + (y - that.y) * (y - that.y);
    }

    public int compareTo(Point2D that) {
        return 0;
    }          // for use in an ordered symbol table
//    public boolean equals(Object that)              // does this point equal that object?
//    public    void draw()                           // draw to standard draw
//    public  String toString()                       // string representation
}