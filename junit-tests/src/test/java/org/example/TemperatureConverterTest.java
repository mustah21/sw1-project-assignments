package org.example;


import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TemperatureConverterTest {

    private TemperatureConverter tc = new TemperatureConverter();


    @Test
    void fahrenheitToCelsius() {

        assertEquals(0.0, tc.fahrenheitToCelsius(32), 0.01);
        assertEquals(100.0, tc.fahrenheitToCelsius(212), 0.01);
        assertEquals(37.0, tc.fahrenheitToCelsius(98.6), 0.01);
    }

    @Test
    void celsiusToFahrenheit() {

        assertEquals(32.0, tc.celsiusToFahrenheit(0), 0.01);
        assertEquals(212.0, tc.celsiusToFahrenheit(100), 0.01);
        assertEquals(98.6, tc.celsiusToFahrenheit(37), 0.01);
    }

    @Test
    void isExtremeTemp() {

        assertTrue(tc.isExtremeTemp(-55));
        assertTrue(tc.isExtremeTemp(60));

        assertFalse(tc.isExtremeTemp(0));
        assertFalse(tc.isExtremeTemp(25));
        assertFalse(tc.isExtremeTemp(40));
    }
}

