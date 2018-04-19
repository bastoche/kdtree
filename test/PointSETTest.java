import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointSETTest {

    @Test
    void empty() {
        PointSET pointSET = new PointSET();
        assertTrue(pointSET.isEmpty());
    }

}