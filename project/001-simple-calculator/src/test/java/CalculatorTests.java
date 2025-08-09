import com.kevinhe99.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class CalculatorTests {

    @Test
    @DisplayName("Addition [1/2]")
    void TestAddition1() {
        assertEquals(5.0, Calculator.add(2,3).value());
    }

    @Test
    @DisplayName("Addition [2/2]")
    void TestAddition2() {
        assertEquals(59.0, Calculator.add(25,34).value());
    }

    @Test
    @DisplayName("Subtraction [1/2]")
    void TestSubtraction1() {
        assertEquals(52.0, Calculator.subtract(55,3).value());
    }

    @Test
    @DisplayName("Subtraction [2/2]")
    void TestSubtraction2() {
        assertEquals(-9.0, Calculator.subtract(25,34).value());
    }

    @Test
    @DisplayName("Multiply [1/2]")
    void TestMultiply1() {
        assertEquals(165.0, Calculator.multiply(55,3).value());
    }

    @Test
    @DisplayName("Multiply [2/2]")
    void TestMultiply2() {
        assertEquals(-459250.0, Calculator.multiply(25,-55*334).value());
    }

    @Test
    @DisplayName("Divide [1/3]")
    void TestDivide1() {
        assertEquals(55.7 /3, Calculator.divide(55.7,3).value());
    }

    @Test
    @DisplayName("Divide [2/3]")
    void TestDivide2() {
        assertEquals((double) 25 /34, Calculator.divide(25,34).value());
    }

    @Test
    @DisplayName("Divide by Zero [3/3]")
    void TestDivide3() {
        assertFalse(Calculator.divide(25, 0).valid());
    }

    @Test
    @DisplayName("Power [1/2]")
    void TestPower1() {
        assertEquals(8, Calculator.power(2,3).value());
    }

    @Test
    @DisplayName("Power [2/2]")
    void TestPower2() {
        assertEquals(625, Calculator.power(25,2).value());
    }

    @Test
    @DisplayName("Square Root [1/2]")
    void TestSquareRoot1() {
        assertEquals(2, Calculator.squareRoot(4).value());
    }

    @Test
    @DisplayName("Square Root [2/2]")
    void TestSquareRoot2() {
        assertEquals(9, Calculator.squareRoot(81).value());
    }


}
