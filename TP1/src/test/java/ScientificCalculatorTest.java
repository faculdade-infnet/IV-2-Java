import org.junit.jupiter.api.*;

public class ScientificCalculatorTest {
    private ScientificCalculator calc;

    // 1- Setup - preparar os objetos necesários para o teste
    @BeforeEach
    public void setUp() {
        calc = new ScientificCalculator();
    }

    // ----------------------------------------------------------
    // Testes de operações básicas
    // ----------------------------------------------------------

    @Test
    @DisplayName("Exercício 01")
    public void testAddition (){
        var calculator = new ScientificCalculator();
        double actual = calculator.add(5, 4);

        Assertions.assertEquals(9, actual);
    }

    @Test
    @DisplayName("Exercício 03")
    public void subtractTest (){
        // 2 - Execution - executar o teste
        double actual = calc.subtract(9, 4);

        // 3 - Assertion - verifica se o resultado esta correto
        Assertions.assertEquals(5, actual);

        // 4 - teardown - não aplicável
    }

    // ----------------------------------------------------------
    // Testes de funções matemáticas (log, seno, raiz)
    // ----------------------------------------------------------

    @Test
    @DisplayName("Exercício 05")
    public void testSquareRootPositive () {
        double actual = calc.squareRoot(25);

        Assertions.assertEquals(5, actual);
    }

    @Test
    @DisplayName("Exercício 08")
    public void logMultiplasEntradasTest () {
        double actual = calc.log(1);
        Assertions.assertEquals(0, actual);

        actual = calc.log(10);
        Assertions.assertEquals(2.302585092994046, actual);

        actual = calc.log(100);
        Assertions.assertEquals(4.605170185988092, actual);
    }

    @Test
    @DisplayName("Exercício 08")
    public void sinMultiplasEntradasTest () {
        double actual = calc.sin(0);
        Assertions.assertEquals(0, actual);

        // Adicioando tolerância no teste
        actual = calc.sin(30);
        Assertions.assertEquals(0.5, actual, 0.0001);

        actual = calc.sin(90);
        Assertions.assertEquals(1.0, actual);
    }
    // ----------------------------------------------------------
    // Testes de tratamento de erros / exceções
    // ----------------------------------------------------------

    @Test
    @DisplayName("Exercício 06")
    public void testSquareRootNegative () {
        // Verifica se IllegalArgumentException é lançada quando o número é negativo
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calc.squareRoot(-25);
        });
    }

    @Test
    @DisplayName("Exercício 07")
    public void testDivideByZero () {
         Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calc.divide(5,0);}
        );
    }
}