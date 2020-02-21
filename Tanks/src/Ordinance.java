//Ordinance.java handles mechanics of shells and bombs
   import java.awt.MediaTracker;
   import java.awt.Color;

   public class Ordinance extends TanksPanel
   {
      //pre:  all arguments are valid pixel coordinates 0 <= x1, y1, x2, y2 <= screen screenWidth & screenHeight
   	//post: returns the distance between the two points to see if there is a collision between players
      private static double distance(int x1, int y1, int x2, int y2)
      {
         //***WRITE THE CODE HERE to compute the distance between the points (x1, y1) and (x2, y2)
         //this will be used for the collision detection in the methods checkWallCollision, checkPlaneCollision and checkPlayerCollision.
      	//the return statement is a temporary one to keep things compiling
         return 999;
         //************************************************************************
      }
   
    //post: when terrain is destroyed, any dirt above it will collapse down
      public static void collapseDirt()
      {
         if(collapseDirt)
         {
         //***WRITE THE CODE HERE to apply gravity to terrain that is above elements of terrain that have been destroyed
         //the 2-D array board is comprised of booleans that are false (no terrain at that location) or true (terrain at that location).
         //if there is any cell that is true, and above a cell that is false, shift all elements down to fill the empty space in that column.
         //note the swap helper method defined below - this can be a valuable helper method to complete the task.
          
          
         //*******************************************************************   
         }
      }
   
   
   //swap dirt positions between (r1,c1) and (r2,c2)
      private static void swap(int r1, int c1, int r2, int c2)
      {
         boolean temp = board[r1][c1];
         board[r1][c1] = board[r2][c2];
         board[r2][c2] = temp; 
      }
   
    //pre:  cur != null
    //post: returns true if the Shell curr collides with terrain - destroys terrain
      private static boolean checkWallCollision(Shell curr)
      {
         if(curr==null)
            return false;
         int cX = curr.getX();
         int cY = curr.getY(screenHeight);
           
         for(int r=0;r<board.length;r++)		//see if there is a wall that stops the bullet
         {
            for(int c=0;c<board[0].length;c++)
            {
               if(board[r][c] == true)
               {
                  int bX = (SIZE*c)+(SIZE/2);
                  int bY = (SIZE*r)+(SIZE/2);
                  if(distance(cX, cY, bX, bY) <= (SIZE/1.75))
                  {//destroy the wall if the bullet is powerful enough
                     if(terrainDestroyable)
                     {
                        board[r][c] = false;
                        collapseDirt();
                     }
                     return true;
                  }
                  
               }
            }
         }
         return false;
      }
   
    //pre:  cur != null
    //post: returns true if the Shell curr collides with a bomber - destroys bomber and updates score
      private static boolean checkPlaneCollision(Shell curr)
      {		
         if(curr==null || curr.getType().equals("bomb"))		//we don't want a plane to get hit by its owm bomb
            return false;
         int cX = curr.getX();
         int cY = curr.getY(screenHeight);
         if(cY > screenHeight)
            cY = screenHeight;
         if(bomber!=null)
         {
            int pX = bomber.getX();
            int pY = bomber.getY();
            double dist = distance(cX, cY, pX, pY);
            if(dist <= (SIZE*2))
            {
               players[curr.getOwner()].setScore(players[curr.getOwner()].getScore()+1);
               bomber = null;
               return true;
            }
         }
         return false;
      }
   
    //pre:  cur != null
    //post: returns true if the Shell curr collides with a player (tank) - destroyes tanks and updates score
      private static boolean checkPlayerCollision(Shell curr)
      {
         if(curr==null)
            return false;
         int cX = curr.getX();
         int cY = curr.getY(screenHeight);
         if(cY > screenHeight)
            cY = screenHeight;
         for(int i=0; i<players.length; i++)
         {
            Player target = players[i];
            Player shooter = players[(i+1)%2];
            if(curr.getOwner() == i || cX < 0)	//don't shoot ourselves
               continue;
            int pX = target.findX(SIZE);
            int pY = target.findY(SIZE);
            if(i==0)										//hitbox for LEFT tank seemed to be shifted SIZE pixels to the right - this is a correction for that
               pX += SIZE;
            double dist = distance(cX, cY, pX, pY);
            if(dist <= (SIZE) && !target.onFire())
            {
               shooter.setScore(shooter.getScore()+1);
               target.setOnFire(true);
               return true;
            }
         }
         return false;
      }
   
    //post: advances shells in flight, checks for and resolves collisions between shells and terrain as well as other players
      public static void runBullets()
      {
         for(int i=0; i<shots.size(); i++)
         {
            Shell curr = shots.get(i);
            if(numFrames%10==0 && curr.getType().equals("shell"))
            {
               if(sky.getImageLoadStatus() == MediaTracker.COMPLETE)			//image loaded properly
                  smokeTrail.add(new Smoke(curr.getX(), curr.getY(screenHeight), Color.gray, skyColor, 2));
               else
                  smokeTrail.add(new Smoke(curr.getX(), curr.getY(screenHeight), Color.yellow.darker(), skyColor, 2));
            }
            curr.fly();	//send this the time
            //bullet no longer needs to be tracked if it hits the ground (or drops below it) or goes significantly past the screen to the right or left
            boolean outOfBounds = (curr.getY(screenHeight)>=screenHeight) || curr.getX() < -SIZE*5 || curr.getX() > screenWidth + (SIZE*5);
            boolean hitWall = checkWallCollision(curr);
            boolean hitPlayer = checkPlayerCollision(curr);
            boolean hitPlane = checkPlaneCollision(curr);
            if (outOfBounds || hitWall || hitPlayer || hitPlane)	//remove shots that leave the screen at the bottom
            {
               int shotIndex = shots.get(i).getOwner();
               if(shotIndex>=0 && shotIndex < activeBullet.length)
                  activeBullet[shotIndex]=false;
               shots.remove(i);
               i--;
               String size = "SMALL";
               if(hitPlayer || hitPlane)
                  size = "BIG";
               int eX = curr.getX()-(SIZE/2); 
               int eY = curr.getY(screenHeight)-(SIZE);
               if(eX > 0 && eY > 0 && eX < screenWidth && eY < screenHeight)
               {
                  if(hitPlane)
                     explosions.add(new Explosion(size, eX, eY-SIZE, explosionImages, ANIMATION_DELAY/2));
                  else if(Math.random() < .5 || (QBASICtheme && curr.getType().equals("shell")))
                     explosions.add(new Explosion(size, eX, eY, puffImages, ANIMATION_DELAY/2));
                  else
                     explosions.add(new Explosion(size, eX, eY, explosionImages, ANIMATION_DELAY/2));
               }
               if(curr.getType().equals("shell"))
                  leftsTurn = !leftsTurn;
               continue;
            }         
         }
         for(int i=0; i<smokeTrail.size(); i++)
         {
            Smoke s = smokeTrail.get(i);
            if(s.colorEqualsFadeTo() || s.getX()+s.getRadius() > screenWidth || s.getY()+s.getRadius() > screenHeight || s.getX()-s.getRadius() < 0 || s.getY()-s.getRadius() < 0)
            {
               smokeTrail.remove(i);
               i--;
               continue;
            }
            if(numFrames%30==0)
               s.fadeColor();
            if(numFrames%20==0)
               s.makeBigger();
         }
      }
   
   }