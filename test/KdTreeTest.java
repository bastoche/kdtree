import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KdTreeTest {

    @Test
    void empty_whenEmpty() {
        KdTree kdtree = new KdTree();
        assertTrue(kdtree.isEmpty());
    }

    @Test
    void empty_whenNotEmpty() {
        KdTree kdtree = new KdTree();
        kdtree.insert(new Point2D(0, 0));
        assertFalse(kdtree.isEmpty());
    }

    @Test
    void size_whenEmpty() {
        KdTree kdtree = new KdTree();
        assertEquals(0, kdtree.size());
    }

    @Test
    void size_whenNotEmpty() {
        KdTree kdtree = new KdTree();
        kdtree.insert(new Point2D(0, 0));
        assertEquals(1, kdtree.size());
    }

    @Test
    void insert_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new KdTree().insert(null);
        });
    }

    @Test
    void contains_false() {
        KdTree kdtree = new KdTree();
        assertFalse(kdtree.contains(new Point2D(0, 0)));
    }

    @Test
    void contains_true() {
        KdTree kdtree = new KdTree();
        Point2D p = new Point2D(0, 0);
        kdtree.insert(p);
        assertTrue(kdtree.contains(p));
    }

    @Test
    void contains_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new KdTree().contains(null);
        });
    }

    @Test
    void range_empty() {
        KdTree kdtree = new KdTree();
        RectHV rectHV = new RectHV(-2, -2, 2, 2);
        assertEquals(0, IterableUtils.size(kdtree.range(rectHV)));
    }

    @Test
    void range_notEmpty() {
        KdTree kdtree = new KdTree();
        kdtree.insert(new Point2D(0, 0));
        kdtree.insert(new Point2D(1, 1));
        kdtree.insert(new Point2D(2, 2));
        kdtree.insert(new Point2D(3, 3));
        RectHV rectHV = new RectHV(-2, -2, 2, 2);
        assertEquals(3, IterableUtils.size(kdtree.range(rectHV)));
    }

    @Test
    void nearest_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new KdTree().nearest(null);
        });
    }

    @Test
    void nearest_empty() {
        KdTree kdtree = new KdTree();
        assertNull(kdtree.nearest(new Point2D(0, 0)));
    }

    @Test
    void nearest_notEmpty() {
        KdTree kdtree = new KdTree();
        Point2D point2D = new Point2D(1, 1);
        kdtree.insert(point2D);
        kdtree.insert(new Point2D(2, 2));
        assertEquals(point2D, kdtree.nearest(new Point2D(0, 0)));
    }
}