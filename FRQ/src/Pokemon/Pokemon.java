package Pokemon;

public class Pokemon {

    private double catchRate;
    private double attackPower;
    private int weight;
    private int level;

    public Pokemon(int w, int lev) {
        weight = w;
        level = lev;
        catchRate = Math.random() * .25; // catch rate between 0 and 25% of the time
        attackPower = Math.random() * 10 + 60; // attack power between 60 and 70
    }

    public void gainWeight() {
        weight *= 1.05; // has the Pokemon get 5% heavier
    }

    public void workout() {
        weight *= 0.95; // working out cases the Pokemon to lose 5% of its weight
    }

    public double getWeight() {
        return weight;
    }

    public double getCatchRate() {
        return catchRate;
    }

    public double getAttackPower() {
        return attackPower;
    }

    public int getLevel() {
        return level;
    }

    public void levelUp() {
        attackPower *= 1.05; // 5% attack bonus for leveling up
        level++;
    }

    public void cry() {
        System.out.println("POKEMON!");
    }
}
