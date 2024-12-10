import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MathServiceTest {

    MathService mathService = new MathService();

    // Позитивный тест: дискриминант больше нуля
    @Test
    void testGetAnswer_PositiveDiscriminant() throws NotFoundAnswerException {
        Pair result = mathService.getAnswer(1, -3, 2);
        assertNotNull(result);
        assertEquals(2.0, result.first, 0.01);
        assertEquals(1.0, result.second, 0.01);
    }

    // Позитивный тест: дискриминант равен нулю
    @Test
    void testGetAnswer_ZeroDiscriminant() throws NotFoundAnswerException {
        Pair result = mathService.getAnswer(1, -2, 1);
        assertNotNull(result);
        assertEquals(1.0, result.first, 0.01);
        assertEquals(1.0, result.second, 0.01);
    }

    // Негативный тест: дискриминант меньше нуля
    @Test
    void testGetAnswer_NegativeDiscriminant() {
        assertThrows(NotFoundAnswerException.class, () -> mathService.getAnswer(1, 2, 5));
    }

    // Параметризованный тест: различные значения коэффициентов
    @ParameterizedTest
    @CsvSource({
            "1, -3, 2, 2.0, 1.0",  // Дискриминант > 0
            "1, -2, 1, 1.0, 1.0",  // Дискриминант == 0
            "1, 2, 5, null, null"  // Дискриминант < 0 (ошибка)
    })
    void testGetAnswer_Parameterized(int a, int b, int c, Double expectedX1, Double expectedX2) {
        if (expectedX1 == null && expectedX2 == null) {
            assertThrows(NotFoundAnswerException.class, () -> mathService.getAnswer(a, b, c));
        } else {
            try {
                Pair result = mathService.getAnswer(a, b, c);
                assertNotNull(result);
                assertEquals(expectedX1, result.first, 0.01);
                assertEquals(expectedX2, result.second, 0.01);
            } catch (NotFoundAnswerException e) {
                fail("Unexpected exception: " + e.getMessage());
            }
        }
    }

    // Тест на метод getD
    @Test
    void testGetD() {
        assertEquals(1, mathService.getD(1, -2, 1));
        assertEquals(-16, mathService.getD(1, 2, 5));
        assertEquals(25, mathService.getD(1, -5, 0));
    }
}
