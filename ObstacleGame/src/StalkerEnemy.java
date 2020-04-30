import java.awt.*;

public class StalkerEnemy extends Enemy {

    private Rectangle playerRect;

    public StalkerEnemy(int x, int y, int w, int h, Rectangle p) {
        super(x, y, w, h);
        this.playerRect = p;
    }

    @Override
    public Color getColor() {
        return Color.MAGENTA;
    }

    @Override
    public void move() {
        Rectangle ourRect = getRectangle();

        if (ourRect.x < playerRect.x ) {
            ourRect.x++;
        }

        if (ourRect.y < playerRect.y ) {
            ourRect.y++;
        }

        if (ourRect.x > playerRect.x ) {
            ourRect.x--;
        }

        if (ourRect.y > playerRect.y ) {
            ourRect.y--;
        }
    }
}