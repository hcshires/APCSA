import java.awt.*;

public class SpinningEnemy extends Enemy {

    private int centerX, centerY;
    private int radius;
    private double angle;

     public SpinningEnemy(int cX, int cY, int w, int h, int r) {
        super(cX + r - w/2, cY - h/2, w, h);
        
        centerX = cX;
        centerY = cY;
        radius = r;
        angle = 0;
    }

    @Override
    public Color getColor() {
        return new Color(randomColorNum(), randomColorNum(), randomColorNum());
    }

    public int randomColorNum() {
        return (int)(Math.random() * 256);
    }

    @Override
    public void move() {
    
        angle += 0.1;
        
        Rectangle rect = getRectangle();
        
        rect.x = (int)(centerX + radius*Math.cos(angle)) - rect.width/2;
        rect.y = (int)(centerY + radius*Math.sin(angle)) - rect.height/2;
    }

    @Override
    public void draw(Graphics g) {

        super.draw(g);
        
        g.setColor(Color.BLACK);
        g.fillOval(centerX-5, centerY-5, 10, 10);
    
    }


}