import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.Stack;

public class KdTree {

    private static class Node {
        final Point2D p;
        Node lb;
        Node rt;
        int size;

        Node(Point2D p, int size) {
            this.p = p;
            this.size = size;
        }
    }

    private Node rootNode;


    public KdTree() {
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(rootNode);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    public void insert(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException();
        }

        rootNode = insert(rootNode, p, true);
    }

    private Node insert(Node node, Point2D p, boolean useX) {
        if (node == null) {
            return new Node(p, 1);
        }

        if (isSmaller(p, node.p, useX)) {
            node.lb = insert(node.lb, p, !useX);
        } else {
            node.rt = insert(node.rt, p, !useX);
        }

        node.size = 1 + size(node.lb) + size(node.rt);
        return node;
    }

    public boolean contains(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException();
        }
        return contains(rootNode, p, true);
    }

    private boolean contains(Node node, Point2D p, boolean useX) {
        if (node == null) {
            return false;
        }

        if (node.p.equals(p)) {
            return true;
        }

        if (isSmaller(p, node.p, useX)) {
            return contains(node.lb, p, !useX);
        }
        else {
            return contains(node.rt, p, !useX);
        }
    }

    private boolean isSmaller(Point2D p1, Point2D p2, boolean useX) {
        if (useX) {
            return p2.x() - p1.x() > 0;
        }
        return p2.y() - p1.y() > 0;

    }

    public void draw() {
    }

    public Iterable<Point2D> range(RectHV rect) {
        Stack<Point2D> stack = new Stack<>();
        return stack;
    }

    public Point2D nearest(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException();
        }
        return null;
    }
}
