

interface Inter1 {
    String function1();
}

public class ClassesAndInheritence {

    static abstract class A1 implements Inter1 {
        public String function1() {
            return "Hello World!";
        }
        public abstract String function2();
    }

    static class C1 extends A1 {
        public String function1() {
            return function2();
        }
        public String function2() {
            return "Hi there!";
        }
    }

    public static void main(String[] args) {
        Inter1 interface1 = new C1();
        System.out.println("Result = " + interface1.function1());
        A1 ace = new C1();
        System.out.println("Second Result = " + ace.function2());
    }
}
