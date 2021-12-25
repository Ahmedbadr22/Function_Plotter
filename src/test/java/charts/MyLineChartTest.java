package charts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLineChartTest {

    @Test
    void generateXLine() {
        float [] actualResult = new float[] {2, 3, 4, 5};
        float [] expResult = MyLineChart.generateXLine(5, 2);

        assertNotNull(expResult);
        assertArrayEquals(actualResult, expResult);
    }
}