   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
    
   public class Player extends Entity
   {							
      private int row;			//start row for the player
      private int col;			//start col for the player
      
      private int moveIncrX;	//pixel increments for transitioning between array coordinates
      private int moveIncrY;
   
      private int tempX;		//save locations for graphic position of where the player is 
      private int tempY;		//to be used to draw the player in motion when transitioning from one cell to another
   
      private int angle;		//the angle of our turret;
      private int power;		//the speed (or power) we will apply to our shell
   	
      private int score;		//number of kills
        
      private boolean onFire;	//set to true when we are hit	  
   	  
   	//pre: 	r and c must be valid indecies of the board in MyGridExample
   	//			image must at least be of size 1 x 1 and contain String values of image file names
   	//			ad >= 1
      public Player(String n, int r, int c, String[][] image, int ad, int a)
      {
         super(n, 0, 0, image, ad);
              
         row = r;
         col = c;
         moveIncrX = 0;
         moveIncrY = 0;
         tempX = 0;
         tempY = 0;
         angle = a;
         power = 25;
         score = 0;
      }
   
      public void clearDirections()
      {
         super.clearDirections();
         moveIncrX = 0;
         moveIncrY = 0;
      }
   
   //pre:  SIZE is the pixel size of the player
   //post: returns the actual x coordinate in pixel space
      public int findX(int SIZE)
      {
         x = (SIZE*this.getCol()) + this.getMoveIncrX();
         return x;
      }
   
   //pre:  SIZE is the pixel size of the player
   //post: returns the actual y coordinate in pixel space
      public int findY(int SIZE)
      {
         y = (SIZE*this.getRow()) + this.getMoveIncrY();
         return y;
      }
   
      public boolean onFire()
      {
         return onFire;
      }
     
      public void setOnFire(boolean of)
      {
         onFire = of;
      }
   
      public int getMoveIncrX()
      {
         return moveIncrX;
      }
     
      public int getMoveIncrY()
      {
         return moveIncrY;
      }
      
      public void setMoveIncrX(int x)
      {
         moveIncrX = x;
      }
   	
      public void setMoveIncrY(int y)
      {
         moveIncrY = y;
      }
   
      public void addMoveIncrX(int x)
      {
         moveIncrX += x;
      }
   
      public void addMoveIncrY(int y)
      {
         moveIncrY += y;
      }
   
      public void setRow(int r)
      {
         row = r;
      }
   	
      public void setCol(int c)
      {
         col = c;
      }
   	
      public void setX(int X)
      {
         x = X;
      }
   	
      public void setY(int Y)
      {
         y = Y;
      }
   
   	
      public void setCoord(int r, int c)
      {
         row = r;
         col = c;
      }
   		
      public int getRow()
      {
         return row;
      }
   	
      public int getCol()
      {
         return col;
      }
   
      public int getTempX()
      {
         return tempX;
      }
   
      public int getTempY()
      {
         return tempY;
      }
   
      public void setTempX(int x)
      {
         tempX = x;
      }
   
      public void setTempY(int y)
      {
         tempY = y;
      }  
   	
      public int getAngle()
      {
         return angle;
      }
   	
      public void setAngle(int a)
      {
         angle = a;
      }
   	
      public int getPower()
      {
         return power;
      }
   	
      public void setPower(int p)
      {
         power = p;
      }
      
      public int getScore()
      {
         return score;
      }
   	
      public void setScore(int s)
      {
         score = s;
      }
   
   }