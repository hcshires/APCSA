//Display.java handles images and what is shown on the screen
   import javax.swing.ImageIcon;
   import java.awt.Graphics;
   import java.awt.Color;
   import java.awt.Font;
   import java.awt.MediaTracker;

    public class Display extends TanksPanel
   {
    //post: fills image file name arrays and fills image icon arrays
       public static void loadImages()
      {
         String temp = "";
         if(ATARItheme)
            temp = "ATARI";
         if(QBASICtheme)
         {
            tankImages[0][0] = "images/players/playerRightR0.GIF";	
            tankImages[0][1] = "images/players/playerRightD0.GIF";	
            tankImages[0][2] = "images/players/playerRightR1.GIF";	
             
            tankImages[1][0] = "images/players/playerLeftL0.GIF";	
            tankImages[1][1] = "images/players/playerLeftD0.GIF";	
            tankImages[1][2] = "images/players/playerLeftL1.GIF";	
         }
         else
         {
            tankImages[0][0] = "images/players/"+temp+"player0.GIF";	 
            tankImages[0][1] = "images/players/"+temp+"player0.GIF";	 
            tankImages[0][2] = "images/players/"+temp+"player0.GIF";	 
         
            tankImages[1][0] = "images/players/"+temp+"player1.GIF";	
            tankImages[1][1] = "images/players/"+temp+"player1.GIF";	
            tankImages[1][2] = "images/players/"+temp+"player1.GIF";	
         }  
         //EXPLOSIONS and BOMBERS****************
         for(int i=0; i<4; i++)
         {
            planeImages[i][0] = "images/players/"+temp+"bomber"+i+".GIF";	 
            explosionImages[0][i] = "images/explosion/"+temp+"explosion"+i+".GIF";
            puffImages[0][i] = "images/explosion/"+temp+"puff"+i+".GIF";
            if(QBASICtheme || ATARItheme)		//we want the QBASIC and ATARI theme to share the same fire images
               fireImages[0][i] = "images/explosion/ATARIfire"+i+".GIF";
            else
               fireImages[0][i] = "images/explosion/fire"+i+".GIF";
            bananaImages[0][i] = "images/ordinance/banana"+i+".GIF";
         }
         for(int r=0; r<fire.length; r++)
         {
            for(int c=0; c<fire[0].length; c++)
            {
               if(fireImages[r][c] != null)
               {
                  fire[r][c] = new ImageIcon( fireImages[r][c]);      
               }
               if(bananaImages[r][c] != null)
               {
                  banana[r][c] = new ImageIcon( bananaImages[r][c]);      
               }
            }
         }
         bomb = new ImageIcon("images/ordinance/bomb.gif");
      }
   
    //post:  returns true if the round needs to be reset (a player has been hit)
   //			for a real time game, all shells will have had to impacted before we see if the round is over
       public static boolean roundOver()
      {
         if(turnBased)
            return (players[0].onFire() || players[1].onFire());
         return ((players[0].onFire() || players[1].onFire()) && shots.size() == 0);
      }
   
    //pre:  r & c are valid indexes of board array
     //post: returns true if there is a player within 1 spot of row r, col c
       private static boolean thereIsAPlayerHere(int r, int c)
      {
         for(Player curr:players)
         {
            if(Math.abs(curr.getRow() - r) < 2 && Math.abs(curr.getCol() - c) < 2)
               return true;
         }
         return false;
      }
   
    //post: draws the turret at the designated angle for the player
       private static void drawTurret(Graphics g, Player curr)
      {
         int width = 4;		//width of the turret
         for(int i= -width/2; i<width/2; i++)
         {
            int startX = curr.findX(SIZE) + (SIZE) + i;	//center of our player postion (and of circle)
            int startY = screenHeight - (curr.findY(SIZE));
            int endX = (int)(startX + (SIZE) * Math.cos(curr.getAngle()* Math.PI / 180));
            int endY = (int)(startY + (SIZE) * Math.sin(curr.getAngle()* Math.PI / 180));
            g.setColor(Color.green.darker().darker().darker());
            g.drawLine(startX, screenHeight - startY, endX, screenHeight - endY);
         }
      }
   
   
   	//post:  shows different pictures on the screen in grid format depending on the values stored in the array board
   	//			0-blank, 1-white, 2-black and gives priority to drawing the player
       public static void showBoard(Graphics g)	
      {
         g.setColor(Color.gray.brighter());
         g.fillRect(0, 0, screenWidth+(SIZE*10), screenHeight+(SIZE*3));
        //draw the sky
         if(sky.getImageLoadStatus() == MediaTracker.COMPLETE)			//image loaded properly
            g.drawImage(sky.getImage(), 0, 0, screenWidth, screenHeight, null);  //scaled image
         else
         {
            if(roundOver())
            {	//sky is illuminated when a player is on fire
               if(Math.random() < .5)
                  g.setColor(skyColor.brighter());
               else
                  g.setColor(skyColor);
            }
            else
               g.setColor(skyColor);		
            g.fillRect(0, 0, screenWidth, screenHeight);
         }
         //draw a sun or moon  
         if(QBASICtheme)
         {}		//QBASIC gorillas sky already has a sun in it
         else
         {	
            g.setColor(sunColor);
            if(ATARItheme)
               g.fillRect(sunX, sunY, sunRad, sunRad);
            else
               g.fillOval(sunX, sunY, sunRad, sunRad);
         }
         //now draw any smoke in the air
         if(!QBASICtheme)		//no smoke trail in QBASIC gorillas
            for(Smoke s: smokeTrail)
            {
               g.setColor(s.getColor());
               if(ATARItheme)
                  g.fillRect(s.getX(), s.getY(), s.getRadius(), s.getRadius());
               else
                  g.fillOval(s.getX(), s.getY(), s.getRadius(), s.getRadius());
            }
         int x =0, y=0;							//upper left corner location of where image will be drawn
         for(int r=0;r<board.length;r++)
         {
            x = 0;								//reset the row distance
            for(int c=0;c<board[0].length;c++)
            {
               if(board[r][c]==true)
               {
                  if(ground[0].getImageLoadStatus() == MediaTracker.COMPLETE)			//image loaded properly
                  {  //if the ground tile does not have slope images, just use the flat one (index 0)
                     if(thereIsAPlayerHere(r,c) || ground[1].getImageLoadStatus() != MediaTracker.COMPLETE || ground[2].getImageLoadStatus() != MediaTracker.COMPLETE || ground[3].getImageLoadStatus() != MediaTracker.COMPLETE)
                        g.drawImage(ground[0].getImage(), x, y, SIZE, SIZE, null);  //scaled image
                     //if there is no tile above, left or right, show peak image
                     else if(r-1>=0 && board[r-1][c]==false && c+1<board[0].length && board[r][c+1]==false && c-1>=0 && board[r][c-1]==false)
                        g.drawImage(ground[3].getImage(), x, y, SIZE, SIZE, null);  //scaled image
                        //if there is no tile above or left, but there is one to the right, show the positive slope image
                     else if(r-1>=0 && board[r-1][c]==false && c+1<board[0].length && board[r][c+1]==true && c-1>=0 && board[r][c-1]==false)
                        g.drawImage(ground[1].getImage(), x, y, SIZE, SIZE, null);  //scaled image
                        //if there is no tile above or right, but there is one to the left, show the negative slope image
                     else if(r-1>=0 && board[r-1][c]==false && c-1>=0 && board[r][c-1]==true && c+1<board[0].length && board[r][c+1]==false)
                        g.drawImage(ground[2].getImage(), x, y, SIZE, SIZE, null);  //scaled image
                     else
                        g.drawImage(ground[0].getImage(), x, y, SIZE, SIZE, null);  //scaled image
                  }
                  else														
                  {	
                     if(roundOver() && sky.getImageLoadStatus() == MediaTracker.COMPLETE)
                     {	//sky is illuminated when a player is on fire
                        if(Math.random() < .5)
                           g.setColor(groundColor.brighter());
                        else
                           g.setColor(groundColor);
                     }
                     else
                        g.setColor(groundColor);
                     g.fillRect(x, y, SIZE, SIZE);
                  }
               }
               x+=SIZE;
            }
            y+=SIZE;
         }
         for(int i=0; i<players.length; i++)
         {
            Player curr = players[i];
            drawTurret(g, curr);
            if(QBASICtheme)
            {
               int enemyIndex = (i+1)%players.length;
               if(curr.onFire())
                  g.drawImage(curr.getPictureAndAdvance(i).getImage(), curr.findX(SIZE), curr.findY(SIZE)-SIZE, SIZE*2, SIZE*2, null);  //scaled image
               else if(activeBullet[i])									//if our bullet is in flight, this frame has trhowing arm extended
                  g.drawImage(curr.getPicture(i,2).getImage(), curr.findX(SIZE), curr.findY(SIZE)-SIZE, SIZE*2, SIZE*2, null);  //scaled image
               else if(activeBullet[enemyIndex] || players[enemyIndex].onFire())	//if other player's bullet is in flight, this frame has the gorilla looking at us
                  g.drawImage(curr.getPicture(i,1).getImage(), curr.findX(SIZE), curr.findY(SIZE)-SIZE, SIZE*2, SIZE*2, null);  //scaled image
               else														//this frame has the player eyeing his target
                  g.drawImage(curr.getPicture(i,0).getImage(), curr.findX(SIZE), curr.findY(SIZE)-SIZE, SIZE*2, SIZE*2, null);  //scaled image
            }
            else
               g.drawImage(curr.getPicture(i,0).getImage(), curr.findX(SIZE), curr.findY(SIZE)-SIZE, SIZE*2, SIZE*2, null);  //scaled image
            if(curr.onFire())							//draw any fire on this player
            {
               int picSize = SIZE*2;
               int dW=0;		//variation in width
               int dH=0; 		//variation in height
               dW = (int)(Math.random()*(SIZE/2));
               dH = (int)(Math.random()*(SIZE/2));
               int rand = (int)(Math.random()*4);
               g.drawImage(fire[0][rand].getImage(), curr.findX(SIZE)+(SIZE/2), curr.findY(SIZE)-SIZE, SIZE+dW, SIZE+dH, null);  //scaled image
            }
         }
         if(bomberRun && bomber!=null)
         {
            g.drawImage(bomber.getPicture(bomberIndex,0).getImage(), bomber.getX(), bomber.getY()-SIZE, SIZE*4, SIZE*2, null);  //scaled image
         }
         for(Shell shot: shots)
         {
            g.setColor ( Color.yellow );
            if (shot.getX()>0 && shot.getX()<screenWidth && shot.getY(screenHeight)>0 && shot.getY(screenHeight)<screenHeight)
            {
               if(QBASICtheme && shot.getType().equals("shell"))
               {
                  int rand = (int)(Math.random()*4);
                  g.drawImage(banana[0][rand].getImage(), shot.getX(), shot.getY(screenHeight), SIZE, SIZE, null);  //scaled image
               }
               else
                  if(ATARItheme)
                     g.fillRect(shot.getX(), shot.getY(screenHeight), SIZE/2, SIZE/2);
                  else
                     if(shot.getType().equals("shell"))
                        g.fillOval ( shot.getX(), shot.getY(screenHeight), shot.getWidth(), shot.getHeight() );
                     else
                        g.drawImage(bomb.getImage(), shot.getX(), shot.getY(screenHeight), SIZE, SIZE, null);  //scaled image
            }
         }
         for(int i=0; i<explosions.size(); i++)								//draw any explosions on the screen
         {
            int picSize = SIZE;
            Explosion curr = explosions.get(i);
            int eX = curr.getX();
            int eY = curr.getY();
            if(eX < 0 || eY < 0 || eX > screenWidth || eY > screenHeight || curr.getAnimationIndex() >= explosionImages[0].length-1)	
            {//remove out-of-bounds or expired explosions
               explosions.remove(i);
               i--;
            }
            else
            {
               if(curr.getName().equals("BIG"))									//draw a larger explosion for aircraft
               {
                  picSize*=3;
                  g.drawImage(curr.getPictureAndAdvance().getImage(), eX, eY, picSize, picSize, null);  //scaled image
               }
               else
                  g.drawImage(curr.getPictureAndAdvance().getImage(), eX + (picSize/2), eY + (picSize/2), picSize, picSize, null);  //scaled image
            }
         }
      	//SHOW LEFT PLAYER STATS
         g.setColor(Color.gray.brighter());
         g.fillRect(screenWidth, 0, screenWidth+(SIZE*10), screenHeight+(SIZE*3));
         g.fillRect(0, screenHeight, screenWidth+(SIZE*10), screenHeight+(SIZE*3));
      
         g.setFont(new Font("Monospaced", Font.BOLD, (int)(SIZE)));
         
         if((leftsTurn || !turnBased) && !roundOver())
            g.setColor(Color.blue);
         else
            g.setColor(Color.black);
         
         if(QBASICtheme && !leftsTurn && turnBased && !roundOver())
            g.drawString("ANGLE: ?", SIZE/2, screenHeight + SIZE);	//hide values when other players go like in QBASIC gorillas
         else   
            g.drawString("ANGLE:"+players[0].getAngle(), SIZE/2, screenHeight + SIZE);
         
         if(howitzerMode)
         {
            g.setColor(Color.black);
            g.drawString("LOCK :"+players[0].getPower(), SIZE/2, screenHeight + SIZE*2);
            if((leftsTurn || !turnBased) && !roundOver())
               g.setColor(Color.blue);
         }
         else
         {
            if(QBASICtheme && !leftsTurn && turnBased && !roundOver())
               g.drawString("POWER: ?", SIZE/2, screenHeight + SIZE*2);
            else  
               g.drawString("POWER:"+players[0].getPower(), SIZE/2, screenHeight + SIZE*2);
         }
         g.drawString("SCORE:"+players[0].getScore(), SIZE/2, screenHeight + SIZE*3);
      	
      	//SHOW CENTER INFO
         g.setColor(Color.green.darker());
         if(!roundOver())
         {
            int wind = (int)Math.abs(windPower);
            String windStatus = "STEADY";
            if(variableWinds)
               windStatus = "VARIABLE";
            if(!turnBased)
               g.drawString("TURN :<<>>", screenWidth/2 - (SIZE*2), screenHeight + SIZE);
            else if(leftsTurn)
               g.drawString("TURN :<<", screenWidth/2 - (SIZE*2), screenHeight + SIZE);
            else
               g.drawString("TURN :>>", screenWidth/2 - (SIZE*2), screenHeight + SIZE);
            if(windPower > 0)   
               g.drawString("WIND :>>"+wind+" "+windStatus, screenWidth/2 - (SIZE*2), screenHeight + SIZE*2);
            else if(windPower < 0)   
               g.drawString("WIND :<<"+wind+" "+windStatus, screenWidth/2 - (SIZE*2), screenHeight + SIZE*2);
            else
               g.drawString("WIND :<>"+(int)windPower, screenWidth/2 - (SIZE*2), screenHeight + SIZE*2);
            g.drawString("ROUND:"+round, screenWidth/2 - (SIZE*2), screenHeight + SIZE*3);
         }
         else	//round is over, say who won
         {
            if(players[0].onFire() && players[1].onFire())
               g.drawString("DRAW", screenWidth/2 - 2, screenHeight + SIZE);
            else if(players[0].onFire())
               g.drawString(">> WINS", screenWidth/2 - 3, screenHeight + SIZE);
            else if(players[1].onFire())
               g.drawString("<< WINS", screenWidth/2 - 3, screenHeight + SIZE);
         }
      	
      	//SHOW RIGHT PLAYER STATS
         if((!leftsTurn || !turnBased)  && !roundOver())
            g.setColor(Color.red);
         else
            g.setColor(Color.black);
         if(QBASICtheme && leftsTurn && turnBased && !roundOver())
            g.drawString("ANGLE: ?", (screenWidth - SIZE*6), screenHeight + SIZE);
         else 
            g.drawString("ANGLE:"+(180-players[1].getAngle()), (screenWidth - SIZE*6), screenHeight + SIZE);
         if(howitzerMode)
         {
            g.setColor(Color.black);
            g.drawString("LOCK :"+players[1].getPower(), (screenWidth - SIZE*6), screenHeight + SIZE*2);
            if((!leftsTurn || !turnBased)  && !roundOver())
               g.setColor(Color.red);
         }
         else
         {
            if(QBASICtheme && leftsTurn && turnBased && !roundOver())
               g.drawString("POWER: ?", (screenWidth - SIZE*6), screenHeight + SIZE*2);
            else
               g.drawString("POWER:"+players[1].getPower(), (screenWidth - SIZE*6), screenHeight + SIZE*2);
         }
         g.drawString("SCORE:"+players[1].getScore(), (screenWidth - SIZE*6), screenHeight + SIZE*3);
      
         //SHOW GAME OPTIONS AND KEYBOARD COMMANDS TO THE RIGHT OF THE BATTLEFIELD
         x = screenWidth;
         y = 0;
         g.setColor(Color.green.darker());
         g.drawString("________________", x, y+=SIZE);
         y += SIZE;
         g.drawString("***JAVA TANKS***", x, y+=SIZE);
         g.drawString("________________", x, y+=SIZE);
         y += SIZE;
         g.setColor(Color.black);
         if(QBASICtheme)
         {
            g.setColor(Color.green.darker());
            g.drawString("THEME:    QBASIC", x, y+=SIZE);
         }
         else if(ATARItheme)
         {
            g.setColor(Color.green.darker());
            g.drawString("THEME: ATARI2600", x, y+=SIZE);
         }
         else  
            g.drawString("THEME:   REGULAR", x, y+=SIZE);
      
         g.setColor(Color.black);
         if(turnBased)
            g.drawString("MODE: TURN BASED", x, y+=SIZE);
         else 
         {
            g.setColor(Color.green.darker());
            g.drawString("MODE:  REAL TIME", x, y+=SIZE);
         }
         g.setColor(Color.black);
         if(howitzerMode)
         {
            g.setColor(Color.green.darker());
            g.drawString("ROUND:  HOWITZER", x, y+=SIZE);
         }
         else 
            g.drawString("ROUND:   REGULAR", x, y+=SIZE);
         g.setColor(Color.black);
         if(terrainDestroyable)
            g.drawString("DIRT:DESTROYABLE", x, y+=SIZE);
         else 
         {
            g.setColor(Color.green.darker());
            g.drawString("DIRT:  IMMOVABLE", x, y+=SIZE);
         }
         g.setColor(Color.black);
         if(bomberRun)
         {
            g.setColor(Color.green.darker());
            g.drawString("AIRSTRIKE:CALLED", x, y+=SIZE);
         }
         else 
            g.drawString("AIRSTRIKE:  NONE", x, y+=SIZE);
         g.setColor(Color.green.darker());
         g.drawString("________________", x, y+=SIZE);
         y += SIZE;
         g.setColor(Color.blue);
         g.drawString("***LEFT  KEYS***", x, y+=SIZE);
         g.drawString("ANGLE:       W,S", x, y+=SIZE);
         g.drawString("POWER:       A,D", x, y+=SIZE);
         g.drawString("FIRE :     SPACE", x, y+=SIZE);
         g.setColor(Color.green.darker());
         g.drawString("________________", x, y+=SIZE);
         y += SIZE;
         g.setColor(Color.red);
         g.drawString("***RIGHT KEYS***", x, y+=SIZE);
         g.drawString("ANGLE:   UP,DOWN", x, y+=SIZE);
         g.drawString("POWER:LEFT,RIGHT", x, y+=SIZE);
         g.drawString("FIRE :     ENTER", x, y+=SIZE);
         g.drawString("________________", x, y+=SIZE);
         y += SIZE;
         g.setColor(Color.black);
         g.drawString("****GENERAL ****", x, y+=SIZE);
         g.drawString("RESET:         R", x, y+=SIZE);
         g.drawString("BIGGER  FIELD: +", x, y+=SIZE);
         g.drawString("SMALLER FIELD: -", x, y+=SIZE);
         g.drawString("QUIT :       ESC", x, y+=SIZE);
         g.setColor(Color.green.darker());
         g.drawString("________________", x, y+=SIZE);
      
      }
   
   }