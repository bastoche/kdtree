import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdDraw;

import java.util.function.DoubleBinaryOperator;

public class KdTree {

    private static class Node {
        final Point2D p;
        final RectHV rect;

        int size;

        Node lb;
        Node rt;

        Node(Point2D p, RectHV rect, int size) {
            this.p = p;
            this.rect = rect;
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

        rootNode = insert(rootNode, p, new RectHV(0, 0, 1, 1), true);
    }

    private Node insert(Node node, Point2D p, RectHV rect, boolean useX) {
        if (node == null) {
            return new Node(p, rect, 1);
        }

        if (node.p.equals(p)) {
            return node;
        }

        double limit = useX ? node.p.x() : node.p.y();
        if (isSmaller(p, node.p, useX)) {
            node.lb = insert(node.lb, p, cut(rect, limit, useX, Math::min), !useX);
        } else {
            node.rt = insert(node.rt, p, cut(rect, limit, useX, Math::max), !useX);
        }

        node.size = 1 + size(node.lb) + size(node.rt);
        return node;
    }

    private RectHV cut(RectHV rect, double at, boolean useX, DoubleBinaryOperator operator) {
        if (useX) {
            return new RectHV(operator.applyAsDouble(rect.xmin(), at), rect.ymin(), operator.applyAsDouble(rect.xmax(), at), rect.ymax());
        } else {
            return new RectHV(rect.xmin(), operator.applyAsDouble(rect.ymin(), at), rect.xmax(), operator.applyAsDouble(rect.ymax(), at));
        }
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
        } else {
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
        draw(rootNode, true);
    }

    private void draw(Node node, boolean useX) {
        if (node == null) {
            return;
        }

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.01);
        node.p.draw();

        StdDraw.setPenColor(useX ? StdDraw.RED : StdDraw.BLUE);
        StdDraw.setPenRadius();

        if (useX) {
            StdDraw.line(node.p.x(), node.rect.ymin(), node.p.x(), node.rect.ymax());
        } else {
            StdDraw.line(node.rect.xmin(), node.p.y(), node.rect.xmax(), node.p.y());
        }

        draw(node.lb, !useX);
        draw(node.rt, !useX);
    }

    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new IllegalArgumentException();
        }
        Stack<Point2D> stack = new Stack<>();
        return stack;
    }

    public Point2D nearest(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException();
        }
        Point2D result = null;
        return result;
    }
}
