
   import java.awt.*;


   public class Shell
   {
      private String type;			//shell or bomb    
      private int startX;    		//initial x position of the Shell
      private int startY;   		//initial y position of the Shell
      private int ourX;   			//for drawing: the new x position (computed in fly ( double time )
      private int ourY;   			//for drawing: the new y position (computed in fly ( double time )
      private int angle;   		//angle at which the Shell has been thrown
      private double speed;  		//speed (power) of the Shell (sqrt(speedX^2+speedY^2)) at throw time
      private double speedX;  	//x-component of the Shell's velocity at fire time
      private double speedY;  	//y-component of the Shell's velocity at fire time
      private double windPower; 	//wind speed during the flight of our Shell (needs testing)
   
      private int width;   		 //The width of this Shell (default 8)
      private int height;   		 //The height of this Shell (default 8)
   
      private static double scale;//conversion factor for pixels to meters (25 is a default tile size (SIZE))
   
      private long time;			 //time variables used to keep track of location of shell in flight
      private long newTime;
      private long oldTime;
   
      private int owner;			//the owner # that fired the shell to make sure we can't shoot ourselves  
   
      private static final double GRAVITY = 9.81;
      private static final double FRICTION = 0.3;
      private static final double MASS = 1.0;
   
      //PRE: x  & y are firing coordinates that are valid screen pixel locations
   	//		0<=x<=PWIDTH, 0<=y<=screenHeight from the main panel
      public Shell (String t, int x, int y, int o)
      {
         type = t;
         startX = x;
         startY = y;
         width = 8;
         height = 8;   
         scale = 25/2.5;
         time = 0;
         newTime = 0;
         oldTime = 0;
         owner = o;
      }
   
      //PRE: w & h are width and height of the shell (to be used for showing the shell and collision detection
   	//		1<=w<=PWIDTH, 1<=h<=screenHeight
      public Shell (String t, int x, int y, int w, int h, int o)
      {
         type = t;
         startX = x;
         startY = y; 
         width = w;
         height = h; 
         scale = 25/2.5;  
         time = 0;
         newTime = 0;
         oldTime = 0;
         owner = o;
      }
   
      //PRE:  SIZE is a unit of size sent from the main panel to affect the conversion factor for pixels to meters
      public Shell (String t, int x, int y, int w, int h, int SIZE, int o)
      {
         type = t;
         startX = x;
         startY = y; 
         width = w;
         height = h;  
         scale = SIZE/2.5; 
         time = 0;
         newTime = 0;
         oldTime = 0;
         owner = o;
      }
   
   	//PRE:  a is the angle of the shot (0<=a<360), s is the speed or power, w is the wind speed
   	//POST: calculates the starting velocity from the time of the shot on the x and y planes
      public void shoot ( int a, double s, double w)
      {
         angle = a;
         speed = s;
         windPower = w;
         //***WRITE THE CODE HERE to compute speedX and speedY (the X & Y velocity given speed and angle)
      	//the following assignment statements are temporary - they only keep things compiling
      	//don't forget to subtract the windPower from speedX
         speedX = 20;	
         speedY = 20;
      	//***********************************************************************************************/
         time = 0;
         oldTime = System.currentTimeMillis();
         newTime = oldTime;
      }
   
   	//POST:  updates the x and y coordinate of the shell
      public void fly ()
      {
         newTime = System.currentTimeMillis();
         time = time + (newTime - oldTime);
         oldTime = newTime;
         double temp = 1 - Math.exp(-(FRICTION/MASS) * (time/1000.0));
         ourX = (int)(startX + scale * (speedX*(MASS/FRICTION) * temp + windPower * (time/1000.0)));
         ourY = (int)(startY + scale * (MASS/(FRICTION*FRICTION))*( (speedY*FRICTION + (MASS * GRAVITY)) * temp - (FRICTION * GRAVITY)*(time/1000.0) ));
      }
          
      public String getType()
      {
         return type;
      }
   		 
      public int getX()
      {
         return ourX - width/2;
      }
      
   	//PRE: screenHeight is the number of vertical pixels of the screen size sent from the panel
   	//POST:since the screen is a flip of the standard coordinate quadrant, this returns the y pos as it should be seen on the screen
      public int getY(int screenHeight)
      {
         return screenHeight - ourY - height/2;
      }
   
      public int getWidth()
      {
         return width;
      }
   
      public int getHeight()
      {
         return height;
      }
   	
      public int getOwner()
      {
         return owner;
      }
        
   }
