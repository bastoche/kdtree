import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Point2DTest {
    @Test
    void coordinates() {
        Point2D point2D = new Point2D(1, 2);
        assertEquals(1, point2D.x());
        assertEquals(2, point2D.y());
    }
}