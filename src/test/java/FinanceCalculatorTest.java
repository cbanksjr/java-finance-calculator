import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.FinanceCalculator;

public class FinanceCalculatorTest {
    private final FinanceCalculator calculator = new FinanceCalculator(0, 0, 0, 0);

    @Test
    void testTotal(){
        double testInput = 500;
        double testPercent = 40 / 100;
        double testValue = testInput * testPercent;
        assertEquals(testValue, calculator.total());
        }
    } 
