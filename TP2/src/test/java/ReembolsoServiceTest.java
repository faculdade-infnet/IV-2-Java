import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ReembolsoServiceTest {
    @Test
    @DisplayName("Exercício 01")
    public void testAddition() {
        var calculator = new ReembolsoService();
        double actual = calculator.calcularReembolso(200, 70);

        assertEquals(140.0, actual, 0.01);
    }
}