import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Point2DTest {
    @Test
    void coordinates() {
        Point2D point2D = new Point2D(1, 2);
        assertEquals(1, point2D.x());
        assertEquals(2, point2D.y());
    }

    @Test
    void distance() {
        Point2D point2D = new Point2D(0, 0);
        assertEquals(1, point2D.distanceTo(new Point2D(0, 1)));
        assertEquals(1, point2D.distanceTo(new Point2D(1, 0)));
        assertEquals(5, point2D.distanceTo(new Point2D(3, 4)));
    }
}