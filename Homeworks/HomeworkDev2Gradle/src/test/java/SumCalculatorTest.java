import org.example.SumCalculator;
import org.junit.jupiter.api.*;

public class SumCalculatorTest {

    public SumCalculator sumCalculator;

    @BeforeEach
    public void beforeEach(){
        sumCalculator = new SumCalculator();
    }

    @Test
    public void test1ThatSumWorks(){
        //when
        int actual = sumCalculator.sum(1);
        //then
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test2ThatSumWorks(){
        //when
        int actual = sumCalculator.sum(3);
        //then
        int expected = 6;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void test3ThatSumWorks(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            sumCalculator.sum(0);
        });
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("Finish");
    }
}