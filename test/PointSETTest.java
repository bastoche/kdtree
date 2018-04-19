import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointSETTest {

    @Test
    void empty_whenEmpty() {
        PointSET pointSET = new PointSET();
        assertTrue(pointSET.isEmpty());
    }

    @Test
    void empty_whenNotEmpty() {
        PointSET pointSET = new PointSET();
        pointSET.insert(new Point2D(0, 0));
        assertFalse(pointSET.isEmpty());
    }

    @Test
    void size_whenEmpty() {
        PointSET pointSET = new PointSET();
        assertEquals(0, pointSET.size());
    }

    @Test
    void size_whenNotEmpty() {
        PointSET pointSET = new PointSET();
        pointSET.insert(new Point2D(0, 0));
        assertEquals(1, pointSET.size());
    }

    @Test
    void insert_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PointSET().insert(null);
        });
    }

    @Test
    void contains_false() {
        PointSET pointSET = new PointSET();
        assertFalse(pointSET.contains(new Point2D(0, 0)));
    }

    @Test
    void contains_true() {
        PointSET pointSET = new PointSET();
        Point2D p = new Point2D(0, 0);
        pointSET.insert(p);
        assertTrue(pointSET.contains(p));
    }

    @Test
    void contains_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PointSET().contains(null);
        });
    }

    @Test
    void range_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PointSET().range(null);
        });
    }

    @Test
    void range_empty() {
        PointSET pointSET = new PointSET();
        RectHV rectHV = new RectHV(-2, -2, 2, 2);
        assertEquals(0, IterableUtils.size(pointSET.range(rectHV)));
    }

    @Test
    void range_notEmpty() {
        PointSET pointSET = new PointSET();
        pointSET.insert(new Point2D(0, 0));
        pointSET.insert(new Point2D(1, 1));
        pointSET.insert(new Point2D(2, 2));
        pointSET.insert(new Point2D(3, 3));
        RectHV rectHV = new RectHV(-2, -2, 2, 2);
        assertEquals(3, IterableUtils.size(pointSET.range(rectHV)));
    }

    @Test
    void nearest_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PointSET().nearest(null);
        });
    }

    @Test
    void nearest_empty() {
        PointSET pointSET = new PointSET();
        assertNull(pointSET.nearest(new Point2D(0, 0)));
    }

    @Test
    void nearest_notEmpty() {
        PointSET pointSET = new PointSET();
        Point2D point2D = new Point2D(1, 1);
        pointSET.insert(point2D);
        pointSET.insert(new Point2D(2, 2));
        assertEquals(point2D, pointSET.nearest(new Point2D(0, 0)));
    }
}