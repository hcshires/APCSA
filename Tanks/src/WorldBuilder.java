//WorldBuilder.java handles creating the random battlefield
   import java.util.ArrayList;

    public class WorldBuilder extends TanksPanel
   {
     //pre:   c is the column in which we are filling in terrain 0 <= c < board[0].length   
    //		 colHeight is the height of terrain in that column 0<= colHeight < board.length
    //		 spireHeight is the difference that a colHeight can change from an adjacent column 0 <= spireHeight < board.length
    //		 spireWidth governs how many columns across will have the same height 1 <= spireWidth <= 4
    //post:  creates the terrain for a specific column (c)
       private static int createTerrain(int c, int colHeight, int spireHeight, int spireWidth)
      {
         int r = board.length - 1;
         for(int i=0; i<colHeight && r>=0 && r<board.length; i++)  
            board[r--][c] = true;
         if(c % spireWidth == 0)
            colHeight += (int)(Math.random()*spireHeight) - (spireHeight/2);
         if(colHeight < 1)
            colHeight = 1;
         else if (colHeight > board.length - 1)	//col height is governed by the number of rows
            colHeight = board.length - 1;
         return colHeight;
      }            
   
       //pre:   0 <= c < board[0].length
       //post:  returns the height of the terrain in column c
       private static int columnHeight(int c)
      {
         for(int r=0; r<board.length; r++)
            if(board[r][c]==true)
               return r;
         return -1;
      }
   
     //post: places the players on the map and clears out some territory for them
       private static void placePlayers()
      {
         for(int i=0; i<players.length; i++)
         {
            int startC  = (int)(Math.random()*board[0].length / 3);
            if(i==1)  
               startC = (int)(Math.random()*board[0].length / 3 - 1) + (int)((board[0].length*2)/3);
            int startR = 0;
            for(startR = 0;startR+1<board.length;startR++)
               if(board[startR+1][startC] == true)
                  break;
            if(startR <= 1)								//if tank is on the top 2 rows, clear out the first 3 rows in its column
            {
               board[startR][startC] = false;
               board[startR+1][startC] = false;
               board[startR+2][startC] = false;
               startR = 2;
            }
            if(startC-1 >= 0)
               for(int r=0; r<board.length; r++)
               {
                  if(r<=startR)
                     board[r][startC-1] = false;
                  else
                     board[r][startC-1] = true;
               
               }
            if(startC+1 < board[0].length)				//clear out some territory so there is room to shoot
               for(int r=0; r<board.length; r++)
               {
                  if(r<=startR)
                     board[r][startC+1] = false;
                  else
                     board[r][startC+1] = true;
               
               }
         
            int oldScore = 0;
            if(players[i] != null)
               oldScore = players[i].getScore();
            String name = "LEFT";
            int angle = 45;
            if(i==1)
            {
               name = "RIGHT";   
               angle = 135;
            }
            players[i] = new Player(name,  startR, startC, tankImages, ANIMATION_DELAY, angle);
            players[i].setScore(oldScore);
         }
         if(QBASICtheme)	//now that players are placed, put some space between buildings (as long as a player is not in that column)
         {
            ArrayList<Integer> skip = new ArrayList();	//store columns close to where players are so that we skip over them (and don't clear out the terrain below them)
            for(int i=0; i<players.length; i++)
            {
               skip.add(players[i].getCol());
               skip.add(players[i].getCol()-1);
               skip.add(players[i].getCol()+1);
            }
            for(int c=0; c<board[0].length-1; c++)
            {
               if(columnHeight(c) != columnHeight(c+1) && !skip.contains(c))
               {
                  for(int r=0; r<board.length; r++)
                     board[r][c] = false;
                  c++;
               }
            }
         }
      
      }
   
     //post: creates the terrain and puts the players on the board
       protected static void setUpGame()
      {
         for(int r=0;r<board.length;r++)					
            for(int c=0;c<board[0].length;c++)
               board[r][c] = false;  
         int colHeight = (int)(Math.random()*(board[0].length*0.75));     
         int spireHeight = (int)(Math.random()*10) + 2;			//this is the vertical distance that can change from one column to another
         int spireWidth = (int)(Math.random()*4) + 1;				//this is the number of columns that will have the same terrain height in a row
         if(QBASICtheme)
         {
            spireHeight = (int)(Math.random()*10) + 5;			//this is the vertical distance that can change from one column to another
            spireWidth = (int)(Math.random()*4) + 4;   
         }
         if(Math.random() < .5)   		
         {	//since a changing terrain sometimes bottoms out, let random decide whether we build from right to left or left to right to even out the possibility of who has the high-ground
            for(int c=0;c<board[0].length;c++)
               colHeight = createTerrain(c, colHeight, spireHeight, spireWidth);
         }
         else
         {
            for(int c=board[0].length-1;c>=0;c--)
               colHeight = createTerrain(c, colHeight, spireHeight, spireWidth);
         } 
         int lowestLevel = -1;
         for(int r=board.length-1; r>=0; r--)			//find lowest solid block of earth and eliminate it to lower the playing field
         {
            boolean done = false;
            for(int c=0; c<board[0].length; c++)
            {
               if(board[r][c]==false)
               {
                  done = true;
                  break;
               }
            }
            if(done)
               break;
            lowestLevel = r;
         }
         if(lowestLevel != -1)
         {
            for(int r=lowestLevel+1; r<board.length; r++)			//find lowest solid block of earth and eliminate it to lower the playing field
            {
               for(int c=0; c<board[0].length; c++)
                  board[r][c] = false;
               Ordinance.collapseDirt();
            }
         }
         placePlayers();  
      }
   
   }