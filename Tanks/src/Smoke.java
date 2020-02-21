   import java.awt.Color;

   public class Smoke
   {
      private int x, y;					//location
      private Color color, fadeTo;	//start color, color to fade to each frame
      private int radius;				//circle size
      private boolean redDone, greenDone, blueDone, totalDone;	//to see when color is the same as fadeTo
   
      public Smoke(int dx, int dy, Color c, Color f, int r)
      {
         x = dx;
         y = dy;
         color = c;
         fadeTo = f;
         radius = r;
         redDone = false;
         greenDone = false;
         blueDone = false;
         totalDone = false;
      }
      
      public void fadeColor()
      {
         int startR = color.getRed();
         int startG = color.getGreen();
         int startB = color.getBlue();
         int endR = fadeTo.getRed();
         int endG = fadeTo.getGreen();
         int endB = fadeTo.getBlue();
         if(startR < endR)
            startR++;
         else if(startR > endR)
            startR--;
         else
            redDone = true;
         if(startG < endG)
            startG++;
         else if(startG > endG)
            startG--;
         else
            greenDone = true;
         if(startB < endB)
            startB++;
         else if(startB > endB)
            startB--;
         else
            blueDone = true;
         color = new Color(startR, startG, startB);
      	   
         if(redDone && greenDone && blueDone)
            totalDone = true;
      }
      
      public void makeBigger()
      {
         radius++;
      }
      
      public boolean colorEqualsFadeTo()
      {
         return totalDone;
      }
      
      public int getX()
      {
         return x;
      }
   
      public int getY()
      {
         return y;
      }
   
      public void setX(int dx)
      {
         x = dx;
      }
   
      public void setY(int dy)
      {
         y = dy;
      }
   
      public Color getColor()
      {
         return color;
      }
   	
      public Color getFadeToColor()
      {
         return fadeTo;
      }
   
      public void setColor(Color c)
      {
         color = c;
      }
   	
      public void setFadeToColor(Color c)
      {
         fadeTo = c;
      }
   
      public int getRadius()
      {
         return radius;
      }
   
      public void setRadius(int r)
      {
         radius = r;
      }
   }