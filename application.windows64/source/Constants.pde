import guru.ttslib.*;

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

color currentShapeColor = (255);
color fillColorTest1 = color(255);
color fillColorTest2 = color(255);
color fillColorTest3 = color(255);
color fillColorTest4 = color(255);
color fillColorTest5 = color(255);
color fillColorTest6 = color(255);
color fillColorTest7 = color(255);
color fillColorTest8 = color(255);
color fillColorTest9 = color(255);
color fillColorTest10 = color(255);
color fillColorSubmit = color(255);
color fillColorHelp = color(255);
color fillColorClear = color(255);
color fillColorRepeat = color(255);
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
