package Football;

public class FootballPlayer {

    private String name;
    private int number;
    private double weight;
    private double height;
    private double speed;

    public FootballPlayer() {
        System.out.println("I play football!");
    }

    public void setWeight(double w) {
        weight = w;
    }

    public void setSpeed(double s) {
        speed = s;
    }

    public void run() {
        System.out.println("Huff huff puff...");
    }



}
