**Design Pattens** - a general repeatable solution to a commonly occurring problem in software design.<br />
-a description or template for how to solve a problem that can be used in many different situations.<br />
<br />
<br />
**1. Behavioral Pattern** <br />
-explains how objects interact.<br />
-identify common communication patterns among objects<br />
-how the steps of a task are divided among different objects.<br />
-Behavioral patterns describe a process or a flow<br />
<br />
**BEHAVIORAL DESIGN PATTERNS**<br />
**Chain of responsibility** - A way of passing a request between a chain of objects to handle request<br />
**Command** - Encapsulate a command request as an object and send to invoker.<br />
Invoker object looks for the appropriate object which can handle this command and pass the command to the corresponding object<br />
**Interpreter** - A way to evaluate language grammar or expression.<br /> 
Involves implementing an expression interface which tells to interpret a particular context.<br />
This pattern is used in SQL parsing, symbol processing engine etc.<br />
**Iterator** - Sequentially access the elements of a collection<br />
**Mediator** - Define an object that encapsulates how a set of objects interact.<br />
**Memento** - Restore state of an object to a previous state.<br />
**Null Object** - Designed to act as a default value of an object<br />
**Observer** - A way of notifying change to a number of classes<br />
**State** - Alter an object's behavior when its state changes<br />
**Strategy** - Encapsulates an algorithm inside a class<br />
**Template method** - Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.<br />
**Visitor** - Define a new operation without changing the classes of the elements on which it operates.<br />
<br /><br />
**2. Creational patterns** are design patterns that deal with object creation mechanisms and<br />
are used in situations when basic form of object creation could result in design problems or<br />
increase complexity of a code base.<br />
<br />
**CREATIONAL DESIGN PATTERNS**<br />
**Abstract Factory** - Creates an instance of several families of classes<br />
**Builder** - construct a complex object from simple objects using step-by-step approach<br />
**Factory Method** - Define an interface for creating an object, but let subclasses decide which class to instantiate.<br />
**Object Pool** - used to manage the object caching.<br />
Basically, an Object pool is a container which contains a specified amount of objects.<br /> 
When an object is taken from the pool, it is not available in the pool until it is put back.<br />
Recycle objects that are no longer in use<br />s
**Prototype** - A fully initialized instance to be copied or cloned<br />
**Singleton** - A class of which only a single instance can exist<br />
<br />
<br />
**3.Structural design patterns** how classes and objects can be composed, to form larger structures.<br />
-simplifies the structure by identifying the relationships.<br /> 
-for creating relationships between objects.<br /><br />
**STRUCTURAL DESIGN PATTERNS**<br />
**Adapter** - Match interfaces of different classes<br />
**Bridge** - Separates an object’s interface from its implementation<br />
**Composite** - A tree structure of simple and composite objects<br />
**Decorator** - Add responsibilities to objects dynamically<br />
**Facade** - A single class that represents an entire subsystem<br />
**Flyweight** - A fine-grained instance used for efficient sharing<br />
**Private Class Data** - Restricts accessor/mutator access<br />
**Proxy** - An object representing another object<br />
