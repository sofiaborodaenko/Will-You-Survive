/*
Borodaenko Sofia & Novikova Karyna
06.16.2023
ICS3U Final Project
Our game is called "Will you survive?" and it follows a story of a young girl surviving in the world after a dangerous virus killed society.
She finds a village and in order to get out of it, she has to gather keys from the buildings and not get hit by the viruses. She receives a map
and goes to different locations where she has different tasks to do. In school, she has to solve some math problems and gain points to then later
buy products for other survivors. In the end, she either dies because of the viruses, survives but infects other survivors or just survives and
unites with others.
*/

import java.awt.*;
import hsa_ufa.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.util.*;

class WillYouSurvive {
   // create a new console and scanner
   static Console c = new Console(800,750, "Will You Survive? - Sofia Borodaenko & Karina Novikova");
   static Scanner keyboard = new Scanner(System.in);
   // declare global variables
   // how many points did the user get at the school location
   static int points;
   // character that has to be pressed to close the method windows of four locations
   static char keyCharMGame;
   // how many keys the user got
   static int keys = 0;
 
   public static void main(String[] args) {
   
   //the button
      JButton skipBtn = new JButton("Skip");
   
   //load the virus image
      Image virusallImage;
      virusallImage = loadImage("virusall.png");
   
   //text for the intro 
      String text2 = "A deadly plague has swept across the world, pushing society to the brink of collapse.";
      String text3 = "The government’s attempt to contain the outbreak has failed, leaving chaos in their wake.";
      String text4 = "As one of the few remaining uninfected survivors, you come across a village...";
    
   //text for the end screen
      String endText = "YOU LOST";
      String endText2 = "You collided with the viruses three times...";
      String endText3 = "You got infected and died a slow death...";
    
   //text for the end screen with no collision
      String endNoCollisionText = "YOU WON";
      String endNoCollisionText2 = "You succesfully got to the safe house without colliding with the viruses.";
      String endNoCollisionText3 = "In the safe house you encounter the other survivors.";
      String endNoCollisionText4 = "The items you bought managed to help a lot of them. ";
      String endNoCollisionText5 = "Good job.";
   
   //text for the end screen with one or two collisions 
      String endCollisionText = "Throughout your journey you collided with the viruses catching the disease...";
      String endCollisionText2 = "After you enter the safe house you encounter other survivors, among them is a doctor...";
    
      String endCollisionFalse = "The symptoms were very severe and the doctor couldn't save you...";
      String endCollisionFalse2 = "You contaminated the items and those items spread the disease to the rest...";
      String endCollisionFalse3 = "You killed the survivors in the safe house and died a slow death...";
     
   
   // keys pressed, shapes & count for viruses
      char keyChar = '0';
      int virusCount = 0;
    
   // character's position, width and height, center, angle
      int x = 70;
      int y = 630;
      int dx = 0;
      int dy = 0;
      int width = 90;
      int height = 90;
      int charXc = x + width/2;
      int charYc = y + height/2;
      int charangle = 0;
      int chardir = 0;
   // images of the main character
      Image characterRightImage;
      characterRightImage = loadImage("girlfinalright.png");
      Image characterLeftImage;
      characterLeftImage = loadImage("girlfinal.png");
    
   // 3 viruses upload picture
      Image virus1Image;
      virus1Image = loadImage("virusone.png");
      Image virus2Image;
      virus2Image = loadImage("virusone.png");
      Image virus3Image;
      virus3Image = loadImage("virusone.png");
    
   //uploads the map image 
      Image map;
      map = loadImage("MAP.png");
   
   //calculates the area of the drawn objects
      Rectangle2D.Double character = new Rectangle2D.Double(0, 0,100, 100);
      Ellipse2D.Double virus1 = new Ellipse2D.Double(0, 0, 100, 100);
      Ellipse2D.Double virus2 = new Ellipse2D.Double(0, 0, 100, 100);
      Ellipse2D.Double virus3 = new Ellipse2D.Double(0, 0, 100, 100);
              
   // 1st virus position, movement, width and height
      int virus1X = 0;
      int virus1Y = 230;
      int dxVirus1 = 5;
      int virus1Width = 50;
      int virus1Height = 50;
      
   // 2nd virus position, movement, width and height
      int virus2X =500;
      int virus2Y = 690;
      int dyVirus2 = -5;
      int virus2Width = 50;
      int virus2Height = 50;
      
   // 3rd virus position, movement, width and height
      int virus3X =750;
      int virus3Y = 450;
      int dxVirus3 = 5;
      int virus3Width = 50;
      int virus3Height = 50;
   
   //runs the loops
      boolean gamePlaying = true;
      boolean menuScreen = true;
      boolean backStory = true;
      boolean officialGame = false;
      boolean hasCollided = false;
     
    
    
   //main loop for the entire game
      while(gamePlaying == true){
       
      
      
      //shows the menu screen until 1 is pressed
         while(menuScreen == true){
         
            keyChar = c.getKeyChar();
            synchronized(c){
            // a method that draws a start screen
               startScreen(virusallImage);
              // if the player presses "2", the rules are shown
               if (keyChar == '2'){
                  rulesScreen(virusallImage);
               }
               // if the player presses "3", the information about the game is shown
               if (keyChar == '3'){
                  aboutScreen(virusallImage);
               }
               // if the player presses "1", the loop ends and the main game starts
               if(keyChar == '1'){
                  c.clear();
                  menuScreen = false;
               }
               // if the player presses "0", the loops end and jumps right to the thank you screen
               if(keyChar == '0') {
                  menuScreen = false;
                  backStory = false;
                  officialGame = false;
                  keys = -5;
               }
               
            }
            // delay statement for the animation
            delay(15);
             
         }
        
       
        // backstory loop
         while (backStory == true){
          // clear backgrounf to make it black
            c.setBackgroundColor(Color.black);
            c.clear();
         
         //draws the text for the intro screen 
            c.setColor(Color.white);
            skipBtn.setVisible(true);
            printTxt(text2, skipBtn);
            printTxt(text3, skipBtn);
            skipBtn.setVisible(false);
            printTxt(text4, skipBtn);
            // delay statement for the text
            delay(2000);
           // initialize the officialGame variable
            officialGame = true;
            // make a BackStory variable be false so that it exists the loop
            backStory = false;
         }
       
      //the main game graphics loop 
         while (officialGame == true) {
         
           // the character of the key currently held down
            keyChar = c.getKeyChar ();
         
            synchronized(c){
            
            //draws the main picture for the game
               mainSettingOfGame();
            
            // draws the character if there is no collision between it and viruses
               if (hasCollided == false )
               {
                  // checks the direction the character is moving to draw the correct picture (left or right)
                  if (chardir == 0)
                  {
                     // updates the variables of where the character is and it's size at the moment
                     character.x = x;
                     character.y = y;
                     character.width = width;
                     character.height = height;
                     // draws the character
                     c.drawImage(characterRightImage, x, y, width, height, charangle);
                  }
                  // checks if the direction of the character is to the left
                  else if (chardir == 1)
                  {
                     // updates the variables of where the character is and it's sixe at the moment
                     character.x = x;
                     character.y = y;
                     character.width = width;
                     character.height = height;
                     // draws the character
                     c.drawImage(characterLeftImage, x, y, width, height, charangle);
                  }
               }
               // if there is a collision between the character and viruses, nothing is drawn for one moment
               // this is done to make a character flick and show the user that there was a collision with a virus
               else if (hasCollided == true)
               {
                  // changes the variable back to false to draw it next time
                  hasCollided = false;
               }
              // initializes the virus figures to coordinates and sizes of the first virus
               virus1.x = virus1X;
               virus1.y = virus1Y;
               virus1.width = virus1Width;
               virus1.height = virus1Height;
               // draws the first virus figure
               c.drawImage(virus1Image, virus1X, virus1Y, virus1Width, virus1Height);
               // initializes the virus figures to coordinates and sizes of the second virus
               virus2.x = virus2X;
               virus2.y = virus2Y;
               virus2.width = virus2Width;
               virus2.height = virus2Height;
               // draws the second virus figure
               c.drawImage(virus2Image, virus2X, virus2Y, virus2Width, virus2Height);
               // initializes the virus figures to coordinates and sizes of the third virus
               virus3.x = virus3X;
               virus3.y = virus3Y;
               virus3.width = virus3Width;
               virus3.height = virus3Height;
               // draws the third virus figure
               c.drawImage(virus3Image, virus3X, virus3Y, virus3Width, virus3Height);
             
             //draws the map if the key m is held down
               if (keyChar == 'm') {
                  c.drawImage(map, 145, 130, 500, 500);
                
                  //draws which buiding you need to go to
                  if (keys == 0){ //direction to school
                     c.setColor(Color.red);
                     c.fillStar(545, 485, 25,25);
                  } else if (keys == 1){//direction to shop
                     c.setColor(Color.red);
                     c.fillStar(195, 210, 25, 25);
                  } else if (keys == 2) {//direction to post office
                     c.setColor(Color.red);
                     c.fillStar(320, 520, 25, 25);
                  } else if (keys == 3){//direction to safe house
                     c.setColor(Color.red);
                     c.fillStar(545, 240, 25,25);
                  }
               }
            
            }
           // delay statement for drawing the viruses and the character
            delay (15);      
         
         // go right
            if (keyChar == 'd')
            {
               dx = 6;
               dy = 0;
               charangle = 0;
               chardir = 0;
            }
            
            // go left
            else if (keyChar == 'a' )
            {
               dx = -6;
               dy = 0;
               charangle = 0;
               chardir = 1;
            }
            
            // go down
            else if (keyChar == 's' )
            {
               dy = 6;
               dx = 0;
               charangle = 90;
               chardir = 0;
            }
            
            // go up
            else if (keyChar == 'w')
            {
               dy = -6;
               dx = 0;
               charangle = 270;
               chardir = 0;
            }
            
            // go up and right
            else if (keyChar == 'e')
            {
               dx = 3;
               dy = -3;
               charangle = 315;
               chardir = 0;
            }
            
            // go up and left
            else if (keyChar == 'q' )
            {
               dx = -3;
               dy = -3;
               charangle = 45;
               chardir = 1;
            }
            
            // go down and left
            else if (keyChar == 'z' )
            {
               dy = 3;
               dx = -3;
               charangle = 315;
               chardir = 1;
            }
            
             // go down and right
            else if (keyChar == 'c')
            {
               dy = 3;
               dx = 3;
               charangle = 45;
               chardir = 0;
            }
            
             // stop
            else if (keyChar == 0)
            {
               dy = 0;
               dx = 0;
            }
         
         // check for the collision with borders
         // check top border line
            if (distanceLinePoint(-90, 0, 890, 0, charXc, charYc) < (width/2))
            {
               dy = 0;
               dx = 0;
               y=y+1;
            }
         
         // check bottom border line
            if (distanceLinePoint(-90, 750, 890, 750, charXc, charYc) < (width/2))
            {
               dy = 0;
               dx = 0;
               y = y - 1;
            }
         
         // check left border line
            if (x < 0)
            {
               dy = 0;
               dx = 0;
               x=x+1;
            }
            
            // check right border line
            else if (x > 710)
            {
               dy = 0;
               dx = 0;
               x=x-1;
            }
         
         //check collision with buildings
         //final destination
         // horizontal wall
            if (distanceLinePoint(c.getWidth()-150, 160 ,800, 160, charXc, charYc) < (width/2)){ 
               dy = 0;
               dx = 0;
              // checks the angles of the collisions and determines the direction the characters jumps back
               if (keys == 3) {
                  officialGame = false;
               } else if (charangle == 270)
               {
                  y = y + 1;
               }
               else if (charangle == 315)
               {
                  y = y + 1;
                  x = x - 1;
               }
               else if (charangle == 45)
               {
                  y = y + 1;
                  x = x +1;
               }
            }
           // vertical wall
            if (distanceLinePoint(c.getWidth()-150, 0, c.getWidth()-150, 160, charXc, charYc) < (width/2))
            {
               dy = 0;
               dx = 0;
               // checks the angles of the collisions and determines the direction the characters jumps back
               if (charangle == 0)
               {
                  x = x - 1;
               }
               else if (charangle == 315)
               {
                  y = y + 1;
                  x = x - 1;
               }
               else if (charangle == 45)
               {
                  y = y - 1;
                  x = x - 1;
               }
            }
            // checks the corner for the character not to be stuck in it
            if (distanceLinePoint(c.getWidth()-150, 160,c.getWidth()-150, 160, charXc, charYc) < (width/2))
            {
               dy = 0;
               dx = 0;
               x = x - 1;
               y = y +1;
            }
         
             
         // school
         // horizontal wall
            if (distanceLinePoint(c.getWidth()-210, c.getHeight()-180 , 800, c.getHeight()-180, charXc, charYc) < (width/2)){ 
               dy = 0;
               dx = 0;
               // if there is no keys earned yet and school id the first location the character goes to, the method is called and the school task starts
               if (keys == 0) {
                  schoolGraphic();
               }
               // if there are keys earned and the character already visitied this location, it becomes just a collision determination
               else {
                  // checks the angles of the collisions and determines the direction the characters jumps back
                  if (charangle == 90)
                  {
                     y = y - 1;
                  }
                  else if (charangle == 315)
                  {
                     y = y - 1;
                     x = x + 1;
                  }
                  else if (charangle == 45)
                  {
                     y = y - 1;
                     x = x - 1;
                  }
               
               }
            }
            // vertical wall
            if (distanceLinePoint(c.getWidth()-210, c.getHeight()-180, c.getWidth()-210, 750, charXc, charYc) < (width/2))
            {
               dy = 0;
               dx = 0;
               // checks the angles of the collisions and determines the direction the characters jumps back
               if (charangle == 0)
               {
                  x = x - 1;
               }
               else if (charangle == 45)
               {
                  y = y - 1;
                  x = x - 1;
               }
               else if (charangle == 315)
               {
                  y = y + 1;
                  x = x - 1;
               }
            }
            // checks the corner for the character not to be stuck in it
            if (distanceLinePoint(c.getWidth()-210, c.getHeight()-180, c.getWidth()-210, c.getHeight()-180, charXc, charYc) < (width/2))
            {
               dy = 0;
               dx = 0;
               x = x - 1;
               y = y - 1;
            }
         
         
         // postal office
         // vertical wall
            if (distanceLinePoint(c.getWidth()/2-130, c.getHeight()-145,c.getWidth()/2-130, 750, charXc, charYc) < (width/2)){ 
               dy = 0;
               dx = 0;
               // checks the angles of the collisions and determines the direction the characters jumps back
               if (charangle == 0)
               {
                  x = x - 1;
               }
               else if (charangle == 315)
               {
                  y = y + 1;
                  x = x - 1;
               }
               else if (charangle == 45)
               {
                  y = y - 1;
                  x = x - 1;
               }
            }
            // horizontal wall
            if (distanceLinePoint(c.getWidth()/2-130, c.getHeight()-145, c.getWidth()/2-10, c.getHeight()-145, charXc, charYc) < (width/2))
            {
               dy = 0;
               dx = 0;
            
               // if the character has two keys and already visited the school and the store, the method is called and the last location opens
               if (keys == 2) {
                  postGraphic();
               }
               // in every other case, just check for the collisions with borders
               else {
                // checks the angles of the collisions and determines the direction the characters jumps back
                  if (charangle == 90)
                  {
                     y = y-1;
                  }
                  else if (charangle == 45)
                  {
                     y = y - 1;
                     x = x - 1;
                  }
                  else if (charangle == 315)
                  {
                     y = y - 1;
                     x = x + 1;
                  }
               
               }
            }
            // vertical wall
            if (distanceLinePoint(c.getWidth()/2-10, c.getHeight()-145, c.getWidth()/2-10, 750, charXc, charYc) < (width/2))
            {
               dy = 0;
               dx = 0;
               // checks the angles of the collisions and determines the direction the characters jumps back
               if (charangle == 0)
               {
                  x = x + 1;
               }
               else if (charangle == 45)
               {
                  y = y + 1;
                  x = x + 1;
               }
               else if (charangle == 315)
               {
                  y = y - 1;
                  x = x + 1;
               }
            }
            // checks the corner for the character not to be stuck in it
            if (distanceLinePoint(c.getWidth()/2-10, c.getHeight()-145, c.getWidth()/2-10, c.getHeight()-145, charXc, charYc) < (width/2))
            {
               dy = 0;
               dx = 0;
               x = x + 1;
               y = y - 1;
            }
            // checks another corner for the character not to be stuck in it
            if (distanceLinePoint(c.getWidth()/2-130, c.getHeight()-145, c.getWidth()/2-130, c.getHeight()-145, charXc, charYc) < (width/2))
            {
               dy = 0;
               dx = 0;
               x = x - 1;
               y = y - 1;
            }
         
                    
         //store
         // horizontal wall
            if (distanceLinePoint(0, 110, 220, 110, charXc, charYc) < (width/2))
            {
               dy = 0;
               dx = 0;
               // if the chartacter already has 1 key and visited the school, the method is called and the store location opens
               if (keys == 1) {
                  shopGraphic();
               }
               // if no, only collisions with the borders are checked
               else {
               // checks the angles of the collisions and determines the direction the characters jumps back
                  if (charangle == 270)
                  {
                     y = y + 1;
                  }
                  else if (charangle == 45)
                  {
                     y = y + 1;
                     x = x + 1;
                  }
                  else if (charangle == 315)
                  {
                     y = y + 1;
                     x = x - 1;
                  }
               
               }
            }
            // vertical wall
            if (distanceLinePoint(220, 0, 220, 110, charXc, charYc) < (width/2))
            {
               dy = 0;
               dx = 0;
               // checks the angles of the collisions and determines the direction the characters jumps back
               if (charangle == 0)
               {
                  x = x + 1;
               }
               else if (charangle == 45)
               {
                  y = y + 1;
                  x = x + 1;
               }
               else if (charangle == 315)
               {
                  y = y - 1;
                  x = x + 1;
               }
            }
            // checks another corner for the character not to be stuck in it
            if (distanceLinePoint(220, 110,220, 110, charXc, charYc) < (width/2))
            {
               dy = 0;
               dx = 0;
               x = x + 1;
               y = y + 1;
            }
         
          //check collision with viruses
          // the first virus
            if (hasCollided (character, virus1)){
            // increment virus count variable by one
               virusCount++;
               // make hasCollided variable true so that the character will flick for a moment
               hasCollided = true;
               // infinite loop for determining the coordinates where the virus will reappear
               while (true)
               {
                  // pick a random x coordinate
                  int randNum = (int)(800 * Math.random() + 1);
                  // check if it is further than 50 from the character
                  if (((randNum < (x - 50)))||((randNum > (x + width + 50))))
                  {
                     // if it is, add the coordinates and break the loop
                     virus1X = randNum;
                     break;
                  }
               }
               // y coordinate stays the same
               virus1Y = 230;
            }
            // the second virus
            if (hasCollided (character, virus2)){
            // increment virus count variable by one
               virusCount++;
               // make hasCollided variable true so that the character will flick for a moment
               hasCollided = true;
               // x coordinate stays the same
               virus2X = 500;
               // infinite loop for determining the coordinates where the virus will reappear
               while (true)
               {  
                  // pick a random x coordinate
                  int randNum = (int)(750 * Math.random() + 1);
                  // check if it is further than 50 from the character
                  if (((randNum < (y-50)))||((randNum > (y+height+50))))
                  {
                     // if it is, add the coordinates and break the loop
                     virus2Y = randNum;
                     break;
                  }
               }
            }
            // the third virus
            if (hasCollided (character, virus3)){
            // increment virus count variable by one
               virusCount++;
               // make hasCollided variable true so that the character will flick for a moment
               hasCollided = true;
               // infinite loop for determining the coordinates where the virus will reappear
               while (true)
               {
                  // pick a random x coordinate
                  int randNum = (int)(800 * Math.random() + 1);
                  // check if it is further than 50 from the character
                  if (((randNum < (x-50)))||((randNum > (x+width+50))))
                  {
                     // if it is, add the coordinates and break the loop
                     virus3X = randNum;
                     break;
                  }
               }
               // y coordinate stays the same
               virus3Y = 450;
            }
          
            //leaves the game loop
            if (virusCount == 3) {
             
               officialGame = false;
            }
         
         // checks if viruses need to reverse (in case they reached the border)
            if (virus1X + virus1Width > c.getDrawWidth()){
               dxVirus1 = -5;
            }
            else if(virus1X < 0){
               dxVirus1 = 5;
            }
         
            if (virus2Y + virus2Height > c.getDrawHeight()){
               dyVirus2 = -5;
            }
            else if(virus2Y < 0){
               dyVirus2 = 5;
            }
         
            if (virus3X + virus3Width > c.getDrawWidth()){
               dxVirus3 = -5;
            }
            else if(virus3X < 0){
               dxVirus3 = 5;
            }
            // updates the coordinates of the character
            x = x + dx;
            y = y + dy;
            // updates the center coordinates of the character
            charXc = x + width/2;
            charYc = y + height/2;
            // updates the virus coordinates
            virus2Y = virus2Y + dyVirus2;
            virus1X = virus1X + dxVirus1;
            virus3X = virus3X + dxVirus3;             
         }
         // clears everything
         c.setBackgroundColor(Color.black);
         c.clear();
         c.setColor(Color.white);
        
         //exits the game if the person clicked 0
         if (keys == -5) {
            break;
         }
       
         //draws the winning end screen
         if (virusCount == 0) {
            printTxt(endNoCollisionText, skipBtn);
            printTxt(endNoCollisionText2, skipBtn);
            printTxt(endNoCollisionText3, skipBtn);
            printTxt(endNoCollisionText4, skipBtn);
            printTxt(endNoCollisionText5, skipBtn);
            delay(2000);
            gamePlaying = false;
         }
       
         //draws the losing end screen
         if (virusCount == 1 || virusCount == 2) {
         
            printTxt(endText, skipBtn);
            printTxt(endCollisionText, skipBtn);
            printTxt(endCollisionText2, skipBtn);
            printTxt(endCollisionFalse, skipBtn);
            printTxt(endCollisionFalse2, skipBtn);
            printTxt(endCollisionFalse3, skipBtn);
          
            delay(2000);
            gamePlaying = false;
         }
       
         //draws the second losing end screen with an option to retry
         if (virusCount == 3) {
            printTxt(endText, skipBtn);
            printTxt(endText2, skipBtn);
            printTxt(endText3, skipBtn);
          
            delay(2000);
         
          //asks the user if they want to retry 
            while (true) {
               keyChar = c.getKeyChar();
               Font f2 = new Font("Comic Sans", Font.BOLD, 24);
               c.setFont(f2);
               String retry = "Would you like to try again? \"y\" - yes | \"n\" - no";
               synchronized (c) {
                  c.clear();
                  c.drawString(retry, 100, 650);
               }
             
               delay(15);
            
            //if yes then reset the whole game
               if (keyChar == 'y'){
               
               //resets all the variables
                  keyChar='0';
                
                  virus1X = 0;
                  virus1Y = 230;
                  dxVirus1 = 5;
                  virus1Width = 50;
                  virus1Height = 50;
               
                  virus2X =500;
                  virus2Y = 690;
                  dyVirus2 = -5;
                  virus2Width = 50;
                  virus2Height = 50;
               
                  virus3X =750;
                  virus3Y = 450;
                  dxVirus3 = 5;
                  virus3Width = 50;
                  virus3Height = 50;
               
                  x = 70;
                  y = 630;
                  dx = 0;
                  dy = 0;
                  width = 90;
                  height = 90;
                  charXc = x + width/2;
                  charYc = y + height/2;
                  charangle = 0;
                  chardir = 0;
                  points = 0;
                  keys = 0;
                  virusCount = 0;
               
               //resets the loops 
                  menuScreen = true;
                  backStory = true;
                  officialGame = false;
                  break;
               
               } else if (keyChar == 'n') { //if not then exit the loop
               
                  gamePlaying = false;
                  break;
               }
              
              
            }
         }
      }
    
      //thank you message
      c.setBackgroundColor(Color.black);
      c.clear();
    
      Font f2 = new Font("Comic Sans", Font.BOLD, 24);
      c.setFont(f2);
      c.drawString("Thank You for Playing", c.getWidth()/2-150, c.getHeight()/2);
      delay(3000);
      c.close();
   }
 
   /* The post office main graphics
   *  Takes the input from jGRASP and draws it on the main console
   *  Draws the main scene.
   */
   public static void postGraphic(){
   //fonts
      Font f1 = new Font("Secular One", Font.BOLD, 25);
      Font f2 = new Font("Comic Sans", Font.BOLD, 12);
      Font f3 = new Font("Comic Sans", Font.BOLD, 10);
      Font f4 = new Font("Comic Sans", Font.BOLD, 14);
   
   //imports images
      Image postOffice;
      Image paper;
      Image signature;
    
      postOffice = loadImage("postOffice.png");
      paper = loadImage("paper.jpeg");
      signature = loadImage("signature.png");
    
   //the strings
      String title = "The Post Office";
      String directions = "Type your answers into the jGRASP console.";
      String intro = "Welcome to the post office. You grab a small piece of paper and a pencil to write a message to the future survivours about your experience.";
      String finalMessage = "You succesfully written a message.";
      String keysMsg = "You collected the 3rd and final key. You can now enter the safe house.";
   
   //the y coordinates to make the picture move
      int x = 10;
      int stop = -800;
      int paperY = -620;
      int titleY = -740;
      int directionY = -650;
      int introY = -670;
      int finalMsgY = c.getHeight()-80;
      int keyMsgY = c.getHeight()-50;
   
   //loop runs until the picture is put into place
      while (stop != 0) {
         synchronized (c) {
         //prints the images
            c.drawImage(postOffice, 0, stop, c.getWidth(), c.getHeight());
            c.drawImage(paper, c.getWidth()/3-50, paperY, 400, 480);
         
            c.setColor(Color.black);
            c.fillRect(c.getWidth()/2 - 113, stop, 250, 100);
         
         //prints the strings
            c.setFont(f1);
            c.setColor(Color.white);
            c.drawString(title, c.getWidth()/2 - 87, titleY);
         
            c.setFont(f2);
            c.drawString(directions, c.getWidth()/2 - 125, directionY);
         
            c.setFont(f3);
            c.drawString(intro, 35, introY);
         
         }
       
         delay(15);
      
      //changes the y coordinates to put the picture in place
         stop += x;
         paperY += x;
         titleY += x;
         directionY += x;
         introY += x;
      
      
      }
    
   //keeps the input from the method
      String[] writing = postalOfficeCode();
   
   //prints the users input
      c.setFont(f4);
      c.setColor(Color.black);
      c.drawString(writing[0], c.getWidth()/3-35, 250);
      c.drawString(writing[1], c.getWidth()/3-35, 280);
      c.drawString(writing[2], c.getWidth()/3-35, 530);
   
   //the signature 
      c.drawImage(signature, c.getWidth()/3-25, 550, 70, 50);
   
   //the final message of this section 
      c.setFont(f2);
      c.setColor(Color.white);
    
      c.drawString(finalMessage, 50, finalMsgY);
      c.drawString(keysMsg, 50, keyMsgY);
    
      keys = 3;
      c.drawString("Click \"n\" to continue", 650, keyMsgY);
    
    
   //runs the loop until the letter n is clicked
      while (true) {
         keyCharMGame = c.getKeyChar();
      
      
       //if clicked remove the picture off the screen
         if (keyCharMGame == 'n') {
         
         
         //moves the picture out of the screen
            while(stop != -800) {
            
               synchronized (c) {
                  mainSettingOfGame();
                
               //prints the images
                  c.drawImage(postOffice, 0, stop, c.getWidth(), c.getHeight());
                  c.drawImage(paper, c.getWidth()/3-50, paperY, 400, 480);
               
                  c.setColor(Color.black);
                  c.fillRect(c.getWidth()/2 - 113, stop, 250, 100);
               
               //prints the strings
                  c.setFont(f1);
                  c.setColor(Color.white);
                  c.drawString(title, c.getWidth()/2 - 87, titleY);
               
                  c.setFont(f2);
                  c.drawString(directions, c.getWidth()/2 - 125, directionY);
               
                  c.setFont(f3);
                  c.drawString(intro,35, introY);
               
                  c.drawString(finalMessage, 50, finalMsgY);
                  c.drawString(keysMsg, 50, keyMsgY);
               }
            
               delay(15);
            
               stop -= x;
               paperY -= x;
               titleY -= x;
               directionY -= x;
               introY -= x;
               finalMsgY -= x;
               keyMsgY  -=x;
             
            }
          
         //exits the loop
            break;
         }
      
      }
    
   }
 
 
   /* Asks the user to write their input for the post office section
   *  After sends the input into the post office main graphics method
   *
   */
   public static String[] postalOfficeCode() {
      Scanner keyboard = new Scanner(System.in);
      String input;
    
   //outputs the directions
      System.out.println ("Your message should be at least 1 and no more than 100 characters.");
      System.out.println ("You also have to sign it in the end in the format: \"by Last name First name, Date\" (without the quotation marks)");
      System.out.println("The date has to be written as: DD.MM.YYYY");
    
   //example of how it should be formated
      System.out.println();
      System.out.println ("Example of this can be:");
      System.out.println ("Don't touch the viruses and know Math by Brown Tiffanie, 12.12.2012");
    
   //runs the loop to keep asking for input
      while (true)
      {
      //expretion
         String exp = ".{1,100} by [A-Z][a-z]+ [A-Z][a-z]+, ((0[1-9])|([1-2][0-9])|(3[0-1]))\\.((0[1-9])|(1[0-2]))\\.[0-9]{4}";
      
      //asks for input and stores it
         System.out.println();
         System.out.println ("Enter your message:");
         input = keyboard.nextLine();
      
      //if incorrect keep asking 
         System.out.println();
         while (!input.matches(exp))
         {
            System.out.println("Incorrect format. Try again.");
            System.out.println ("Enter your string:");
            input = keyboard.nextLine();
         }
       
      //once succesfully completed exit the loop
         System.out.println();
         System.out.println("You completed the necessary task. Please return to the game console.");
         break;
      }
    
   //breaks the string when it reaches a certain length to start from the other end
      String out = "";
      String date = input.substring(input.length()-11);
      input = input.substring(0, input.length()-11);
      Scanner lineScan = new Scanner(input);
      String output = "";
      String output2 = "";
    
   //scans the inputed text
      while(lineScan.hasNext()){
         if (output.length() < 40)
         {
            output = output + " " + lineScan.next();
         }
         else
         {
            output2 = output2 + " " + lineScan.next();
         }
      }
    
   //stores the broken up input
      String[] writing = {output, output2, date};
   
   //returns it back to the other method 
      return writing;     
   }
 
   /*The shop main graphics method
   * Takes the input from the jGRASP console and draws it on the main console
   *
   */
   public static void shopGraphic(){
   //the colours
      Color brown = new Color(31, 16, 3);
      Color green = new Color(33, 166, 3);
    
   //imports the images  
      Image shelvesImage;
      Image apple;
      Image waterBottle;
      Image meat;
      Image healthKit;
      Image sign;
       
      shelvesImage = loadImage("shelvesNEW.png");
      apple = loadImage("apple.png");
      waterBottle = loadImage("water bottle.png");
      meat = loadImage("meat.png");
      healthKit = loadImage("healthkit.png");
      sign = loadImage("sign.png");
    
   //the y coordinates to make the picture move
      int x = 10;
      int stop = -800;
      int appleY = c.getHeight()/2-670;
      int waterBottleY = c.getHeight()/2-690;
      int meatY = c.getHeight()/2-545;
      int healthKitY = c.getHeight()/2-540;
    
      int rect1Y = c.getHeight()/2-578;
      int rect2Y = c.getHeight()/2-578;
      int rect3Y = c.getHeight()/2-460;
      int rect4Y = c.getHeight()/2-460;
    
      int cost1Y = c.getHeight()/2-562;
      int cost2Y = c.getHeight()/2-562;
      int cost3Y = c.getHeight()/2-444;
      int cost4Y = c.getHeight()/2-444;
      int instructionsY = -650;
      int descriptionY = -680;
      int finalMsgY = c.getHeight()/2+40;
      int keyMsgY = c.getHeight()/2+60;
    
   //fonts for the text 
      Font f1 = new Font("Comic Sans", Font.BOLD, 16);
      Font f2 = new Font("Comic Sans", Font.BOLD, 12);
    
   //the cost of each object 
      String cost1 = "20";
      String cost2 = "25";
      String cost3 = "50";
      String cost4 = "250";
    
      String instructions = "Type your answers into the jGRASP console.";
      String description = "Welcome to the shop. You have to buy at least one item for the other survivors. Make sure you have enough points.";
    
      String finalMsg = "You succesfully bought the necessary products for the other survivors.";
      String keyMsg = "You collected 1 more key. Collect the last one to finish the game.";
   
   
     //moves the screen until the picture is on screen fully
      while (stop != 0){
      
         synchronized (c){
         
         //draws the images
            c.drawImage(shelvesImage, 0, stop, c.getWidth(),c.getHeight());
            c.drawImage(apple, 180, appleY, 160,160);
            c.drawImage(waterBottle, 480, waterBottleY, 140,140);
            c.drawImage(meat, 195, meatY, 90,90);
            c.drawImage(healthKit, 505, healthKitY, 80,80);
            c.drawImage(sign, c.getWidth()/2-90, stop, 180, 80);
         
         //draws the box for the price
            c.setColor(brown);
            c.fillRect(217, rect1Y, 40, 20);
            c.fillRect(522, rect2Y, 40, 20);
            c.fillRect(217, rect3Y, 40, 20);
            c.fillRect(522, rect4Y, 40, 20);
         
         //prints the cost text
            c.setFont(f1);
            c.setColor(green);
            c.drawString(cost1, 225, cost1Y);
            c.drawString(cost2, 531, cost2Y);
            c.drawString(cost3, 225, cost3Y);
            c.drawString(cost4, 525, cost4Y);
         
         //prints the instructions
            c.setFont(f2);
            c.setColor(Color.white);
            c.drawString(instructions, c.getWidth()/2 - 135, instructionsY);
            c.drawString(description, 40, descriptionY);
         }
       
         delay(15);
       
         //changes the location creating a transition
         stop += x;
         appleY += x;
         waterBottleY += x;
         meatY += x;
         healthKitY += x;
         rect1Y += x;
         rect2Y += x;
         rect3Y += x;
         rect4Y += x;
         cost1Y += x;
         cost2Y += x;
         cost3Y += x;
         cost4Y += x;
         instructionsY += x;
         descriptionY += x;
       
      }
   
   //prints the boxes for the display 
      c.setColor(brown);
      c.fillRect(160, 170, 140, 90);
      c.fillRect(c.getWidth()-300, 170, 140, 90);
      c.fillRect(160, 300, 140, 90);
      c.fillRect(c.getWidth()-300, 300, 140, 90);
   
   //draws the smaller images for the display    
      c.drawImage(apple, 165, 175, 100, 100);
      c.drawImage(waterBottle, c.getWidth()-295, 175, 80,80);
      c.drawImage(meat, 170, 315, 55, 55);
      c.drawImage(healthKit, c.getWidth()-285, 320, 50,50);
   
   //draws the dash    
      c.setColor(Color.white);
      c.drawString("-", 235, 220);
      c.drawString("-", c.getWidth()-225, 220);
      c.drawString("-", 235, 350);
      c.drawString("-", c.getWidth()-225, 350);
   
   //runs the method where user has to input the amount they want 
      String[] givenAmounts = shopMath(points);
   
   //converts the int into string 
      String appleNum = String.valueOf(givenAmounts[0]);
      String waterNum = String.valueOf(givenAmounts[1]);
      String meatNum = String.valueOf(givenAmounts[2]);
      String aidNum = String.valueOf(givenAmounts[3]);
   
   //prints the value the user inputed in jGRASP
      c.drawString(appleNum, 255, 220);
      c.drawString(waterNum, c.getWidth()-205, 220);
      c.drawString(meatNum, 255, 350);
      c.drawString(aidNum, c.getWidth()-205, 350);
               
   //draws the final message 
      c.drawString(finalMsg, c.getWidth()/2-220, finalMsgY);
      c.drawString(keyMsg, c.getWidth()/2-205, keyMsgY);
    
      keys = 2;
      c.drawString("Click \"n\" to continue", 650, c.getHeight()/2+80);
    
      //runs the loop until the letter n is clicked
      while (true) {
         keyCharMGame = c.getKeyChar();
      
       //if clicked remove the picture off the screen
         if (keyCharMGame == 'n') {
         
         //moves the picture out of the screen
            while(stop != -800){
               synchronized (c){
               
                  mainSettingOfGame();
                
               //draws the images
                  c.drawImage(shelvesImage, 0, stop, c.getWidth(),c.getHeight());
                  c.drawImage(apple, 180, appleY, 160,160);
                  c.drawImage(waterBottle, 480, waterBottleY, 140,140);
                  c.drawImage(meat, 195, meatY, 90,90);
                  c.drawImage(healthKit, 505, healthKitY, 80,80);
                  c.drawImage(sign, c.getWidth()/2-90, stop, 180, 80);
               
               //draws the box for the price
                  c.setColor(brown);
                  c.fillRect(217, rect1Y, 40, 20);
                  c.fillRect(522, rect2Y, 40, 20);
                  c.fillRect(217, rect3Y, 40, 20);
                  c.fillRect(522, rect4Y, 40, 20);
               
               //prints the cost text
                  c.setFont(f1);
                  c.setColor(green);
                  c.drawString(cost1, 225, cost1Y);
                  c.drawString(cost2, 531, cost2Y);
                  c.drawString(cost3, 225, cost3Y);
                  c.drawString(cost4, 525, cost4Y);
               
               //prints the instructions
                  c.setFont(f2);
                  c.setColor(Color.white);
                  c.drawString(instructions, c.getWidth()/2 - 135, instructionsY);
                  c.drawString(description, 40, descriptionY);
               
               //draws the final message 
                  c.drawString(finalMsg, c.getWidth()/2-220, finalMsgY);
                  c.drawString(keyMsg, c.getWidth()/2-205, keyMsgY);
               
               }
               delay(15);
            
            //changes the location creating a transition
               stop -= x;
               appleY -= x;
               waterBottleY -= x;
               meatY -= x;
               healthKitY -= x;
               rect1Y -= x;
               rect2Y -= x;
               rect3Y -= x;
               rect4Y -= x;
               cost1Y -= x;
               cost2Y -= x;
               cost3Y -= x;
               cost4Y -= x;
               instructionsY -= x;
               descriptionY -= x;
               finalMsgY -= x;
               keyMsgY -=x;
            
            }
          
         //exits the loop
            break;
         }
      
      }
   
   }
 
 
  /*Asks the user to input their amount for the shop section
  * After sends the input to the shop main graphics method
  *  
  */
   public static String[] shopMath(int points) {
      Scanner keyboard = new Scanner(System.in);
    
   //keeps the prices
      int apple = 20, water = 25, meat = 50, firstaid = 250;
   //keeps the users input
      String appleamount, wateramount, meatamount, firstaidamount;
   //will keep the converted string input into an int 
      int appleamountInt, wateramountInt, meatamountInt, firstaidamountInt;
    
   //copies the points
      int pointsCopy = points;
   
   //runs until loop is broken 
      while (true)
      {
      //tells the user how many points they have
         System.out.println("You have " + points + " points.");
         System.out.println();
       
      //amount of apples is asked
         System.out.println ("How many apples do you want to purchase?");
         appleamount = keyboard.nextLine();
      
      //loop runs until correct input is given 
         while(!appleamount.matches("[0-9]+")){
            System.out.println("Incorrect input. Please enter a vaild input.");
            System.out.println("How many apples do you want to purchase?");
            appleamount = keyboard.nextLine();
         }
      
      //changes the string into an int
         appleamountInt = Integer.parseInt(appleamount);
       
      //multiplies by the points it costs and subtracts from the copy of points
         pointsCopy = pointsCopy - (apple * appleamountInt);
         System.out.println("You have " + pointsCopy + " points left");
       
         System.out.println();
       
      //amount of water is asked
         System.out.println ("How many bottles of water do you want to purchase?");
         wateramount = keyboard.nextLine();
      
      //loop runs until correct input is given    
         while(!wateramount.matches("[0-9]+")){
            System.out.println("Incorrect input. Please enter a vaild input.");
            System.out.println("How many bottles of water do you want to purchase?");
            wateramount = keyboard.nextLine();
         }
       
      //changes the string into an int 
         wateramountInt = Integer.parseInt(wateramount);
      //multiplies by the points it costs and subtracts from the copy of points 
         pointsCopy = pointsCopy - (water * wateramountInt);
         System.out.println("You have " + pointsCopy + " points left");
       
         System.out.println();
      
      //amount of meat is asked
         System.out.println ("How much meat do you want to purchase?");
         meatamount = keyboard.nextLine();
      
      //loop runs until correct input is given   
         while(!meatamount.matches("[0-9]+")){
            System.out.println("Incorrect input. Please enter a vaild input.");
            System.out.println("How much meat do you want to purchase?");
            meatamount = keyboard.nextLine();
         }
       
      //changes the string into an int
         meatamountInt = Integer.parseInt(meatamount);
      //multiplies by the points it costs and subtracts from the copy of points
         pointsCopy = pointsCopy - (meat * meatamountInt);
         System.out.println("You have " + pointsCopy + " points left");
       
         System.out.println();
      
      //amount of first aid is asked 
         System.out.println ("How many first aid supplies do you want to purchase?");
         firstaidamount = keyboard.nextLine();
      
      //loop runs until correct input is given  
         while(!firstaidamount.matches("[0-9]+")){
            System.out.println("Incorrect input. Please enter a vaild input.");
            System.out.println("How many first aid supplies do you want to purchase?");
            firstaidamount = keyboard.nextLine();
         }
      
      //changes the string into an int
         firstaidamountInt = Integer.parseInt(firstaidamount);
      //multiplies by the points it costs and subtracts from the copy of points
         pointsCopy = pointsCopy - (firstaid * firstaidamountInt);
         System.out.println("You have " + pointsCopy + " points left");
      
         System.out.println();
      
      //checks if the task was completed properly
         if (pointsCopy >= 0 && pointsCopy < points)
         {
            System.out.println ("You completed the necessary task. Please return to the game console.");
            break;
         }
         else
         {
            System.out.println ("You incorrectly passed this section, try again.");
            pointsCopy = points;
         }
      }
    
      //keeps the given amounts in an array
      String[] givenAmounts = {appleamount, wateramount, meatamount, firstaidamount};
    
      //returns it back to the main store method
      return givenAmounts;
   }
 
   /* The school main graphics method
   *  Takes the input from jGRASP console and draws it on the main console
   *  Draws the main scene
   */
   public static void schoolGraphic() {
   
   //the fonts
      Font f1 = new Font("Secular One", Font.BOLD, 35);
      Font f2 = new Font("Comic Sans", Font.BOLD, 12);
      Font f3 = new Font("Comic Sans", Font.BOLD, 24);
      Font f4 = new Font("Comic Sans", Font.BOLD, 16);
   
   //the description
      String title = "The School";
      String instructions = "Welcome to the school. You have to solve 9 mathematical problems to get points and collect your first key.";
      String sectionOne = "Section 1.";
      String sectionTwo = "Section 2.";
      String sectionThree = "Section 3.";
      String typeAnswerJgrasp = "Type your answers into the jGRASP console.";
    
   //the math questions
      String q1 = "Q1.  2 + 2 = ";
      String q2 = "Q2.  12 + 45 = ";
      String q3 = "Q3.  123 + 890 = ";
      String q4 = "Q4.  5 x 5 = ";
      String q5 = "Q5.  9 x 8 = ";
      String q6 = "Q6.  123 x 0 = ";
      String q7 = "Q7.  36 / 18 = ";
      String q8 = "Q8.  231 / 33 = ";
      String q9 = "Q9.  5 + (7 x 3) = ";
   
   //imports the images
      Image classroom;
      Image paper;
    
   //keeps the users answers
      String ans1, ans2, ans3, ans4, ans5, ans6, ans7, ans8, ans9;
    
   
      classroom = loadImage("classroom.jpeg");
      paper = loadImage("paper.jpeg");
    
   //the y coordinates to make the picture move
      int x = 10;
      int stop = -800;
      int paperY = c.getHeight()/2-890;
      int schoolY = -740;
      int schoolY2 = -620;
      int instructionsY = -650;
      int sectionTxtY = c.getHeight()/2-50;
    
      int q1a4a7Y = c.getHeight()/2-13;
      int q2a5a8Y = c.getHeight()/2+48;
      int q3a6a9Y = c.getHeight()/2+107;
      int totalMarkY = c.getHeight()-140;
      int pointsCollectY = c.getHeight()-110;
      int keysY = c.getHeight()-80;
   
    
      //runs the loop until the images get into their proper positions
      while (stop != 0){
       
         synchronized (c) {
            //prints the images 
            c.drawImage(classroom, 0,stop, c.getWidth(), c.getHeight());
            c.drawImage(paper, c.getWidth()/3 - 250, paperY, 220, 280);
            c.drawImage(paper, c.getWidth()/2-108, paperY, 220, 280);
            c.drawImage(paper, c.getWidth()-235, paperY, 220,280);
          
            c.setColor(Color.black);
            c.fillRect(c.getWidth()/2 - 113, stop, 250, 100);
          
            //prints the description 
            c.setFont(f1);
            c.setColor(Color.white);
            c.drawString(title, c.getWidth()/2 - 87, schoolY);
          
            c.setFont(f2);
            c.drawString(instructions, 60, instructionsY);
            c.drawString(typeAnswerJgrasp, c.getWidth()/2 - 125, schoolY2);
         }
       
         delay(15);
       
         //changes the coordinates of the y for the images 
         stop += x;
         paperY += x;
         schoolY += x;
         instructionsY += x;
         schoolY2 += x;
       
      }
    
      //prints the sections
      c.setColor(Color.black);
      c.setFont(f3);
      c.drawString(sectionOne, c.getWidth()/3 - 200, sectionTxtY);
      c.drawString(sectionTwo, c.getWidth()/2-58, sectionTxtY);
      c.drawString(sectionThree, c.getWidth()-180, sectionTxtY);
    
      //prints the questions
      //question 1 
      c.setFont(f4);
      c.drawString(q1, c.getWidth()/3 - 230, q1a4a7Y);
    
      System.out.println("Your answer for problem number 1 is:");
      ans1 = keyboard.nextLine();
    
      //keeps asking until the correct input was given 
      while(!ans1.matches("[0-9]+")){
         System.out.println("Incorrect input. Please enter a vaild input.");
         System.out.println("Your answer for problem number 1 is:");
         ans1 = keyboard.nextLine();
      }
       
      c.drawString(ans1, c.getWidth()/3-110, q1a4a7Y);
    
      System.out.println();
      //question 2 
      c.drawString(q2, c.getWidth()/3 - 230, q2a5a8Y);
    
      System.out.println("Your answer for problem number 2 is:");
      ans2 = keyboard.nextLine();
    
      //keeps asking until the correct input was given  
      while(!ans2.matches("[0-9]+")){
         System.out.println("Incorrect input. Please enter a vaild input.");
         System.out.println("Your answer for problem number 2 is:");
         ans2 = keyboard.nextLine();
      }
      c.drawString(ans2, c.getWidth()/3-90, q2a5a8Y);
    
    
      System.out.println();
      //question 3 
      c.drawString(q3, c.getWidth()/3 - 230, q3a6a9Y);
    
      System.out.println("Your answer for problem number 3 is:");
      ans3 = keyboard.nextLine();
    
      //keeps asking until the correct input was given   
      while(!ans3.matches("[0-9]+")){
         System.out.println("Incorrect input. Please enter a vaild input.");
         System.out.println("Your answer for problem number 3 is:");
         ans3 = keyboard.nextLine();
      }
      c.drawString(ans3, c.getWidth()/3-80, q3a6a9Y);
    
    
      System.out.println();
      //second section
      //question 4
      c.drawString(q4, c.getWidth()/2-88, q1a4a7Y);
    
      System.out.println("Your answer for problem number 4 is:");
      ans4 = keyboard.nextLine();
    
      //keeps asking until the correct input was given  
      while(!ans4.matches("[0-9]+")){
         System.out.println("Incorrect input. Please enter a vaild input.");
         System.out.println("Your answer for problem number 4 is:");
         ans4 = keyboard.nextLine();
      }
      c.drawString(ans4, c.getWidth()/2+20, q1a4a7Y);
    
    
      System.out.println();
      //question 5
      c.drawString(q5, c.getWidth()/2-88, q2a5a8Y);
    
      System.out.println("Your answer for problem number 5 is:");
      ans5 = keyboard.nextLine();
    
      //keeps asking until the correct input was given  
      while(!ans5.matches("[0-9]+")){
         System.out.println("Incorrect input. Please enter a vaild input.");
         System.out.println("Your answer for problem number 5 is:");
         ans5 = keyboard.nextLine();
      }
      c.drawString(ans5, c.getWidth()/2+20, q2a5a8Y);
    
    
      System.out.println();
      //question 6
      c.drawString(q6, c.getWidth()/2-88, q3a6a9Y);
    
      System.out.println("Your answer for problem number 6 is:");
      ans6 = keyboard.nextLine();
    
      //keeps asking until the correct input was given  
      while(!ans6.matches("[0-9]+")){
         System.out.println("Incorrect input. Please enter a vaild input.");
         System.out.println("Your answer for problem number 6 is:");
         ans6 = keyboard.nextLine();
      }
      c.drawString(ans6, c.getWidth()/2+40, q3a6a9Y);
    
    
      System.out.println();
      //third section
      //question 7
      c.drawString(q7, c.getWidth()-210, q1a4a7Y);
    
      System.out.println("Your answer for problem number 7 is:");
      ans7 = keyboard.nextLine();
    
      //keeps asking until the correct input was given  
      while(!ans7.matches("[0-9]+")){
         System.out.println("Incorrect input. Please enter a vaild input.");
         System.out.println("Your answer for problem number 7 is:");
         ans7 = keyboard.nextLine();
      }
      c.drawString(ans7, c.getWidth()-80, q1a4a7Y);
    
    
      System.out.println();
      //question 8
      c.drawString(q8, c.getWidth()-210, q2a5a8Y);
    
      System.out.println("Your answer for problem number 8 is:");
      ans8 = keyboard.nextLine();
    
      //keeps asking until the correct input was given  
      while(!ans8.matches("[0-9]+")){
         System.out.println("Incorrect input. Please enter a vaild input.");
         System.out.println("Your answer for problem number 8 is:");
         ans8 = keyboard.nextLine();
      }
      c.drawString(ans8, c.getWidth()-70, q2a5a8Y);
    
    
      System.out.println();
      //question 9
      c.drawString(q9, c.getWidth()-210, q3a6a9Y);
    
      System.out.println("Your answer for problem number 9 is:");
      ans9 = keyboard.nextLine();
    
      //keeps asking until the correct input was given 
      while(!ans9.matches("[0-9]+")){
         System.out.println("Incorrect input. Please enter a vaild input.");
         System.out.println("Your answer for problem number 9 is:");
         ans9 = keyboard.nextLine();
      }
      c.drawString(ans9, c.getWidth()-60, q3a6a9Y);
    
      //asks user to go return to the game console 
      System.out.println();
      System.out.println("You completed the necessary task. Please return to the game console.");
    
      //stores the input in the array
      String[] inputAnswers = {ans1, ans2, ans3, ans4, ans5, ans6, ans7, ans8, ans9};
      //sends the inputed answers into the schoolMath method and returns the necessary text
      String[] finalMsg = schoolMath(inputAnswers);
    
      c.setColor(Color.white);
      c.setFont(f2);
    
      //prints the final messages
      c.drawString(finalMsg[0], 50, totalMarkY);
    
      c.drawString(finalMsg[1], 50, pointsCollectY);
      c.drawString(finalMsg[2], 50, keysY);
    
      keys = 1;
      c.drawString("Click \"n\" to continue", 650, keysY);
    
    
    
      //runs the loop until the letter n is clicked
      while (true){
         keyCharMGame = c.getKeyChar();
      
      //if clicked remove the picture off the screen
         if (keyCharMGame == 'n'){
         
         //moves the picture out of the screen
            while (stop != -800){
               synchronized (c) {
                  mainSettingOfGame();
                
               //prints the images 
                  c.drawImage(classroom, 0,stop, c.getWidth(), c.getHeight());
                  c.drawImage(paper, c.getWidth()/3 - 250, paperY, 220, 280);
                  c.drawImage(paper, c.getWidth()/2-108, paperY, 220, 280);
                  c.drawImage(paper, c.getWidth()-235, paperY, 220,280);
               
                  c.setColor(Color.black);
                  c.fillRect(c.getWidth()/2 - 113, stop, 250, 100);
               
               //prints the description 
                  c.setFont(f1);
                  c.setColor(Color.white);
                  c.drawString(title, c.getWidth()/2 - 87, schoolY);
               
               //prints the instructions
                  c.setFont(f2);
                  c.drawString(instructions, 60, instructionsY);
                  c.drawString(typeAnswerJgrasp, c.getWidth()/2 - 125, schoolY2);
               
               //prints the sections text
                  c.setColor(Color.black);
                  c.setFont(f3);
                  c.drawString(sectionOne, c.getWidth()/3 - 200, sectionTxtY);
                  c.drawString(sectionTwo, c.getWidth()/2-58, sectionTxtY);
                  c.drawString(sectionThree, c.getWidth()-180, sectionTxtY);
               
               //prints the final messages
                  c.setColor(Color.white);
                  c.setFont(f2);
               
                  c.drawString(finalMsg[0], 50, totalMarkY);
               
                  c.drawString(finalMsg[1], 50, pointsCollectY);
                  c.drawString(finalMsg[2], 50, keysY);
               
               }
            
               delay(15);
            
            //moves the y coordinates up    
               stop -= x;
               paperY -= x;
               schoolY -= x;
               schoolY2 -= x;
               instructionsY -= x;
               sectionTxtY -=x;
               totalMarkY-=x;
               pointsCollectY-=x;
               keysY-=x;
            
            }
         
         //exits the loop
            break;
         }
      
      }
    
   }
 
 
 
   /* The math operators for the school section
   *  Adds the total marks of the inputs
   *  Sends it to the school main graphics method
   */
   public static String[] schoolMath(String[] inputAnswers) {
    
      int[] answers =  new int [9];
    
      //converts the string answers into integers and puts them in the array
      for (int i = 0; i < answers.length; i++) {
         answers[i] = Integer.parseInt(inputAnswers[i]);
      }
   
   //keeps the final percent
      double percentage = 0.0;
   //adds the correct marks together
      double sum = 0.0;
   //the answers
      int ans1 = 4, ans2 = 57, ans3 = 1013, ans4 = 25, ans5 = 72, ans6 = 0, ans7 = 2, ans8 = 7, ans9 =26;
   
      int[] realAnswers = {ans1, ans2, ans3, ans4, ans5, ans6, ans7, ans8, ans9};
   
   //checks if the answer is correct and adds that to the sum
      for (int i = 0; i < realAnswers.length; i++) {
      
         if (answers[i] == realAnswers[i]) {
            sum++;
          
         }
      }
   
   //finds the percent of the average 
      sum = (sum/9.0)*100;
   //rounds the final mark 
      percentage = Math.round(sum);
   
   //decides how many points the user gets  
      if (percentage >= 80.0)
      {
         points = 300;
      }
      else if (percentage < 80.0 && percentage >= 50.0)
      {
         points = 200;
      }
      else if (percentage < 50.0 && percentage >= 0.0)
      {
         points = 100;
      }
    
      String totalMarkPerc = "Your total mark is " + percentage + " percent";
      String collectedPoints = "You collected " + points + " points. Go to the shop to buy products for the other survivours.";
      String keyCollect = "You collected the first key. Collect two more to finish the game.";
    
      String[] finalMsg = {totalMarkPerc, collectedPoints, keyCollect};
   
      return finalMsg;
   }

   /*draws the main game graphics
   *
   *
   */
   public static void mainSettingOfGame() {
   
      background();
      title();
      buildingOne();
      buildingTwo();
      buildingThree();
      buldingFour();
   
   }

 
  /* draws the final destination building
  *
  */
   public static void buildingOne() {
   //colours
      Color gray = new Color(66, 63, 60);
      Color lighterBrown = new Color(92, 50, 8);
      Color darkBrown = new Color(66, 36, 6);
      Color darkerBrown = new Color(46, 23, 0);
      Color DARKERBrown = new Color(31, 21, 0);
   
   //draws the first rectangle
      c.setColor(gray);
      c.fillRect(c.getWidth()-150, 80, 70, 20);
    //draws the door
      c.setColor(DARKERBrown);
      c.fillRect(c.getWidth()-125, 80, 20, 20);
    //draws the second rectangle
      c.setColor(lighterBrown);
      c.fillRect(c.getWidth()-150, 60, 70, 20);
   
    //draws the trapezoid
      int[] xTrapezoid = {c.getWidth()-150, c.getWidth()-140, c.getWidth()-90, c.getWidth()-80};
      int[] yTrapezoid = {60, 50, 50, 60};
   
      c.fillPolygon(xTrapezoid, yTrapezoid, 4);
    //draws the roof
      c.setColor(darkBrown);
      c.fillRect(c.getWidth()-140, 0, 50, 50);
   
    //draws the right side of the roof
      int[] xRightRoof = {c.getWidth()-90,  c.getWidth()-90, c.getWidth()-80, c.getWidth()-80};
      int[] yRightRoof = {50, 0, 0, 60};
   
      c.setColor(darkerBrown);
      c.fillPolygon(xRightRoof, yRightRoof, 4);
   
      c.setColor(darkBrown);
    //draws the left side of the roof
      int[] xLeftRoof = {c.getWidth()-140, c.getWidth()-140, c.getWidth()-150, c.getWidth()-150};
      int[] yLeftRoof = {50, 0, 0, 60};
   
      c.fillPolygon(xLeftRoof,yLeftRoof, 4);
   
    //draws the second part of the house
      c.setColor(gray);
      c.fillRect(c.getWidth()-80, 140, 80, 20);
   
    //draws the upper rectangle
      c.setColor(lighterBrown);
      c.fillRect(c.getWidth()-80, 120, 80, 20);
   
    //draws the trapezoid
      int[] xTrapezoid2 = {c.getWidth()-80, c.getWidth()-60, c.getWidth(), c.getWidth()};
      int[] yTrapezoid2 = {120, 110, 110, 120};
   
      c.fillPolygon(xTrapezoid2, yTrapezoid2, 4);
   
    //draws the roof for the second part of the house
      c.setColor(darkBrown);
      c.fillRect(c.getWidth()-70, 0, 80, 110);
   
    //draws the left side of the roof
      int[] xLeftRoof2 = {c.getWidth()-80, c.getWidth()-80, c.getWidth()-60, c.getWidth()-60};
      int[] yLeftRoof2 = {120, 0, 0, 110};
   
      c.setColor(darkBrown);
      c.fillPolygon(xLeftRoof2, yLeftRoof2, 4);
   }

  /*draws the school
  *
  */
   public static void buildingTwo() {
   //colours
      Color darkRed = new Color(71, 1, 1);
      Color lighterRed = new Color(105, 1, 1);
      Color red = new Color(153, 2, 2);
      Color DARKERBrown = new Color(31, 21, 0);
      Color gray = new Color(92, 87, 87);
   
   //the school yard
      c.setColor(gray);
      c.fillRect(c.getWidth()-180, c.getHeight()-130, 90,90);
   
   //the triangle on the left
      c.setColor(darkRed);
      int[] xTriangleLeft = {c.getWidth()-210, c.getWidth()-210, c.getWidth()-195};
      int[] yTriangleLeft = {c.getHeight()-130, c.getHeight()-160, c.getHeight()-145};
   
      c.fillPolygon(xTriangleLeft,yTriangleLeft,3);
      c.setColor(lighterRed);
   
   //the bottom part of the roof
      int[] xBottomRoof = {c.getWidth()-210, c.getWidth()-195, c.getWidth()-50, c.getWidth()-90};
      int[] yBottomRoof = {c.getHeight()-130, c.getHeight()-145, c.getHeight()-145, c.getHeight()-130};
   
      c.fillPolygon(xBottomRoof, yBottomRoof, 4);
   
      c.setColor(red);
   
   //the top part of the roof
      int[] xTopRoof = {c.getWidth()-210, c.getWidth()-195, c.getWidth()-50, c.getWidth()-90};
      int[] yTopRoof = {c.getHeight()-160, c.getHeight()-145, c.getHeight()-145, c.getHeight()-160};
   
      c.fillPolygon(xTopRoof, yTopRoof, 4);
   
      c.setColor(red);
   
   //big triangle
      int[] xBigTriangle = {c.getWidth()-90, c.getWidth()-10, c.getWidth()-50};
      int[] yBigTriangle = {c.getHeight()-180, c.getHeight()-180, c.getHeight()-145};
   
      c.fillPolygon(xBigTriangle, yBigTriangle, 3);
   
   //little traingle
      c.setColor(darkRed);
   
      int[] xLittleTriangle = {c.getWidth()-90, c.getWidth()-90, c.getWidth()-50};
      int[] yLittleTriangle = {c.getHeight()-160, c.getHeight()-180, c.getHeight()-145};
   
      c.fillPolygon(xLittleTriangle, yLittleTriangle, 3);
   
   //right side of the roof of the bigger part
      c.setColor(lighterRed);
   
      int[] xRightRoofB = {c.getWidth()-10, c.getWidth()-50, c.getWidth()-50, c.getWidth()-10};
      int[] yRightRoofB = {c.getHeight()-180, c.getHeight()-145, c.getHeight()-50, c.getHeight()-50};
   
      c.fillPolygon(xRightRoofB, yRightRoofB, 4);
   
   //left side of the roof of the bigger part
      c.setColor(darkRed);
   
      int[] xLeftRoofB = {c.getWidth()-50, c.getWidth()-90, c.getWidth()-90, c.getWidth()-50};
      int[] yLeftRoodB = {c.getHeight()-145, c.getHeight()-130, c.getHeight()-50, c.getHeight()-50};
   
      c.fillPolygon(xLeftRoofB, yLeftRoodB, 4);
   
   //the entrence rectangle
      c.setColor(DARKERBrown);
      c.fillRect(c.getWidth()-130, c.getHeight()-180, 40,20);
   
   //fence
      c.setColor(Color.black);
      c.drawLine(c.getWidth()-195, c.getHeight()-130, c.getWidth()-195, c.getHeight()-35);
      c.drawLine(c.getWidth()-195, c.getHeight()-35, c.getWidth()-10, c.getHeight()-35);
      c.drawLine(c.getWidth()-10, c.getHeight()-35, c.getWidth()-10, c.getHeight()-50);
   }
 
  /* draws the store
  *
  */
   public static void buildingThree() {
   //colours
      Color darkGray = new Color(61, 60, 58);
      Color sGray = new Color(79, 79, 77);
      Color lightGray = new Color(115, 115, 110);
      Color darkerGray = new Color(48, 48, 47);
   
   //left square
      c.setColor(darkGray);
      c.fillRect(40, 30, 70,70);
   //right square
      c.fillRect(150, 30, 70,70);
   //long rectangle in the back
      c.fillRect(60, 15, 140, 35);
   
   //slightly lighter rectangles as the roof
      c.setColor(sGray);
      c.fillRect(50, 40, 60, 50);
      c.fillRect(150, 40, 60, 50);
      c.fillRect(70, 25, 120, 30);
   
   //lighter rectangle at the top
      c.setColor(lightGray);
      c.fillRect(105, 50, 50, 40);
   
   //smaller rectangles at the top
      c.fillRect(90, 100, 20, 10);
      c.fillRect(150, 100, 20,10);
   
      c.setColor(darkerGray);
      c.fillRect(90, 50, 15, 7);
      c.fillRect(155, 50, 15, 7);
   
   }
 
  /* draws the post office
  *
  */
   public static void buldingFour() {
      Color slightlyWhite = new Color(194, 194, 194);
      Color darkBlue = new Color(12, 21, 46);
   
   //main building
      c.setColor(darkBlue);
      c.fillRect(c.getWidth()/2-130, c.getHeight()-120, 120,70);
    //the nose of the building
      c.setColor(slightlyWhite);
      c.fillArc(c.getWidth()/2-110, c.getHeight()-145, 80, 50, 0, 180);
   }
 
 
  //background image for the main map
   public static void background() {
      Image grass;
      grass = loadImage("Untitled design.png");
   
      c.drawImage(grass,  0, 0, c.getWidth()+300, c.getHeight());
   
   }
 
 
  /* the title in the background
  *
  */
   public static void title() {
      Color green = new Color(1, 20, 5);
   
   
      Font f1 = new Font("Secular One", Font.BOLD | Font.ITALIC, 64);
      Font f2 = new Font("Comic Sans", Font.BOLD, 12);
    
   
      c.setColor(green);
      c.setFont(f1);
      c.drawString("Will You Survive?", c.getWidth()/2-280, c.getHeight()/2);
   
      String mapInstructions = "Hold \"m\" for map";
   
      c.setColor(Color.white);
      c.setFont(f2);
      c.drawString(mapInstructions, 50, c.getHeight()-50);
   }
 
  /* Backstory
  *  Makes the text appear character by character
  *
  */
   public static void printTxt(String phrase, JButton skipBtn) {
      String newTxt = "";
   
      skipBtn.setBounds(c.getWidth()-100, c.getHeight()-100, 50,50);
   
      c.addButton(skipBtn);
   
      int num = 5;
      int count = 0;
   
      while(count < phrase.length()){
      
         num = c.getButtonDown();
         newTxt = phrase.substring(count + 1);
          
         c.print(phrase.charAt(count));
         delay(50);
          
         count++;
         if (num == 0) {
            c.print(newTxt);
            break;
         }
          
      }
      c.println();
      c.println();
      c.println();
      c.println();
      c.println();
   }

 
  /* Rules screen method
  *
  */
   public static void rulesScreen(Image virusallImage) {
      Color darkGray = new Color(61, 60, 58);
      Color sGray = new Color(79, 79, 77);
   
      c.setBackgroundColor(darkGray);
      c.clear();
   
   
      c.setColor(Color.black);
      Font f1 = new Font("Secular One", Font.BOLD | Font.ITALIC, 70);
      Font f2 = new Font("Comic Sans MS", Font.PLAIN, 18);
      Font f3 = new Font("Comic Sans MS", Font.PLAIN, 9);
   
      c.setFont(f1);
      String rules = "Rules";
      c.drawString (rules, c.getWidth()/2-100, 300);
   
      c.setFont(f2);
      String keysMove = "Use the WASD keys to move the character.";
      c.drawString(keysMove, c.getWidth()/2-180, 370);
   
      String tip = "Try to avoid the viruses. If you get hit, you won’t die right away, you have three tries.";
      c.drawString(tip, c.getWidth()/2-350, 400);
   
      String instructions = "You have to visit each structure and complete the necessary tasks.";
      c.drawString(instructions, c.getWidth()/2-280, 430);
   
      String instructions2 = "After a completed task you collect a key, collect all three keys to finish the game.";
      c.drawString(instructions2, c.getWidth()/2-320, 460);
    
      String instructions3 = "Hold the \"m\" button to see the map, it will show you the location you need to go to.";
      c.drawString(instructions3, c.getWidth()/2-320, 490);
    
      c.setColor(sGray);
      c.fillRect(50, c.getHeight()-230, 200,180);
   
      c.setColor(Color.black);
      String additionalKeys = "Additional Keys:";
      c.drawString(additionalKeys, 80, c.getHeight()-210);
   
      c.setFont(f3);
      String qMove = "Q moves the character up and to the left.";
      c.drawString(qMove, 60, c.getHeight()-180);
   
      String eMove = "E moves the character up and to the right.";
      c.drawString(eMove, 60, c.getHeight()-150);
   
      String zMove = "Z moves the character down and to the left.";
      c.drawString(zMove, 58, c.getHeight()-120);
   
      String cMove = "C moves the character down and to the right.";
      c.drawString(cMove, 56, c.getHeight()-90);
   
      // draw the viruses on the top left corner
      c.drawImage(virusallImage, 0, 0, 100, 100, 335);
      c.drawImage(virusallImage, 90, 30, 80, 80, 335);
      c.drawImage(virusallImage, 0, 100, 90, 90, 335);
      c.drawImage(virusallImage, 90, 110, 100, 100, 335);
      c.drawImage(virusallImage, 140, 0, 110, 110, 335);
      c.drawImage(virusallImage, 0, 190, 70, 70, 335);
      c.drawImage(virusallImage, 70, 210, 50, 50, 335);
      c.drawImage(virusallImage, -10, 260, 90, 90, 335);
      c.drawImage(virusallImage, 220, 0, 80, 80, 335);
   
   // draw the viruses on the top right corner
      c.drawImage(virusallImage, 730, 0, 80, 80, 25);
      c.drawImage(virusallImage, 630, -10, 110, 110, 25);
      c.drawImage(virusallImage, 710, 80, 90, 90, 25);
      c.drawImage(virusallImage, 590, 0, 50, 50, 25);
      c.drawImage(virusallImage, 640, 100, 70, 70, 25);
      c.drawImage(virusallImage, 590, 60, 70, 70, 25);
      c.drawImage(virusallImage, 500, 10, 100, 100, 25);
      c.drawImage(virusallImage, 740, 260, 50, 50, 25);
      c.drawImage(virusallImage, 690, 150, 110, 110, 25);
   }
 
  /*About screen method
  *
  */
   public static void aboutScreen(Image virusallImage) {
      Color darkGray = new Color(61, 60, 58);
      c.setBackgroundColor(darkGray);
      c.clear();
   
      Font f1 = new Font("Secular One", Font.BOLD | Font.ITALIC, 70);
      Font f2 = new Font("Comic Sans MS", Font.PLAIN, 18);
   
      c.setColor(Color.black);
      c.setFont(f1);
      String about = "About";
      c.drawString (about, c.getWidth()/2-110, 300);
   
      c.setFont(f2);
      String instructions = "This game is a collision avoidance game where you have to avoid viruses";
      c.drawString(instructions, c.getWidth()/2-290, 370);
   
      String instructions2 = "and complete the necessary tasks.";
      c.drawString(instructions2,c.getWidth()/2-150, 400);
   
      String instructions3 = "Certain actions will determine the ending.";
      c.drawString(instructions3, c.getWidth()/2-180, 430);
   
      String goodLuck = "Good luck.";
      c.drawString(goodLuck, c.getWidth()/2-50, 460);
   
      // draw the viruses on the top left corner
      c.drawImage(virusallImage, 0, 0, 100, 100, 335);
      c.drawImage(virusallImage, 90, 30, 80, 80, 335);
      c.drawImage(virusallImage, 0, 100, 90, 90, 335);
      c.drawImage(virusallImage, 90, 110, 100, 100, 335);
      c.drawImage(virusallImage, 140, 0, 110, 110, 335);
      c.drawImage(virusallImage, 0, 190, 70, 70, 335);
      c.drawImage(virusallImage, 70, 210, 50, 50, 335);
      c.drawImage(virusallImage, -10, 260, 90, 90, 335);
      c.drawImage(virusallImage, 220, 0, 80, 80, 335);
   
   // draw the viruses on the top right corner
      c.drawImage(virusallImage, 730, 0, 80, 80, 25);
      c.drawImage(virusallImage, 630, -10, 110, 110, 25);
      c.drawImage(virusallImage, 710, 80, 90, 90, 25);
      c.drawImage(virusallImage, 590, 0, 50, 50, 25);
      c.drawImage(virusallImage, 640, 100, 70, 70, 25);
      c.drawImage(virusallImage, 590, 60, 70, 70, 25);
      c.drawImage(virusallImage, 500, 10, 100, 100, 25);
      c.drawImage(virusallImage, 740, 260, 50, 50, 25);
      c.drawImage(virusallImage, 690, 150, 110, 110, 25);
   }
 
 
  /* Start screen method
  *
  */
   public static void startScreen(Image virusallImage) {
      Color darkGray = new Color(61, 60, 58);
      c.setBackgroundColor(darkGray);
      c.clear();
          
   // two new fonts for the text
      Font f1 = new Font("Secular One", Font.BOLD | Font.ITALIC, 70);
      Font f2 = new Font("Comic Sans MS", Font.PLAIN, 25);
   
      c.setColor(Color.black);
   // draw the first phrase in the first font
      c.setFont(f1);
      String title = "Will You Survive?";
      c.drawString (title, 110, 300);
   
   // draw the other phrases in the second font
      c.setFont(f2);
      String start = "Start - Press 1";
      c.drawString (start, 330, 360);
      String rules = "Rules - Hold 2";
      c.drawString (rules, 333, 410);
      String about = "About the Game - Hold 3";
      c.drawString (about, 260, 460);
      String exit = "Exit - Press 0";
      c.drawString(exit, 343, 510);
   
   // draw the viruses on the top left corner
      c.drawImage(virusallImage, 0, 0, 100, 100, 335);
      c.drawImage(virusallImage, 90, 30, 80, 80, 335);
      c.drawImage(virusallImage, 0, 100, 90, 90, 335);
      c.drawImage(virusallImage, 90, 110, 100, 100, 335);
      c.drawImage(virusallImage, 140, 0, 110, 110, 335);
      c.drawImage(virusallImage, 0, 190, 70, 70, 335);
      c.drawImage(virusallImage, 70, 210, 50, 50, 335);
      c.drawImage(virusallImage, -10, 260, 90, 90, 335);
      c.drawImage(virusallImage, 220, 0, 80, 80, 335);
   
   // draw the viruses on the top right corner
      c.drawImage(virusallImage, 730, 0, 80, 80, 25);
      c.drawImage(virusallImage, 630, -10, 110, 110, 25);
      c.drawImage(virusallImage, 710, 80, 90, 90, 25);
      c.drawImage(virusallImage, 590, 0, 50, 50, 25);
      c.drawImage(virusallImage, 640, 100, 70, 70, 25);
      c.drawImage(virusallImage, 590, 60, 70, 70, 25);
      c.drawImage(virusallImage, 500, 10, 100, 100, 25);
      c.drawImage(virusallImage, 740, 260, 50, 50, 25);
      c.drawImage(virusallImage, 690, 150, 110, 110, 25);
   
   // load the building image
      Image buildingImage;
      buildingImage = loadImage("building.png");
   
   // draw two buildings
      c.drawImage(buildingImage, 350, 450, 500, 390);
      c.drawImage(buildingImage, -50, 450, 500, 390);
   }

  // image method
   public static BufferedImage loadImage(String path){
      BufferedImage img = null;
      try{
         img = javax.imageio.ImageIO.read(new java.io.File(path));
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      return img;
   }
 
  //delay
   public static void delay(int milli){
      try{
         Thread.sleep(milli);
      }
      catch (Exception e){}
   
   }

    // determines the distance between point and line
   // int xa, ya  the starting point x1, y1 pair of the line
   // int xb, yb  the end point x2, y2 pair of the line
   // int xc, yc  the point
   public static double distanceLinePoint(int xa, int ya, int xb, int yb, int xc, int yc) {
      int xdiff = xb - xa;
      int ydiff = yb - ya;
      long l2 = (long) (xdiff * xdiff + ydiff * ydiff);
      if (l2 == 0L) {
         return (double) distance(xa, ya, xc, yc);
      }
      else {
         double rnum = (double) ((ya - yc) * (ya - yb) - (xa - xc) * (xb - xa));
         double r = rnum / (double) l2;
         if (r >= 0.0D && r <= 1.0D) {
            double xi = (double) xa + r * (double) xdiff;
            double yi = (double) ya + r * (double) ydiff;
            double xd = (double) xc - xi;
            double yd = (double) yc - yi;
            return Math.sqrt(xd * xd + yd * yd);
         }
         else {
            return 1.7976931348623157E308D;
         }
      }
      
   }

   public static long distance(int x1, int y1, int x2, int y2) {
      return (long) Math.sqrt((double) distance2(x1, y1, x2, y2));
   }
 
   public static double distance(double x1, double y1, double x2, double y2) {
      return Math.sqrt(distance2(x1, y1, x2, y2));
   }
 
   public static double distance(java.awt.geom.Point2D.Double p1, java.awt.geom.Point2D.Double p2) {
      return Math.sqrt(distance2(p1.x, p1.y, p2.x, p2.y));
   }
 
   public static long distance2(int x1, int y1, int x2, int y2) {
      return (long) ((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
   }
 
   public static double distance2(double x1, double y1, double x2, double y2) {
      return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
   }

   public static boolean hasCollided(Shape shapeA, Shape shapeB) {
      Area areaA = new Area(shapeA);
      areaA.intersect(new Area(shapeB));
      return !areaA.isEmpty();
   }
 
}









