package processor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;


class TestCalculator {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

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
        String input = "3 3\n3 3 3\n3 3 3\n3 3 3\n4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(outContent));

        // When
        calculator.multiplyConstant();
        // Filter the captured lines
        String[] result = outContent.toString().split(System.lineSeparator());
        StringBuilder actual = new StringBuilder();
        for (String line : result) {
            if (!line.contains("Enter")) {
                actual.append(line).append("\n");
            }
        }
        // Then
        String expectedOutput = "The result is:\n12.00 12.00 12.00 \n12.00 12.00 12.00 \n12.00 12.00 12.00 \n";
        assertEquals(expectedOutput, actual.toString());
    }

    @Test
    void TestMatricesAddition() {
        // Given
        String input = "3 3\n3 3 3\n3 3 3\n3 3 3\n3 3\n3 3 3\n3 3 3\n3 3 3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(outContent));

        // When
        calculator.matracesAddition();
        // Filter the captured lines
        String[] result = outContent.toString().split(System.lineSeparator());
        StringBuilder actual = new StringBuilder();
        for (String line : result) {
            if (!line.contains("Enter")) {
                actual.append(line).append("\n");
            }
        }
        // Then
        String expectedOutput = "The result is:\n\n6.00 6.00 6.00 \n6.00 6.00 6.00 \n6.00 6.00 6.00 \n";
        assertEquals(expectedOutput, actual.toString());
    }

    @Test
    void TestMatricesAdditionOperationCannotBePerformed() {
        // Given
        String input = "3 4\n3 3 3 3\n3 3 3 3\n3 3 3 3\n3 3\n3 3 3\n3 3 3\n3 3 3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(outContent));

        // When
        calculator.matracesAddition();
        // Filter the captured lines
        String[] result = outContent.toString().split(System.lineSeparator());
        StringBuilder actual = new StringBuilder();
        for (String line : result) {
            if (!line.contains("Enter")) {
                actual.append(line).append("\n");
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
        System.setOut(new PrintStream(outContent));

        // When
        calculator.multiplication();
        // Filter the captured lines
        String[] result = outContent.toString().split(System.lineSeparator());
        StringBuilder actual = new StringBuilder();
        for (String line : result) {
            if (!line.contains("Enter")) {
                actual.append(line).append("\n");
            }
        }
        // Then
        String expectedOutput = "\n31.00 36.00 \n27.00 32.00 \n";
        assertEquals(expectedOutput, actual.toString());

    }

    @Test
    void TestMultiplicationOperationCannotBePerformed() {
        // Given
        String input = "2 2\n2 3\n4 1\n3 2\n5 6\n7 8\n7 7";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(outContent));

        // When
        calculator.multiplication();
        // Filter the captured lines
        String[] result = outContent.toString().split(System.lineSeparator());
        StringBuilder actual = new StringBuilder();
        for (String line : result) {
            if (!line.contains("Enter")) {
                actual.append(line).append("\n");
            }
        }
        // Then
        String expectedOutput = "The operation cannot be performed.\n";
        assertEquals(expectedOutput, actual.toString());

    }

    @Test
    void TestPrint() {
        // Given
        double[][] matrix = {
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4}
        };
        System.setOut(new PrintStream(outContent));
        // When
        calculator.print(matrix);
        //Process Output
        StringBuilder actual = new StringBuilder();
        for (String line : outContent.toString().split(System.lineSeparator())) {
            actual.append(line).append("\n");
        }
        // Then
        String expectedOutPut = "1.00 2.00 3.00 4.00 \n1.00 2.00 3.00 4.00 \n1.00 2.00 3.00 4.00";
        assertEquals(expectedOutPut, actual.toString().trim());

    }

    @Test
    void TestTransMain() {
        // Given
        String input = "3 3\n1 2 3\n4 5 6\n7 8 9";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(outContent));
        // When
        calculator.transMain();
        // Filter Captured lines
        String[] result = outContent.toString().split(System.lineSeparator());
        StringBuilder actual = new StringBuilder();
        for (String line : result) {
            if (!line.contains("Enter")) {
                actual.append(line).append("\n");
            }
        }
        // Then
        String expected = "The result is:\n\n1.00 4.00 7.00 \n2.00 5.00 8.00 \n3.00 6.00 9.00";
        assertEquals(expected, actual.toString().trim());

    }


    @Test
    void TestTransSide() {
        // Given
        String input = "3 3\n1 2 3\n4 5 6\n7 8 9";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(outContent));

        // When
        calculator.transSide();
        // Filter Captured lines
        String[] result = outContent.toString().split(System.lineSeparator());
        StringBuilder actual = new StringBuilder();
        for (String line : result) {
            if (!line.contains("Enter")) {
                actual.append(line).append("\n");
            }
        }
        // Then
        String expected = "9.00 6.00 3.00 \n8.00 5.00 2.00 \n7.00 4.00 1.00 ";
        assertEquals(expected.trim(), actual.toString().trim());


    }


    @Test
    void TestFindInverse() {
        // Given
        String input = "3 3\n4 3 8\n6 2 5\n1 5 9";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(outContent));

        // When
        calculator.findTheInverse();
        // Filter Captured lines
        String[] result = outContent.toString().split(System.lineSeparator());
        StringBuilder actual = new StringBuilder();
        for (String line : result) {
            if (!line.contains("Enter")) {
                actual.append(line).append("\n");
            }
        }
        // Then
        String expected = "-0.14 0.27 -0.02 \n-1.00 0.57 0.57 \n0.57 -0.35 -0.20 ";
        assertEquals(expected.trim(), actual.toString().trim());

    }


}