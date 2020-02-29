package Behavioral;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Allow an object to alter its behavior when its internal state changes.
 * The object will appear to change its class.*/
/** https://sourcemaking.com/design_patterns/state/java/3 */

abstract class State {
	
    public void pull(Chain wrapper) {
    	
        wrapper.setState(new Off());
        System.out.println("   turning off");
    }
}

class Chain {
	
    private State current;

    public Chain() {
        current = new Off();
    }

    public void setState(State state) {
        current = state;
    }

    public void pull() {
        current.pull(this);
    }
    
}

class Off extends State {
	
    public void pull(Chain wrapper) {
    	
        wrapper.setState(new Low());
        System.out.println( "   low speed" );
    }
    
}

class Low extends State {
	
    public void pull(Chain wrapper) {
    	
        wrapper.setState(new Medium());
        System.out.println("   medium speed");
    }
    
}

class Medium extends State {
	
    public void pull(Chain wrapper) {
    	
        wrapper.setState(new High());
        System.out.println("   high speed");
    }
    
}

class High extends State { }

public class StatePattern {
	
    public static void main( String[] args ) throws IOException {
    	
        InputStreamReader is = new InputStreamReader( System.in );
        Chain chain = new Chain();
        
        while (true) {
        	
            System.out.print( "Press 'Enter'" );
            is.read();
            chain.pull();
        }
    }
}
