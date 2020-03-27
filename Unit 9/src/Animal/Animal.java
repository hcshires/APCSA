package Animal;

public class Animal {
    private String sciName;
    private String comName;

    public Animal() {
        sciName = "Animalus Genericus";
        comName = "Generic Animal.Animal";
    }

    public Animal(String sciName, String comName) {
        this.sciName = sciName;
        this.comName = comName;
    }

    public String getSciName() {
        return sciName;
    }

    public String getComName() {
        return comName;
    }

    public static void funFact() {
        System.out.println("The overridden funFact() method displays a fun fact for each animal");
    }

    public String toString() {
        return "I am a(n) " + sciName + " but you can call me a(n) " + comName;
    }
}
