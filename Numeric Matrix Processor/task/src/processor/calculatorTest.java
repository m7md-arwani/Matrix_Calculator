package processor;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class calculatorTest {

    //Square Matrix Case
    @Test
    void TestReadInputMatrix(){
        // Given
        int row = 4;
        int column = 4;
        String input = "1 1 1 1\n2 2 2 2\n1 1 1 1\n1 1 1 1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // When
        double[][] matrix = calculator.readInputMatrix(row,column);
        // Then
        double[][] expectedMatrix = {
                {1,1,1,1},
                {2,2,2,2},
                {1,1,1,1},
                {1,1,1,1}
        };
        assertArrayEquals(expectedMatrix,matrix);
    }

    //non-Square Matrix Case
    @Test
    void TestReadInputMatrixNonSquare(){
        // Given
        int row = 4;
        int column = 2;
        String input = "1 1\n2 2\n1 1\n1 1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // When
        double[][] matrix = calculator.readInputMatrix(row,column);
        // Then
        double[][] expectedMatrix = {
                {1,1},
                {2,2},
                {1,1},
                {1,1}
        };
        assertArrayEquals(expectedMatrix,matrix);
    }
}