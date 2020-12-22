import java.util.*;

/* Lambda expressions basically express instances of functional interfaces
(An interface with single abstract method is called functional interface.
An example is java.lang.Runnable). lambda expressions implement the only
abstract function and therefore implement functional interfaces */

/* A functional interface is an interface that contains only one abstract method. */

/*  Method reference is used to refer method of functional interface */

interface Messageable{
    Message getMessage(String msg);
}
class Message{
    Message(String msg){
        System.out.print("Message = "+msg);
    }
}


interface StringInterfaceForLambda {
    // thread
    String run(String str);
}

interface MathOperationInterfaceForLambda {
    int operationForLambda(int a, int b);
}

interface functionalInterface {
    int calculateFunctionalInterface(int x);
}

interface interfaceWithVoidMethod{
    void say();
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

    public static void staticMethodForMethodReference(){
        System.out.println("Hello, this is static method.");
    }

    public void nonStaticmethodForMethodReference(){
        System.out.println("Hello, this is a non-static method.");
    }

    int arrayListSize = 4;
    ArrayList<Integer> arList = new ArrayList<>();


    public static void main(String[] args) {

        JavaEight j8 = new JavaEight();

        // lambda
        j8.printFormattedForLambda("Hello", j8.exclaim);
        j8.printFormattedForLambda("Hello", j8.ask);

        // returns statement for lambda
        MathOperationInterfaceForLambda subtraction = (a, b) -> a - b;
        MathOperationInterfaceForLambda addition = (a, b) -> a + b;
        MathOperationInterfaceForLambda multiplication = (a, b) -> a * b;
        System.out.println("10 - 5 = " + j8.operateForLambda(10, 5, subtraction));
        System.out.println("10 + 5 = " + j8.operateForLambda(10, 5, addition));
        System.out.println("10 * 5 = " + j8.operateForLambda(10, 5, multiplication));

        for (int i = 0; i < j8.arrayListSize; i++) {
            j8.arList.add(i);
        }
        j8.arList.forEach(n -> System.out.print(", Ar list = " + n));
        System.out.println();

        // functional interface
        functionalInterface funcInterfaceLambda = (int x) -> x * x;
        int functionalInterfaceAnswer = funcInterfaceLambda.calculateFunctionalInterface(5);
        System.out.println("Functional Interface = " + functionalInterfaceAnswer);

        // Method references
        // Referring static method
        interfaceWithVoidMethod referencingStaticMethod = JavaEight::staticMethodForMethodReference;
        // Calling interface method
        referencingStaticMethod.say();

        // Referring non-static method using reference
        interfaceWithVoidMethod referencingNonStaticMethod = j8::nonStaticmethodForMethodReference;
        referencingNonStaticMethod.say();

        // Referring non-static method using anonymous object
        // You can use anonymous object also
        interfaceWithVoidMethod referencingNonStaticMethod2 = new JavaEight()::nonStaticmethodForMethodReference;
        // Calling interface method
        referencingNonStaticMethod2.say();

        Messageable hello = Message::new;
        hello.getMessage("Hello from Reference to a Constructor");
    }

}
