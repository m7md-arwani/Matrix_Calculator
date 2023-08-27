package processor;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class calculatorTest {
    //TODO Restore the signal of System before and after each test

    //Square Matrix Case
    @Test
    void TestReadInputMatrix() {
        // Given
        int row = 4;
        int column = 4;
        String input = "1 1 1 1\n2 2 2 2\n1 1 1 1\n1 1 1 1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // When
        double[][] matrix = calculator.readInputMatrix(row, column);
        // Then
        double[][] expectedMatrix = {
                {1, 1, 1, 1},
                {2, 2, 2, 2},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };
        assertArrayEquals(expectedMatrix, matrix);
    }

    //non-Square Matrix Case
    @Test
    void TestReadInputMatrixNonSquare() {
        // Given
        int row = 4;
        int column = 2;
        String input = "1 1\n2 2\n1 1\n1 1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // When
        double[][] matrix = calculator.readInputMatrix(row, column);
        // Then
        double[][] expectedMatrix = {
                {1, 1},
                {2, 2},
                {1, 1},
                {1, 1}
        };
        assertArrayEquals(expectedMatrix, matrix);
    }

    @Test
    void TestMultiplyByConstant() {
        // Given
        String input = "3\n3\n3 3 3\n3 3 3\n3 3 3\n4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream outputCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputCaptor));

        // When
        calculator.multiplyConstant();
        // Filter the captured lines
        String[] result = outputCaptor.toString().split(System.lineSeparator());
        StringBuilder actual = new StringBuilder();
        for (String line : result) {
            if (!line.contains("Enter")) {
                actual.append(line + "\n");
            }
        }
        // Then
        String expectedOutput = "The result is:\n12.0 12.0 12.0 \n12.0 12.0 12.0 \n12.0 12.0 12.0 \n";
        assertEquals(expectedOutput, actual.toString());
    }

    @Test
    void TestMatricesAddition() {
        // Given
        String input = "3 3\n3 3 3\n3 3 3\n3 3 3\n3 3\n3 3 3\n3 3 3\n3 3 3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream outputCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputCaptor));

        // When
        calculator.matracesAddition();
        // Filter the captured lines
        String[] result = outputCaptor.toString().split(System.lineSeparator());
        StringBuilder actual = new StringBuilder();
        for (String line : result) {
            if (!line.contains("Enter")) {
                actual.append(line + "\n");
            }
        }
        // Then
        String expectedOutput = "The result is:\n\n6.0 6.0 6.0 \n6.0 6.0 6.0 \n6.0 6.0 6.0 \n";
        assertEquals(expectedOutput, actual.toString());
    }

    @Test
    void TestMatricesAdditionOperationCannotBePerformed() {
        // Given
        String input = "3 4\n3 3 3 3\n3 3 3 3\n3 3 3 3\n3 3\n3 3 3\n3 3 3\n3 3 3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream outputCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputCaptor));

        // When
        calculator.matracesAddition();
        // Filter the captured lines
        String[] result = outputCaptor.toString().split(System.lineSeparator());
        StringBuilder actual = new StringBuilder();
        for (String line : result) {
            if (!line.contains("Enter")) {
                actual.append(line + "\n");
            }
        }
        // Then
        String expectedOutput = "Operation cannot be performed.\n";
        assertEquals(expectedOutput, actual.toString());
    }


    @Test
    void TestMultiplication() {
        // Given
        String input = "2 2\n2 3\n4 1\n2 2\n5 6\n7 8";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream outputCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputCaptor));

        // When
        calculator.multiplication();
        // Filter the captured lines
        String[] result = outputCaptor.toString().split(System.lineSeparator());
        StringBuilder actual = new StringBuilder();
        for (String line : result) {
            if (!line.contains("Enter")) {
                actual.append(line + "\n");
            }
        }
        // Then
        String expectedOutput = "\n31.0 36.0 \n27.0 32.0 \n";
        assertEquals(expectedOutput,actual.toString());

    }

    @Test
    void TestMultiplicationOperationCannotBePerformed() {
        // Given
        String input = "2 2\n2 3\n4 1\n3 2\n5 6\n7 8\n7 7";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream outputCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputCaptor));

        // When
        calculator.multiplication();
        // Filter the captured lines
        String[] result = outputCaptor.toString().split(System.lineSeparator());
        StringBuilder actual = new StringBuilder();
        for (String line : result) {
            if (!line.contains("Enter")) {
                actual.append(line + "\n");
            }
        }
        // Then
        String expectedOutput = "The operation cannot be performed.\n";
        assertEquals(expectedOutput,actual.toString());

    }
}