package Behavioral;


/**
 * Encapsulate a request under an object as a command and pass it to invoker
 * object. Invoker object looks for the appropriate object which can handle this
 * command and pass the command to the corresponding object and that object
 * executes the command
 * https://sourcemaking.com/design_patterns/command/java/2
 */
class SimpleCommand {
	
    private int state;

    public SimpleCommand(int state) {
        this.state = state;
    }

    public void add(Integer value) {
        state += value.intValue();
    }

    public void addTwoOperands(Integer firstValue, Integer secondValue) {
        state = state + firstValue.intValue() + secondValue.intValue();
    }

    public int getState() {
        return state;
    }
}

class ReflectCommand {
	
    /** the "encapsulated" object */
    private Object receiver;
    
    /** the "pre-registered" request*/
    private java.lang.reflect.Method action;
    
    /** the "pre-registered" request*/
    private Object[] args;

    public ReflectCommand(Object obj, String methodName, Object[] arguments) {
    	
        this.receiver = obj;
        this.args = arguments;
        Class cls = obj.getClass();
        Class[] argTypes = new Class[args.length];
        
        for (int i = 0; i < args.length; i++) {
            argTypes[i] = args[i].getClass();
        }
        
        try {
            action = cls.getMethod(methodName, argTypes);
            
        } catch(NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public Object execute() {
    	
        try {
        	action.invoke(receiver, args);
            return receiver.getClass().getMethod("getState").invoke(receiver);
            
        } catch(Exception e) {
        	e.printStackTrace();
        }
        
        return null;
    }
    
}

public class Command {
	
    public static void main(String[] args) {
    	
        SimpleCommand[] simpleCommands = {new SimpleCommand(1), new SimpleCommand(2)};
        
        System.out.print("Normal call results: ");
        
        simpleCommands[0].add(3);
        System.out.print(simpleCommands[0].getState() + " ");
        
        simpleCommands[1].addTwoOperands(4, 5);
        System.out.print(simpleCommands[1].getState());

        ReflectCommand[] reflectCommands = {
                new ReflectCommand(simpleCommands[0], "add", new Integer[] {3}),
                new ReflectCommand(simpleCommands[1], "addTwoOperands", new Integer[] {4, 5})
        };
        
        System.out.print("\nReflection results:  ");
        
        for (ReflectCommand command : reflectCommands) {
            System.out.print(command.execute() + " ");
        }
        
        System.out.println();
        
    }
}
