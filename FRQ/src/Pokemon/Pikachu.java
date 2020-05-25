package Pokemon;

public class Pikachu extends Pokemon {

    private boolean hasLightBall;

    public Pikachu(int w, int lev, boolean hasLightBall) {
        super(w, lev);
        this.hasLightBall = hasLightBall;
    }

    @Override
    public double getCatchRate() {
        return super.getCatchRate() / 2;
    }

    @Override
    public double getAttackPower() {
        double attackPower = super.getAttackPower();

        if (super.getWeight() > 50) {
            attackPower -= 5;
        }

        if (hasLightBall) {
            attackPower *= 2;
        }

        return attackPower;

    }

    @Override
    public void levelUp() {
        super.levelUp();
        super.gainWeight();
        System.out.println("PIKA PIKA! I reached level " + super.getLevel() + "!");
    }

    @Override
    public void cry() {
        System.out.println("PIKACHUUUUU!");
    }
}
