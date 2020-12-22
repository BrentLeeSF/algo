import java.util.ArrayList;

/* Lambda expressions basically express instances of functional interfaces
(An interface with single abstract method is called functional interface.
An example is java.lang.Runnable). lambda expressions implement the only
abstract function and therefore implement functional interfaces */

interface StringInterfaceForLambda {
    // thread
    String run(String str);
}

interface MathOperationInterfaceForLambda {
    int operationForLambda(int a, int b);
}

public class JavaEight {

    StringInterfaceForLambda exclaim = (s) -> s + "!";
    StringInterfaceForLambda ask = (s) -> s + "?";

    public void printFormattedForLambda(String str, StringInterfaceForLambda format) {
        String result = format.run(str);
        System.out.println(result);
    }

    private int operateForLambda(int a, int b, MathOperationInterfaceForLambda mathOperation) {
        return mathOperation.operationForLambda(a, b);
    }

    public static void main(String[] args) {

        JavaEight j8 = new JavaEight();

        j8.printFormattedForLambda("Hello", j8.exclaim);
        j8.printFormattedForLambda("Hello", j8.ask);

        // returns statement
        MathOperationInterfaceForLambda subtraction = (a, b) -> a - b;
        MathOperationInterfaceForLambda addition = (a, b) -> a + b;
        MathOperationInterfaceForLambda multiplication = (a, b) -> a * b;
        System.out.println("10 - 5 = " + j8.operateForLambda(10, 5, subtraction));
        System.out.println("10 + 5 = " + j8.operateForLambda(10, 5, addition));
        System.out.println("10 * 5 = " + j8.operateForLambda(10, 5, multiplication));

        int arrayListSize = 4;
        ArrayList<Integer> arList = new ArrayList<>();
        for (int i = 0; i < arrayListSize; i++) {
            arList.add(i);
        }
        arList.forEach(n -> System.out.print(", Ar list = " + n));
        System.out.println();
    }
}
