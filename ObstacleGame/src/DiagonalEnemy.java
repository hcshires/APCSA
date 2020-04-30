import java.awt.*;

public class DiagonalEnemy extends VerticalEnemy {

    private int xSpeed;
    private int screenWidth;

    public DiagonalEnemy(int x, int y, int w, int h, int sH, int yS, int sW, int xS) {
        super(x, y, w, h, sH, yS);
        this.xSpeed = xS;
        this.screenWidth = sW;
    }

    @Override
    public Color getColor() {
        return Color.PINK;
    }

    @Override
    public void move() {
        super.move();

        Rectangle rect = getRectangle();
        rect.x += xSpeed;

        if (rect.x < 0 || rect.x + rect.width > screenWidth) {
            xSpeed = -xSpeed;
        }
    }
}