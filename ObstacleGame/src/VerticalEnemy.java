import java.awt.*;

public class VerticalEnemy extends Enemy {

    private int screenHeight;
    private int ySpeed;

    public VerticalEnemy(int x, int y, int w, int h, int sH, int yS) {
        super(x, y, w, h);
        this.screenHeight = sH;
        this.ySpeed = yS;
    }

    @Override
    public Color getColor() {
        return Color.RED;
    }

    @Override
    public void move() {
        Rectangle rect = getRectangle();
        rect.y += ySpeed;

        if (rect.y < 0 || rect.y + rect.height > screenHeight) {
            ySpeed = -ySpeed;
        }
    }

}