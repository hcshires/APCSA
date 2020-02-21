   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.util.ArrayList;
 	
	//to do:  test - maybe fixed: declaration of a draw is inconsistent when a bomber is present
   public class TanksPanel extends JPanel
   {	
      protected static final int SIZE=20;	//size of cell being drawn (players are of size SIZE*2)
    
      private static final int DELAY=10;	//#miliseconds delay between each time screen refreshes for the timer
      protected static final int ANIMATION_DELAY = 20;		//the speed at which the animations occur for the players and explosions
    	
      protected static boolean[] activeBullet;	//array for the two players to see if they currently have a bullet in flight
      protected static boolean turnBased;			//is this mode one at a time or can both players aim and fire at the same time?
      protected static boolean howitzerMode;		//if true, power is locked at maxPower for both players
      protected static boolean turnBalance;		//if true, the player with the lowest score goes 1st if turn based
      protected static boolean terrainDestroyable;			//if true, the terrain can not be destroyed by shells
      protected static boolean collapseDirt;		//do we want to have destroyed land collapse, or defy gravity?
      protected static boolean bomberRun;			//if true, the player drops bombs on enemy from plane
      
      protected static boolean ATARItheme;		//if true, shows battle in low-res ATARI 2600 style
      protected static boolean QBASICtheme;		//if true, shows battle in low-res ATARI 2600 style
      private static boolean forceTheme;			//reset a game with a special theme (see above)
   
      protected static int round;					//records the round number
   	
      protected static ImageIcon[] ground;		//images for the ground
      protected static ImageIcon sky;				//images for the sky
      protected static int sunX, sunY, sunRad; 	//location and radius of a sun or moon
      protected static Color sunColor;				//color of a sun or moon
      protected static double windPower;			//wind for shell trajectory
      protected static boolean variableWinds;	//can the wind change while in the round?
   	
      protected static ImageIcon bomb; 			//a bomber might drop these
   	
      protected static Color skyColor;				//changes each round
      protected static Color groundColor;			//changes each round
   
      //This array will be represented graphically on the screen
      protected static boolean[][] board;		//we will fill with false (no ground), true (ground)
      private static int numRows,numColumns;	//dimensions of the battlefield
   
      protected static Player [] players;		//array of player objects
      private static int maxPower;				//the maximum power a player can charge for a shot (depends on battlefield size)
      protected static Player bomber;				//sometimes they traverse the map and change the landscape with bombs
      protected static int bomberIndex;			//index for which bomber we will see
   	
      protected static String[][] tankImages; 	//player image arrays 
      protected static String[][] planeImages;
      protected static boolean leftsTurn;		//true if it is the left player's turn - toggles after each shot			
          
      protected static ArrayList<Shell> shots;					//shells fired by players
      protected static ArrayList<Smoke> smokeTrail;			//smoke trailing behind a shell in flight
   
      
   	//explosions	
      protected static ArrayList<Explosion> explosions;	//active explosions to show on the screen
      protected static String[][] explosionImages;			//array of explosion images ([direction]x[animation frames])
      protected static String[][] puffImages;				//array of smoke puff images [direction]x[animation frames]
      protected static String[][] fireImages;				//array of fire images [direction]x[animation frames]
      protected static String[][] bananaImages;				//for QBASIC Gorillas theme projectile
      protected static ImageIcon[][] fire;					//for players that are on fire
      protected static ImageIcon[][] banana;					//for QBASIC Gorillas theme projectile
   
      protected static int numFrames;		//count the # of time frames
   
      private Timer t;							//used to set the speed of the enemy that moves around the screen
   
      public static int screenWidth;		//dimensions of the screen depending on the array size and the size of each cell (in pixels)
      public static int screenHeight;
   
      public TanksPanel()
      {
         turnBased = true;		//is this mode one at a time or can both players aim and fire at the same time?
         turnBalance = true;	//if true, the player with the lowest score goes 1st if turn based
         collapseDirt = true;	//do we want to have destroyed land collapse, or defy gravity?
         terrainDestroyable = true;
         howitzerMode = false;//power locked at maxPower
         ATARItheme = false;
         QBASICtheme = false;
         forceTheme = false;
         round = 1;
         int sizeAdd = (int)(Math.random()*8);
         numRows = 30 + (sizeAdd * 2);		//as we increase battlefield size, the number of rows increases by 2 as the columns increase by 5
         numColumns = 30 + (sizeAdd * 5);
         players = new Player[2];
         activeBullet = new boolean[2];
      	
         tankImages = new String[2][3];  
         planeImages = new String[4][1];
          //explosions
         explosionImages = new String[1][4];				//explosions only have one direction, but 4 animation frames
         puffImages = new String[1][4];					//smoke puffs only have one direction, but 4 animation frames
         fireImages = new String[1][4];					//fire has only have one direction, but 4 animation frames
         bananaImages = new String[1][4];					//projectile for QBASIC Gorillas theme
         fire = new ImageIcon[fireImages.length][fireImages[0].length];  
         banana = new ImageIcon[bananaImages.length][bananaImages[0].length];  
         ground = new ImageIcon[4];
              
         resetGame();    
         t = new Timer(DELAY, new Listener());			//the higher the value of DELAY, the slower the enemy will move
         t.start();       
      }
     
     //post:  reinitializes the battlefield and players when the round changes
      private void resetGame()
      {   
         //***WRITE THE CODE HERE to vary the maxPower in howitzer mode to adjust to the size of the battlefield.
         //the maxPower formula should make it such that the smallest battlefield (30x30) yields a maxPower of 50 
      	//and the largest (70x46) yields a maxPower of 100.
      	//the existing assignment of 50 to maxPower is temporary to keep things compiling.
         maxPower = 50;
      	//******************************************************************************************************
      	
         board = new boolean[numRows][numColumns];
      
         windPower = (Math.random()*20) - 10;
         variableWinds = false;
         if(Math.random() < .25)
            variableWinds = true;
      	
         screenWidth = board[0].length * SIZE;
         screenHeight = board.length * SIZE;
         numFrames = 0;
         int rand = (int)(Math.random()*14);
      
         ground[0] = new ImageIcon("images/terrain/ground"+rand+".GIF");	//flat image
         ground[1] = new ImageIcon("images/terrain/ground"+rand+"a.GIF");	//slope where there is no tile above it or to the left, but there is one to the right
         ground[2] = new ImageIcon("images/terrain/ground"+rand+"b.GIF");	//slope where there is no tile above it or to the right, but there is one to the left
         ground[3] = new ImageIcon("images/terrain/ground"+rand+"c.GIF");	//peak - no tile above, left or right
         
         if(ground[0].getImageLoadStatus() != MediaTracker.COMPLETE || ground[1].getImageLoadStatus() != MediaTracker.COMPLETE || ground[2].getImageLoadStatus() != MediaTracker.COMPLETE || ground[3].getImageLoadStatus() != MediaTracker.COMPLETE)
            ATARItheme = true;
         else
            ATARItheme = false;   
      
         if(forceTheme && !ATARItheme && Math.random() < .5)
         {
            ATARItheme = true;
            rand = 100;
            ground[0] = new ImageIcon("images/terrain/ground"+rand+".GIF");	//flat image
            ground[1] = new ImageIcon("images/terrain/ground"+rand+"a.GIF");	//slope where there is no tile above it or to the left, but there is one to the right
            ground[2] = new ImageIcon("images/terrain/ground"+rand+"b.GIF");	//slope where there is no tile above it or to the right, but there is one to the left
            ground[3] = new ImageIcon("images/terrain/ground"+rand+"c.GIF");	//peak - no tile above, left or right
         }
      
         if(ATARItheme)  		//allow imageIcon to fail in finding file so we use 2600-like random sky colors	
            rand = 100;
         else
            rand = (int)(Math.random()*8);
        	
      		
         if(!ATARItheme && Math.random() < .05)
            QBASICtheme = true;   
         else
            QBASICtheme = false;
            
         if(forceTheme && !ATARItheme)
            QBASICtheme = true;
      
         forceTheme = false;  
      	
         if(QBASICtheme)
         {
            sky = new ImageIcon("images/sky/gorillas.jpg");
            ground[0] = new ImageIcon("images/terrain/gorillas.GIF");	//flat image
            ground[1] = new ImageIcon("images/terrain/gorillasa.GIF");	//slope where there is no tile above it or to the left, but there is one to the right
            ground[2] = new ImageIcon("images/terrain/gorillasb.GIF");	//slope where there is no tile above it or to the right, but there is one to the left
            ground[3] = new ImageIcon("images/terrain/gorillasc.GIF");	//peak - no tile above, left or right
         }
         else
         {
            if(ATARItheme && Math.random() < .33)
               sky = new ImageIcon("images/sky/2600.jpg");
            else
               sky = new ImageIcon("images/sky/sky"+rand+".GIF");
         }
         turnBased = true;					//is this mode one at a time or can both players aim and fire at the same time?
         terrainDestroyable = true;
         howitzerMode = false;			//power locked at maxPower
         bomberRun = false;
         if(Math.random() < .33)			//33% it will be real time (both players can adjust and fire at the same time)
            turnBased = false;		
         if(Math.random() < .33 && !QBASICtheme && windPower < 3)	//33% the terrain will not be destroyable
            terrainDestroyable = false;
         if(terrainDestroyable)
         {
            if(Math.random() < .25 && !QBASICtheme)//25% with destroyable terrain, we go into howitzer mode (power at full)
               howitzerMode = true;
            if(Math.random() < .25)
               bomberRun = true;							//25% with real time, we have bombers traversing the field
         }
         bomber = null;
         int skyRed = (int)(Math.random()*256);
         int skyGreen = (int)(Math.random()*256);
         int skyBlue = (int)(Math.random()*256);
         if(sky.getImageLoadStatus() == MediaTracker.COMPLETE)			//image loaded properly
         {
            if(rand < 2)
            {//1st two skies are daytime, so make skyColor bright so we create a sun with it
               skyRed = 150;
               skyGreen = 150;
               skyBlue = 255;
            }
            else
            {//rest are night, so make skyColor dark so we create a moon with it
               skyRed = 10;
               skyGreen = 10;
               skyBlue = 50;
            }
         }  
         skyColor = new Color(skyRed, skyGreen, skyBlue);
         sunX = (int)(Math.random()*screenWidth);   
         sunY = (int)(Math.random()*screenHeight);
         double yDist = (double)sunY/screenHeight;	
         sunRad = (int)(yDist * (SIZE*5));				//make the sun bigger the lower it is to the horizon
         if(sunRad < SIZE)
            sunRad = SIZE;
         int sunRed = 255;
         int sunGreen = (int)(255 - (yDist * 180));	//make the sun more orange the lower it is to the horizon
         int sunBlue = 0;
         sunColor = new Color(sunRed, sunGreen, sunBlue);
         if((skyRed + skyGreen + skyBlue)/3 < (256/2))					//see if the sky is a dark color - make sun a moon color
            sunColor = new Color(220,220,255);
      	
         groundColor = new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
         shots = new ArrayList();
         smokeTrail = new ArrayList();
         explosions = new ArrayList();
         Display.loadImages();   
         WorldBuilder.setUpGame();
         leftsTurn = true;
         if (turnBalance)
         {
            if(players[0] != null && players[1] != null && players[1].getScore() < players[0].getScore())
               leftsTurn = !leftsTurn;
         }
         else
         {
            if(Math.random() < .5)
               leftsTurn = !leftsTurn;
         }
         if(howitzerMode && players[0] != null && players[1] != null)
         {
            players[0].setPower(maxPower);
            players[1].setPower(maxPower);
         }
         for(int i=0; i<activeBullet.length; i++)
            activeBullet[i] = false;
      }
   
   	//post:  return size of cells to the driver program for screen resizing
      public int getCellSize()
      {
         return SIZE;
      }
      
     //post:  return width of the battlefield in pixel space to the driver program for screen resizing
      public int getScreenWidth()
      {
         return screenWidth;
      }
   	
   	//post:  return height of the battlefield in pixel space to the driver program for screen resizing
      public int getScreenHeight()
      {
         return screenHeight;
      }
      
   	//THIS METHOD IS ONLY CALLED THE MOMENT A KEY IS HIT - NOT AT ANY OTHER TIME
   	//pre:   dir is a valid keyboard code and inputType is either "keyPressed" or "keyReleased"
   	//post:  changes the players position depending on the key that was pressed (sent from the driver)
   	//			keeps the player in the bounds of the size of the array board
      public void processKey(int dir, String inputType)
      {
         if((dir==KeyEvent.VK_PLUS || dir==KeyEvent.VK_EQUALS || dir==KeyEvent.VK_ADD) && inputType.equals("keyReleased"))		//larger battlefield
         {
            if(numColumns < 70 && numRows < 46)
            {
               numColumns+=5;
               numRows+=2;
               resetGame();
            }
            repaint();
            return;
         }
         else if((dir==KeyEvent.VK_MINUS || dir==KeyEvent.VK_SUBTRACT) && inputType.equals("keyReleased"))							//smaller battlefield
         {
            if(numColumns > 30 && numRows > 30)
            {
               numColumns-=5;
               numRows-=2;
               resetGame();
            }
            repaint();
            return;
         }
         if(!turnBased && inputType.equals("keyPressed"))
            return;	//so, in a real-time game, ignore keys that are held down because they would disrupt the other player from sending keyboard input
         if(turnBased && inputType.equals("keyReleased") && dir!=KeyEvent.VK_R)
            return;	//in a turn-based game, we allow pressed and held keys to quickly change angle and power (but not both keyPressed and keyReleased)
         if(players.length == 0 || players[0] == null)
            return;
         if(dir==KeyEvent.VK_ESCAPE)	//End the program	
            System.exit(1);
        
         if(dir==KeyEvent.VK_R || Display.roundOver())		
         {
            if(Display.roundOver())
               round++;
            resetGame();
            repaint();
            return;
         }
         if(dir==KeyEvent.VK_T )		
         {
            forceTheme = true;
            if(Display.roundOver())
               round++;
            resetGame();
            repaint();
            return;
         }
      
      
         if(dir==KeyEvent.VK_SPACE && !players[0].onFire()  && activeBullet[0]==false && ((turnBased && leftsTurn) || (!turnBased)))		
         {
            int shotOwner = 0;
            shots.add(new Shell("shell", players[0].findX(SIZE) + (SIZE/2), screenHeight - players[0].findY(SIZE) - (SIZE/2), shotOwner));
            int index = shots.size()-1;			//we already created the shell, so shoot the last one created
            shots.get(index).shoot(players[0].getAngle(), players[0].getPower(), windPower);
            activeBullet[0]=true;
            repaint();
            return;
         }
         if(dir==KeyEvent.VK_ENTER && !players[1].onFire()  && activeBullet[1]==false && ((turnBased && !leftsTurn) || (!turnBased)))		
         {
            int shotOwner = 1;
            shots.add(new Shell("shell", players[1].findX(SIZE) + (SIZE/2), screenHeight - players[1].findY(SIZE) - (SIZE/2), shotOwner));
            int index = shots.size()-1;			//we already created the shell, so shoot the last one created
            shots.get(index).shoot(players[1].getAngle(), players[1].getPower(), windPower);
            activeBullet[1]=true;
            repaint();
            return;
         }
      	    
         if(dir==KeyEvent.VK_S && ((turnBased && leftsTurn) || !turnBased))	//lower angle
         {
            if(players[0].getAngle()>0)
               players[0].setAngle(players[0].getAngle()-1);
            repaint();
            return;
         }
         
         if(dir==KeyEvent.VK_DOWN && ((turnBased && !leftsTurn) || !turnBased))	//lower angle
         {
            if (180 - players[1].getAngle()>0)
               players[1].setAngle(players[1].getAngle()+1);
            repaint();
            return;
         }
      	
         if(dir==KeyEvent.VK_W && ((turnBased && leftsTurn) || !turnBased))	//raise angle
         {
            if(players[0].getAngle()<180)
               players[0].setAngle(players[0].getAngle()+1);
            repaint();
            return;
         }
         
         if(dir==KeyEvent.VK_UP && ((turnBased && !leftsTurn) || !turnBased))	//raise angle
         {
            if(180 - players[1].getAngle()<180)
               players[1].setAngle(players[1].getAngle()-1); 
            repaint();
            return;
         }
           
         if(dir==KeyEvent.VK_A && ((turnBased && leftsTurn) || !turnBased) && players[0].getPower()>10)	//less power
         {
            if(howitzerMode)
               players[0].setPower(maxPower);
            else
               players[0].setPower(players[0].getPower()-1);
            repaint();
            return;
         }
         
         if(dir==KeyEvent.VK_LEFT && ((turnBased && !leftsTurn) || !turnBased) && players[1].getPower()>10)	//less power
         {
            if(howitzerMode)
               players[1].setPower(maxPower);
            else
               players[1].setPower(players[1].getPower()-1);
            repaint();
            return;
         }
      
         if(dir==KeyEvent.VK_D && ((turnBased && leftsTurn) || !turnBased) && players[0].getPower()<maxPower)//more power
         {
            if(howitzerMode)
               players[0].setPower(maxPower);
            else
               players[0].setPower(players[0].getPower()+1);
            repaint();
            return;
         }
       
         if(dir==KeyEvent.VK_RIGHT && ((turnBased && !leftsTurn) || !turnBased) && players[1].getPower()<maxPower)//more power
         {
            if(howitzerMode)
               players[1].setPower(maxPower);
            else
               players[1].setPower(players[1].getPower()+1);
            repaint();
            return;
         }
      
         players[0].clearDirections();
         players[1].clearDirections();
      
         repaint();			//refresh the screen
      }
         
      public void paintComponent(Graphics g)
      {
         super.paintComponent(g); 
         g.setColor(Color.blue);		//draw a blue boarder around the board
         g.fillRect(0, 0, board[0].length*SIZE, board.length*SIZE);
         Display.showBoard(g);					//draw the contents of the array board on the screen
      }
      
      private class Listener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)	//this is called for each timer iteration - make the enemy move randomly
         {
            numFrames++;
            if(numFrames == Integer.MAX_VALUE)			//roll over frame count and reset shot times if we get to max int value
               numFrames = 0;
            Ordinance.runBullets();
            PlayerMovement.movePlayerSmoothly(); 
            if(variableWinds)
            {
               if(numFrames % 500 == 0 && Math.random() < .5)		//allow possibility for wind to change
                  windPower += (Math.random()*4) - 2;
               if(windPower < -10)
                  windPower = -10;
               else if(windPower > 10)
                  windPower = 10;
            }
            repaint();
         }
      }
   
   }
