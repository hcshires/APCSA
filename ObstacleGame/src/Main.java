import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Main {
      public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Obstacle Game");
        frame.setLayout(new BorderLayout());
        
        ObstacleGame game = new ObstacleGame();
        frame.add(game, BorderLayout.CENTER);
        
        game.addKeyListener(game);
        frame.addKeyListener(game);
        
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
        
        game.setUpGame();
    }
}