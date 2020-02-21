   import javax.swing.*;
   import java.awt.event.*;
   public class TanksDriver								//Driver Program
   {
      public static TanksPanel screen;					//Game window
      public static JFrame frame;
      public static int width, height;
   
   
      public static void main(String[]args)
      {
         screen = new TanksPanel();
         frame = new JFrame("Java Tanks");	//window title
         height = screen.getScreenHeight() + (screen.getCellSize()*5);
         width = screen.getScreenWidth() + (screen.getCellSize()*11);
         			//battlefield size     +  menu screen size
         frame.setSize(width, height);					//Size of game window
         frame.setLocation(0, 0);						//location of game window on the screen
         frame.setExtendedState(JFrame.NORMAL);  	//MAXIMIZED_BOTH, MAXIMIZED_VERT, or ICONIFIED
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(screen);		
         frame.setVisible(true);
         frame.addKeyListener(new listen());			//Get input from the keyboard
      
      }
      
      public static class listen implements KeyListener 
      {
         public void keyTyped(KeyEvent e)
         {
         }
         
         public void keyPressed(KeyEvent e)
         {//send key input to the Panel
            if(e.getKeyCode() != KeyEvent.VK_R)		//R resets the game, and if allowed to process this while a key is pressed, resets happen too quickly
               screen.processKey(e.getKeyCode(), "keyPressed");
         }
      
         public void keyReleased(KeyEvent e)
         {
            int k=e.getKeyCode();
         
            if(k==KeyEvent.VK_PLUS || k==KeyEvent.VK_EQUALS || k==KeyEvent.VK_ADD)		//larger battlefield
            {
               if(width < (screen.getCellSize()*70) + (screen.getCellSize()*10) && height < (screen.getCellSize()*46) + (screen.getCellSize()*4))			
               {				//battlefield size       +  menu screen size
                  screen.processKey(k, "keyReleased");
                  width += screen.getCellSize()*5;
                  height += screen.getCellSize()*2;  
                  frame.setSize(width, height);				//Size of game window
                  frame.setExtendedState(JFrame.NORMAL); //MAXIMIZED_BOTH, MAXIMIZED_VERT, ICONIFIED
                  frame.repaint();
               }
            }
            else if(k==KeyEvent.VK_MINUS || k==KeyEvent.VK_SUBTRACT)							//smaller battlefield
            {
               if(width > (screen.getCellSize()*30) + (screen.getCellSize()*11) && height > (screen.getCellSize()*30) + (screen.getCellSize()*5))
               {
                  screen.processKey(k, "keyReleased");
                  width -= screen.getCellSize()*5;
                  height -= screen.getCellSize()*2;
                  frame.setSize(width, height);				//Size of game window
                  frame.setExtendedState(JFrame.NORMAL); //MAXIMIZED_BOTH, MAXIMIZED_VERT, ICONIFIED
                  frame.repaint();
               }
            }
            else
               screen.processKey(k, "keyReleased");  
         }
      }
   }
