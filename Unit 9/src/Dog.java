public class Dog extends Animal {
    private String name;
    private int age;
    private double weight;

    /* The "server" is the area that stores where the information comes from
    *  The state of an object is the contents of its properties at any given point in time
    * */

    /* Default Constructor */
    public Dog() {
        name = "Bingo";
        age = 3;
        weight = 20.5;
    }

    /* Overloaded Constructor */
    public Dog(String name, int age, double weight) { // Formal Parameters
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String toString() {
        return "Hi my name is " + name + "\nAge: " + age + "\nWeight: " + weight;
    }
}
