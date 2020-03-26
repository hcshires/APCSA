public class Animal {
    private String sciName;
    private String comName;

    public Animal() {
        sciName = "Animalus Genericus";
        comName = "Generic Animal";
    }

    public Animal(String sciName, String comName) {
        this.sciName = sciName;
        this.comName = comName;
    }

    public String toString() {
        return "I am a(n) " + sciName + " but you can call me a(n) " + comName;
    }
}
