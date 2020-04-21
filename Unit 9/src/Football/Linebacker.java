package Football;

public class Linebacker extends DefensivePlayer {

    public Linebacker(String n, int num, int t) {
        super(n, num, t); // DefensivePlayer constructor
    }

    @Override
    public void action() {
        super.action();
        System.out.println("For a loss of 2 yards!");
    }
}
