package Animal;

public class Hippo extends WildAnimal {

    public Hippo() {
        super();
    }

    public Hippo(String sciName, String comName) {
        super(sciName, comName);
    }

    public static void funFact() {
        System.out.println("The word Hippopotamus comes from the Ancient Greek phrase 'river horse'.");
    }
}
