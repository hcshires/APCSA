package Football;

public class DefensivePlayer extends FootballPlayer {

    private int tackles;

    public DefensivePlayer(String n, int num, int t) {
        super(n, num);
        this.tackles = t;
    }

    public void tackle() {
        System.out.println("Gotcha! OOF");
    }

    @Override
    public void action() {
        super.action();
        System.out.println("Tackle made!");
        tackles++;
    }

}
