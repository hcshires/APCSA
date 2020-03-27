package Animal;

/** Animal.BassetHound and other classes become extensions of the Animal.Dog class.
 * Because they are extensions, they inherit all properties and methods of the dog class
 * **/

public class BassetHound extends Dog {

    public BassetHound() {
        super();
    }

    public BassetHound(String name, int age, double weight) {
        super(name, age, weight); // Passes formal parameters to super constructor, calls constructor in superclass
    }
}
