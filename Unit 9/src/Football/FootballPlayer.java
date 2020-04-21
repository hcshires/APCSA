package Football;

public class FootballPlayer {

    private String name;
    private int number;
    private double weight;
    private double height;
    private double speed;

    public FootballPlayer() {
        System.out.println("I play football!");
        name = "Football Player";
        number = 00;
    }

    public FootballPlayer(String n, int num) {
        this.name = n;
        this.number = num;
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

    public void action() {
        System.out.println("My name is " + name + " and I am number " + number);
    }


}
