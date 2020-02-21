//PlayerMovement.java handles moving tanks (if they drop) and bombers smoothy across the screen

    public class PlayerMovement extends TanksPanel
   {
      protected static final int UP	 	= 0;		//movement directions to use as index for moveDir array
      protected static final int RIGHT = 1;
      protected static final int DOWN	= 2;
      protected static final int LEFT	= 3;  
   
      protected static final int SPEED=1;			//when player moves from one cell to the next, this is how many pixels they move in each frame (designated by the timer)
   
   //post:  if bomberRun is active, creates a bomber to traverse across the screen to drop bombs
       public static void addBomber()
      {
         if(!players[0].onFire() && !players[1].onFire() && bomberRun && bomber==null && Math.random() < .005)
         {
            //find highest peak to determine range for random bomber altitudes
            bomberIndex = (int)(Math.random()*planeImages.length);
            int highestRow = 0;
            boolean weFoundIt = false;
            for(int r=0; r<board.length; r++)
            {
               for(int c=0; c<board[0].length; c++)
               {
                  if(board[r][c] == true)
                  {
                     highestRow = r;
                     weFoundIt = true;
                     break;
                  }
               }
               if(weFoundIt)
                  break;     
            }
            if(highestRow == 0)	//no room for a plane, so we will skip bomber run this turn
            {
               bomberRun = false;
            }
            else
            {
               int startRow = (int)(Math.random()*highestRow);
               int startCol = 0;	//LEFT bomber
               int startAngle = 0;
               if(bomberIndex >= planeImages.length / 2 || (turnBased && leftsTurn))	//RIGHT bomber
               {
                  startCol = board[0].length;
                  startAngle = 270;   
               }
               bomber = new Player("BOMBER", startRow, startCol, planeImages, ANIMATION_DELAY, startAngle);
               bomber.setY(startRow*SIZE);
               bomber.setX(startCol*SIZE);
            }
         }
      
      }
   
      //post:  activates bombers if necessary, moves players smothly across the screen by updating intermediate x & y values
       public static void movePlayerSmoothly()
      {
         if(bomberRun)
         {
            addBomber();
            if(bomber!=null && numFrames%2==0)
            {
               //System.out.println(numFrames);
               if(bomberIndex < planeImages.length / 2)		//LEFT bomber moves right  
                  bomber.setX(bomber.getX() + SPEED);
               else
                  bomber.setX(bomber.getX() - SPEED);
              
               if(Math.random() < .02 && !players[0].onFire() && !players[1].onFire())
               {
                  int shotOwner = 0;								//LEFT player's bomber
                  int angle = 0;
                  boolean okToBomb = false;						//only start bombing run if we passed over our side's tank
                  if (bomberIndex >= planeImages.length / 2)//RIGHT player's bomber
                  {
                     shotOwner = 1;
                     angle = 180;
                     if(bomber.getX() < players[shotOwner].findX(SIZE))
                        okToBomb = true;   
                  }
                  else													//LEFT player's bomber
                  {
                     if(bomber.getX() > players[shotOwner].findX(SIZE))
                        okToBomb = true; 
                  }
                  if(okToBomb)
                  {
                     shots.add(new Shell("bomb", bomber.getX() + (SIZE/2), screenHeight - bomber.getY() - (SIZE/2), shotOwner));
                     int index = shots.size()-1;			//we already created the shell, so shoot the last one created
                     shots.get(index).shoot(angle, 3, windPower);
                  }
               }		
               if(bomber.getX() < -(SIZE*4) || bomber.getX() > screenWidth + (SIZE*4))
                  bomber = null;
            }
         }
         for(int i=0; i < players.length; i++)
         {
            Player curr = players[i];
            if(Math.abs(curr.getMoveIncrX()) >= SIZE || Math.abs(curr.getMoveIncrY()) >= SIZE)
            {
               if(curr.isMovingUp() && curr.getRow()>0 && board[curr.getRow()-1][curr.getCol()]==false)
                  curr.setRow(curr.getRow()-1);
               else 
                  if(curr.isMovingDown() && curr.getRow()<board.length-1 && board[curr.getRow()+1][curr.getCol()]==false)
                     curr.setRow(curr.getRow()+1);
                  else
                     if(curr.isMovingLeft() && curr.getCol()>0 && board[curr.getRow()][curr.getCol()-1]==false)
                        curr.setCol(curr.getCol()-1);
                     else 
                        if(curr.isMovingRight() && curr.getCol()<board[0].length-1 && board[curr.getRow()][curr.getCol()+1]==false)
                           curr.setCol(curr.getCol()+1);
               curr.clearDirections();            
            }
            else
            {
               if(curr.isMovingUp() && curr.getRow()>0)
                  curr.addMoveIncrY(-1*SPEED);
               else 
                  if(curr.isMovingDown() && curr.getRow()<board.length-1)
                     curr.addMoveIncrY(SPEED);
                  else
                     if(curr.isMovingLeft() && curr.getCol()>0)
                        curr.addMoveIncrX(-1*SPEED);
                     else 
                        if(curr.isMovingRight() && curr.getCol()<board[0].length-1)
                           curr.addMoveIncrX(SPEED);
            }
            if(collapseDirt)
            {
               int pR = curr.getRow();
               int pC = curr.getCol();
               if(pR+1 < board.length && board[pR+1][pC] == false)
               {
                  curr.setDirection(DOWN);
               }
            }
         
         }
      }
   
   }