package processor;

import java.util.Locale;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        state.start();


    }


}

class calculator {
    static final Scanner sc = new Scanner(System.in).useLocale(Locale.US);

    static double[][] readInputMatrix(int rows, int columns) {

        double[][] matrix = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            String[] items = sc.nextLine().split(" ");
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Double.parseDouble(items[j]);
            }
        }

        return matrix;
    }

    // multiplies any matrix with a constant.
    static void multiplyConstant() {
        // assuming the matrix is a square one.
        System.out.println("Enter size of matrix:");
        int n1 = sc.nextInt();
        int m1 = sc.nextInt();


        System.out.println("Enter matrix:");
        sc.nextLine();
        double[][] arr = readInputMatrix(n1, m1);


        System.out.println("Enter constant:");

        double con = sc.nextDouble();
        System.out.println("The result is:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = arr[i][j] * con;
            }
        }
        print(arr);

    }

    public static double[][] multiplyConstant(double[][] arr, double con) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = arr[i][j] * con;
            }
        }
        return arr.clone();

    }

    static void matracesAddition() {
        System.out.println("Enter the size of first matrix:");
        int n1 = sc.nextInt();
        int m1 = sc.nextInt();
        System.out.println("Enter first matrix:");
        sc.nextLine();
        double[][] arr1 = readInputMatrix(n1, m1);
        System.out.println("Enter the size of second matrix:");
        int n2 = sc.nextInt();
        int m2 = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter second matrix:");
        double[][] arr2 = readInputMatrix(n2, m2);
        if (arr1.length != arr2.length && arr1[0].length != arr2[0].length) {
            System.out.println("Operation cannot be performed.");
        } else {
            double[][] result = new double[n1][m1];
            System.out.println("The result is:");
            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < m1; j++) {
                    result[i][j] = arr1[i][j] + arr2[i][j];
                }
            }

            print(result);

        }


    }

    public static void print(double[][] arr) {
        for (double[] doubles : arr) {
            System.out.println();
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(doubles[j] + " ");
            }
        }
    }

    public static void multiplication() {
        System.out.println("Enter the size of first matrix:");
        int n1 = sc.nextInt();
        int m1 = sc.nextInt();
        System.out.println("Enter first matrix:");
        sc.nextLine();
        double[][] arr1 = readInputMatrix(n1, m1);
        System.out.println("Enter size of second matrix:");
        int n2 = sc.nextInt();
        int m2 = sc.nextInt();
        System.out.println("Enter second matrix:");
        sc.nextLine();
        double[][] arr2 = readInputMatrix(n2, m2);
        if (m1 != n2) {
            System.out.println("The operation cannot be performed.");
        } else {
            double[][] result = new double[n1][m2];
            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < m2; j++) {
                    result[i][j] = 0;
                    for (int x = 0; x < n2; x++) {
                        result[i][j] += arr1[i][x] * arr2[x][j];
                    }

                }

            }
            print(result);
        }


    }

    public static void transMain() {
        double[][] arr = inputForTranspose();
        double[][] arr2 = new double[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr2[j][i] = arr[i][j];
            }
        }
        System.out.println("The result is:");
        print(arr2);

    }

    // overloaded version to be used with inverse operation
    public static double[][] transMain(double[][] arr, int n) {
        double[][] arr2 = new double[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr2[j][i] = arr[i][j];
            }
        }
        return arr2.clone();


    }

    public static void transSide() {
        double[][] arr = inputForTranspose();
        double[][] arr2 = new double[arr.length][arr[0].length];
        for (int i = 0, c = arr[0].length - 1; i < arr.length && c > -1; i++, c--) {

            for (int j = 0, r = arr.length - 1; j < arr[0].length && r > -1; j++, r--) {

                arr2[r][c] = arr[i][j];

            }


        }
        print(arr2);
    }

    public static void transVertical() {
        double[][] arr = inputForTranspose();
        double[][] arr2 = new double[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0, c = arr[0].length - 1; j < arr[0].length && c > -1; j++, c--) {
                arr2[i][c] = arr[i][j];
            }
        }
        print(arr2);

    }

    public static void transHorizontal() {
        double[][] arr = inputForTranspose();
        double[][] arr2 = new double[arr.length][arr[0].length];
        for (int i = 0, r = arr.length - 1; i < arr.length && r > -1; i++, r--) {
            for (int j = 0; j < arr[0].length; j++) {
                arr2[r][j] = arr[i][j];
            }
        }
        print(arr2);

    }

    public static double[][] inputForTranspose() {
        System.out.println("Enter matrix size");
        int n1 = sc.nextInt();
        int m1 = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter matrix:");
        double[][] arr = readInputMatrix(n1, m1);
        return arr.clone();

    }


    // Thanks to Geeksforgeesk.com for helping me in this task.
    // This function will find the cofactor of the given element in the array 'matrix'
    public static void findCofactor(double[][] matrix, double[][] temp, int p, int q, int n) {
        int i = 0, j = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                // Copying into temporary matrix
                // only those element which are
                // not in given row and column
                if (row != p && col != q) {
                    temp[i][j++] = matrix[row][col];
                    // Row is filled, so increase
                    // row index and reset col
                    // index
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }


    public static double findDeterminant(double[][] mat, int n) {
        double R = 0; // initializing the result

        if (n == 1)
            return mat[0][0];
        double[][] temp = new double[n][n];

        int sign = 1;

        for (int i = 0; i < n; i++) {
            // Getting Cofactor of mat[0][f]
            findCofactor(mat, temp, 0, i, n);
            R += sign * mat[0][i] * findDeterminant(temp, n - 1);
            sign = -sign;

        }
        return R;
    }

    public static void DeterminantManager() {
        // the function can be used to take a matrix from the user.
        double[][] matrix = inputForTranspose();
        int n = matrix.length;
        double result = findDeterminant(matrix, n);
        System.out.println("The result is");
        System.out.println(result);

    }

    public static void findTheInverse() {
        double[][] mat = inputForTranspose();
        int n = mat.length;
        double[][] temp = new double[n - 1][n - 1];
        double determinant = findDeterminant(mat, n);
        double[][] cofactorsMatrix = new double[n][n];
        if (determinant == 0) {
            System.out.println("This matrix doesn't have an inverse");
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    findCofactor(mat, temp, i, j, n);
                    cofactorsMatrix[i][j] = Math.pow(-1, (i + j)) * findDeterminant(temp, n - 1);
                }
            }

            double[][] adjoint = transMain(cofactorsMatrix, n);
            double constant = 1 / determinant;
            double[][] result = multiplyConstant(adjoint, constant);
            print(result);

        }
    }

}

class state {
    public static Scanner g = new Scanner(System.in);
    public static boolean isRunning = true;
    public static State currentState = State.CHOOSING_AN_ACTION;

    enum State {
        ADDITION, MULTBYCONST, MULTIPLICATION, EXIT, CHOOSING_AN_ACTION, TRANSPOSE, DETERMINANT, INVERSE
    }

    public static void start() {
        while (isRunning) {
            state.operationManager(state.currentState);
        }
    }

    public static void operationManager(State state) {
        switch (state) {
            case CHOOSING_AN_ACTION:
                System.out.println("\n1. Add matrices\n2. Multiply matrix by a constant\n3. Multiply matrices" +
                        "\n4. Transpose matrix" +
                        "\n5. Calculate a determinant\n6. Inverse matrix\n0. Exit");
                int num = g.nextInt();
                switch (num) {
                    case 1:
                        currentState = State.ADDITION;
                        break;
                    case 2:
                        currentState = State.MULTBYCONST;
                        break;
                    case 3:
                        currentState = State.MULTIPLICATION;
                        break;
                    case 4:
                        currentState = State.TRANSPOSE;
                        break;
                    case 5:
                        currentState = State.DETERMINANT;
                        break;
                    case 6:
                        currentState = State.INVERSE;
                        break;
                    case 0:
                        currentState = State.EXIT;
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Wrong number");
                        break;
                }
                break;
            case ADDITION:
                currentState = State.CHOOSING_AN_ACTION;
                calculator.matracesAddition();
                break;
            case MULTBYCONST:
                currentState = State.CHOOSING_AN_ACTION;
                calculator.multiplyConstant();
                break;
            case MULTIPLICATION:
                currentState = State.CHOOSING_AN_ACTION;
                calculator.multiplication();
                break;
            case TRANSPOSE:
                currentState = State.CHOOSING_AN_ACTION;
                TransManager();
                break;
            case DETERMINANT:
                currentState = State.CHOOSING_AN_ACTION;
                calculator.DeterminantManager();
                break;
            case INVERSE:
                currentState = State.CHOOSING_AN_ACTION;
                calculator.findTheInverse();
                break;

        }
    }

    public static void TransManager() {
        System.out.println("1. Main diagonal\n2. Side diagonal\n3. Vertical line" +
                "\n4. Horizontal line");
        int num = g.nextInt();
        switch (num) {
            case 1:
                calculator.transMain();
                break;
            case 2:
                calculator.transSide();
                break;
            case 3:
                calculator.transVertical();
                break;
            case 4:
                calculator.transHorizontal();
                break;
            default:
                System.out.println("Wrong input");
                break;
        }
    }
}

