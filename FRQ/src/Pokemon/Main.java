package Pokemon;

public class Main {

    public static void main(String[] args) {
        Pokemon pikachu = new Pikachu(51, 2, false);
        Pokemon pikachu2 = new Pikachu(100, 1, true);
        Pokemon pikachu3 = new Pikachu(49, 3, false);

        System.out.println(pikachu.getAttackPower());
        System.out.println(pikachu.getCatchRate());
        System.out.println(pikachu.getLevel());
        pikachu.cry();
        pikachu2.levelUp();
        pikachu3.getAttackPower();
    }
}
