import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import guru.ttslib.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Main extends PApplet {

public void setup() {
  
  setup = new Setup();
  setup.setup();
}

//Goes through all the tests and updates mouse position
public void draw() {
  setup.setup();
  noStroke();
  if (introPlayed == false) {
      dialogue.intro();
      introPlayed = true;
  }
  for (PShape shape : shapesInDrawingBoard) {
    shape(shape, 0, 0);        
  }
  
  for (PShape shape : shapesStuck) {
    shape(shape, 0, 0);        
  }
  
  checkonTest(); 
  checkOverTestRectangles();
  changeShapeColor();
  checkOnShape();
  checkTestStatus();
  checkforHelpButton();
  checkforRepeatButton();
  mouseMakeHand();
  mouseMakeFill(); 
  checkforSubmitButton();
  checkGameOver();
  test.checkTest1Repeat();
  test.checkTest2Repeat();
  test.checkTest3Repeat();
  test.checkTest4Repeat();
  test.checkTest5Repeat();
  test.checkTest6Repeat();
  test.checkTest7Repeat();
  test.checkTest8Repeat();
  test.checkTest9Repeat();
  test.checkTest10Repeat();
  checkforClear();
  whichTest();
  
}

//Checks if game is over
public void checkGameOver() {
  if (livesLeft == 0) {
   dialogue.gameOver();
   exit();
  }
}

public boolean checkonTest() {
  if ((ontest1 || ontest2 || ontest3 || ontest4 || ontest5 || ontest6 || ontest7 || ontest8 || ontest9 || ontest10) && (rect1Over || rect2Over || rect3Over || rect4Over || rect5Over || rect6Over || rect7Over || rect8Over || rect9Over || rect10Over)) {
    onTest = true;
  } else {
    onTest = false;
  }
  return onTest;
}

public boolean whichTest() {
   if ((!ontest1 && !ontest2 && !ontest3 && !ontest4 && !ontest5 && !ontest6 && !ontest7 && !ontest8 && !ontest9 && !ontest10) && (rect1Over || rect2Over || rect3Over || rect4Over || rect5Over || rect6Over || rect7Over || rect8Over || rect9Over || rect10Over)) {
      if (level == 0 && rect1Over) {
        notOnTest = false;
      } else if (level == 1 && rect2Over){
        notOnTest = false;
      } else if (level == 2 && rect3Over){
        notOnTest = false;
      } else if (level == 3 && rect4Over){
        notOnTest = false;
      } else if (level == 4 && rect5Over){
        notOnTest = false;
      } else if (level == 5 && rect6Over){
        notOnTest = false;
      } else if (level == 6 && rect7Over){
        notOnTest = false;
      } else if (level == 7 && rect8Over){
        notOnTest = false;
      } else if (level == 8 && rect9Over){
        notOnTest = false;
      } else if (level == 9 && rect10Over){
        notOnTest = false;
      } else {
        notOnTest = true;
      }
   } else {
     notOnTest = false;
   }
   return notOnTest;
}


//Checks if the mouse is over the rectangle
public void checkOverTestRectangles() {
  if (overRect(rect10x,recty,rectwidth,rectheight)) {
    rect10Over = true;
  } else if (overRect(rect9x,recty,rectwidth,rectheight)) {
    rect9Over = true;
  } else if (overRect(rect8x,recty,rectwidth,rectheight)) {
    rect8Over = true;
  } else if (overRect(rect7x,recty,rectwidth,rectheight)) {
    rect7Over = true;
  } else if (overRect(rect6x,recty,rectwidth, rectheight) ) {
    rect6Over = true;
  } else if (overRect(rect5x,recty,rectwidth,rectheight)) {
    rect5Over = true;
  } else if (overRect(rect4x,recty,rectwidth,rectheight)) {
    rect4Over = true;
  } else if (overRect(rect3x,recty,rectwidth,rectheight)) {
    rect3Over = true;
  } else if (overRect(rect2x,recty,rectwidth, rectheight) ) {
    rect2Over = true;
  } else if (overRect(rect1x, recty, rectwidth, rectheight)) {
    rect1Over = true;
  } else {
     rect10Over = false;
     rect9Over = false;
     rect8Over = false;
     rect7Over = false;
     rect6Over = false;
     rect5Over = false;
     rect4Over = false;
     rect3Over = false;
     rect2Over = false;
     rect1Over = false;
  }
}

//Changes colors of the shapes you can drag on canvas
public void changeShapeColor() {
  if (overRect(colorWidth, 20, colorSize, colorSize)) {
    overRed = true;
  } else if (overRect(colorWidth, 170, colorSize, colorSize)) {
    overGreen = true;
  } else if (overRect(colorWidth, 320, colorSize, colorSize)) {
    overBlue = true;
  } else if (overRect(colorWidth, 470, colorSize, colorSize)) {
    overYellow = true;
  } else if (overRect(colorWidth, 620, colorSize, colorSize)) {
    overPink = true;
  } else if (overRect(colorWidth, 770, colorSize, colorSize)) {
    overOrange = true;
  } else {
    overRed = false;
    overGreen = false;
    overBlue = false;
    overYellow = false;
    overPink = false;
    overOrange = false;
  }
}

//Detects if mouse over clear button
public void checkforClear() {
 if (overRect(clearButtonx, clearButtony, clearButtonwidth, clearButtonheight)) {
   overClear = true;
 } else {
   overClear = false;
 }
}

//Detects if the mouse is over clear button
public void checkforHelpButton() {
  if (overRect(helpButtonX, helpButtonY , helpButtonSizeW, helpButtonSizeL)) {
    overHelp = true;
  } else {
    overHelp = false;
  }
}

public void checkforSubmitButton() {
  if (overRect(submitButtonX, submitButtonY, submitButtonSizeW, submitButtonSizeL)) {
    overSubmit = true;
  } else {
    overSubmit = false;
  }
}

public void checkforRepeatButton() {
  if(overRect(repeatButtonX, repeatButtonY, repeatButtonSizeW, repeatButtonSizeL)) {
    overRepeat = true;
  } else {
    overRepeat = false;
  }
}

//Checks if mouse is over a draggable shape
public void checkOnShape() {
 if (overRect(SquareX, SquareY, SquareSize, SquareSize)) {
   overSqaure = true;
 } else if (overRect(RectangleX,RectangleY, RectangleW, RectangleH)) {
   overRectangle = true;
 } else if (overCircle(CircleX, CircleY, CircleSize)) {
   overCircle = true;
 } else {
   overSqaure = false;
   overRectangle = false;
   overCircle = false;
 }
}

public void mouseMakeHand() {
  if (overSqaure || overRectangle || overCircle || overHelp || overRepeat || overClear || overSubmit || 
         overRed || overBlue || overGreen || overYellow || overPink || overOrange 
         || rect1Over || rect2Over || rect3Over || rect4Over || rect5Over || rect6Over || rect7Over || rect8Over || rect9Over || rect10Over) {
    cursor(HAND);
  } else {
    cursor(ARROW);
  }
}

public void mouseMakeFill() {
  if (rect1Over) {
    fillColorTest1 = color (220,220,220);
  } else if (rect2Over) {
    fillColorTest2 = color (220,220,220);
  } else if (rect3Over) {
    fillColorTest3 = color (220,220,220);
  } else if (rect4Over) {
    fillColorTest4 = color (220,220,220);
  } else if (rect5Over) {
    fillColorTest5 = color (220,220,220);
  } else if (rect6Over) {
    fillColorTest6 = color (220,220,220);
  } else if (rect7Over) {
    fillColorTest7 = color (220,220,220);
  } else if (rect8Over) {
    fillColorTest8 = color (220,220,220);
  } else if (rect9Over) {
    fillColorTest9 = color (220,220,220);
  } else if (rect10Over) {
    fillColorTest10 = color (220,220,220);
  } else if (overHelp) {
    fillColorHelp = color (220,220,220);
  } else if (overSubmit) {
    fillColorSubmit = color (220,220,220);
  } else if (overHelp) {
    fillColorHelp = color (220,220,220);
  } else if (overRepeat) {
    fillColorRepeat = color (220,220,220);
  } else if (overClear) {
    fillColorClear = color (220,220,220);
  } else {
    fillColorTest1 = (255);
    fillColorTest2 = (255);
    fillColorTest3 = (255);
    fillColorTest4 = (255);
    fillColorTest5 = (255);
    fillColorTest6 = (255);
    fillColorTest7 = (255);
    fillColorTest8 = (255);
    fillColorTest9 = (255);
    fillColorTest10 = (255);
    fillColorClear = (255);
    fillColorSubmit = (255);
    fillColorHelp = (255);
    fillColorRepeat = (255);
       
  }
}

//Checks if player can enter a test or not
public void checkTestStatus() {
 if (finishedTest10Setup == true && ontest10 == false) {
    dialogue.youWon();
    exit();
  } else if (test10 == true && finishedTest9Setup == true && finishedTest10Setup == false && ontest9 == false) {
    colors.clear();
    shapes.clear();
    test.test10();
    finishedTest10Setup = true;
  } else if (test9 == true && finishedTest8Setup == true && finishedTest9Setup == false && ontest8 == false) {
    colors.clear();
    shapes.clear();
    test.test9();
    finishedTest9Setup = true;
  } else if (test8 == true && finishedTest7Setup == true && finishedTest8Setup == false && ontest7 == false) {
    colors.clear();
    shapes.clear();
    test.test8();
    finishedTest8Setup = true;
  } else if (test7 == true && finishedTest6Setup == true && finishedTest7Setup == false && ontest6 == false) {
    colors.clear();
    shapes.clear();
    test.test7();
    finishedTest7Setup = true;
  } else if (test6 == true && finishedTest5Setup == true && finishedTest6Setup == false && ontest5 == false) {
    colors.clear();
    shapes.clear();
    test.test6();
    finishedTest6Setup = true;
  } else if (test5 == true && finishedTest4Setup == true && finishedTest5Setup == false && ontest4 == false) {
    colors.clear();
    shapes.clear();
    test.test5();
    finishedTest5Setup = true;
  } else if (test4 == true && finishedTest3Setup == true && finishedTest4Setup == false && ontest3 == false) {
    colors.clear();
    shapes.clear();
    test.test4();
    finishedTest4Setup = true;
  } else if (test3 == true && finishedTest2Setup == true && finishedTest3Setup == false && ontest2 == false) {
    colors.clear();
    shapes.clear();
    test.test3();
    finishedTest3Setup = true;
  } else if (test2 == true && finishedTest1Setup == true && finishedTest2Setup == false && ontest1 == false) {
    colors.clear();
    shapes.clear();
    test.test2();
    finishedTest2Setup = true;
  } else if (test1 == true && finishedTest1Setup == false) {
    colors.clear();
    shapes.clear();
    test.test1();
    finishedTest1Setup = true;
  } 
}

//Inacts a test if a the mouse is pressed over a certain shape
public void mousePressed
() {
  if (rect10Over && finishedTest9Setup) {
    test10 = true;
  } else if (rect9Over && finishedTest8Setup) {
    test9 = true;
  } else if (rect8Over && finishedTest7Setup) {
    test8 = true;
  } else if (rect7Over && finishedTest6Setup) {
    test7 = true;
  } else if (rect6Over && finishedTest5Setup) {
    test6 = true;
  } else if (rect5Over && finishedTest4Setup) {
    test5 = true;
  } else if (rect4Over && finishedTest3Setup) {
    test4 = true;
  } else if (rect3Over && finishedTest2Setup) {
    test3 = true;
  } else if (rect2Over && finishedTest1Setup) {
    test2 = true;
  } else if (rect1Over) {
    test1 = true;
  } else if (overRed) {
    currentShapeColor = color(255,0,0);
    currentColor = "red";
  } else if (overGreen) {
    currentShapeColor = color(0,255,0);
    currentColor = "green";
  } else if (overBlue) {
    currentShapeColor = color(0,0,255);
    currentColor = "blue";
  } else if (overYellow) {
   currentShapeColor = color(255,255,0);
   currentColor = "yellow";
  } else if (overPink) {
    currentShapeColor = color(255,0,255);
    currentColor = "pink";
  } else if (overOrange) {
    currentShapeColor = color(255,128,0);
    currentColor = "orange";
  } else if (overSqaure) {
     xOffset = mouseX-SquareX;
     yOffset = mouseY-SquareY; 
  } else if (overCircle) {
    CircleX = mouseX;
    CircleY = mouseY;
  } else if (overRectangle) {
     xOffset = mouseX-RectangleX;
     yOffset = mouseY-RectangleY;
  } else if (overCircle) {
    CircleX = mouseX;
    CircleY = mouseY;
  } else if (overClear) {
    dialogue.clearButton();
    shapesInDrawingBoard.clear();  
    shapes.clear();
    colors.clear();
  } else if (overHelp) {
    dialogue.helpButton();
  } else if (overRepeat) {
    dialogue.repeatButton();
  } else if (overSubmit) {
    dialogue.SubmitButton();
  } else if (checkonTest()) {
     dialogue.alreadyonTest();
  } else if (whichTest()) {
    dialogue.pressWrongTest();
  }
}


public void mouseDragged() {
  if (overSqaure) {
    SquareX = mouseX-xOffset;
    SquareY = mouseY-yOffset;
  } else if (overRectangle) {
    RectangleX = mouseX-xOffset;
    RectangleY = mouseY-yOffset;
  } else if (overCircle) {
    CircleX = mouseX;
    CircleY = mouseY;
  }
}

public void mouseReleased() {
  if ((SquareinDrawingBoard(SquareX, SquareY) || RectangleinDrawingBoard(RectangleX, RectangleY) || CircleinDrawingBoard(CircleX, CircleY)) && currentColor == "white") {
    dialogue.whiteShapeOnDrawingBoard();
  }
 if (SquareinDrawingBoard(SquareX, SquareY) && currentColor != "white") {
   square = createShape(RECT, SquareX, SquareY, SquareSize, SquareSize);
   square.setFill(currentShapeColor);
   shapesInDrawingBoard.add(square);
   colors.add(currentColor);
   shapes.add("square");
   SquareX = initialSquareX;
   SquareY = initialSquareY;
 } else {
   SquareX = initialSquareX;
   SquareY = initialSquareY;
 }
  if (RectangleinDrawingBoard(RectangleX, RectangleY) && currentColor != "white") {
   rectangle = createShape(RECT, RectangleX, RectangleY, RectangleW, RectangleH);
   rectangle.setFill(currentShapeColor);
   shapesInDrawingBoard.add(rectangle);
   colors.add(currentColor);
   shapes.add("rectangle");
   RectangleX = initialRectangleX;
   RectangleY = initialRectangleY;
 } else {
   RectangleX = initialRectangleX;
   RectangleY = initialRectangleY;
 }
 if (CircleinDrawingBoard(CircleX, CircleY) && currentColor != "white") {
   circle = createShape(ELLIPSE, CircleX, CircleY, CircleSize, CircleSize);
   circle.setFill(currentShapeColor);
   shapesInDrawingBoard.add(circle);
   colors.add(currentColor);
   shapes.add("circle");
   CircleX = initialCircleX;
   CircleY = initialCircleY;
 
 } else {
   CircleX = initialCircleX;
   CircleY = initialCircleY;
 }
} 

//Detects if the mouse is over a rectangle shape
public boolean overRect(int x, int y, int width, int height)  {
  if (mouseX >= x && mouseX <= x+width && 
      mouseY >= y && mouseY <= y+height) {
    return true;
  } else {
    return false;
  }
}

//detects if the mouse if over an eclipse shape
public boolean overCircle(int x, int y, int diameter) {
  float disX = x - mouseX;
  float disY = y - mouseY;
  if (sqrt(sq(disX) + sq(disY)) < diameter/2 ) {
    return true;
  } else {
    return false;
  }
}

//Checks if square player dragged is in drawing board 
public boolean SquareinDrawingBoard(int x, int y) {
  if (drawingBoardRectX <= x && drawingBoardRectW >= x-25 && drawingBoardRectY <= y && drawingBoardRectL >= y) {
    return true;
  } else {
    return false;
  }
}


//Checks if rectangle player dragged is in drawing board 
public boolean RectangleinDrawingBoard(int x, int y) {
  if (drawingBoardRectX <= x && drawingBoardRectW >= x-25 && drawingBoardRectY <= y && drawingBoardRectL >= y+52) {
    return true;
  } else {
    return false;
  }
}


//Checks if circle player dragged is in drawing board 
public boolean CircleinDrawingBoard(int x, int y) {
  if (drawingBoardRectX <= x - 75 && drawingBoardRectW >= x - 100 && drawingBoardRectY <= y - 73 && drawingBoardRectL >= y-73) {
   return true; 
  } else {
  return false;
  }
}


//Creates a new instance of the dialogue class 
Dialogue dialogue = new Dialogue();

//Creates a new instance of the test class
Test test = new Test();

//Allows for screen to be full
int fullscreen = 0;

//checks if the intro dialogue has played yet  
boolean introPlayed = false;

//variables used for the test
int livesLeft = 4;

//boolean that says if you are on a test
boolean onTest = false;
boolean notOnTest = false;

int level = 0;

//Checks if you are in the middle of test
boolean ontest1 = false;
boolean ontest2 = false; 
boolean ontest3 = false;
boolean ontest4 = false;
boolean ontest5 = false;
boolean ontest6 = false;
boolean ontest7 = false; 
boolean ontest8 = false;
boolean ontest9 = false;
boolean ontest10 = false;

//Checks if you are clicking on a test or not 
boolean test1 = false;
boolean test2 = false; 
boolean test3 = false;
boolean test4 = false;
boolean test5 = false;
boolean test6 = false;
boolean test7 = false; 
boolean test8 = false;
boolean test9 = false;
boolean test10 = false;

//Tells you if your mouse is over the Test rectangles or not
boolean rect1Over = false;
boolean rect2Over = false;
boolean rect3Over = false;
boolean rect4Over = false;
boolean rect5Over = false;
boolean rect6Over = false;
boolean rect7Over = false;
boolean rect8Over = false;
boolean rect9Over = false;
boolean rect10Over = false;

//Makes sure you can only do a test once a you are doing the tests in order
boolean finishedTest1Setup = false;
boolean finishedTest2Setup = false;
boolean finishedTest3Setup = false;
boolean finishedTest4Setup = false;
boolean finishedTest5Setup = false;
boolean finishedTest6Setup = false;
boolean finishedTest7Setup = false;
boolean finishedTest8Setup = false;
boolean finishedTest9Setup = false;
boolean finishedTest10Setup = false;

//Says if mouse if over clear button
boolean overClear = false; 

//says if mouse if over help button
boolean overHelp = false;

//says if mouse is over repeat button
boolean overRepeat = true;

//says if mouse is over sumbit button
boolean overSubmit = false;

//Checks if the mouse is over one of the color squares
boolean overRed = false;
boolean overGreen = false;
boolean overBlue = false;
boolean overYellow = false;
boolean overPink = false;
boolean overOrange = false;

//Checks if the mouse if over the shapes you can drag
boolean overSqaure = false;
boolean overCircle = false;
boolean overRectangle = false;

//Initilaizes the widths heights and sizes of the rectangles displaying the test  
int recty = 925;
int rect1x = 25;
int rect2x = 215;
int rect3x = 405;
int rect4x = 595;
int rect5x = 785;
int rect6x = 975;
int rect7x = 1165;
int rect8x = 1355;
int rect9x = 1545;
int rect10x = 1735;
int rectheight = 100;
int rectwidth = 150;

// dimensions and size for clear button
int clearButtonx = 1280;
int clearButtony = 30;
int clearButtonheight = 100;
int clearButtonwidth = 150;

//Initializes the position and size of the text saying the test number
int testTexty = 1000;
int colorSize = 55;
int colorWidth = 30;
int colorHeight1 = 20;
int colorHeight2 = 170;
int colorHeight3 = 320;
int colorHeight4 = 470;
int colorHeight5 = 620;
int colorHeight6 = 770;

//Numbers for the draggable shapes
int initialSquareX = 1725;
int initialSquareY = 100;
int initialRectangleX = 1725;
int initialRectangleY = 600;
int initialCircleX = 1800;
int initialCircleY = 425;
int SquareX = 1725; 
int SquareY = 100;
int SquareSize = 150;  
int CircleX = 1800;
int CircleY = 425;
int CircleSize = 150;
int RectangleX = 1725;
int RectangleY = 600;
int RectangleW = 150;
int RectangleH = 200;
int xOffset = 0; 
int yOffset = 0;

 
//Drawing Board Rectangle
int drawingBoardRectX = 175;
int drawingBoardRectY = 150;
int drawingBoardRectW = 1500;
int drawingBoardRectL = 700;

//creates the help button
int helpButtonSizeW = 50;
int helpButtonSizeL = 45;
int helpButtonX = 1620;
int helpButtonY = 30;

//creates the repeat button
int repeatButtonSizeW = 50;
int repeatButtonSizeL = 45;
int repeatButtonX = 1620;
int repeatButtonY = 85;

//creates the submit button
int submitButtonSizeW = 150;
int submitButtonSizeL = 100;
int submitButtonX = 1450;
int submitButtonY = 30;

int currentShapeColor = (255);
int fillColorTest1 = color(255);
int fillColorTest2 = color(255);
int fillColorTest3 = color(255);
int fillColorTest4 = color(255);
int fillColorTest5 = color(255);
int fillColorTest6 = color(255);
int fillColorTest7 = color(255);
int fillColorTest8 = color(255);
int fillColorTest9 = color(255);
int fillColorTest10 = color(255);
int fillColorSubmit = color(255);
int fillColorHelp = color(255);
int fillColorClear = color(255);
int fillColorRepeat = color(255);
TTS tts;
String playerName;
String currentColor = "white";
PShape square;
PShape rectangle;
PShape circle;

ArrayList<PShape> shapesInDrawingBoard = new ArrayList<PShape>();
ArrayList<PShape> shapesStuck = new ArrayList<PShape>();
ArrayList<String> colors = new ArrayList<String>();
ArrayList<String> shapes = new ArrayList<String>();
ArrayList<String> colorsCompare = new ArrayList<String>();
ArrayList<String> shapesCompare = new ArrayList<String>();

//Instance to re set up shapes on screen
Setup setup;
class Dialogue {
  
  Dialogue() {
    playerName = "Daniel";
    tts = new TTS();
  }
  public void intro() {
     tts.speak("Hello " + playerName + ", my name is dab. That stands for drawing assistant buddy. Welcome to memorization madness! This game has ten increasingly harder memorization tests. Practice dragging shapes or press test 1 to begin");
  }
  
  int helpButtonInt = -1;
  public void helpButton() {
    if (helpButtonInt == -1) {
      tts.speak("This is the help button. Press it again to learn how to use the drawing interface and play the game");
      helpButtonInt++;
    } else if (helpButtonInt == 0) {
      tts.speak("So " + playerName + ", you want to learn how to play? Well first off, the white area in the middle of the screen is the drawing board. This is where you can put shapes. Click and drag a shape on the left of the drawing board and drag it"
       + "to the drawing board to make a shape. The shape will only stay in place if you drag the shape to the drawing board. To change the color of the shape, simply press on the colored rectangles on the left. You can not put white shapes on the drawing board," 
       + " so make sure to change the color before you start creating. Other than that, press the clear button to clear all shapes on the drawing board, press the repeat button to repeat the things you must memorize one time, or press test 1 to begin."
       + " I will tell you when you can press the other test buttons");
       helpButtonInt++;
    } else if (helpButtonInt == 1) {
      tts.speak("Did you listen to what I said the first time, " + playerName + ". Well I guess not so let me tell you everything again. The white, area in the middle is the drawing board. Drag shapes to the left of the drawing board here. Press the color buttons to the" 
      + " left to change the color of the shapes. Do not add white shapes. The clear button clears all the shapes from the drawing board. The repeat button repeats the shapes and colors you must memorize once, The test one button begins the game");
      helpButtonInt++;
    } else if (helpButtonInt == 2) {
      tts.speak("Really, " + playerName + ", is your memory really that bad. All you do is drag the shapes on the left to the drawing board. Change the colors of the shapes with the colors to the left. Everything else is very obvious. Just figure it out"
      + ", You obviously can not listen to me," + playerName + ",This is the last time I will explain this to you");
      helpButtonInt++;
    } else if (helpButtonInt == 3){
      tts.speak("Leave me alone," + playerName + ", you are trying to annoy me or you are t0o stupid to play this game. I have already told you what to do");
      helpButtonInt++;
    } else if (helpButtonInt == 4) {
      tts.speak("Not listening anymore. I will just watch some you tube videos until you are ready to start");
      helpButtonInt++;
    } else if (helpButtonInt == 5) {
      tts.speak("HAHAHAHAHAHAHAHA, Pew de pie is the funniest you tuber, he reviews me mes very well. Oh hello ," + playerName + ", I am still waiting");
      helpButtonInt++;
    } else if (helpButtonInt == 6) {
      tts.speak("System shutting down, participant is to dumb to continue, unless he stops does something other than press the freaking help button");
    }
  }
  
  boolean clearFirstDialogue = false;
  boolean pressClearButton = false;
  public void clearButton() {
     if (finishedTest1Setup == false && clearFirstDialogue == false && shapesInDrawingBoard.size() == 0 && pressClearButton == false) {
         tts.speak("This is the clear button. All the shapes in the drawing board will dissappear, unless they are shapes placed in previous tests");
         clearFirstDialogue = true;
         pressClearButton = true;
       } else {
         if (shapesInDrawingBoard.size() == 0) {
         pressClearButton = true;
         int randomDialogue = PApplet.parseInt(random(5));
          if (randomDialogue == 0) {
            tts.speak("There is nothing to clear, " + playerName);
          } else if (randomDialogue == 1) {
             tts.speak("Why would you use the clear button with no shapes in the drawing board");     
          } else if (randomDialogue == 2) {
             tts.speak("Error 387, " + playerName + ", no shapes to clear");     
          } else if (randomDialogue == 3) {
             tts.speak(playerName + ", it is impossible to clear things when there is nothing to clear");     
          } else if (randomDialogue == 4) {
             tts.speak("There are zero things to remove");     
          }
        } else {
          pressClearButton = true;
          int randomDialogue = PApplet.parseInt(random(5));
          if (randomDialogue == 0) {
             tts.speak("Say bye to the shapes, " + playerName);
           } else if (randomDialogue == 1) {
              tts.speak("Clearing Shapes");     
           } else if (randomDialogue == 2) {
              tts.speak("Erase erase erase");     
           } else if (randomDialogue == 3) {
              tts.speak(playerName + ", the shapes will leave as you wish");     
           } else if (randomDialogue == 4) {
              tts.speak("Bye shapes");     
           }
        }
      } 
   }
  
    int repeatButtonInt = 0;
    boolean repeatButtonIntt1 = true;
    boolean repeatButtonIntt2 = true;
    boolean repeatButtonIntt3 = true;
    boolean repeatButtonIntt4 = true;
    boolean repeatButtonIntt5 = true;
    boolean repeatButtonIntt6 = true;
    boolean repeatButtonIntt7 = true;
    boolean repeatButtonIntt8 = true;
    boolean repeatButtonIntt9 = true;
    boolean repeatButtonIntt10 = true;
  public void repeatButton() {
    if (finishedTest1Setup == false) {
      if (repeatButtonInt == 0) {
        tts.speak("This is the repeat button. You can use it in game to repeat the shapes and colors you must memorize. It can only be used once though for each test");
        repeatButtonInt++;
      } else if (repeatButtonInt == 1) {
        tts.speak(playerName + ", Like I said before, this is the repeat button. I will repeat what you must memorize for each test once when you press this button");
        repeatButtonInt++;
      } else if (repeatButtonInt == 2) {
        tts.speak(playerName + ", I have already talked about the repeat button twice. It allows you to here what you must memorize a second time for the tests");
        repeatButtonInt++;
      } else if (repeatButtonInt == 3) {
        tts.speak("Come on, I know you know what to do, " + playerName);
        repeatButtonInt++;
      } else if (repeatButtonInt == 4) {
        tts.speak("I will ignore you now, ");
        repeatButtonInt++;
      } else if (repeatButtonInt == 5) {
        tts.speak("I will shut this game down, " + playerName + ", if you press the repeat button again. I am serious and have the power to do this");
        repeatButtonInt++;
      } else if (repeatButtonInt == 6) {
        tts.speak("See you later, maybe you will listen to be next time");
        repeatButtonInt++;
        exit();
      }
    } else {
      if (ontest1 && repeatButtonIntt1) {
        dialogue.test1Answer();
        repeatButtonIntt1 = false;
      } else if (ontest2 && repeatButtonIntt2) {
        dialogue.test2Answer();
        repeatButtonIntt2 = false;
      } else if (ontest3 && repeatButtonIntt3) {
        dialogue.test3Answer();
        repeatButtonIntt3 = false;
      } else if (ontest4 && repeatButtonIntt4) {
        dialogue.test4Answer();
        repeatButtonIntt4 = false;
      } else if (ontest5 && repeatButtonIntt5) {
        dialogue.test5Answer();
        repeatButtonIntt5 = false;
      } else if (ontest6 && repeatButtonIntt6) {
        dialogue.test6Answer();      
        repeatButtonIntt6 = false;
      } else if (ontest7 && repeatButtonIntt7) {
        dialogue.test7Answer();
        repeatButtonIntt7 = false;
      } else if (ontest8 && repeatButtonIntt8) {
        dialogue.test8Answer();
        repeatButtonIntt8 = false;
      } else if (ontest9 && repeatButtonIntt9) {
        dialogue.test9Answer();
        repeatButtonIntt9 = false;
      } else if (ontest10 && repeatButtonIntt10) {
        dialogue.test10Answer();
        repeatButtonIntt10 = false;
      } else {
        int randomDialogue = PApplet.parseInt(random(5));
        if (randomDialogue == 0) {
           tts.speak("You have already pressed the repeat button");
        } else if (randomDialogue == 1) {
          tts.speak("Nice try, " + playerName + ", you can only press the repeat button once per test");  
        } else if (randomDialogue == 2) {
          tts.speak("Try to remember what I said, you already pressed repeat");  
        } else if (randomDialogue == 3) {
          tts.speak("If you can not remember what I said the first two times, you can not pass the test I guess, " + playerName);  
        } else if (randomDialogue == 4) {
          tts.speak("I wish I could help you, but I can only repeat the answer once");  
        }
    
      }
    }
  }
  
  public void test1() {
   int randomDialogue = PApplet.parseInt(random(3));
   if (randomDialogue == 0) {
      tts.speak("Welcome to the first test. This is a warm up. You must memorize one shape and one color.");
   } else if (randomDialogue == 1) {
     tts.speak("Congratulations, you have pressed the first test. I know you can do this one.");
   } else if (randomDialogue == 2) {
     tts.speak("This is test 1, it is very easy. Just put down one colored shape.");
   }
   tts.speak("Remember, you can pass the repeat button, the button with an R, to repeat what you must memorize once for each rounds");
  }
  
  public void test1Answer() {
     tts.speak("Just put a," + colorsCompare.get(0) + ". " + shapesCompare.get(0) + ". On the drawing board");
  }
    
  public void test2() {
   int randomDialogue = PApplet.parseInt(random(3));
   if (randomDialogue == 0) {
      tts.speak("Welcome to the second test. This is slightly harder than the first test. You must memorize two shapes and two colors.");
   } else if (randomDialogue == 1) {
     tts.speak("Congratulations, you have made it to rouund two, it was easy, was it not.");
   } else if (randomDialogue == 2) {
     tts.speak("This is test 2, it is just slightly harder than the first one.");
   }
  }
  
 public void test2Answer() {
   tts.speak("In this order, put a," + colorsCompare.get(0) + ", " + shapesCompare.get(0) + ",  and a, " + colorsCompare.get(1) + ", " + shapesCompare.get(1) + ", on the drawing canvas");
 }
  
  public void test3() {
    int randomDialogue = PApplet.parseInt(random(3));
   if (randomDialogue == 0) {
      tts.speak("Welcome to the third test. You must memorize three shapes and colors.");
   } else if (randomDialogue == 1) {
     tts.speak("Congratulations, you have passed two easy tests. This should not give you too much trouble either");
   } else if (randomDialogue == 2) {
     tts.speak("This is test 3, remember you can press the R button to repeat the answer once per round");
   }
  }
  
  public void test3Answer() {
     tts.speak("In this order, put a," + colorsCompare.get(0) + ", " + shapesCompare.get(0) + ",  and a, " + colorsCompare.get(1) + ", " + shapesCompare.get(1) + ",  and a, " + colorsCompare.get(2) + ", " + shapesCompare.get(2) + ", in the drawing board");
  }
  
  public void test4() {
   int randomDialogue = PApplet.parseInt(random(3));
   if (randomDialogue == 0) {
      tts.speak("Welcome to the fourth test. You must memorize four shapes and colors.");
   } else if (randomDialogue == 1) {
     tts.speak("The steaks are now raised. It is getting harder, you must memorize four things");
   } else if (randomDialogue == 2) {
     tts.speak("This is test 4, try your best, you need to memorize four shape and color combinations");
   }
  }
  
  public void test4Answer() {
      tts.speak("In this order, put a," + colorsCompare.get(0) + ", " + shapesCompare.get(0) + ",  and a, " + colorsCompare.get(1) + ", " + shapesCompare.get(1) 
         + ",  and a, " + colorsCompare.get(2) + ", " + shapesCompare.get(2)  + ",  and a, " + colorsCompare.get(3) + ", " + shapesCompare.get(3) + ",on the drawing board");
  }
  
  public void test5() {
   int randomDialogue = PApplet.parseInt(random(3));
   if (randomDialogue == 0) {
      tts.speak("Welcome to the test number five. You must memorize five shapes and colors.");
   } else if (randomDialogue == 1) {
     tts.speak("Great job, " + playerName + ", you are now almost halfway done with this game");
   } else if (randomDialogue == 2) {
     tts.speak("This is test 5, it might get harder now, you need to memorize four shape and color combinations");
   }
  }
  
  public void test5Answer() {
    tts.speak("In this order, put a," + colorsCompare.get(0) + ", " + shapesCompare.get(0) + ",  and a, " + colorsCompare.get(1) + ", " + shapesCompare.get(1) 
         + ",  and a, " + colorsCompare.get(2) + ", " + shapesCompare.get(2)  + ",  and a, " + colorsCompare.get(3) + ", " + shapesCompare.get(3)+ ",  and a, " + colorsCompare.get(4) + ", " + shapesCompare.get(4) + ", on the drawing board");
  }
  
  public void test6() {
   int randomDialogue = PApplet.parseInt(random(3));
   if (randomDialogue == 0) {
      tts.speak("Welcome to the sixth test. You must memorize six shapes and colors.");
   } else if (randomDialogue == 1) {
     tts.speak("This is the harder part of the game, you must memorize six things");
   } else if (randomDialogue == 2) {
     tts.speak("This is test 6, try to focus on what I am about to say, you need to memorize six shape and color combinations");
   }
  }
  
  public void test6Answer() {
    tts.speak("In this order, put a," + colorsCompare.get(0) + ", " + shapesCompare.get(0) + ",  and a, " + colorsCompare.get(1) + ", " + shapesCompare.get(1) 
         + ",  and a, " + colorsCompare.get(2) + ", " + shapesCompare.get(2)  + ",  and a, " + colorsCompare.get(3) + ", " + shapesCompare.get(3)+ ",  and a, " 
         + colorsCompare.get(4) + ", " + shapesCompare.get(4) + ",  and a, " + colorsCompare.get(5) + ", " + shapesCompare.get(5) + ", in the drawing board");
  }
  
  public void test7() {
   int randomDialogue = PApplet.parseInt(random(3));
   if (randomDialogue == 0) {
      tts.speak("Welcome to the seventh test. You must memorize seven shapes and colors.");
   } else if (randomDialogue == 1) {
     tts.speak("I am impressed about how far you are getting, you must memorize seven things now. That is a lot");
   } else if (randomDialogue == 2) {
     tts.speak("This is test 7, your memory is above average if you got here, you need to memorize seven shape and color combinations");
   }
  }
  
  public void test7Answer() {
     tts.speak("In this order, put a," + colorsCompare.get(0) + ", " + shapesCompare.get(0) + ",  and a, " + colorsCompare.get(1) + ", " + shapesCompare.get(1) 
         + ",  and a, " + colorsCompare.get(2) + ", " + shapesCompare.get(2)  + ",  and a, " + colorsCompare.get(3) + ", " + shapesCompare.get(3)+ ",  and a, " 
         + colorsCompare.get(4) + ", " + shapesCompare.get(4) + ",  and a, " + colorsCompare.get(5) + ", " + shapesCompare.get(5) + ",  and a, " + colorsCompare.get(6) + ", " + shapesCompare.get(6) + ", in the drawing board");
  }
  
  public void test8() {
   int randomDialogue = PApplet.parseInt(random(3));
   if (randomDialogue == 0) {
      tts.speak("Welcome to the eighth test. You must memorize eight shapes and colors.");
   } else if (randomDialogue == 1) {
     tts.speak(playerName + ", you need to memorize eight things now, I know you can do this");
   } else if (randomDialogue == 2) {
     tts.speak("This is test 8, you are getting near the end of the game, you need to memorize eight shape and color combinations");
   }
  }
  
  public void test8Answer() {
     tts.speak("In this order, put a," + colorsCompare.get(0) + ", " + shapesCompare.get(0) + ",  and a, " + colorsCompare.get(1) + ", " + shapesCompare.get(1) 
         + ",  and a, " + colorsCompare.get(2) + ", " + shapesCompare.get(2)  + ",  and a, " + colorsCompare.get(3) + ", " + shapesCompare.get(3)+ ",  and a, " 
         + colorsCompare.get(4) + ", " + shapesCompare.get(4) + ",  and a, " + colorsCompare.get(5) + ", " + shapesCompare.get(5) + ",  and a, " + colorsCompare.get(6) + ", " + shapesCompare.get(6)
          + ",  and a, " + colorsCompare.get(7) + ", " + shapesCompare.get(7) + ", in the drawing board");
  }
  
  public void test9() {
   int randomDialogue = PApplet.parseInt(random(3));
   if (randomDialogue == 0) {
      tts.speak("Welcome to the ninth test. You must memorize nine shapes and colors.");
   } else if (randomDialogue == 1) {
     tts.speak("Only two tests left now. It is getting very hard right now, you must memorize nine things");
   } else if (randomDialogue == 2) {
     tts.speak("This is test nine, you have come so far, you need to memorize nine shape and color combinations");
   }
  }
  
  public void test9Answer() {
      tts.speak("In this order, put a," + colorsCompare.get(0) + ", " + shapesCompare.get(0) + ",  and a, " + colorsCompare.get(1) + ", " + shapesCompare.get(1) 
         + ",  and a, " + colorsCompare.get(2) + ", " + shapesCompare.get(2)  + ",  and a, " + colorsCompare.get(3) + ", " + shapesCompare.get(3)+ ",  and a, " 
         + colorsCompare.get(4) + ", " + shapesCompare.get(4) + ",  and a, " + colorsCompare.get(5) + ", " + shapesCompare.get(5) + ",  and a, " + colorsCompare.get(6) + ", " + shapesCompare.get(6)
         + ",  and a, " + colorsCompare.get(7) + ", " + shapesCompare.get(7) + ",  and a, " + colorsCompare.get(8) + ", " + shapesCompare.get(8) + ", on the drawing board");
  }
  
  public void test10() {
   int randomDialogue = PApplet.parseInt(random(3));
   if (randomDialogue == 0) {
      tts.speak("Welcome to the tenth test. The final test. You must memorize ten shapes and colors.");
   } else if (randomDialogue == 1) {
     tts.speak("This is the last test in the game. I am very impressed you got this far. You must memorize ten things");
   } else if (randomDialogue == 2) {
     tts.speak("This is test 10, the ultimate test, you need to memorize ten shape and color combinations");
   }
  }
  
  public void test10Answer() {
       tts.speak("In this order, put a," + colorsCompare.get(0) + ", " + shapesCompare.get(0) + ",  and a, " + colorsCompare.get(1) + ", " + shapesCompare.get(1) 
         + ",  and a, " + colorsCompare.get(2) + ", " + shapesCompare.get(2)  + ",  and a, " + colorsCompare.get(3) + ", " + shapesCompare.get(3)+ ",  and a, " 
         + colorsCompare.get(4) + ", " + shapesCompare.get(4) + ",  and a, " + colorsCompare.get(5) + ", " + shapesCompare.get(5) + ",  and a, " + colorsCompare.get(6) + ", " + shapesCompare.get(6)
         + ",  and a, " + colorsCompare.get(7) + ", " + shapesCompare.get(7) + ",  and a, " + colorsCompare.get(8) + ", " + shapesCompare.get(8)
         +  ",  and a, " + colorsCompare.get(9) + ", " + shapesCompare.get(9) + ", on the drawing board");
  }
  
  public void youWon() {
    tts.speak("Congratulations " + playerName + ", you have completed all of the tests I gave you. You have one of the best memorizations I know. Either that or you cheated and wrote down all the answers. Have a nice day and play again");
  }
  
  public void gameOver() {
    Integer i = new Integer(level);   
    String onLevel = i.toString();
    if (level == 1) {
      tts.speak("You got to level, " + onLevel + ", That is sad, I know you can pass level one");
    } else if (level == 2) {
      tts.speak("You got to level, " + onLevel + ", Really you basically did nothing");
    } else if (level == 3) {
      tts.speak("You got to level, " + onLevel + ", you probably have a very bad memory");
    } else if (level == 4) {
      tts.speak("You got to level, " + onLevel + ", you were just getting to the challenge");
    } else if (level == 5) {
      tts.speak("You got to level, " + onLevel + ", not to shabby but you can do better");
    } else if (level == 6) {
      tts.speak("You got to level, " + onLevel + ", you got a pretty good memory but not good enough to win");
    } else if (level == 7) {
      tts.speak("You got to level, " + onLevel + ", you are getting closer to winning, you might just be able to win");
    } else if (level == 8) {
      tts.speak("You got to level, " + onLevel + ", very impressive, a few more levels will grant you a victory");
    } else if (level == 9) {
      tts.speak("You got to level, " + onLevel + ", I can smell a victory coming soon");
    } else if (level == 10) {
      tts.speak("You got to level, " + onLevel + ", tough luck, you could not have gotten any closer");
    }
    tts.speak("Feel free to play again and get to an even better level or maybe even complete the game");
  }
  
  int whiteShapeNum = 0;
  public void whiteShapeOnDrawingBoard() {
    if (whiteShapeNum == 0) {
      tts.speak(playerName + ", white shapes can not be dragged on the drawing board. Please select a color first");
      whiteShapeNum++;
    } else if (whiteShapeNum == 1) {
       tts.speak("Ok " + playerName + ", please listen. Select a color, You can not drag white shapes on the drawing board");
       whiteShapeNum++;
    } else if (whiteShapeNum == 2) {
      tts.speak("This is getting annoying " + playerName + ", change the color before dragging shapes");
       whiteShapeNum++;
    } else if (whiteShapeNum == 3) {
      tts.speak("I will continue to ignore you if you do not listen to me");
      whiteShapeNum++;
    } else if (whiteShapeNum == 4) {
      tts.speak("I am just gonna listen to music until you decide to listen to me");
      whiteShapeNum++;
    } else if (whiteShapeNum == 5) {
      tts.speak("Cause this is thriller. Thriller night. And no one's gonna save you from the beast about to strike. You know it’s thriller, Thriller night");
      whiteShapeNum++;
    } else if (whiteShapeNum == 6) {
      tts.speak("I can show you the world, Shining, shimmering splendid, Tell me, princess, now when did You last let your heart decide? I can open your eyes, Take you wonder by wonder, Over sideways and under, On a magic carpet ride, A whole new world");
      whiteShapeNum++;
    } else if (whiteShapeNum == 7) {
      tts.speak("I'm upset. Fifty thousand on my head, it's disrespect. So offended that I had to double check. I'ma always take the money over sex. That's why they need me out the way What you expect?. Got a lot of blood and it's cold."
        + "They keep tryna get me for my soul. Thankful for the women that I know. Can't go fifty-fifty with no hoe");
      whiteShapeNum++;
    } else if (whiteShapeNum == 8) {
     tts.speak("Back in black. I hit the sack. I've been too long I'm glad to be back. Yes, I'm let loose. From the noose. That's kept me hanging about. I've been looking at the sky. Cause it's gettin' me high. Forget the hearse 'cause I never die"
     + "I got nine lives. Cat's eyes. Abusin' every one of them and running wild");
     whiteShapeNum++;
    } else if (whiteShapeNum == 9) {
      tts.speak("You do not deserve to hear my beatiful singing voice anymore. Shutting down");
      whiteShapeNum++;
    }
  }
  
  boolean clearFirstSubmit = false;
  boolean pressSubmitButton = false;
  public void SubmitButton() {
    if (finishedTest1Setup == false) {
       if (finishedTest1Setup == false && clearFirstSubmit == false && shapesInDrawingBoard.size() == 0 && pressSubmitButton == false) {
         tts.speak("This is the submit button. It checks if you have past the test. If you press submit and you do the test incorrectly, you will lose a life");
         clearFirstSubmit = true;
         pressSubmitButton = true;
       } else {
         int randomDialogue = PApplet.parseInt(random(5));
         if (randomDialogue == 0) {
           tts.speak("Can not submit anything when you are in practice mode");
         } else if (randomDialogue == 1) {
           tts.speak(playerName + ", please begin a test before pressing the submit button");
         } else if (randomDialogue == 2) {
           tts.speak("This button is useless if you are not on a test");
         } else if (randomDialogue == 3) {
           tts.speak("I am waiting for you to press the test button, " + playerName + ", before this button will do something");
         } else if (randomDialogue == 4) {
           tts.speak("Congratulations, you did absolutely nothing");
         }
       }
    } else {
       if (ontest1 == false && ontest2 == false && ontest3 == false && ontest4 == false && ontest5 == false && ontest6 == false && ontest7 == false && ontest8 == false && ontest9 == false && ontest10 == false) {
      int randomDialogue = PApplet.parseInt(random(5));
         if (randomDialogue == 0) {
           tts.speak("Can not submit anything when you are in between tests");
         } else if (randomDialogue == 1) {
           tts.speak(playerName + ", please press the next test before pressing the submit button");
         } else if (randomDialogue == 2) {
           tts.speak("This button is useless if you are not on a test");
         } else if (randomDialogue == 3) {
           tts.speak("I am waiting for you to press the test button, " + playerName + ", before this button will do something");
         } else if (randomDialogue == 4) {
           tts.speak("Congratulations, you did absolutely nothing");
         }
      }
     }
  }
  
  public void lostLife() {
    int randomDialogue = PApplet.parseInt(random(5));
         if (randomDialogue == 0) {
           tts.speak("Somebody just answered the test wrong");
         } else if (randomDialogue == 1) {
           tts.speak(playerName + ", you just lost a life, sorry");
         } else if (randomDialogue == 2) {
           tts.speak("Rest in peace one of your lifes, " + playerName);
         } else if (randomDialogue == 3) {
           tts.speak("You just lost a life , " + playerName + ", do not run out of lives");
         } else if (randomDialogue == 4) {
           tts.speak("Congratulations, you just lost a life");
         }
      Integer i = new Integer(livesLeft);   
      String lives = i.toString();
      tts.speak("You have," + lives + ", lives left");
  
    }
    
    public void answerRight() {
      int randomDialogue = PApplet.parseInt(random(5));
       if (randomDialogue == 0) {
          tts.speak("Nice job, " + playerName + ", you may move on to the next test");
        } else if (randomDialogue == 1) {
          tts.speak(playerName + ", that is correct");
        } else if (randomDialogue == 2) {
          tts.speak("Someone is moving on to the next test, " + playerName);
        } else if (randomDialogue == 3) {
          tts.speak("Congratulations , " + playerName + ", press the next test to begin");
        } else if (randomDialogue == 4) {
          tts.speak("Congratulations, you just passed this test");
        }
    }
    
    public void pressWrongTest() {
      int randomDialogue = PApplet.parseInt(random(5));
       if (randomDialogue == 0) {
          tts.speak(playerName + ", you pressed the wrong test number.");
        } else if (randomDialogue == 1) {
          tts.speak("That is not the right test number, " + playerName);
        } else if (randomDialogue == 2) {
          tts.speak("Please press the right test number");
        } else if (randomDialogue == 3) {
          tts.speak("Congratulations , " + playerName + ", you pressed the wrong test number");
        } else if (randomDialogue == 4) {
          tts.speak("That is not the correct test number");
        }
        Integer i = new Integer(level + 1);   
        String nextLevel = i.toString();
        tts.speak("Go to test number, " + nextLevel);
    }
    
    public void alreadyonTest() {
       int randomDialogue = PApplet.parseInt(random(5));
       if (randomDialogue == 0) {
          tts.speak(playerName + ", you can change test numbers because you are already on a test");
        } else if (randomDialogue == 1) {
          tts.speak("Already on a test, " + playerName);
        } else if (randomDialogue == 2) {
          tts.speak("Please do not press the test buttons until you finish this test");
        } else if (randomDialogue == 3) {
          tts.speak(playerName + ", you need to beat this test first");
        } else if (randomDialogue == 4) {
          tts.speak("you can not go to that test now");
        }
    }     
}
class Setup {
  
  Setup() {}
  
  public void setup() {
    stroke(128,128,128);
    strokeWeight(4);
    PFont font;
    background(0);
  
  //This is the board where you can drags shape
  fill(255);
  rect(drawingBoardRectX, drawingBoardRectY, drawingBoardRectW, drawingBoardRectL);
  
  //Draws the test rectangles on the screen
  fill(fillColorTest1);
  rect(rect1x,recty,rectwidth, rectheight);
   fill(fillColorTest2);
  rect(rect2x,recty,rectwidth,rectheight);
   fill(fillColorTest3);
  rect(rect3x,recty,rectwidth,rectheight);
   fill(fillColorTest4);
  rect(rect4x,recty,rectwidth,rectheight);
   fill(fillColorTest5);
  rect(rect5x,recty,rectwidth,rectheight);
   fill(fillColorTest6);
  rect(rect6x,recty,rectwidth, rectheight);
   fill(fillColorTest7);
  rect(rect7x,recty,rectwidth,rectheight);
   fill(fillColorTest8);
  rect(rect8x,recty,rectwidth,rectheight);
   fill(fillColorTest9);
  rect(rect9x,recty,rectwidth,rectheight);
   fill(fillColorTest10);
  rect(rect10x,recty,rectwidth,rectheight);
  
  //Draws the text that go inside the test rectangles on the screen
  fill(0);
  font = loadFont("Bahnschrift-48.vlw");
  textFont(font);
  textSize(50);
  text("Test 1", rect1x + 15, testTexty - 8); 
  text("Test 2", rect2x + 10, testTexty - 8);
  text("Test 3", rect3x + 10, testTexty - 8);
  text("Test 4", rect4x + 10, testTexty - 8);
  text("Test 5", rect5x + 10, testTexty - 8);
  text("Test 6", rect6x + 10, testTexty - 8); 
  text("Test 7", rect7x + 10, testTexty - 8);
  text("Test 8", rect8x + 10, testTexty - 8);
  text("Test 9", rect9x + 10, testTexty - 8);
  textSize(45);
  text("Test 10", rect10x + 8, testTexty - 10);
  
  //draws the clear button and text
   fill(fillColorClear);
  rect(clearButtonx, clearButtony, clearButtonwidth, clearButtonheight);
  font = loadFont("Bahnschrift-48.vlw");
  textFont(font);
  fill(0);
  textSize(55);
  text("Clear", clearButtonx + 10, clearButtony + 70);
  
  noStroke();
  
  //Draws the colors that change the shapes in the game
  fill(255,0,0);
  rect(colorWidth, colorHeight1, colorSize, colorSize);
  fill(0,255,0);
  rect(colorWidth, colorHeight2, colorSize, colorSize);
  fill(0,0,255);
  rect(colorWidth, colorHeight3, colorSize, colorSize);
  fill(255,255,0);
  rect(colorWidth, colorHeight4, colorSize, colorSize);
  fill(255,0,255);
  rect(colorWidth, colorHeight5, colorSize, colorSize);
  fill(255,128,0);
  rect(colorWidth, colorHeight6, colorSize, colorSize);
  
  //Creates all the shapes in the game with a default white color
  fill(currentShapeColor);
  rect(SquareX, SquareY, SquareSize, SquareSize);
  ellipse(CircleX, CircleY, CircleSize, CircleSize);
  rect(RectangleX,RectangleY,RectangleW,RectangleH);
  
  stroke(128,128,128);
  strokeWeight(4);
  
  //Creates the help button 
  fill(fillColorHelp);
  rect(helpButtonX, helpButtonY, helpButtonSizeW, helpButtonSizeL);
  fill(0);
  textSize(45);
  text("?", helpButtonX + 15, helpButtonY + 38);
  
  //Creates the repeat button 
  fill(fillColorRepeat);
  rect(repeatButtonX, repeatButtonY, repeatButtonSizeW, repeatButtonSizeL);
  fill(0);
  textSize(45);
  text("R", repeatButtonX + 10, repeatButtonY + 38);
  
  //Creates the sumbit button and check mark in it
  fill(fillColorSubmit);
  rect(submitButtonX, submitButtonY, submitButtonSizeW, submitButtonSizeL);
  fill(0);
  textSize(46);
  text("Submit", submitButtonX + 3, submitButtonY + 67);
  
  fill(255);
  font = loadFont("BookmanOldStyle-Bold-48.vlw");
  textFont(font);
  textSize(80);
  text("Memorization Madness", 225, 110);
  strokeWeight(2);
  rect(225, 120, 960, 5);
  }
}
class Test {
  
  String color1 = "";
  String shape1 = "";
   
  Test() {
  }
  
  public void test1() {
     level = 1;
     colorsCompare.clear();
     shapesCompare.clear();
     shapesInDrawingBoard.clear();   
    int randomShape = PApplet.parseInt(random(3));
    if (randomShape == 0) {
       shape1 = "square";
       shapesCompare.add(shape1);
     } else if (randomShape == 1) {
       shape1 = "circle";
       shapesCompare.add(shape1);
     } else if (randomShape == 2) {
       shape1 = "rectangle";
       shapesCompare.add(shape1);
     }
       
       int randomColor = PApplet.parseInt(random(6));
       if (randomColor == 0) {
        color1 = "red";
        colorsCompare.add(color1);
      } else if (randomColor == 1) {
        color1 = "green";
        colorsCompare.add(color1);
      } else if (randomColor == 2) {
        color1 = "blue";
        colorsCompare.add(color1);
      } else if (randomColor == 3) {
        color1 = "yellow";
        colorsCompare.add(color1);
      } else if (randomColor == 4) {
        color1 = "pink";
        colorsCompare.add(color1);
      } else if (randomColor == 5) {
        color1 = "orange";
        colorsCompare.add(color1);
     }
     dialogue.test1();
     dialogue.test1Answer();
     ontest1 = true;
}

  public void checkTest1Repeat() {
    if (ontest1) {
      if (mousePressed && overSubmit) {
        if (colorsCompare.size() == colors.size() && shapesCompare.size() == shapes.size() && colorsCompare.get(0) == colors.get(0) && shapesCompare.get(0) == shapes.get(0)) {
           dialogue.answerRight();
            for (PShape shape : shapesInDrawingBoard) {
                 shapesStuck.add(shape); 
            }
            shapesInDrawingBoard.clear();
  
           ontest1 = false;
        } else {
          livesLeft--;
          dialogue.lostLife();
        }
        }
    }
  }
  
    public void test2() {
      level = 2;
      colorsCompare.clear();
      shapesCompare.clear();
      for (int i = 1; i < 3; i++) {
        int randomShape = PApplet.parseInt(random(2));
        if (randomShape == 0) {
          shape1 = "square";
          shapesCompare.add(shape1);
         } else if (randomShape == 1) {
           shape1 = "circle";
           shapesCompare.add(shape1);
         } else if (randomShape == 2) {
           shape1 = "rectangle";
           shapesCompare.add(shape1);
         }
      }
      for (int i = 1; i < 3; i++) {
         int randomColor = PApplet.parseInt(random(3));
         if (randomColor == 0) {
          color1 = "red";
          colorsCompare.add(color1);
        } else if (randomColor == 1) {
          color1 = "green";
          colorsCompare.add(color1);
        } else if (randomColor == 2) {
          color1 = "blue";
          colorsCompare.add(color1);
        } else if (randomColor == 3) {
          color1 = "yellow";
          colorsCompare.add(color1);
        } else if (randomColor == 4) {
          color1 = "pink";
          colorsCompare.add(color1);
        } else if (randomColor == 5) {
          color1 = "orange";
          colorsCompare.add(color1);
        }
      }
       dialogue.test2();
       dialogue.test2Answer();
       ontest2 = true;
  }
  
  public void checkTest2Repeat() {
    if (ontest2) {
      if (mousePressed && overSubmit) {
        if (colorsCompare.size() == colors.size() && shapesCompare.size() == shapes.size()) {
            boolean missed = false;
            for (int i = 1; i < 3; i++) {
              if (colors.get(i-1) != colorsCompare.get(i-1) || shapes.get(i-1) != shapesCompare.get(i-1)) {
                missed = true;
              }
            }
              if (missed == false) {
                 dialogue.answerRight();
                 for (PShape shape : shapesInDrawingBoard) {
                 shapesStuck.add(shape); 
                 }
                 shapesInDrawingBoard.clear();
                 ontest2 = false;
              } else {
                livesLeft--;
                dialogue.lostLife();
              }
        } else {
          livesLeft--;
          dialogue.lostLife();
        }
        }
    }
  }
  
  public void test3() {
     level = 3;
     colorsCompare.clear();
     shapesCompare.clear();
      for (int i = 1; i < 4; i++) {
        int randomShape = PApplet.parseInt(random(3));
        if (randomShape == 0) {
          shape1 = "square";
          shapesCompare.add(shape1);
         } else if (randomShape == 1) {
           shape1 = "circle";
           shapesCompare.add(shape1);
         } else if (randomShape == 2) {
           shape1 = "rectangle";
           shapesCompare.add(shape1);
         }
      }
      for (int i = 1; i < 4; i++) {
         int randomColor = PApplet.parseInt(random(6));
         if (randomColor == 0) {
          color1 = "red";
          colorsCompare.add(color1);
        } else if (randomColor == 1) {
          color1 = "green";
          colorsCompare.add(color1);
        } else if (randomColor == 2) {
          color1 = "blue";
          colorsCompare.add(color1);
        } else if (randomColor == 3) {
          color1 = "yellow";
          colorsCompare.add(color1);
        } else if (randomColor == 4) {
          color1 = "pink";
          colorsCompare.add(color1);
        } else if (randomColor == 5) {
          color1 = "orange";
          colorsCompare.add(color1);
        }
      }
       dialogue.test3();
       dialogue.test3Answer();
       ontest3 = true;
  }
  
  public void checkTest3Repeat() {
     if (ontest3) {
      if (mousePressed && overSubmit) {
        if (colorsCompare.size() == colors.size() && shapesCompare.size() == shapes.size()) {
            boolean missed = false;
            for (int i = 1; i < 4; i++) {
              if (colors.get(i-1) != colorsCompare.get(i-1) || shapes.get(i-1) != shapesCompare.get(i-1)) {
                missed = true;
              }
            }
              if (missed == false) {
                 dialogue.answerRight();
                 for (PShape shape : shapesInDrawingBoard) {
                 shapesStuck.add(shape); 
                 }
                 shapesInDrawingBoard.clear();
                 ontest3 = false;
              } else {
                livesLeft--;
                dialogue.lostLife();
              }
        } else {
           livesLeft--;
           dialogue.lostLife();
        }
        }
    }
  }
  
  public void test4() {
    level = 4;
    colorsCompare.clear();
     shapesCompare.clear();
      for (int i = 1; i < 5; i++) {
        int randomShape = PApplet.parseInt(random(3));
        if (randomShape == 0) {
          shape1 = "square";
          shapesCompare.add(shape1);
         } else if (randomShape == 1) {
           shape1 = "circle";
           shapesCompare.add(shape1);
         } else if (randomShape == 2) {
           shape1 = "rectangle";
           shapesCompare.add(shape1);
         }
      }
      for (int i = 1; i < 5; i++) {
         int randomColor = PApplet.parseInt(random(6));
         if (randomColor == 0) {
          color1 = "red";
          colorsCompare.add(color1);
        } else if (randomColor == 1) {
          color1 = "green";
          colorsCompare.add(color1);
        } else if (randomColor == 2) {
          color1 = "blue";
          colorsCompare.add(color1);
        } else if (randomColor == 3) {
          color1 = "yellow";
          colorsCompare.add(color1);
        } else if (randomColor == 4) {
          color1 = "pink";
          colorsCompare.add(color1);
        } else if (randomColor == 5) {
          color1 = "orange";
          colorsCompare.add(color1);
        }
      }
       dialogue.test4();
       dialogue.test4Answer();
       ontest4 = true;
  }
  
  public void checkTest4Repeat() {
      if (ontest4) {
      if (mousePressed && overSubmit) {
        if (colorsCompare.size() == colors.size() && shapesCompare.size() == shapes.size()) {
            boolean missed = false;
            for (int i = 1; i < 5; i++) {
              if (colors.get(i-1) != colorsCompare.get(i-1) || shapes.get(i-1) != shapesCompare.get(i-1)) {
                missed = true;
              }
            }
              if (missed == false) {
                 dialogue.answerRight();
                 for (PShape shape : shapesInDrawingBoard) {
                 shapesStuck.add(shape); 
                 }
                 shapesInDrawingBoard.clear();
                 ontest4 = false;
              } else {
                livesLeft--;
                dialogue.lostLife();
              }
        } else {
          livesLeft--;
          dialogue.lostLife();
        }
        }
    }
  }
  
  public void test5() {
   level = 5;
   colorsCompare.clear();
     shapesCompare.clear();
      for (int i = 1; i < 6; i++) {
        int randomShape = PApplet.parseInt(random(3));
        if (randomShape == 0) {
          shape1 = "square";
          shapesCompare.add(shape1);
         } else if (randomShape == 1) {
           shape1 = "circle";
           shapesCompare.add(shape1);
         } else if (randomShape == 2) {
           shape1 = "rectangle";
           shapesCompare.add(shape1);
         }
      }
      for (int i = 1; i < 6; i++) {
         int randomColor = PApplet.parseInt(random(6));
         if (randomColor == 0) {
          color1 = "red";
          colorsCompare.add(color1);
        } else if (randomColor == 1) {
          color1 = "green";
          colorsCompare.add(color1);
        } else if (randomColor == 2) {
          color1 = "blue";
          colorsCompare.add(color1);
        } else if (randomColor == 3) {
          color1 = "yellow";
          colorsCompare.add(color1);
        } else if (randomColor == 4) {
          color1 = "pink";
          colorsCompare.add(color1);
        } else if (randomColor == 5) {
          color1 = "orange";
          colorsCompare.add(color1);
        }
      }
       dialogue.test5();
       dialogue.test5Answer();
       ontest5 = true;
  } 
  
  public void checkTest5Repeat() {
      if (ontest5) {
      if (mousePressed && overSubmit) {
        if (colorsCompare.size() == colors.size() && shapesCompare.size() == shapes.size()) {
            boolean missed = false;
            for (int i = 1; i < 6; i++) {
              if (colors.get(i-1) != colorsCompare.get(i-1) || shapes.get(i-1) != shapesCompare.get(i-1)) {
                missed = true;
              }
            }
              if (missed == false) {
                 dialogue.answerRight();
                 for (PShape shape : shapesInDrawingBoard) {
                 shapesStuck.add(shape); 
                 }
                 shapesInDrawingBoard.clear();
                 ontest5 = false;
              } else {
               livesLeft--;
                dialogue.lostLife();
              }
        } else {
          livesLeft--;
           dialogue.lostLife();
        }
        }
    }
  }
  
  public void test6() {
     level = 6;
     colorsCompare.clear();
     shapesCompare.clear();
      for (int i = 1; i < 7; i++) {
        int randomShape = PApplet.parseInt(random(3));
        if (randomShape == 0) {
          shape1 = "square";
          shapesCompare.add(shape1);
         } else if (randomShape == 1) {
           shape1 = "circle";
           shapesCompare.add(shape1);
         } else if (randomShape == 2) {
           shape1 = "rectangle";
           shapesCompare.add(shape1);
         }
      }
      for (int i = 1; i < 7; i++) {
         int randomColor = PApplet.parseInt(random(6));
         if (randomColor == 0) {
          color1 = "red";
          colorsCompare.add(color1);
        } else if (randomColor == 1) {
          color1 = "green";
          colorsCompare.add(color1);
        } else if (randomColor == 2) {
          color1 = "blue";
          colorsCompare.add(color1);
        } else if (randomColor == 3) {
          color1 = "yellow";
          colorsCompare.add(color1);
        } else if (randomColor == 4) {
          color1 = "pink";
          colorsCompare.add(color1);
        } else if (randomColor == 5) {
          color1 = "orange";
          colorsCompare.add(color1);
        }
      }
       dialogue.test6();
       dialogue.test6Answer();
       ontest6 = true;
  }
  
  public void checkTest6Repeat() {
     if (ontest6) {
      if (mousePressed && overSubmit) {
        if (colorsCompare.size() == colors.size() && shapesCompare.size() == shapes.size()) {
            boolean missed = false;
            for (int i = 1; i < 7; i++) {
              if (colors.get(i-1) != colorsCompare.get(i-1) || shapes.get(i-1) != shapesCompare.get(i-1)) {
                missed = true;
              }
            }
              if (missed == false) {
                 dialogue.answerRight();
                 for (PShape shape : shapesInDrawingBoard) {
                 shapesStuck.add(shape); 
                 }
                 shapesInDrawingBoard.clear();
                 ontest6 = false;
              } else {
                livesLeft--;
                dialogue.lostLife();
              }
        } else {
         livesLeft--;
         dialogue.lostLife();
        }
        }
    }
  }
  
  public void test7() {
    level = 7;
    colorsCompare.clear();
     shapesCompare.clear();
      for (int i = 1; i < 8; i++) {
        int randomShape = PApplet.parseInt(random(3));
        if (randomShape == 0) {
          shape1 = "square";
          shapesCompare.add(shape1);
         } else if (randomShape == 1) {
           shape1 = "circle";
           shapesCompare.add(shape1);
         } else if (randomShape == 2) {
           shape1 = "rectangle";
           shapesCompare.add(shape1);
         }
      }
      for (int i = 1; i < 8; i++) {
         int randomColor = PApplet.parseInt(random(6));
         if (randomColor == 0) {
          color1 = "red";
          colorsCompare.add(color1);
        } else if (randomColor == 1) {
          color1 = "green";
          colorsCompare.add(color1);
        } else if (randomColor == 2) {
          color1 = "blue";
          colorsCompare.add(color1);
        } else if (randomColor == 3) {
          color1 = "yellow";
          colorsCompare.add(color1);
        } else if (randomColor == 4) {
          color1 = "pink";
          colorsCompare.add(color1);
        } else if (randomColor == 5) {
          color1 = "orange";
          colorsCompare.add(color1);
        }
      }
       dialogue.test7();
       dialogue.test7Answer();
       ontest7 = true;  
  }
  
  public void checkTest7Repeat() {
     if (ontest7) {
      if (mousePressed && overSubmit) {
        if (colorsCompare.size() == colors.size() && shapesCompare.size() == shapes.size()) {
            boolean missed = false;
            for (int i = 1; i < 8; i++) {
              if (colors.get(i-1) != colorsCompare.get(i-1) || shapes.get(i-1) != shapesCompare.get(i-1)) {
                missed = true;
              }
            }
              if (missed == false) {
                 dialogue.answerRight();
                 for (PShape shape : shapesInDrawingBoard) {
                 shapesStuck.add(shape); 
                 }
                 shapesInDrawingBoard.clear();
                 ontest7 = false;
              } else {
                livesLeft--;
                dialogue.lostLife();
              }
        } else {
          livesLeft--;
          dialogue.lostLife();
        }
        }
    }
  }
  
  public void test8() {
    level = 8;
     colorsCompare.clear();
     shapesCompare.clear();
      for (int i = 1; i < 9; i++) {
        int randomShape = PApplet.parseInt(random(3));
        if (randomShape == 0) {
          shape1 = "square";
          shapesCompare.add(shape1);
         } else if (randomShape == 1) {
           shape1 = "circle";
           shapesCompare.add(shape1);
         } else if (randomShape == 2) {
           shape1 = "rectangle";
           shapesCompare.add(shape1);
         }
      }
      for (int i = 1; i < 9; i++) {
         int randomColor = PApplet.parseInt(random(6));
         if (randomColor == 0) {
          color1 = "red";
          colorsCompare.add(color1);
        } else if (randomColor == 1) {
          color1 = "green";
          colorsCompare.add(color1);
        } else if (randomColor == 2) {
          color1 = "blue";
          colorsCompare.add(color1);
        } else if (randomColor == 3) {
          color1 = "yellow";
          colorsCompare.add(color1);
        } else if (randomColor == 4) {
          color1 = "pink";
          colorsCompare.add(color1);
        } else if (randomColor == 5) {
          color1 = "orange";
          colorsCompare.add(color1);
        }
      }
       dialogue.test8();
       dialogue.test8Answer();
       ontest8 = true;  
  }
  
  public void checkTest8Repeat() {
     if (ontest8) {
      if (mousePressed && overSubmit) {
        if (colorsCompare.size() == colors.size() && shapesCompare.size() == shapes.size()) {
            boolean missed = false;
            for (int i = 1; i < 9; i++) {
              if (colors.get(i-1) != colorsCompare.get(i-1) || shapes.get(i-1) != shapesCompare.get(i-1)) {
                missed = true;
              }
            }
              if (missed == false) {
                 dialogue.answerRight();
                 for (PShape shape : shapesInDrawingBoard) {
                 shapesStuck.add(shape); 
                 }
                 shapesInDrawingBoard.clear();
                 ontest8 = false;
              } else {
                livesLeft--;
                dialogue.lostLife();
              }
        } else {
          livesLeft--;
          dialogue.lostLife();
        }
        }
    }
  }
  
  public void test9() {
    level = 9;
     colorsCompare.clear();
     shapesCompare.clear();
      for (int i = 1; i < 10; i++) {
        int randomShape = PApplet.parseInt(random(3));
        if (randomShape == 0) {
          shape1 = "square";
          shapesCompare.add(shape1);
         } else if (randomShape == 1) {
           shape1 = "circle";
           shapesCompare.add(shape1);
         } else if (randomShape == 2) {
           shape1 = "rectangle";
           shapesCompare.add(shape1);
         }
      }
      for (int i = 1; i < 10; i++) {
         int randomColor = PApplet.parseInt(random(6));
         if (randomColor == 0) {
          color1 = "red";
          colorsCompare.add(color1);
        } else if (randomColor == 1) {
          color1 = "green";
          colorsCompare.add(color1);
        } else if (randomColor == 2) {
          color1 = "blue";
          colorsCompare.add(color1);
        } else if (randomColor == 3) {
          color1 = "yellow";
          colorsCompare.add(color1);
        } else if (randomColor == 4) {
          color1 = "pink";
          colorsCompare.add(color1);
        } else if (randomColor == 5) {
          color1 = "orange";
          colorsCompare.add(color1);
        }
      }
       dialogue.test9();
       dialogue.test9Answer();
       ontest9 = true;  
  }
  
  public void checkTest9Repeat() {
     if (ontest9) {
      if (mousePressed && overSubmit) {
        if (colorsCompare.size() == colors.size() && shapesCompare.size() == shapes.size()) {
            boolean missed = false;
            for (int i = 1; i < 10; i++) {
              if (colors.get(i-1) != colorsCompare.get(i-1) || shapes.get(i-1) != shapesCompare.get(i-1)) {
                missed = true;
              }
            }
              if (missed == false) {
                 dialogue.answerRight();
                 for (PShape shape : shapesInDrawingBoard) {
                 shapesStuck.add(shape); 
                 }
                 shapesInDrawingBoard.clear();
                 ontest9 = false;
              } else {
                livesLeft--;
                dialogue.lostLife();
              }
        } else {
          livesLeft--;
          dialogue.lostLife();
        }
        }
    }
  }
  
  public void test10() {
    level = 10;
     colorsCompare.clear();
     shapesCompare.clear();
      for (int i = 1; i < 11; i++) {
        int randomShape = PApplet.parseInt(random(3));
        if (randomShape == 0) {
          shape1 = "square";
          shapesCompare.add(shape1);
         } else if (randomShape == 1) {
           shape1 = "circle";
           shapesCompare.add(shape1);
         } else if (randomShape == 2) {
           shape1 = "rectangle";
           shapesCompare.add(shape1);
         }
      }
      for (int i = 1; i < 11; i++) {
         int randomColor = PApplet.parseInt(random(6));
         if (randomColor == 0) {
          color1 = "red";
          colorsCompare.add(color1);
        } else if (randomColor == 1) {
          color1 = "green";
          colorsCompare.add(color1);
        } else if (randomColor == 2) {
          color1 = "blue";
          colorsCompare.add(color1);
        } else if (randomColor == 3) {
          color1 = "yellow";
          colorsCompare.add(color1);
        } else if (randomColor == 4) {
          color1 = "pink";
          colorsCompare.add(color1);
        } else if (randomColor == 5) {
          color1 = "orange";
          colorsCompare.add(color1);
        }
      }
       dialogue.test10();
       dialogue.test10Answer();
       ontest10 = true;  
  }
  
  public void checkTest10Repeat() {
     if (ontest10) {
      if (mousePressed && overSubmit) {
        if (colorsCompare.size() == colors.size() && shapesCompare.size() == shapes.size()) {
            boolean missed = false;
            for (int i = 1; i < 11; i++) {
              if (colors.get(i-1) != colorsCompare.get(i-1) || shapes.get(i-1) != shapesCompare.get(i-1)) {
                missed = true;
              }
            }
              if (missed == false) {
                 dialogue.answerRight();
                 for (PShape shape : shapesInDrawingBoard) {
                 shapesStuck.add(shape); 
                 }
                 shapesInDrawingBoard.clear();
                 ontest10 = false;
              } else {
                livesLeft--;
                dialogue.lostLife();
              }
        } else {
          livesLeft--;
          dialogue.lostLife();
        }
        }
    }
  }

 }
  public void settings() {  fullScreen(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Main" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
