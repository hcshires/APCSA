public class Unit9Notes {
    /* Inheritance: Sharing code between classes
       Inheritance avoids duplicate code and defines a common protocol for a group of classes

       Allows easy managing group of similar objects

       Polymorphism: Treating different objects the same
     */
    public static void main(String[] args) {
        // dog1 is an example/type of Dog, it is a subclass of Dog and inherits Dog's properties (IS-A Relationship)
        BassetHound dog1 = new BassetHound();

        // myDog has ownership of/contains properties that are its own (HAS-A Relationship)
        Dog myDog = new Dog();
        System.out.println(dog1);

        // Polymorphism allows objects of different types to be combined in the same array
        Dog[] myDogs = new Dog[5];
        myDogs[0] = new BassetHound();
    }
}