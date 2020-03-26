public class Unit9Notes {
    /* Inheritance: Sharing code between classes
       Inheritance avoids duplicate code and defines a common protocol for a group of classes

       Allows easy managing group of similar objects

       Polymorphism: Treating different objects the same
     */
    public static void main(String[] args) {
        /* Defining the objects is the client. Asking from the server for information */

        // myDog is an example/type of Dog, it is a subclass of Dog and inherits Dog's properties (IS-A Relationship)

        /* This doesn't work if we ONLY inherit the super constructor
        * We used an empty super() to pass to the DEFAULT super constructor. If you use overloaded constructors you MUST include a default
        */
        BassetHound myDog = new BassetHound();
        System.out.println(myDog);

        // d1 has ownership of/contains properties that are its own (HAS-A Relationship)
        Dog d1 = new Dog();
        System.out.println(d1);

        Dog d2 = new Dog("Nova", 3, 50.0); // Actual parameters
        System.out.println(d2);

        // Polymorphism allows objects of different types to be combined in the same array
        Dog[] myDogs = new Dog[5];
        myDogs[0] = myDog;
        myDogs[1] = d1;
        myDogs[2] = d2;

        /* If a class doesn't SPECIFICALLY extend another class, it will automatically extend the OBJECT class
           - The object class includes basic methods such as a default constructor, toString(), equals(), etc.
           - All numeric properties are set to 0
           - All object properties are set to null
         */

        // CANNOT do this without specifying an overloaded constructor in subclass
        // In this case, we used super() in the subclass, to pass our parameters to the super constructor in "Dog"
        BassetHound myDog2 = new BassetHound("Beau", 7, 35.4);

        /** Hippo Example **/
        Hippo h1 = new Hippo();
        Hippo h2 = new Hippo("Hippopotamus amphibious", "Hippopotamus");
        System.out.println(h1);
        System.out.println(h2);
    }
 }