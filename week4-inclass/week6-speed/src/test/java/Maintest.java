package org.example;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    @Test
    void testNormalCase_100km_2hours() {
        String input = "100\n2\n";
        String expectedOutputPart = "The speed is: 50";

        String output = runMainWithInput(input);
        assertTrue(output.contains(expectedOutputPart),
                "Should contain 'The speed is: 50'\nActual:\n" + output);
    }

    @Test
    void testTruncation_70km_3hours() {
        String input = "70\n3\n";
        String output = runMainWithInput(input);
        assertTrue(output.contains("The speed is: 23"),
                "70/3 should print 23 (integer division)\nActual:\n" + output);
    }

    @Test
    void testZeroDistance() {
        String input = "0\n5\n";
        String output = runMainWithInput(input);
        assertTrue(output.contains("The speed is: 0"));
    }

    // Helper method - simulates console input and captures output
    private String runMainWithInput(String simulatedInput) {
        // Save original streams
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        // Prepare fake input & output
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));

        try {
            // Call main()
            Main.main(new String[0]);
        } finally {
            // Restore original streams
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        return out.toString();
    }
}