package processor;
import java.util.Scanner;

// State of Machine, a design pattern.
class state {
    public static Scanner g = new Scanner(System.in);
    public static boolean isRunning = true; // An indicator of machine state.
    public static State currentState = State.CHOOSING_AN_ACTION;
    // The enum encompasses all the different states.
    enum State {
        ADDITION, MULTBYCONST, MULTIPLICATION, EXIT, CHOOSING_AN_ACTION, TRANSPOSE, DETERMINANT, INVERSE
    }
    // The power button of the machine.
    public static void start() {
        while (isRunning) {
            state.operationManager(state.currentState);
        }
    }
    // The function has two nested switches,
    // both handle different scenarios according to the state.
    public static void operationManager(State state) {
        switch (state) {
            case CHOOSING_AN_ACTION:
                System.out.println("\n1. Add matrices\n2. Multiply matrix by a constant\n3. Multiply matrices" +
                        "\n4. Transpose matrix" +
                        "\n5. Calculate a determinant\n6. Inverse matrix\n0. Exit");
                int num = g.nextInt();
                // in this switch, user choice will change the default state,
                // in the switch after, the operation will be chosen according to the state,
                // and will return the state to its default value
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
            // Meaning, ok I have received your signal no need to shout for me any longer.
            // That is why we return the state to its default value.
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
    // Different kind of transpose needed a manager function.
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

