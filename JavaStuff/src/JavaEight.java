import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* Lambda expressions - is a short block of code which takes in parameters and returns a value.
Can express instances of functional interfaces
(An interface with single abstract method is called functional interface.
An example is java.lang.Runnable). lambda expressions implement the only
abstract function and therefore implement functional interfaces */

/* A functional interface is an interface that contains only one abstract method. */

/*  Method reference is used to refer method of functional interface */

/* Optional is a container object used to contain not-null objects.
Optional object is used to represent null with absent value.
This class has various utility methods to facilitate code to handle
values as ‘available’ or ‘not available’ instead of checking null values.
https://www.tutorialspoint.com/java8/java8_optional_class.htm */

/* DEFAULT METHODS - Before Java 8, interfaces could have only abstract methods.
The implementation of these methods has to be provided in a separate class.
So, if a new method is to be added in an interface, then its
implementation code has to be provided in the class implementing
the same interface.
To overcome this issue, Java 8 has introduced the concept of default methods
which allow the interfaces to have methods with implementation without
affecting the classes that implement the interface. */

/*Streams - JS type functions (map, filter, etc)
* process collections of objects. A stream is a sequence of objects
* that supports various methods which can be pipelined to produce the desired result. */

interface Messageable{
    Message getMessage(String msg);
}
class Message{
    Message(String msg){
        System.out.print("Message = "+msg);
    }
}

// Test Interface default method
interface TestDefaultMethodInterface {
    // abstract method
    public void square(int a);

    // default method
    default void show() {
        System.out.println("Default Method Executed");
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

class TestDefaultMethodTestClass implements TestDefaultMethodInterface {
    public void square(int a) {
        System.out.println("implementation of square abstract method = "+(a*a));
    }
}

public class JavaEight {

    // lambda as stored in values
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

    public Integer sumWithOptionals(Optional<Integer> a, Optional<Integer> b) {
        //Optional.isPresent - checks the value is present or not

        System.out.println("First parameter is present: " + a.isPresent());
        System.out.println("Second parameter is present: " + b.isPresent());

        //Optional.orElse - returns the value if present otherwise returns
        //the default value passed.
        int value1 = a.orElse(1);

        //Optional.get - gets the value, value should be present
        int value2 = b.get();
        return value1 + value2;
    }

    int arrayListSize = 4;
    ArrayList<Integer> arList = new ArrayList<>();


    public static void main(String[] args) {

        JavaEight j8 = new JavaEight();

        // lambda with stored-in values
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
        j8.arList.forEach(n -> System.out.print(n+", "));
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

        // reference to a constructor
        Messageable hello = Message::new;
        hello.getMessage("Hello from Reference to a Constructor");

        Integer value1 = null;
        Integer value2 = 10;
        //Optional.ofNullable - allows passed parameter to be null.
        Optional<Integer> a = Optional.ofNullable(value1);

        //Optional.of - throws NullPointerException if passed parameter is null
        Optional<Integer> b = Optional.of(value2);
        System.out.println("OPTIONALS = "+j8.sumWithOptionals(a,b));

        // default method
        TestDefaultMethodTestClass d = new TestDefaultMethodTestClass();
        d.square(4);
        // default method executed
        d.show();

        // streams https://www.geeksforgeeks.org/stream-in-java/
        List<Integer> ListOfInts = Arrays.asList(2,3,4,5);

        // demonstration of map method
        List<Integer> squareOfInts = ListOfInts.stream().map(x -> x*x).collect(Collectors.toList());
        System.out.println("Map = "+squareOfInts);

        List<String> listOfStrings = Arrays.asList("Reflection", "Collection", "Stream", "testing", "Second value");

        List<String> result = listOfStrings.stream().filter(s->s.startsWith("S")).collect(Collectors.toList());
        System.out.println("Filtered = "+result);

        List<String> sortedResults = listOfStrings.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted Results = "+sortedResults);

        System.out.println("For Each");
        ListOfInts.stream().map(x->x*x).forEach(y->System.out.print(y+", "));

        // Spliterator
        List<Integer> ListOfInts2 = Arrays.asList(1,2,-3,-4,5);
        Stream<Integer> str = ListOfInts2.stream();
        Spliterator<Integer> splitr1 = str.spliterator();
        // hasCharacteristics and characteristics method
        System.out.println(splitr1.hasCharacteristics(splitr1.characteristics()));

        System.out.print("Content of arraylist: ");
        // forEachRemaining method
        splitr1.forEachRemaining((n) -> System.out.print(n+", "));
        System.out.println();

        // Obtaining another  Stream to the array list.
        Stream<Integer> str1 = ListOfInts2.stream();
        splitr1 = str1.spliterator();

        // trySplit() method
        Spliterator<Integer> splitr2 = splitr1.trySplit();
        // If splitr1 could be split, use splitr2 first.
        if(splitr2 != null) {
            System.out.println("Output from splitr2: ");
            splitr2.forEachRemaining((n) -> System.out.print(n+", "));
        }

        System.out.println("\nOutput from splitr1: ");
        splitr1.forEachRemaining((n) -> System.out.print(n+", "));

        System.out.println();
        System.out.println();
    }

}
