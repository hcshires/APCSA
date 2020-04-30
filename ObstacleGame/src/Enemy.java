import java.awt.*;

public class Enemy {
    private Rectangle rect;
    
    public Enemy(int x, int y, int w, int h) {
        rect = new Rectangle(x, y, w, h);
    }
    
    public Color getColor() {
        return Color.BLACK;
    }
    
    public Rectangle getRectangle() {
        return rect;
    }
    
    public boolean intersects(Rectangle p) {
        return rect.intersects(p);
    }
    
    public void move() {
    }
    
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(rect.x, rect.y, rect.width, rect.height);
    }
}