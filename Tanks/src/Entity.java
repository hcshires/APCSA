   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
    
   public class Entity
   {
      private String name;
   	
      protected static final int UP = 0;		//movement directions to use as index for moveDir array
      protected static final int RIGHT = 1;
      protected static final int DOWN = 2;
      protected static final int LEFT = 3;
   
   	
      private ImageIcon[][] picture;	//array of images for the player
      								//the row value determines which way you are facing (UP, RIGHT, DOWN or LEFT)
   									//the col value is each next frame of an animation
   
      protected int x;				//our true location in pixel space on the screen
      protected int y;				//	to be used for collision detection
   
      private boolean [] moveDir;	//flags to know which direction we want to move
    
      private int animationIndex;  	//this is the index for the col in picture array (which animation frame we are on
      private int animationDelay;	//the higher the delay, the slower the animation will be
      private int numFrames;			//the total number of frames that have passed
   	
        
   	//pre: 	r and c must be valid indecies of the board in MyGridExample
   	//			image must at least be of size 1 x 1 and contain String values of image file names
   	//			ad >= 1
      public Entity(String n, int X, int Y, String[][] image, int ad)
      {
         name = n;
         
         picture = new ImageIcon[image.length][image[0].length];
         for(int i = 0; i < picture.length; i++)
            for(int j = 0; j < picture[0].length; j++)
               picture[i][j] = new ImageIcon(image[i][j]);
         animationIndex=0; 
         animationDelay=ad;
         numFrames = 0;
      
         x = X;
         y = Y;
         
         moveDir = new boolean[4];							//reset movement flags and increments					
         for(int i=0; i<moveDir.length; i++)
            moveDir[i] = false;
      }
   
      public void clearDirections()
      {
         for(int i=0; i<moveDir.length; i++)
            moveDir[i] = false;
      }
   
   //pre:  dir is 0,1,2,3 or 4
      public void setDirection(int dir)
      {
         for(int i=0; i<moveDir.length; i++)
            moveDir[i] = false;
         if(dir >= 0 && dir < moveDir.length)
            moveDir[dir] = true;
      }
      
   	//pre: dir is "up", "right", "down" or "left"
      public void setDirection(String dir)
      {
         for(int i=0; i<moveDir.length; i++)
            moveDir[i] = false;
         if(dir.equals("up"))
            moveDir[UP] = true;
         else
            if(dir.equals("right"))
               moveDir[RIGHT] = true;
            else
               if(dir.equals("down"))
                  moveDir[DOWN] = true;
               else
                  if(dir.equals("left"))
                     moveDir[LEFT] = true;
      }
   	
      public boolean isMoving()
      {
         for(int i=0; i<moveDir.length; i++)
            if(moveDir[i])
               return true;
         return false;
      }
   
      public boolean isMovingUp()
      {
         return moveDir[UP];
      }
   	
      public boolean isMovingRight()
      {
         return moveDir[RIGHT];
      }
   
      public boolean isMovingDown()
      {
         return moveDir[DOWN];
      }
   
      public boolean isMovingLeft()
      {
         return moveDir[LEFT];
      }
   
      public int getAnimationIndex()
      {
         return animationIndex;
      }
   	
      public void setAnimationIndex(int i)
      {
         animationIndex = i;
      }
      
   	//post:	advances the animation index and clips it to the number of animation frames
      public void advanceAnimation()
      {
         if(numFrames == Integer.MAX_VALUE)
            numFrames = 0;
         numFrames++;
         if(numFrames % animationDelay == 0)
            animationIndex = (animationIndex + 1) % picture[0].length;
      }
   
   	//pre:	dir is a valid row index of picture array, index is a valid col index of picture array
   	//post:	returns a specific image icon of the player
      public ImageIcon getPicture(int dir, int index)
      {
         if(dir < picture.length && index < picture[0].length)
            return picture[dir][index];
         return picture[0][0];
      }
      
   	//post:	returns an image of the player depending on which way they are facing
   	//			but doesn't advance the animation index
      public ImageIcon getPicture()
      {
         if(isMovingUp() && UP < picture.length)
            return picture[UP][animationIndex];
         if(isMovingRight()  && RIGHT < picture.length)
            return picture[RIGHT][animationIndex];
         if(isMovingDown()  && DOWN < picture.length)
            return picture[DOWN][animationIndex];
         if(isMovingLeft()  && LEFT < picture.length)
            return picture[LEFT][animationIndex];
         return picture[0][0];
      }
   
      //post:	returns an image of the player depending on which way they are facing
   	//			and advances the animation index
      public ImageIcon getPictureAndAdvance()
      {
         ImageIcon temp;
         if(isMovingUp() && UP < picture.length)
            temp =  picture[UP][animationIndex];
         else
            if(isMovingRight()  && RIGHT < picture.length)
               temp = picture[RIGHT][animationIndex];
            else
               if(isMovingDown()  && DOWN < picture.length)
                  temp = picture[DOWN][animationIndex];
               else
                  if(isMovingLeft()  && LEFT < picture.length)
                     temp = picture[LEFT][animationIndex];
                  else
                     temp = picture[0][animationIndex];
         advanceAnimation();
         return temp;
      }
   
      //post:	returns an image of the player depending on which way they are facing
   	//			and advances the animation index
      public ImageIcon getPictureAndAdvance(int index)
      {
         ImageIcon temp;
         temp = picture[index][animationIndex];
         advanceAnimation();
         return temp;
      }
   
         
      public void setName(String n)
      {
         name = n;
      }
   
      public void setX(int X)
      {
         x = X;
      }
   	
      public void setY(int Y)
      {
         y = Y;
      }
   
   	
        	
      public String getName()
      {
         return name;
      }
   	
      
      public int getX()
      {
         return x;
      }
   	
      public int getY()
      {
         return y;
      }
   
      public String toString()
      {
         return name + x + "," + y;
      }
   }