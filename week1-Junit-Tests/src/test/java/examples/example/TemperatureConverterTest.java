package examples.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TemperatureConverterTest {

    TemperatureConverter converter;

    @BeforeEach
    void setUp() {
        converter = new TemperatureConverter();
    }

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0.0, converter.fahrenheitToCelsius(32), 0.0001);
        assertEquals(100.0, converter.fahrenheitToCelsius(212), 0.0001);
        assertEquals(-40.0, converter.fahrenheitToCelsius(-40), 0.0001);
    }

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32.0, converter.celsiusToFahrenheit(0), 0.0001);
        assertEquals(212.0, converter.celsiusToFahrenheit(100), 0.0001);
        assertEquals(-40.0, converter.celsiusToFahrenheit(-40), 0.0001);
    }

    @Test
    void testIsExtremeTemperature() {
        assertTrue(converter.isExtremeTemp(-50));
        assertTrue(converter.isExtremeTemp(60));

        assertFalse(converter.isExtremeTemp(-40));
        assertFalse(converter.isExtremeTemp(50));
        assertFalse(converter.isExtremeTemp(20));
    }
}